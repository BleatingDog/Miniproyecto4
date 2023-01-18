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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelos.Almacenamiento;
import modelos.Cliente;
import vistas.GestionSupermercado;
import vistas.PlantillaCliente;

public class GestorPlantillaCliente {
    
    private final PlantillaCliente vistaPlantillaCliente;
    private final String opcion;
    private final long cedula;
    private final Almacenamiento almacenamiento;
    
    public GestorPlantillaCliente(PlantillaCliente vistaPlantillaCliente, String opcion, long cedula, Almacenamiento almacenamiento){
        this.vistaPlantillaCliente = vistaPlantillaCliente;
        this.cedula = cedula;
        this.opcion = opcion;
        this.almacenamiento = almacenamiento;
        modificarPlantilla();
        this.vistaPlantillaCliente.addBtnGeneralListener(new ManejadoraDeMouse());
        this.vistaPlantillaCliente.addBtnRegresarListener(new ManejadoraDeMouse());
        verificarNumero(vistaPlantillaCliente.getTxtCedula());
        verificarNumero(vistaPlantillaCliente.getTxtTelefono());
        verificarTexto(vistaPlantillaCliente.getTxtNombre());
    }
    
    public void modificarPlantilla(){
        switch(opcion){
            case "Actualizar" -> {
                
                plantillaActualizarCliente();
            }
            case "Eliminar" -> {
                plantillaEliminarCliente();
                
            }
        }
    }

    public void plantillaActualizarCliente() {
        //Modificando título y botón general
        vistaPlantillaCliente.getLblTitulo().setText("Actualizar cliente");
        vistaPlantillaCliente.getBtnGeneral().setText("Actualizar");
        
        //Desactivando campo cédula
        vistaPlantillaCliente.getTxtCedula().setEditable(false);
        
        //Ingresando los datos del cliente
        Cliente miCliente = almacenamiento.getClientes().get(cedula);
        vistaPlantillaCliente.getTxtNombre().setText(miCliente.getNombre());
        vistaPlantillaCliente.getTxtCedula().setText(String.valueOf(miCliente.getCedula()));
        vistaPlantillaCliente.getTxtTelefono().setText(String.valueOf(miCliente.getTelefono()));
    }

    public void plantillaEliminarCliente() {
        
        //Modificando título y botón general
        vistaPlantillaCliente.getLblTitulo().setText("Eliminar cliente");
        vistaPlantillaCliente.getBtnGeneral().setText("Eliminar");
        
        //Desactivando campos
        vistaPlantillaCliente.getTxtNombre().setEditable(false);
        vistaPlantillaCliente.getTxtCedula().setEditable(false);
        vistaPlantillaCliente.getTxtTelefono().setEditable(false);
        
        //Ingresando datos del cliente
        Cliente miCliente = almacenamiento.getClientes().get(cedula);
        vistaPlantillaCliente.getTxtNombre().setText(miCliente.getNombre());
        vistaPlantillaCliente.getTxtCedula().setText(String.valueOf(miCliente.getCedula()));
        vistaPlantillaCliente.getTxtTelefono().setText(String.valueOf(miCliente.getTelefono()));
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
            
            if (e.getSource() == vistaPlantillaCliente.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestion();
                }
            }
        }
    }
    
    public void agregarCliente() {
        if(validarCamposVacios()){
            JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos antes de continuar.", "Datos incompletos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Obteniendo los datos de la ventana
        String nombre = vistaPlantillaCliente.getTxtNombre().getText();
        long cedulaNueva = Long.parseLong(vistaPlantillaCliente.getTxtCedula().getText());
        long telefono = Long.parseLong(vistaPlantillaCliente.getTxtTelefono().getText());

        //Creando el cliente
        Cliente cliente = new Cliente(cedulaNueva, nombre, telefono);
        try {
            //Agregando al cliente
            if (almacenamiento.anadirCliente(cliente)){
                JOptionPane.showMessageDialog(null, "Cliente agregado con éxito", "Resultado de agregar", JOptionPane.INFORMATION_MESSAGE);
                irGestion();
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe una persona con ese número de cédula", "Resultado de agregar", JOptionPane.ERROR_MESSAGE);
            }
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al agregar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarCliente() {
        if(validarCamposVacios()){
            JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos antes de continuar.", "Datos incompletos", JOptionPane.ERROR_MESSAGE);            
            return;
        }
        
        //Obteniendo los datos de la ventana
        String nombre = vistaPlantillaCliente.getTxtNombre().getText();
        long telefono = Long.parseLong(vistaPlantillaCliente.getTxtTelefono().getText());
        
        //Creando el cliente con los nuevos datos
        Cliente cliente = new Cliente(cedula, nombre, telefono);

        //Verifica si no existe una cédula duplicada y modifica el cliente
        try {
            if(almacenamiento.modificarCliente(cedula ,cliente)){
                JOptionPane.showMessageDialog(null, "Cliente actualizado con éxito", "Resultado de actualizar", JOptionPane.INFORMATION_MESSAGE);
                irGestion();            
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un cliente con esa cédula", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarCliente() {
        //Eliminando el cliente
        try{
            almacenamiento.eliminarCliente(cedula);
            JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito", "Resultado de eliminar", JOptionPane.INFORMATION_MESSAGE);
            irGestion();
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void irGestion() {
        GestionSupermercado vistaGestionSupermercado = new GestionSupermercado("Supermercado - Universidad del Valle", almacenamiento);
        vistaPlantillaCliente.dispose();
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
    
    public final void verificarTexto(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (!Character.isAlphabetic(c)){
                    e.consume();
                }
            }
        });
    }
    
    public boolean validarCamposVacios(){
        boolean error = false;
        if(vistaPlantillaCliente.getTxtNombre().getText().isBlank())
            error = true;
        if(vistaPlantillaCliente.getTxtCedula().getText().isBlank())
            error = true;
        if(vistaPlantillaCliente.getTxtTelefono().getText().isBlank())
            error = true;
        return error;
    }
}
