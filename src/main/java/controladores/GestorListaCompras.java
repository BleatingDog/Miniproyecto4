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
import java.util.HashMap;
import java.util.Iterator;
import modelos.Almacenamiento;
import modelos.Compra;
import vistas.GestionSupermercado;
import vistas.ListaCompras;

public class GestorListaCompras {
    
    private final ListaCompras vistaListaCompras;
    private final Almacenamiento almacenamiento;
    private HashMap <Long, Compra> compras;

    public GestorListaCompras(ListaCompras vistaListaCompras, Almacenamiento almacenamiento) {
        this.vistaListaCompras = vistaListaCompras;
        this.almacenamiento = almacenamiento;
        compras = almacenamiento.getCompras();
        insertarCompras();
        this.vistaListaCompras.addBtnRegresarListener(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaListaCompras.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestion();  
                }
            }
        }
    }
    
    public void irGestion(){
        GestionSupermercado vistaGestionSupermercado = new GestionSupermercado("Supermercado - Universidad del Valle", almacenamiento);
        vistaListaCompras.dispose();
    }
    
    public void insertarCompras() {
        Iterator i = compras.entrySet().iterator();

        while(i.hasNext()) {
            HashMap.Entry <String, Compra> mapa = (HashMap.Entry) i.next();
            Compra compra = mapa.getValue();
            Object[] fila = new Object[3];
            fila[0] = compra.getProveedor();
            fila[1] = compra.getnFactura();
            fila[2] = compra.getPrecioTotal();
            vistaListaCompras.anadirFilaTabla(fila);
        }
    }
}
