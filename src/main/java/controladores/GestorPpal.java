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
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import modelos.Almacenamiento;
import vistas.CompraProductos;
import vistas.GestionSupermercado;
import vistas.Ppal;
import vistas.VentaProductos;

public class GestorPpal {
    
    private final Ppal vistaPpal;
    private final Almacenamiento almacenamiento;
    
    public GestorPpal(Ppal vistaPpal, Almacenamiento almacenamiento){
        this.vistaPpal = vistaPpal;
        this.almacenamiento = almacenamiento;
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
       try{
            String cedulaABuscar = (String) JOptionPane.showInputDialog(vistaPpal, 
                    "<html><p style = \" font:14px; \">Ingrese la cédula del cliente </p></html>", "Cedula cliente", 
                    JOptionPane.DEFAULT_OPTION);
            long cedula;
            

            if (cedulaABuscar.isBlank()){
                JOptionPane.showMessageDialog(vistaPpal, 
                        "<html><p style = \" font:14px; \">Por favor ingrese una "
                        + "cédula</p></html>", "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
                return;
            }
            try{
                cedula = Long.parseLong(cedulaABuscar);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese una cédula "
                        + "válida", "Error", JOptionPane.ERROR_MESSAGE);
                return;  
            }
            
            VentaProductos ventanaVentaProducto = new VentaProductos("Venta Poductos",almacenamiento);            

            /*if(!almacenamiento.getClientes().containsKey(cedula)){
                JOptionPane.showMessageDialog(vistaPpal, 
                        "<html><p style = \" font:12px; \">No se encontró ningún "
                        + "cliente registrado con esa cédula</p></html>", 
                        "Cliente no encontrado", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
                return;
            }*/
            
            } catch (NullPointerException np) {

            }
        
        vistaPpal.dispose();
    }
    
    public void irCompraDeProductos(){
        CompraProductos ventanaCompraProductos = new CompraProductos("Supermercado - Universidad del Valle",almacenamiento);
        vistaPpal.dispose();
    }
    
    public void irGestion(){
        GestionSupermercado ventanaGestionSupermercado = new GestionSupermercado("Supermercado - Universidad del Valle", almacenamiento);
        vistaPpal.dispose();
    }
}
