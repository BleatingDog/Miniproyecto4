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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import modelos.Almacenamiento;
import modelos.Producto;
import modelos.Proveedor;
import vistas.GestionSupermercado;
import vistas.ListaProveedores;

public class GestorListaProveedores {
    
    private final ListaProveedores vistaListaProveedores;
    private final Almacenamiento almacenamiento;
    private HashMap <Long, Proveedor> proveedores;

    public GestorListaProveedores(ListaProveedores vistaListaProveedores, Almacenamiento almacenamiento) {
        this.vistaListaProveedores = vistaListaProveedores;
        this.almacenamiento = almacenamiento;
        proveedores = almacenamiento.getProveedores();
        insertarProveedores();
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
    
    public void insertarProveedores() {
        Iterator i = proveedores.entrySet().iterator();

        while(i.hasNext()) {
            HashMap.Entry <String, Proveedor> mapa = (HashMap.Entry) i.next();
            Proveedor proveedor = mapa.getValue();
            Object[] fila = new Object[3];
            fila[0] = proveedor.getNombre();
            ArrayList <Producto> productos = proveedor.getProductos();
            String productosString = "";
            Iterator o = productos.iterator();
            while (o.hasNext()) {
                productosString += o.next();
                if (o.hasNext()) {
                    productosString += ", ";
                } else {
                    productosString += ".";
                }
            }
            fila[1] = productosString;
            fila[2] = proveedor.getNIT();
            vistaListaProveedores.anadirFilaTabla(fila);
        }
    }
}
