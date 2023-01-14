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
import modelos.Producto;
import vistas.GestionSupermercado;
import vistas.PlantillaProducto;

public class GestorPlantillaProducto {
    
    private final PlantillaProducto vistaPlantillaProducto;
    private final String opcion;
    private final int codigo;
    private long codigoAsignado;
    private final Almacenamiento almacenamiento;
        
    public GestorPlantillaProducto(PlantillaProducto vistaPlantillaProducto, String opcion, int codigo, Almacenamiento almacenamiento){
        this.vistaPlantillaProducto = vistaPlantillaProducto;
        this.codigo = codigo;
        this.opcion = opcion;
        this.almacenamiento = almacenamiento;
        this.vistaPlantillaProducto.addBtnGeneralListener(new ManejadoraDeMouse());
        this.vistaPlantillaProducto.addBtnRegresarListener(new ManejadoraDeMouse());
        modificarPlantilla();
        if("Agendar".equals(opcion)){
            asignarCodigoProducto();
        }
        verificarTexto(vistaPlantillaProducto.getTxtNombre());
        verificarNumero(vistaPlantillaProducto.getTxtPrecio());
    }
    
    public void modificarPlantilla(){
        switch(opcion){
            case "Actualizar" -> {
                
                plantillaActualizarProducto();
            }
            case "Eliminar" -> {
                plantillaEliminarProducto();
                
            }
        }
    }

    public void plantillaActualizarProducto() {
        
        vistaPlantillaProducto.getLblTitulo().setText("Actualizar producto");
        vistaPlantillaProducto.getBtnGeneral().setText("Actualizar");
        
        //Ingresando datos del producto en la ventana
        vistaPlantillaProducto.getTxtCodigo().setText(String.valueOf(codigo));
        vistaPlantillaProducto.getTxtNombre().setText(almacenamiento.getProductos().get(codigo).getNombre());
        vistaPlantillaProducto.getTxtPrecio().setText(almacenamiento.getProductos().get(codigo).getPrecio());
        
    }

    public void plantillaEliminarProducto() {
        vistaPlantillaProducto.getLblTitulo().setText("Eliminar producto");
        vistaPlantillaProducto.getBtnGeneral().setText("Eliminar");
        
        //Ingresando datos del producto en la ventana
        vistaPlantillaProducto.getTxtCodigo().setText(String.valueOf(codigo));
        vistaPlantillaProducto.getTxtNombre().setText(almacenamiento.getProductos().get(codigo).getNombre());
        vistaPlantillaProducto.getTxtPrecio().setText(almacenamiento.getProductos().get(codigo).getPrecio());
        
        //Desactivando campos
        vistaPlantillaProducto.getTxtCodigo().setEditable(false);
        vistaPlantillaProducto.getTxtNombre().setEditable(false);
        vistaPlantillaProducto.getTxtPrecio().setEditable(false);
    }

    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaPlantillaProducto.getBtnGeneral() && "Agregar".equals(opcion)){
                if (e.getButton() == 1){
                    agregarProducto();
                }
            }

            if (e.getSource() == vistaPlantillaProducto.getBtnGeneral() && "Actualizar".equals(opcion)){
                if (e.getButton() == 1){
                    actualizarProducto();
                }
            }
            
            if (e.getSource() == vistaPlantillaProducto.getBtnGeneral() && "Eliminar".equals(opcion)){
                if (e.getButton() == 1){
                    eliminarProducto();
                }
            }
            
            if (e.getSource() == vistaPlantillaProducto.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestion();
                }
            }
        }
    }
    
    public void agregarProducto() {
        if(validarCamposVacios()){
            JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos antes de continuar.", "Datos incompletos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Obteniendo los datos de la ventana
        String nombre = vistaPlantillaProducto.getTxtNombre().getText();
        int precioNuevo = Integer.parseInt(vistaPlantillaProducto.getTxtPrecio().getText());
        long numeroCodigo = Long.parseLong(vistaPlantillaProducto.getTxtCodigo().getText());
        //Estableciendo los datos obtenidos al modelo
        Producto producto = new Producto(numeroCodigo, nombre, precioNuevo);
        try {
            //Agregando el producto
            if (almacenamiento.anadirProducto(producto)){ //Posiblemente nunca entre al else
                JOptionPane.showMessageDialog(null, "Producto agregado con éxito", "Resultado de agregar", JOptionPane.INFORMATION_MESSAGE);
                irGestion();
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe una producto con ese código", "Resultado de agregar", JOptionPane.ERROR_MESSAGE);
            }
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al agregar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarProducto() {
        if(validarCamposVacios()){
            JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos antes de continuar.", "Datos incompletos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Obteniendo los datos de la ventana
        String nombre = vistaPlantillaProducto.getTxtNombre().getText();
        int precioNuevo = Integer.parseInt(vistaPlantillaProducto.getTxtPrecio().getText());
        long numeroCodigo = Long.valueOf(codigo);
        
        //Creando el producto con los nuevos datos
        Producto producto = new Producto(numeroCodigo, nombre, precioNuevo);
        try {
            //Actualizando el producto
            if (almacenamiento.actualizarProducto(codigo, producto)){ //Posiblemente nunca entre al else
                JOptionPane.showMessageDialog(null, "Producto actualizado con éxito", "Resultado de actualizar", JOptionPane.INFORMATION_MESSAGE);
                irGestion();
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe una producto con ese código", "Resultado de actualizar", JOptionPane.ERROR_MESSAGE);
            }
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al agregar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarProducto() {
        //Eliminando el producto
        try{
            almacenamiento.eliminarProducto(codigo);
            JOptionPane.showMessageDialog(null, "Producto eliminado con éxito", "Resultado de eliminar", JOptionPane.INFORMATION_MESSAGE);
            irGestion();
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void irGestion() {
        GestionSupermercado vistaGestionSupermercado = new GestionSupermercado("Supermercado - Universidad del Valle", almacenamiento);
        vistaPlantillaProducto.dispose();
    }
    
    public void asignarCodigoProducto() {
        long miCodigoProducto = 1;
        while (almacenamiento.getProductos().containsKey(miCodigoProducto)) {
            miCodigoProducto += 1;
        }
        codigoAsignado = miCodigoProducto;
        vistaPlantillaProducto.getTxtCodigo().setText(String.valueOf(codigoAsignado));
    }
    
    public final void verificarTexto(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (Character.isAlphabetic(c) | Character.isSpaceChar(c)){
                    e.setKeyChar(c);
                } else {
                    e.consume();
                }
            }
        });
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
        if(vistaPlantillaProducto.getTxtNombre().getText().isBlank())
            error = true;
        if(vistaPlantillaProducto.getTxtPrecio().getText().isBlank())
            error = true;
        return error;
    }
}
