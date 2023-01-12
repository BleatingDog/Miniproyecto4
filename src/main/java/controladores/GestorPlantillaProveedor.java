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

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelos.Almacenamiento;
import modelos.Producto;
import modelos.Proveedor;
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
        verificarNumero(vistaPlantillaProveedor.getTxtNit());
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
        vistaPlantillaProveedor.getTxtNit().setEditable(false);
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
            
            if (e.getSource() == vistaPlantillaProveedor.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestion();
                }
            }
        }
    }
    
    public void agregarProveedor() {
        if(validarCamposVacios()){
            JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos antes de continuar.", "Datos incompletos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Obteniendo los datos de la ventana
        String nombre = vistaPlantillaProveedor.getTxtNombre().getText();
        long nitNuevo = Long.parseLong(vistaPlantillaProveedor.getTxtNit().getText());
        List<String> listaProductos = vistaPlantillaProveedor.getListaProductos().getSelectedValuesList();
        ArrayList<Producto> misProductos = new ArrayList(listaProductos);
        
        //Creando el proveedor
        Proveedor proveedor = new Proveedor(nitNuevo, nombre, misProductos);
        
        try {
            //Agregando el proveedor
            if (almacenamiento.anadirProveedor(proveedor)){
                JOptionPane.showMessageDialog(null, "Proveedor agregado con éxito", "Resultado de agregar", JOptionPane.INFORMATION_MESSAGE);
                irGestion();
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un proveedor con ese número de NIT", "Resultado de agregar", JOptionPane.ERROR_MESSAGE);
            }
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al agregar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarProveedor() {
        if(validarCamposVacios()){
            JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos antes de continuar.", "Datos incompletos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Obteniendo los datos de la ventana
        String nombreNuevo = vistaPlantillaProveedor.getTxtNombre().getText();
        long nitNuevo = Long.parseLong(vistaPlantillaProveedor.getTxtNit().getText());
        List<String> listaProductos = vistaPlantillaProveedor.getListaProductos().getSelectedValuesList();
        ArrayList<Producto> misProductos = new ArrayList(listaProductos);
        
        //Creando el proveedor con los nuevos datos
        Proveedor proveedor = new Proveedor(nitNuevo, nombreNuevo, misProductos);
        
        try {
            //Actualizando el proveedor
            if (almacenamiento.actualizarProveedor(nit, proveedor)){
                JOptionPane.showMessageDialog(null, "Proveedor actualizar con éxito", "Resultado de actualizar", JOptionPane.INFORMATION_MESSAGE);
                irGestion();
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un proveedor con ese número de NIT", "Resultado de actualizar", JOptionPane.ERROR_MESSAGE);
            }
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al agregar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarProveedor() {
        //Eliminando el proveedor
        try{
            almacenamiento.eliminarProveedor(nit);
            JOptionPane.showMessageDialog(null, "Proveedor eliminado con éxito", "Resultado de eliminar", JOptionPane.INFORMATION_MESSAGE);
            irGestion();
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void irGestion() {
        GestionSupermercado vistaGestionSupermercado = new GestionSupermercado("Supermercado - Universidad del Valle", almacenamiento);
        vistaPlantillaProveedor.dispose();
    }
    
    public final void verificarNumero(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (!Character.isDigit(c) | Character.isSpaceChar(c)){
                    e.consume();
                }
            }
        });
    }
    
    public boolean validarCamposVacios(){
        boolean error = false;
        if(vistaPlantillaProveedor.getTxtNombre().getText().isBlank())
            error = true;
        if(vistaPlantillaProveedor.getTxtNit().getText().isBlank())
            error = true;
        List<String> listaProductos = vistaPlantillaProveedor.getListaProductos().getSelectedValuesList();
        if(listaProductos.isEmpty())
            error = true;
        return error;
    }
}
