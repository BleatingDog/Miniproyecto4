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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;
import modelos.Almacenamiento;
import modelos.Producto;
import modelos.Proveedor;
import vistas.Carrito;
import vistas.CompraProductos;
import vistas.VentaProductos;

public class GestorCarrito {
    
    private final Carrito vistaCarrito;
    private final Almacenamiento almacenamiento;
    private final long identificador;
    private final String opcion;
    private HashMap <Long, HashMap <String, Object>> articulosCarrito;
    
    public GestorCarrito(Carrito vistaCarrito, long identificador, String opcion, Almacenamiento almacenamiento, HashMap <Long, HashMap <String, Object>> articulosCarrito) {
        this.vistaCarrito = vistaCarrito;
        this.almacenamiento = almacenamiento;
        this.identificador = identificador;
        this.opcion = opcion;
        this.articulosCarrito = articulosCarrito;
        modificarPlantilla();
        this.vistaCarrito.addBtnRegresarVentaListener(new ManejadoraDeMouse());
        this.vistaCarrito.addBtnFinalizarVentaListener(new ManejadoraDeMouse());
        this.vistaCarrito.addBtnEliminarListener(new ManejadoraDeMouse());
        this.vistaCarrito.addBtnCambiarCantidadListener(new ManejadoraDeMouse());
        insertarProductos();
    }
    
    public final void modificarPlantilla(){
        switch(opcion) {
            case "Venta" -> {
                plantillaVenta();
            }
            
            case "Compra" -> {
                plantillaCompra();
            }
        }
    }
    
    public void insertarProductos(){
        switch(opcion) {
            case "Venta" -> {
                Iterator i = articulosCarrito.entrySet().iterator();

                while(i.hasNext()) {
                    HashMap.Entry <Long, HashMap<String, Object>> mapa = (HashMap.Entry) i.next();
                    HashMap <String, Object> informacion = mapa.getValue();
                    Object[] fila = new Object[5];
                    fila[0] = informacion.get("nombre");
                    fila[1] = mapa.getKey();
                    fila[2] = informacion.get("cantidad");
                    fila[3] = ((Producto) informacion.get("producto")).getPrecio();
                    fila[4] = ((int) fila[1]) * ((int) fila[2]);
                    vistaCarrito.anadirFilaTabla(fila);
                }
            }
            
            case "Compra" -> {
                Iterator i = articulosCarrito.entrySet().iterator();

                while(i.hasNext()) {
                    HashMap.Entry <Long, HashMap<String, Object>> mapa = (HashMap.Entry) i.next();
                    HashMap <String, Object> informacion = mapa.getValue();
                    Object[] fila = new Object[6];
                    fila[0] = informacion.get("nombre");
                    fila[1] = mapa.getKey();
                    fila[2] = informacion.get("cantidad");
                    fila[3] = ((Producto) informacion.get("producto")).getPrecio();
                    fila[4] = ((int) fila[2]) * ((int) fila[3]);
                    fila[5] = ((Proveedor) informacion.get("proveedor")).getNombre();
                    vistaCarrito.anadirFilaTabla(fila);
                }
            }
        }
    }
    
    public void plantillaVenta(){
        vistaCarrito.getTxtNombre().setText(almacenamiento.getClientes().get(identificador).getNombre());
        
        Iterator i = articulosCarrito.entrySet().iterator();
        int precioTotal = 0;
        asignarPrecioTotal();
        vistaCarrito.getTxtTotal().setText(String.valueOf(precioTotal));
    }
    
    public void plantillaCompra(){
        vistaCarrito.getLblNombre().setVisible(false);
        vistaCarrito.getTxtNombre().setVisible(false);
        vistaCarrito.getLblTitulo().setText("Compra productos");
        asignarPrecioTotal();
        vistaCarrito.anadirColumnaTabla("Proveedor");
    }
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaCarrito.getBtnRegresar() && opcion.equals("Venta")){
                if (e.getButton() == 1){
                    irVentaProductos();  
                }
            }
            
            if (e.getSource() == vistaCarrito.getBtnRegresar() && opcion.equals("Compra")){
                if (e.getButton() == 1){
                    irCompraProductos();  
                }
            }
            
            if (e.getSource() == vistaCarrito.getBtnFinalizarVenta()){
                if (e.getButton() == 1){
                    irFinalizarVenta();  
                }
            }
            
            if (e.getSource() == vistaCarrito.getBtnEliminar()){
                if (e.getButton() == 1){
                    //Eliminar producto de la lista  
                }
            }
            
            if (e.getSource() == vistaCarrito.getBtnCambiarCantidad()){
                if (e.getButton() == 1){
                    cambiarCantidad();
                }
            }
        }
    }
    
    public void irVentaProductos(){
        VentaProductos vistaVentaProductos = new VentaProductos("Supermercado - Universidad del Valle", identificador, almacenamiento);
        vistaCarrito.dispose();
    }
    
    public void irCompraProductos(){
        CompraProductos vistaCompraProductos = new CompraProductos("Supermercado - Universidad del Valle", almacenamiento, articulosCarrito);
        vistaCarrito.dispose();
    }
    
    public void irFinalizarVenta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void eliminarProducto(){
        
    }
    
    public void cambiarCantidad() {
        int filaSeleccionada =  vistaCarrito.getTablaContenido().getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un producto", "Error", 
                        JOptionPane.ERROR_MESSAGE);
            return;
        }
        Long codigoProductoSeleccionado = (Long) vistaCarrito.getTablaContenido().getModel().getValueAt(filaSeleccionada, 1);
        
        String cantidad = (String) JOptionPane.showInputDialog(null, 
                                "<html><p style = \" font:12px; \">Ingrese la nueva cantidad:"
                                        + "</p></html>", "Actualizar cliente", 
                                JOptionPane.DEFAULT_OPTION);
        
        try {
            
            if(Integer.parseInt(cantidad) < 1) {
                JOptionPane.showMessageDialog(null, "Sólo puede comprar de 1 a 1000 unidades por producto", "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if(Integer.parseInt(cantidad) > 1000 ){ //Cant. de productos > existencias
                JOptionPane.showMessageDialog(null, "Superó la cantidad de existencias disponibles", "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            articulosCarrito.get(codigoProductoSeleccionado).replace("cantidad", Integer.parseInt(cantidad));
            refrescarCarrito();
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese una cantidad válida", "Error", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
    public void refrescarCarrito() {
        int cantidad = vistaCarrito.getTablaContenido().getRowCount();
        for(int i = 0; i < cantidad; i++){
            vistaCarrito.getModeloTablaContenido().removeRow(0);
        }
        insertarProductos();
        asignarPrecioTotal();
    }
    
    public void asignarPrecioTotal() {
        Iterator i = articulosCarrito.entrySet().iterator();
        int precioTotal = 0;
        while(i.hasNext()) {
            HashMap.Entry <Long, HashMap<String, Object>> mapa = (HashMap.Entry) i.next();
            HashMap <String, Object> informacion = mapa.getValue();
            int cantidad = (int) informacion.get("cantidad");
            int precio = (int) ((Producto) informacion.get("producto")).getPrecio();
            precioTotal += cantidad * precio;
        }
        vistaCarrito.getTxtTotal().setText(String.valueOf(precioTotal));
    }
}
