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
import modelos.Venta;
import vistas.GestionSupermercado;
import vistas.ListaVentas;

public class GestorListaVentas {
    
    private final ListaVentas vistaListaVentas;
    private final Almacenamiento almacenamiento;
    private HashMap <Long, Venta> ventas;

    public GestorListaVentas(ListaVentas vistaListaVentas, Almacenamiento almacenamiento) {
        this.vistaListaVentas = vistaListaVentas;
        this.almacenamiento = almacenamiento;
        ventas = almacenamiento.getVentas();
        insertarVentas();
        this.vistaListaVentas.addBtnRegresarListener(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaListaVentas.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestion();  
                }
            }
        }
    }
    
    public void irGestion(){
        GestionSupermercado vistaGestionSupermercado = new GestionSupermercado("Supermercado - Universidad del Valle", almacenamiento);
        vistaListaVentas.dispose();
    }
    
    public void insertarVentas() {
        Iterator i = ventas.entrySet().iterator();

        while(i.hasNext()) {
            HashMap.Entry <String, Venta> mapa = (HashMap.Entry) i.next();
            Venta venta = mapa.getValue();
            Object[] fila = new Object[3];
            fila[0] = venta.getCliente();
            fila[1] = venta.getnFactura();
            fila[2] = venta.getPrecioTotal();
            vistaListaVentas.anadirFilaTabla(fila);
        }
    }
}