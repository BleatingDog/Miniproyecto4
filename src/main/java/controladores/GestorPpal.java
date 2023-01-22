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
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import modelos.Almacenamiento;
import vistas.CompraProductos;
import vistas.GestionSupermercado;
import vistas.ListaCompras;
import vistas.ListaVentas;
import vistas.Ppal;
import vistas.VentaProductos;

public class GestorPpal {
    
    private final Ppal vistaPpal;
    private final Almacenamiento almacenamiento;
    
    public GestorPpal(Ppal vistaPpal, Almacenamiento almacenamiento){
        this.vistaPpal = vistaPpal;
        this.almacenamiento = almacenamiento;
        
        //Añadiendo listeners
        this.vistaPpal.addBtnCompraListener(new ManejadoraDeMouse());
        this.vistaPpal.addBtnVentaListener(new ManejadoraDeMouse());
        this.vistaPpal.addBtnGestionListener(new ManejadoraDeMouse());
        this.vistaPpal.addBtnRegistroComprasListener(new ManejadoraDeMouse());
        this.vistaPpal.addBtnRegistroVentasListener(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            if (e.getSource() == vistaPpal.getBtnVenta()){
                  if (e.getButton() == 1){
                      ventaDeProductos();
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

            if (e.getSource() == vistaPpal.getBtnRegistroCompras()){
                if (e.getButton() == 1){
                    irRegistroCompras();
                }
            }
            
            if (e.getSource() == vistaPpal.getBtnRegistroVentas()){
                if (e.getButton() == 1){
                    irRegistroVentas();
                }
            }
        }
    }
    
    public void ventaDeProductos(){
       try{
           if(almacenamiento.getProductos().isEmpty() || almacenamiento.getProveedores().isEmpty()){
                JOptionPane.showMessageDialog(vistaPpal, 
                        "<html><p style = \" font:12px; \">Agregue por lo menos 1 producto y 1 proveedor</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
                return;
            }
            String cedulaABuscar = (String) JOptionPane.showInputDialog(vistaPpal, 
                    "<html><p style = \" font:14px; \">Ingrese la cédula del cliente </p></html>", "Datos requeridos", 
                    JOptionPane.DEFAULT_OPTION);
            
            if (cedulaABuscar.isBlank()){
                JOptionPane.showMessageDialog(vistaPpal, 
                        "<html><p style = \" font:14px; \">Por favor ingrese una "
                        + "cédula</p></html>", "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
                return;
            }
            
            long cedula;
            try{
                cedula = Long.parseLong(cedulaABuscar);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese una cédula "
                        + "válida", "Error", JOptionPane.ERROR_MESSAGE);
                return;  
            }
            
            if(!almacenamiento.getClientes().containsKey(cedula)){
                JOptionPane.showMessageDialog(vistaPpal, 
                        "<html><p style = \" font:12px; \">No se encontró ningún "
                        + "cliente registrado con esa cédula</p></html>", 
                        "Cliente no encontrado", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
                return;
            }
            
            irVentaDeProductos(cedula);
        } catch (NullPointerException np) {

        }
    }
    
    public void irVentaDeProductos(long cedula){
        VentaProductos vistaVentaProductos = new VentaProductos("Supermercado - Universidad del Valle", cedula, almacenamiento);
        vistaPpal.dispose();
    }
    
    public void irRegistroCompras() {
        if(almacenamiento.getCompras().isEmpty()){
            JOptionPane.showMessageDialog(null, "Aún no se han realizado compras", "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;  
        }
        ListaCompras vistaListaCompras = new ListaCompras("Supermercado - Universidad del Valle", almacenamiento);
        vistaPpal.dispose();
    }

    public void irRegistroVentas() {
        if(almacenamiento.getVentas().isEmpty()){
            JOptionPane.showMessageDialog(null, "Aún no se han realizado ventas", "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;  
        }
        ListaVentas vistaListaVentas = new ListaVentas("Supermercado - Universidad del Valle", almacenamiento);
        vistaPpal.dispose();
    }
    
    public void irCompraDeProductos(){
        HashMap <Long, HashMap <String, Object>> articulosCarrito = new HashMap();
        CompraProductos vistaCompraProductos = new CompraProductos("Supermercado - Universidad del Valle", almacenamiento, articulosCarrito);
        vistaPpal.dispose();
    }
    
    public void irGestion(){
        GestionSupermercado ventanaGestionSupermercado = new GestionSupermercado("Supermercado - Universidad del Valle", almacenamiento);
        vistaPpal.dispose();
    }
}
