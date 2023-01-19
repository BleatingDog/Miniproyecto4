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
import modelos.Producto;
import vistas.GestionSupermercado;
import vistas.ListaProductos;

public class GestorListaProductos {
    
    private final ListaProductos vistaListaProductos;
    private final Almacenamiento almacenamiento;
    private HashMap <Long, Producto> productos;

    public GestorListaProductos(ListaProductos vistaListaProductos, Almacenamiento almacenamiento) {
        this.vistaListaProductos = vistaListaProductos;
        this.almacenamiento = almacenamiento;
        productos = almacenamiento.getProductos();
        insertarProductos();
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
    
    public void insertarProductos() {
        Iterator i = productos.entrySet().iterator();

        while(i.hasNext()) {
            HashMap.Entry <String, Producto> mapa = (HashMap.Entry) i.next();
            Producto producto = mapa.getValue();
            Object[] fila = new Object[4];
            fila[0] = producto.getNombre();
            fila[1] = producto.getPrecio();
            fila[2] = producto.getCantidad();
            fila[3] = producto.getCodigo();
            vistaListaProductos.anadirFilaTabla(fila);
        }
    }
}
