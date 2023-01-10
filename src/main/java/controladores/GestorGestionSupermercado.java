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
import vistas.GestionSupermercado;
import vistas.ListaProductos;
import vistas.PlantillaCliente;
import vistas.PlantillaProducto;
import vistas.PlantillaProveedor;
import vistas.Ppal;

public class GestorGestionSupermercado {
    
    private GestionSupermercado vistaGestionSupermercado;
    private final String[] opciones = {
                                    "Agregar",
                                    "Actualizar",
                                    "Consultar",
                                    "Eliminar"
                                   };
    
    public GestorGestionSupermercado(GestionSupermercado vistaGestionSupermercado){
        this.vistaGestionSupermercado = vistaGestionSupermercado;
        this.vistaGestionSupermercado.addBtnClienteListener(new ManejadoraDeMouse());
        this.vistaGestionSupermercado.addBtnProductoListener(new ManejadoraDeMouse());
        this.vistaGestionSupermercado.addBtnProveedorListener(new ManejadoraDeMouse());
        this.vistaGestionSupermercado.addBtnRegresarListener(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
          if (e.getSource() == vistaGestionSupermercado.getBtnCliente()){
                if (e.getButton() == 1){
                    opcionesCliente();
                }
          }
          
          if (e.getSource() == vistaGestionSupermercado.getBtnProducto()){
                if (e.getButton() == 1){
                    irPlantillaProducto();
                }
          }
          
          if (e.getSource() == vistaGestionSupermercado.getBtnProveedor()){
                if (e.getButton() == 1){
                    irPlantillaProveedor();
                }
          }
          
          if (e.getSource() == vistaGestionSupermercado.getBtnRegresar()){
                if (e.getButton() == 1){
                    irPpal();
                }
          }
        }

    }
    
    public void opcionesCliente(){
        try {
            String resp = (String) JOptionPane.showInputDialog(vistaGestionSupermercado, 
                    "<html><p style = \" font:12px; \">¿Qué desea hacer?</p></html>", 
                    "Opciones afiliados", JOptionPane.DEFAULT_OPTION, 
                    UIManager.getIcon("OptionPane.questionIcon"), opciones, opciones[0]);
        switch(resp) {
            case "Agregar" -> {
                irAgregarCliente();
            }
            case "Actualizar" -> {
                try{
                        String cedulaABuscar = (String) JOptionPane.showInputDialog(vistaGestionSupermercado, 
                                "<html><p style = \" font:12px; \">Ingrese la cédula del afiliado "
                                + "a actualizar</p></html>", "Actualizar afiliado", 
                                JOptionPane.DEFAULT_OPTION);
                        long cedula;
                        if (cedulaABuscar.isBlank()){
                            JOptionPane.showMessageDialog(vistaGestionSupermercado, 
                                    "<html><p style = \" font:12px; \">Por favor ingrese una "
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
                        if(!almacenamiento.getClientes().containsKey(cedula)){
                            JOptionPane.showMessageDialog(vistaGestionSupermercado, 
                                    "<html><p style = \" font:12px; \">No se encontró ningún "
                                    + "afiliado registrado con esa cédula</p></html>", 
                                    "Afiliado no encontrado", JOptionPane.OK_OPTION, 
                                    UIManager.getIcon("OptionPane.errorIcon"));
                            return;
                        }
                        irActualizarCliente(cedula);
                    } catch (NullPointerException np) {
                        
                    }
            }
            case "Eliminar" -> {
                try{
                    String cedulaABuscar = (String) JOptionPane.showInputDialog(vistaGestionSupermercado, 
                            "<html><p style = \" font:12px; \">Ingrese la cédula del afiliado "
                                    + "a actualizar</p></html>", "Actualizar afiliado", 
                                    JOptionPane.DEFAULT_OPTION);
                    long cedula;
                    if (cedulaABuscar.isBlank()){
                        JOptionPane.showMessageDialog(vistaGestionSupermercado, 
                                "<html><p style = \" font:12px; \">Por favor ingrese una "
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
                    if(!almacenamiento.getAfiliados().containsKey(cedula)){
                        JOptionPane.showMessageDialog(vistaGestionSupermercado, 
                                "<html><p style = \" font:12px; \">No se encontró ningún afiliado"
                                + " registrado con esa cédula</p></html>", 
                                "Afiliado no encontrado", JOptionPane.OK_OPTION, 
                                UIManager.getIcon("OptionPane.errorIcon"));
                        return;
                    }
                    irEliminarCliente(cedula);
                }
            }
            case "Consultar" -> {
                irConsultarCliente();
            }
        }
        } catch (NullPointerException np) {
            
        }
    }
    public void irAgregarCliente() {
        PlantillaCliente vistaPlantillaCliente = new PlantillaCliente("Supermercado - Universidad del Valle", "Agregar", 0);
        vistaGestionSupermercado.dispose();
    }
    public void irActualizarCliente(long cedula) {
        PlantillaCliente vistaPlantillaCliente = new PlantillaCliente("Supermercado - Universidad del Valle", "Actualizar", cedula);
        vistaGestionSupermercado.dispose();
    }
    public void irEliminarCliente(long cedula) {
        PlantillaCliente vistaPlantillaCliente = new PlantillaCliente("Supermercado - Universidad del Valle", "Eliminar", cedula);
        vistaGestionSupermercado.dispose();
    }
    public void irConsultarCliente() {
        PlantillaCliente vistaPlantillaCliente = new PlantillaCliente("Supermercado - Universidad del Valle", "Agregar", 0);
        vistaGestionSupermercado.dispose();
    }

    public void opcionesProducto(){
        try {
            
            String resp = (String) JOptionPane.showInputDialog(vistaGestionSupermercado, 
                    "<html><p style = \" font:12px; \">¿Qué desea hacer?</p></html>", 
                    "Opciones afiliados", JOptionPane.DEFAULT_OPTION, 
                    UIManager.getIcon("OptionPane.questionIcon"), opciones, opciones[0]);
        switch(resp) {
            case "Agregar" -> {
                irAgregarProducto();
            }
            case "Actualizar" -> {
                irActualizarProducto();
            }
            case "Eliminar" -> {
                irEliminarProducto();
            }
            case "Consultar" -> {
                irConsultarProducto();
            }
        }
        
            
        } catch (NullPointerException np) {
            
        }
    }
    
    public void irAgregarProducto(){
        PlantillaProducto vistaPlantillaProducto = new PlantillaProducto("Supermercado - Universidad del Valle", "Agregar", 0);
        vistaGestionSupermercado.dispose();
    }
    
    public void irActualizarProducto(){
        PlantillaProducto vistaPlantillaProducto = new PlantillaProducto("Supermercado - Universidad del Valle", "Actualizar", codigo);
        vistaGestionSupermercado.dispose();
    }
    public void irEliminarProducto(){
        PlantillaProducto vistaPlantillaProducto = new PlantillaProducto("Supermercado - Universidad del Valle", "Eliminar", codigo);
        vistaGestionSupermercado.dispose();
    }
    public void irConsultarProducto(){
        ListaProductos vistaListaProductos = new ListaProductos("Supermercado - Universidad del Valle");
        vistaGestionSupermercado.dispose();
    }
    
    public void irPlantillaProveedor() {
        PlantillaProveedor vistaPlantillaProveedor = new PlantillaProveedor("Supermercado - Universidad del Valle");
        vistaGestionSupermercado.dispose();
    }

    public void irPpal() {
        Ppal vistaPpal = new Ppal("Supermercado - Universidad del Valle");
        vistaGestionSupermercado.dispose();
    }
}
