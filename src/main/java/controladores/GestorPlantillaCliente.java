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
import vistas.PlantillaCliente;

public class GestorPlantillaCliente {
    
    private final PlantillaCliente vistaPlantillaCliente;
    private final String opcion;
    private long cedula;
    
    public GestorPlantillaCliente(PlantillaCliente vistaPlantillaCliente, String opcion, long cedula){
        this.vistaPlantillaCliente = vistaPlantillaCliente;
        this.cedula = cedula;
        this.opcion = opcion;
        this.vistaPlantillaCliente.addBtnGeneralListener(new ManejadoraDeMouse());
        this.vistaPlantillaCliente.addBtnRegresarListener(new ManejadoraDeMouse());
    }
    
    public void modificarPlantilla(){
        switch(opcion){
            case "Actualizar" -> {
                
                plantillaActualizarCliente();
            }
            case "Eliminar" -> {
                plantillaEliminarCliente();
                
            }
            case "Consultar" -> {
                plantillaConsultarCliente();
                
            }
        }
    }

    private void plantillaActualizarCliente() {
        vistaPlantillaCliente.getLblTitulo().setText("Actualizar cliente");
        vistaPlantillaCliente.getBtnGeneral().setText("Actualizar");
    }

    private void plantillaEliminarCliente() {
        vistaPlantillaCliente.getLblTitulo().setText("Eliminar cliente");
        vistaPlantillaCliente.getBtnGeneral().setText("Eliminar");
    }

    private void plantillaConsultarCliente() {
        vistaPlantillaCliente.getLblTitulo().setText("Consultar cliente");
        vistaPlantillaCliente.getBtnGeneral().setText("Consultar");
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaPlantillaCliente.getBtnGeneral() && "Agregar".equals(opcion)){
                if (e.getButton() == 1){
                    agregarCliente();
                }
            }

            if (e.getSource() == vistaPlantillaCliente.getBtnGeneral() && "Actualizar".equals(opcion)){
                if (e.getButton() == 1){
                    actualizarCliente();
                }
            }
            
            if (e.getSource() == vistaPlantillaCliente.getBtnGeneral() && "Eliminar".equals(opcion)){
                if (e.getButton() == 1){
                    eliminarCliente();
                }
            }
            
            if (e.getSource() == vistaPlantillaCliente.getBtnRegresar() && !"Consultar".equals(opcion)){
                if (e.getButton() == 1){
                    irGestion();  
                }
            } 
            if (e.getSource() == vistaPlantillaCliente.getBtnRegresar() && "Consultar".equals(opcion)) {
                if (e.getButton() == 1){
                    irListaDeClientes();
                }
            }
        }

    }
    
    private void agregarCliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void actualizarCliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void eliminarCliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void irGestion() {
        GestionSupermercado vistaGestionSupermercado = new GestionSupermercado("Supermercado - Universidad del Valle");
        vistaPlantillaCliente.dispose();
    }

    private void irListaDeClientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
