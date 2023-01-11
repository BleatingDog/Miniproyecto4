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
import vistas.GestionSupermercado;
import vistas.Ppal;

public class GestorPpal {
    
    private Ppal vistaPpal;
    
    public GestorPpal(Ppal vistaPpal){
        this.vistaPpal = vistaPpal;
        this.vistaPpal.addBtnCompraListener(new ManejadoraDeMouse());
        this.vistaPpal.addBtnVentaListener(new ManejadoraDeMouse());
        this.vistaPpal.addBtnGestionListener(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
          if (e.getSource() == vistaPpal.getBtnVenta()){
                if (e.getButton() == 1){
                    irVentaDeProductos();
                }
          }
          
          if (e.getSource() == vistaPpal.getBtnCompra()){
                if (e.getButton() == 1){
                    irCompraDeProductos();
                }
          }
          
          if (e.getSource() == vistaPpal.getBtnGestion()){
                if (e.getButton() == 1){
                    irGestion();
                }
          }
        }
    }
    
    public void irVentaDeProductos(){
        //VentaProductos ventanaVentaProductos = new VentaProductos();
        vistaPpal.dispose();
    }
    
    public void irCompraDeProductos(){
        //CompraProductos ventanaCompraProductos = new CompraProductos();
        vistaPpal.dispose();
    }
    
    public void irGestion(){
        GestionSupermercado ventanaGestionSupermercado = new GestionSupermercado("Supermercado - Universidad del Valle");
        vistaPpal.dispose();
    }
}
