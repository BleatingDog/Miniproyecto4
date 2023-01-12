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
import javax.swing.JTextField;
import modelos.Almacenamiento;
import vistas.GestionSupermercado;
import vistas.PlantillaProducto;

public class GestorPlantillaProducto {
    
    private final PlantillaProducto vistaPlantillaProducto;
    private final String opcion;
    private final int codigo;
    private final Almacenamiento almacenamiento;
        
    public GestorPlantillaProducto(PlantillaProducto vistaPlantillaProducto, String opcion, int codigo, Almacenamiento almacenamiento){
        this.vistaPlantillaProducto = vistaPlantillaProducto;
        this.codigo = codigo;
        this.opcion = opcion;
        this.almacenamiento = almacenamiento;
        this.vistaPlantillaProducto.addBtnGeneralListener(new ManejadoraDeMouse());
        this.vistaPlantillaProducto.addBtnRegresarListener(new ManejadoraDeMouse());
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
    }

    public void plantillaEliminarProducto() {
        vistaPlantillaProducto.getLblTitulo().setText("Eliminar producto");
        vistaPlantillaProducto.getBtnGeneral().setText("Eliminar");
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void actualizarProducto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void eliminarProducto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void irGestion() {
        GestionSupermercado vistaGestionSupermercado = new GestionSupermercado("Supermercado - Universidad del Valle", almacenamiento);
        vistaPlantillaProducto.dispose();
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
}
