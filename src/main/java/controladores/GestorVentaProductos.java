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
import modelos.Almacenamiento;
import modelos.Producto;
import vistas.Ppal;
import vistas.Carrito;
import vistas.VentaProductos;


public class GestorVentaProductos {
    
    private final VentaProductos vistaVentaProductos;
    private final Almacenamiento almacenamiento;
    private ArrayList<Object[]> opcionComboProducto;
    private HashMap<Long, HashMap<String, Object>> articulosCarrito;
    private final long cedula;
    private long codigoAsignado;
    
    public GestorVentaProductos(VentaProductos vistaVentaProductos, long cedula, Almacenamiento almacenamiento){
        this.vistaVentaProductos = vistaVentaProductos;
        this.almacenamiento = almacenamiento;
        this.cedula = cedula;
        modificarVentana();
        produtosDisponibles();
        this.vistaVentaProductos.addBtnRegresarListener(new ManejadoraDeMouse());
        this.vistaVentaProductos.addBtnAgregarListener(new ManejadoraDeMouse());
        this.vistaVentaProductos.addBtnIrCarritoListener(new ManejadoraDeMouse());
        this.vistaVentaProductos.addComboListener(new ManejadoraDeLista());
        if (!this.articulosCarrito.isEmpty()) {
            this.vistaVentaProductos.getBtnIrCarrito().setEnabled(true);
        }
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaVentaProductos.getBtnAgregar()){
                if (e.getButton() == 1 && vistaVentaProductos.getBtnAgregar().isEnabled()){
                    agregarAlCarritoVenta();
                }
            }
            
            if (e.getSource() == vistaVentaProductos.getBtnIrCarrito()){
                if (e.getButton() == 1 && vistaVentaProductos.getBtnIrCarrito().isEnabled()){
                    irCarritoVenta(cedula);
                }
            }
            
            if (e.getSource() == vistaVentaProductos.getBtnRegresar()){
                if (e.getButton() == 1 && vistaVentaProductos.getBtnRegresar().isEnabled()){
                    irPpal();
                }
            }
        }
    }
    
    class ManejadoraDeLista implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getSource() == vistaVentaProductos.getComboProducto()){
                vistaVentaProductos.reiniciarSpinner();
            }
        }
    }
    public final void modificarVentana(){
        vistaVentaProductos.getTxtCliente().setText(almacenamiento.getClientes().get(cedula).getNombre());
    }
    
    //Ingresa al comboBox los productos disponibles
    public final void produtosDisponibles(){
        vistaVentaProductos.limpiarProductosCombo();
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
            vistaVentaProductos.anadirProductosCombo(productoStr);
        }
    }
    public void agregarAlCarritoVenta() {
        
        HashMap <String, Object> informacionDelProducto = new HashMap();
        Producto productoSeleccionado = obtenerProductoEscogido();
        
        informacionDelProducto.put("Nombre", productoSeleccionado.getNombre());
        informacionDelProducto.put("Precio", productoSeleccionado.getPrecio());
        informacionDelProducto.put("Producto", productoSeleccionado);
        
        int cantidadProducto = (int)vistaVentaProductos.getSpinner().getValue();
        
        if(cantidadProducto > productoSeleccionado.getCantidad()) {
            JOptionPane.showMessageDialog(null, "Superó la cantidad de existencias disponibles", "Error", 
                       JOptionPane.ERROR_MESSAGE);
               return;
        }
        
        informacionDelProducto.put("Cantidad", cantidadProducto);
        
        articulosCarrito.put(productoSeleccionado.getCodigo(), informacionDelProducto);
        vistaVentaProductos.getBtnIrCarrito().setEnabled(true);
        JOptionPane.showMessageDialog(null, "Producto agregado al carrito con éxito", "Éxito",JOptionPane.INFORMATION_MESSAGE);
        
    }

    public Producto obtenerProductoEscogido() {
        int opcionElegida = vistaVentaProductos.getComboProducto().getSelectedIndex();
        return (Producto)opcionComboProducto.get(opcionElegida)[0];
    }
    
    public void irCarritoVenta(long cedulaCliente) {
        Carrito vistaCarrito = new Carrito(cedulaCliente, "Venta", almacenamiento, articulosCarrito);
        vistaVentaProductos.dispose();
    }
 
    public void irPpal() {
        Ppal vistaPpal = new Ppal("Supermercado - Universidad del Valle", almacenamiento);
        vistaVentaProductos.dispose();
    }
}
