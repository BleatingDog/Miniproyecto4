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
import vistas.GestionSupermercado;
import vistas.PlantillaProveedor;

public class GestorPlantillaProveedor {
    
    private final PlantillaProveedor vistaPlantillaProveedor;
    private final String opcion;
    private long nit;
    private final Almacenamiento almacenamiento;
    
    public GestorPlantillaProveedor(PlantillaProveedor vistaPlantillaProveedor, String opcion, long nit, Almacenamiento almacenamiento) {
        this.vistaPlantillaProveedor = vistaPlantillaProveedor;
        this.opcion = opcion;
        this.nit = nit;
        this.almacenamiento = almacenamiento;
        this.vistaPlantillaProveedor.addBtnGeneralListener(new ManejadoraDeMouse());
        this.vistaPlantillaProveedor.addBtnRegresarListener(new ManejadoraDeMouse());
    }
    
    public void modificarPlantilla(){
        switch(opcion){
            case "Actualizar" -> {
                
                plantillaActualizarProveedor();
            }
            case "Eliminar" -> {
                plantillaEliminarProveedor();
                
            }
        }
    }

    private void plantillaActualizarProveedor() {
        vistaPlantillaProveedor.getLblTitulo().setText("Actualizar proveedor");
        vistaPlantillaProveedor.getBtnGeneral().setText("Actualizar");
    }

    private void plantillaEliminarProveedor() {
        vistaPlantillaProveedor.getLblTitulo().setText("Eliminar proveedor");
        vistaPlantillaProveedor.getBtnGeneral().setText("Eliminar");
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaPlantillaProveedor.getBtnGeneral() && "Agregar".equals(opcion)){
                if (e.getButton() == 1){
                    agregarProveedor();
                }
            }

            if (e.getSource() == vistaPlantillaProveedor.getBtnGeneral() && "Actualizar".equals(opcion)){
                if (e.getButton() == 1){
                    actualizarProveedor();
                }
            }
            
            if (e.getSource() == vistaPlantillaProveedor.getBtnGeneral() && "Eliminar".equals(opcion)){
                if (e.getButton() == 1){
                    eliminarProveedor();
                }
            }
            
            if (e.getSource() == vistaPlantillaProveedor.getBtnRegresar() && !"Consultar".equals(opcion)){
                if (e.getButton() == 1){
                    irGestion();  
                }
            } 
            if (e.getSource() == vistaPlantillaProveedor.getBtnRegresar() && "Consultar".equals(opcion)) {
                if (e.getButton() == 1){
                    irListaDeProveedores();
                }
            }
        }
    }
    
    private void agregarProveedor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void actualizarProveedor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void eliminarProveedor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void irGestion() {
        GestionSupermercado vistaGestionSupermercado = new GestionSupermercado("Supermercado - Universidad del Valle", almacenamiento);
        vistaPlantillaProveedor.dispose();
    }

    private void irListaDeProveedores() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
