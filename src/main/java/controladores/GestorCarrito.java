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
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;
import modelos.Almacenamiento;
import modelos.Cliente;
import modelos.Compra;
import modelos.Producto;
import modelos.Proveedor;
import modelos.Venta;
import vistas.Carrito;
import vistas.CompraProductos;
import vistas.ListaCompras;
import vistas.ListaVentas;
import vistas.Ppal;
import vistas.VentaProductos;

public class GestorCarrito {
    
    private final Carrito vistaCarrito;
    private final Almacenamiento almacenamiento;
    private final long identificador;
    private final String opcion;
    private final HashMap <Long, HashMap <String, Object>> articulosCarrito;
    
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
            
            case "Lista Venta" -> {
                plantillaListaVenta();
            }
            
            case "Lista Compra" -> {
                plantillaListaCompra();
            }
        }
    }
    
    public final void insertarProductos(){
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
                    fila[4] = ((int)fila[2]) * ((int) fila[3]);
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
            
            case "Lista Venta" -> {
                Iterator i = articulosCarrito.entrySet().iterator();

                while(i.hasNext()) {
                    HashMap.Entry <Long, HashMap<String, Object>> mapa = (HashMap.Entry) i.next();
                    HashMap <String, Object> informacion = mapa.getValue();
                    Object[] fila = new Object[5];
                    fila[0] = informacion.get("nombre");
                    fila[1] = mapa.getKey();
                    fila[2] = informacion.get("cantidad");
                    fila[3] = ((Producto) informacion.get("producto")).getPrecio();
                    fila[4] = ((int)fila[2]) * ((int) fila[3]);
                    vistaCarrito.anadirFilaTabla(fila);
                }
            }
            
            case "Lista Compra" -> {
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
        asignarPrecioTotal();
    }
    
    public void plantillaListaVenta(){
        vistaCarrito.getTxtNombre().setText(almacenamiento.getClientes().get(identificador).getNombre());
        vistaCarrito.getBtnCambiarCantidad().setVisible(false);
        vistaCarrito.getBtnEliminar().setVisible(false);
        vistaCarrito.getBtnFinalizarVenta().setVisible(false);
        asignarPrecioTotal();
    }
    
    public void plantillaCompra(){
        vistaCarrito.getLblNombre().setVisible(false);
        vistaCarrito.getTxtNombre().setVisible(false);
        vistaCarrito.getLblTitulo().setText("Compra productos");
        asignarPrecioTotal();
        vistaCarrito.anadirColumnaTabla("Proveedor");
    }
    
    public void plantillaListaCompra(){
        vistaCarrito.getLblTitulo().setText("Compra productos");
        vistaCarrito.getLblNombre().setVisible(false);
        vistaCarrito.getTxtNombre().setVisible(false);
        vistaCarrito.getBtnCambiarCantidad().setVisible(false);
        vistaCarrito.getBtnEliminar().setVisible(false);
        vistaCarrito.getBtnFinalizarVenta().setVisible(false);
        asignarPrecioTotal();
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
            
            if (e.getSource() == vistaCarrito.getBtnRegresar() && opcion.equals("Lista Venta")){
                if (e.getButton() == 1){
                    irListaVentaProductos();  
                }
            }
            
            if (e.getSource() == vistaCarrito.getBtnRegresar() && opcion.equals("Lista Compra")){
                if (e.getButton() == 1){
                    irListaCompraProductos();  
                }
            }
            
            if (e.getSource() == vistaCarrito.getBtnFinalizarVenta() && vistaCarrito.getBtnFinalizarVenta().isEnabled()){
                if (e.getButton() == 1){
                    irFinalizar();  
                }
            }
            
            if (e.getSource() == vistaCarrito.getBtnEliminar() && vistaCarrito.getBtnEliminar().isEnabled()){
                if (e.getButton() == 1){
                    eliminarProducto();
                }
            }
            
            if (e.getSource() == vistaCarrito.getBtnCambiarCantidad() && vistaCarrito.getBtnCambiarCantidad().isEnabled()){
                if (e.getButton() == 1){
                    cambiarCantidad();
                }
            }
        }
    }
    
    public void irFinalizar() {
        if (opcion.equals("Venta")) {
            Long codigo = asignarCodigoFactura();
            Cliente cliente = almacenamiento.getClientes().get(identificador);
            int precioTotal = Integer.parseInt(vistaCarrito.getTxtTotal().getText());
            
            //Eliminando existencias de los productos vendidos
            Iterator iteradorProductos = articulosCarrito.entrySet().iterator();
            while (iteradorProductos.hasNext()) {
                HashMap.Entry <Long, HashMap<String, Object>> mapa = (HashMap.Entry) iteradorProductos.next();
                HashMap <String, Object> informacion = mapa.getValue();
                long codigoProducto = mapa.getKey();
                int unidadesVendidas = (int)informacion.get("cantidad");
                almacenamiento.getProductos().get(codigoProducto).removerExistencias(unidadesVendidas);
            }
            
            Venta venta = new Venta(codigo, cliente, articulosCarrito, precioTotal);
            try {
                almacenamiento.anadirVenta(venta);
                JOptionPane.showMessageDialog(null, "Venta realizada con éxito", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar la venta", "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            Long codigo = asignarCodigoFactura();
            int precioTotal = Integer.parseInt(vistaCarrito.getTxtTotal().getText());
            
            //Eliminando existencias de los productos comprados
            Iterator iteradorProductos = articulosCarrito.entrySet().iterator();
            while (iteradorProductos.hasNext()) {
                HashMap.Entry <Long, HashMap<String, Object>> mapa = (HashMap.Entry) iteradorProductos.next();
                HashMap <String, Object> informacion = mapa.getValue();
                long codigoProducto = mapa.getKey();
                int unidadesCompradas = (int)informacion.get("cantidad");
                almacenamiento.getProductos().get(codigoProducto).agregarExistencias(unidadesCompradas);
                
            }
            Compra compra = new Compra(codigo, articulosCarrito, precioTotal);
            try {
                almacenamiento.anadirCompra(compra);
                JOptionPane.showMessageDialog(null, "Compra realizada con éxito", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar la compra", "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        irPpal();
    }
    
    public void eliminarProducto(){
        int filaSeleccionada =  vistaCarrito.getTablaContenido().getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un producto", "Error", 
                        JOptionPane.ERROR_MESSAGE);
            return;
        }
        Long codigoProductoSeleccionado = (Long) vistaCarrito.getTablaContenido().getModel().getValueAt(filaSeleccionada, 1);
        
        articulosCarrito.remove(codigoProductoSeleccionado);
        refrescarCarrito();
        if(vistaCarrito.getTablaContenido().getRowCount() == 0){
            vistaCarrito.getBtnEliminar().setEnabled(false);
            vistaCarrito.getBtnCambiarCantidad().setEnabled(false);
            vistaCarrito.getBtnFinalizarVenta().setEnabled(false);
        }
    }
    
    public void cambiarCantidad() {
        int filaSeleccionada =  vistaCarrito.getTablaContenido().getSelectedRow();
        
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un producto", "Error", 
                        JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Obteniendo las existencias del producto seleccionado
        Long codigoProductoSeleccionado = (Long) vistaCarrito.getTablaContenido().getModel().getValueAt(filaSeleccionada, 1);
        int existenciasDelProducto = almacenamiento.getProductos().get(codigoProductoSeleccionado).getCantidad();
        
        String cantidad = (String) JOptionPane.showInputDialog(null, 
                                "<html><p style = \" font:12px; \">Ingrese la nueva cantidad:"
                                        + "</p></html>", "Cambiar cantidad", 
                                JOptionPane.DEFAULT_OPTION);
        
        try {
            
            if(Integer.parseInt(cantidad) < 1) {
                JOptionPane.showMessageDialog(null, "Sólo puede comprar de 1 a 1000 unidades por producto", "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if(opcion.equals("Venta") && (Integer.parseInt(cantidad) > existenciasDelProducto) ){
                JOptionPane.showMessageDialog(null, "Superó la cantidad de existencias disponibles: " + existenciasDelProducto + " ", "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if((Integer.parseInt(cantidad) > 1000) ){
                JOptionPane.showMessageDialog(null, "Sólo puede comprar de 1 a 1000 unidades por producto", "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            articulosCarrito.get(codigoProductoSeleccionado).replace("cantidad", Integer.parseInt(cantidad));
            refrescarCarrito();
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese una cantidad válida", "Error", 
                    JOptionPane.ERROR_MESSAGE);
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
    
    public final long asignarCodigoFactura() {
        long miCodigoFactura = 1;
        if (opcion.equals("Venta")) {
            while (almacenamiento.getVentas().containsKey(miCodigoFactura)) {
                miCodigoFactura += 1;
            }
        } else {
            while (almacenamiento.getCompras().containsKey(miCodigoFactura)) {
                miCodigoFactura += 1;
            }
        }
        
        return miCodigoFactura;
    }
    
    public void irVentaProductos(){
        VentaProductos vistaVentaProductos = new VentaProductos("Supermercado - Universidad del Valle", identificador, almacenamiento, articulosCarrito);
        vistaCarrito.dispose();
    }
    
    public void irCompraProductos(){
        CompraProductos vistaCompraProductos = new CompraProductos("Supermercado - Universidad del Valle", almacenamiento, articulosCarrito);
        vistaCarrito.dispose();
    }
    
    public void irListaVentaProductos(){
        ListaVentas vistaListaVentas = new ListaVentas("Supermercado - Universidad del Valle", almacenamiento);
        vistaCarrito.dispose();
    }
    
    public void irListaCompraProductos(){
        ListaCompras vistaListaVentas = new ListaCompras("Supermercado - Universidad del Valle", almacenamiento);
        vistaCarrito.dispose();
    }
    
    public void irPpal() {
        Ppal vistaPpal = new Ppal("Supermercado - Universidad del Valle", almacenamiento);
        vistaCarrito.dispose();
    }
}
