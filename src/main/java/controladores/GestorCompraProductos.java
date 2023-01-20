/*
 * MINIPROYECTO #4
 *
 * INTEGRANTES: 
 * John Freddy Belalcázar
 * Hernán David Cisneros
 * Santiago González Gálvez
 *
 * Grupo 01 FPOE 
 *
 * PROFESOR: Luis Yohany Romo Portilla 
 */

package controladores;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import modelos.Almacenamiento;
import modelos.Producto;
import modelos.Proveedor;
import vistas.Carrito;
import vistas.CompraProductos;
import vistas.Ppal;


public final class GestorCompraProductos {
    private final CompraProductos vistaCompraProductos;
    private final Almacenamiento almacenamiento;
    private ArrayList<Object[]> opcionComboProducto;
    private ArrayList<Object[]> opcionComboProveedor;
    private final HashMap <Long, HashMap <String, Object>> articulosCarrito;
    
    public GestorCompraProductos(CompraProductos vistaCompraProductos, Almacenamiento almacenamiento, HashMap <Long, HashMap <String, Object>> articulosCarrito){
        this.vistaCompraProductos = vistaCompraProductos;
        this.almacenamiento = almacenamiento;
        this.articulosCarrito = articulosCarrito;
        productosDisponibles();
        proveedoresDelProducto();
        this.vistaCompraProductos.addBtnRegresarListener(new ManejadoraDeMouse());
        this.vistaCompraProductos.addBtnAgregarListener(new ManejadoraDeMouse());
        this.vistaCompraProductos.addBtnIrCarritoListener(new ManejadoraDeMouse());
        this.vistaCompraProductos.addProductoComboListener(new ManejadoraDeLista());
        this.vistaCompraProductos.addProveedorComboListener(new ManejadoraDeLista());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaCompraProductos.getBtnRegresar()){
                if (e.getButton() == 1){
                    irPpal();
                }
            }

            if (e.getSource() == vistaCompraProductos.getBtnAgregar()){
                if (e.getButton() == 1){
                    agregarAlCarritoCompra();
                }
            }
            
            if (e.getSource() == vistaCompraProductos.getBtnIrCarrito()){
                if (e.getButton() == 1){
                    irCarritoCompra();
                }
            }
        }
    }
    
    class ManejadoraDeLista implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getSource() == vistaCompraProductos.getComboProducto()){
                vistaCompraProductos.reiniciarSpinner();
                proveedoresDelProducto();
            }
            if(e.getSource() == vistaCompraProductos.getComboProveedor()){
                vistaCompraProductos.reiniciarSpinner();
            }
        }
    }
    
    //Ingresa al comboBox los productos disponibles
    public final void productosDisponibles(){
        vistaCompraProductos.limpiarProductosCombo();
        opcionComboProducto = new ArrayList();
        Iterator iteradorProductos = almacenamiento.getProductos().entrySet().iterator();
        while (iteradorProductos.hasNext()) {
            HashMap.Entry <Long, Producto> mapa = (HashMap.Entry) iteradorProductos.next();
            Producto producto = mapa.getValue();
            String productoStr;
            productoStr = mapa.getValue().getNombre();
            Object[] productoEscogido = new Object[1];
            productoEscogido[0] = producto;
            opcionComboProducto.add(productoEscogido);
            vistaCompraProductos.anadirProductosCombo(productoStr);
        }
    }
    
    //Ingresa al comboBox los proveedores que ofrecen el producto seleccionado
    public void proveedoresDelProducto(){
        vistaCompraProductos.limpiarProveedoresCombo();
        opcionComboProveedor = new ArrayList();
        
        Iterator i = almacenamiento.getProveedores().entrySet().iterator();
        Producto miProducto = obtenerProductoEscogido();
        
        while(i.hasNext()) {
            HashMap.Entry <Long, Proveedor> mapa = (HashMap.Entry) i.next();
            Proveedor proveedor = mapa.getValue();
            ArrayList<Producto> productoDelProveedor = proveedor.getProductos();
            
            //Obteniendo los proveedores que ofrecen el producto escogido
            for (int o = 0; o < productoDelProveedor.size(); o++){
                if (String.valueOf(productoDelProveedor.get(o)).equals(miProducto.getNombre())) {
                    Object[] proveedorEscogido = new Object[1];
                    proveedorEscogido[0] = proveedor;
                    opcionComboProveedor.add(proveedorEscogido);
                    vistaCompraProductos.anadirProveedoresCombo(proveedor.getNombre());
                }
            }
        }
        
        if(vistaCompraProductos.getComboProveedor().getModel().getSize() == 0){ //Se repite el mensaje varias veces
            System.out.println("Eyou");
            JOptionPane.showMessageDialog(null, "<html><p style = \" font:12px; \">No hay "
                    + "proveedores que ofrezcan el producto.</p></html>", "Aviso", 
                    JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
            vistaCompraProductos.getComboProveedor().setEnabled(false);
            vistaCompraProductos.getBtnAgregar().setEnabled(false);
            vistaCompraProductos.getSpinner().setEnabled(false);
        } else {
            vistaCompraProductos.getComboProveedor().setEnabled(true);
            vistaCompraProductos.getBtnAgregar().setEnabled(true);
            vistaCompraProductos.getSpinner().setEnabled(true);
        }
    }
    
    public Producto obtenerProductoEscogido() {
        int opcionElegida = vistaCompraProductos.getComboProducto().getSelectedIndex();
        vistaCompraProductos.getComboProveedor().setEnabled(true);
        return (Producto)opcionComboProducto.get(opcionElegida)[0];
    }
    
    public Proveedor obtenerProveedorEscogido() {
        int opcionElegida = vistaCompraProductos.getComboProveedor().getSelectedIndex();
        return (Proveedor)opcionComboProveedor.get(opcionElegida)[0];
    }
    
    public void agregarAlCarritoCompra() {
        HashMap <String, Object> informacionDelProducto = new HashMap();
        informacionDelProducto.put("nombre", null);
        informacionDelProducto.put("precio", null);
        informacionDelProducto.put("cantidad", null);
        informacionDelProducto.put("producto", null);
        informacionDelProducto.put("proveedor", null);
        articulosCarrito.put(null, informacionDelProducto);
        vistaCompraProductos.getBtnIrCarrito().setEnabled(true);
    }

    public void irCarritoCompra() {
        Carrito vistaCarrito = new Carrito("Registro de Ventas", obtenerProveedorEscogido().getNIT(), "Compra", almacenamiento, articulosCarrito);
        vistaCompraProductos.dispose();
    }
 
    public void irPpal() {
        Ppal vistaPpal = new Ppal("Supermercado - Universidad del Valle", almacenamiento);
        vistaCompraProductos.dispose();
    }
}
