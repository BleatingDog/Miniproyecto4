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
import vistas.ListaProveedores;

public class GestorListaProveedores {
    
    private final ListaProveedores vistaListaProveedores;
    private final Almacenamiento almacenamiento;

    public GestorListaProveedores(ListaProveedores vistaListaProveedores, Almacenamiento almacenamiento) {
        this.vistaListaProveedores = vistaListaProveedores;
        this.almacenamiento = almacenamiento;
        this.vistaListaProveedores.addBtnRegresarListener(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaListaProveedores.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestion();  
                }
            }
        }
    }
    
    public void irGestion(){
        GestionSupermercado vistaGestionSupermercado = new GestionSupermercado("Supermercado - Universidad del Valle", almacenamiento);
        vistaListaProveedores.dispose();
    }
}
