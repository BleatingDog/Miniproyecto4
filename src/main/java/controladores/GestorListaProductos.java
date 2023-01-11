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
import vistas.ListaProductos;

public class GestorListaProductos {
    
    private final ListaProductos vistaListaProductos;
    private final Almacenamiento almacenamiento;

    public GestorListaProductos(ListaProductos vistaListaProductos, Almacenamiento almacenamiento) {
        this.vistaListaProductos = vistaListaProductos;
        this.almacenamiento = almacenamiento;
        this.vistaListaProductos.addBtnRegresarListener(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaListaProductos.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestion();  
                }
            }
        }
    }
    
    public void irGestion(){
        GestionSupermercado vistaGestionSupermercado = new GestionSupermercado("Supermercado - Universidad del Valle", almacenamiento);
        vistaListaProductos.dispose();
    }
}
