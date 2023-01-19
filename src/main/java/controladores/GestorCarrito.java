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
import vistas.VentaProductos;

public class GestorCarrito {
    
    private final Carrito vistaCarrito;
    private final Almacenamiento almacenamiento;

    public GestorCarrito(Carrito vistaCarrito, Almacenamiento almacenamiento) {
        this.vistaCarrito = vistaCarrito;
        this.almacenamiento = almacenamiento;
        this.vistaCarrito.addBtngetBtnRegresarVentaListener(new ManejadoraDeMouse());
        this.vistaCarrito.addBtnFinalizarVentaListener(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaCarrito.getBtnRegresarVenta()){
                if (e.getButton() == 1){
                    irVentaProductos();  
                }
            }
            
            if (e.getSource() == vistaCarrito.getBtnFinalizarVenta()){
                if (e.getButton() == 1){
                    irFinalizarVenta();  
                }
            }
        }
    }
    
    public void irVentaProductos(){
        VentaProductos vistaVentaProductos = new VentaProductos("Venta de Productos", 0, almacenamiento);
        vistaCarrito.dispose();
    }
    
    public void irFinalizarVenta() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
}
