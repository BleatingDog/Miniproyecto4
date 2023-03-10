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
import modelos.Cliente;
import vistas.GestionSupermercado;
import vistas.ListaClientes;

public class GestorListaClientes {
    
    private final ListaClientes vistaListaClientes;
    private final Almacenamiento almacenamiento;
    private HashMap <Long, Cliente> clientes;

    public GestorListaClientes(ListaClientes vistaListaClientes, Almacenamiento almacenamiento) {
        this.vistaListaClientes = vistaListaClientes;
        this.almacenamiento = almacenamiento;
        clientes = almacenamiento.getClientes();
        insertarClientes();
        this.vistaListaClientes.addBtnRegresarListener(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaListaClientes.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestion();  
                }
            }
        }
    }
    
    public void irGestion(){
        GestionSupermercado vistaGestionSupermercado = new GestionSupermercado("Supermercado - Universidad del Valle", almacenamiento);
        vistaListaClientes.dispose();
    }
    
    public void insertarClientes() {
        Iterator i = clientes.entrySet().iterator();

        while(i.hasNext()) {
            HashMap.Entry <String, Cliente> mapa = (HashMap.Entry) i.next();
            Cliente cliente = mapa.getValue();
            Object[] fila = new Object[3];
            fila[0] = cliente.getNombre();
            fila[1] = cliente.getCedula();
            fila[2] = cliente.getTelefono();
            vistaListaClientes.anadirFilaTabla(fila);
        }
    }
}
