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
import vistas.RegistroVentas;
import vistas.VentaProductos;

public class GestorRegistroVentas {
    
    private final RegistroVentas vistaRegistroVentas;
    private final Almacenamiento almacenamiento;

    public GestorRegistroVentas(RegistroVentas vistaRegistroVentas, Almacenamiento almacenamiento) {
        this.vistaRegistroVentas = vistaRegistroVentas;
        this.almacenamiento = almacenamiento;
        this.vistaRegistroVentas.addBtngetBtnRegresarVentaListener(new ManejadoraDeMouse());
        this.vistaRegistroVentas.addBtnFinalizarVentaListener(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaRegistroVentas.getBtnRegresarVenta()){
                if (e.getButton() == 1){
                    irVentaProductos();  
                }
            }
            
            if (e.getSource() == vistaRegistroVentas.getBtnFinalizarVenta()){
                if (e.getButton() == 1){
                    irFinalizarVenta();  
                }
            }
        }
    }
    
    public void irVentaProductos(){
        VentaProductos vistaVentaProductos = new VentaProductos("Venta de Productos", almacenamiento);
        vistaRegistroVentas.dispose();
    }
    
    public void irFinalizarVenta() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
}
