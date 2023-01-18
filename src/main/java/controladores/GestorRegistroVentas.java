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
import vistas.RegistroVentas;

public class GestorRegistroVentas {
    
    private final RegistroVentas vistaRegistroVentas;
    private final Almacenamiento almacenamiento;

    public GestorRegistroVentas(RegistroVentas vistaRegistroVentas, Almacenamiento almacenamiento) {
        this.vistaRegistroVentas = vistaRegistroVentas;
        this.almacenamiento = almacenamiento;
        this.vistaRegistroVentas.addBtnRegresarListener(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaRegistroVentas.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestion();  
                }
            }
        }
    }
    
    public void irGestion(){
        GestionSupermercado vistaGestionSupermercado = new GestionSupermercado("Supermercado - Universidad del Valle", almacenamiento);
        vistaRegistroVentas.dispose();
    }
}
