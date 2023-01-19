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
import modelos.Almacenamiento;
import vistas.Carrito;
import vistas.CompraProductos;
import vistas.VentaProductos;

public class GestorCarrito {
    
    private final Carrito vistaCarrito;
    private final Almacenamiento almacenamiento;
    private final long identificador;
    private final String opcion;
    public GestorCarrito(Carrito vistaCarrito, long identificador, String opcion, Almacenamiento almacenamiento) {
        this.vistaCarrito = vistaCarrito;
        this.almacenamiento = almacenamiento;
        this.identificador = identificador;
        this.opcion = opcion;
        modificarPlantilla();
        this.vistaCarrito.addBtnRegresarVentaListener(new ManejadoraDeMouse());
        this.vistaCarrito.addBtnFinalizarVentaListener(new ManejadoraDeMouse());
        this.vistaCarrito.addBtnEliminarListener(new ManejadoraDeMouse());
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
        //Inserte aquí los productos
    }
    
    public void plantillaVenta(){
        vistaCarrito.getTxtNombre().setText(almacenamiento.getClientes().get(identificador).getNombre());
        vistaCarrito.getTxtTotal().setText("10000");
    }
    
    public void plantillaCompra(){
        vistaCarrito.getLblNombre().setText("Proveedor");
        vistaCarrito.getTxtNombre().setText(almacenamiento.getProveedores().get(identificador).getNombre());
        vistaCarrito.getTxtTotal().setText("10000");
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
        }
    }
    
    public void irVentaProductos(){
        VentaProductos vistaVentaProductos = new VentaProductos("Supermercado - Universidad del Valle", identificador, almacenamiento);
        vistaCarrito.dispose();
    }
    
    public void irCompraProductos(){
        CompraProductos vistaCompraProductos = new CompraProductos("Supermercado - Universidad del Valle", almacenamiento);
        vistaCarrito.dispose();
    }
    
    public void irFinalizarVenta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void eliminarProducto(){
        
    }
}
