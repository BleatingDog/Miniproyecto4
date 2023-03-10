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
import javax.swing.JOptionPane;
import modelos.Almacenamiento;
import modelos.Compra;
import vistas.Carrito;
import vistas.ListaCompras;
import vistas.Ppal;

public class GestorListaCompras {
    
    private final ListaCompras vistaListaCompras;
    private final Almacenamiento almacenamiento;
    private final HashMap <Long, Compra> compras;

    public GestorListaCompras(ListaCompras vistaListaCompras, Almacenamiento almacenamiento) {
        this.vistaListaCompras = vistaListaCompras;
        this.almacenamiento = almacenamiento;
        compras = almacenamiento.getCompras();
        insertarCompras();
        this.vistaListaCompras.addBtnRegresarListener(new ManejadoraDeMouse());
        this.vistaListaCompras.addBtnConsultarListener(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaListaCompras.getBtnRegresar()){
                if (e.getButton() == 1){
                    irPpal();  
                }
            }
            
            if (e.getSource() == vistaListaCompras.getBtnConsultar()){
                if (e.getButton() == 1){
                    irCarritoCompras();  
                }
            }
        }
    }
    
    public final void insertarCompras() {
        Iterator i = compras.entrySet().iterator();

        while(i.hasNext()) {
            HashMap.Entry <String, Compra> mapa = (HashMap.Entry) i.next();
            Compra compra = mapa.getValue();
            Object[] fila = new Object[3];
            fila[0] = compra.getnFactura();
            fila[1] = compra.getFecha().toString() + ", " + compra.getHora().getHour() + ":" + compra.getHora().getMinute() + ":" + compra.getHora().getSecond();
            fila[2] = compra.getPrecioTotal();
            vistaListaCompras.anadirFilaTabla(fila);
        }
    }
    
    public void irCarritoCompras() {
        
        int filaSeleccionada = vistaListaCompras.getTablaContenido().getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Ninguna entrada seleccionada.", "Error", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        long numeroFactura = vistaListaCompras.compraSeleccionada(filaSeleccionada);
        Compra compraSeleccionada = compras.get(numeroFactura);
        HashMap <Long, HashMap<String, Object>> informacionDeCompra = compraSeleccionada.getInformacionDelProducto();
        Carrito vistaCarrito = new Carrito(0, "Lista Compra", almacenamiento, informacionDeCompra);
        vistaListaCompras.dispose();
    }
    
    public void irPpal(){
        Ppal vistaPpal = new Ppal("Supermercado - Universidad del Valle", almacenamiento);
        vistaListaCompras.dispose();
    }
}
