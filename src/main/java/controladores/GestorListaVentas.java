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
import modelos.Venta;
import vistas.Carrito;
import vistas.ListaVentas;
import vistas.Ppal;

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
        this.vistaListaVentas.addBtnConsultarListener(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaListaVentas.getBtnRegresar()){
                if (e.getButton() == 1){
                    irPpal();  
                }
            }
            
            if (e.getSource() == vistaListaVentas.getBtnConsultar()){
                if (e.getButton() == 1){
                    irCarritoVentas();  
                }
            }
        }
    }
    
    public void irPpal(){
        Ppal vistaPpal = new Ppal("Supermercado - Universidad del Valle", almacenamiento);
        vistaListaVentas.dispose();
    }
    
    public final void insertarVentas() {
        Iterator i = ventas.entrySet().iterator();

        while(i.hasNext()) {
            HashMap.Entry <String, Venta> mapa = (HashMap.Entry) i.next();
            Venta venta = mapa.getValue();
            Object[] fila = new Object[4];
            fila[0] = venta.getCliente().getCedula();
            fila[1] = venta.getnFactura();
            fila[2] = venta.getFecha().toString() + ", " + venta.getHora().getHour() + ":" + venta.getHora().getMinute() + ":" + venta.getHora().getSecond();
            fila[3] = venta.getPrecioTotal();
            vistaListaVentas.anadirFilaTabla(fila);
        }
    }
    
    public void irCarritoVentas() {
        
        int filaSeleccionada = vistaListaVentas.getTablaContenido().getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Ninguna entrada seleccionada.", "Error", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        long numeroFactura = vistaListaVentas.ventaSeleccionada(filaSeleccionada);
        Venta ventaSeleccionada = almacenamiento.getVentas().get(numeroFactura);
        
        Carrito vistaCarrito = new Carrito(ventaSeleccionada.getCliente().getCedula(), "Lista Venta", almacenamiento, ventaSeleccionada.getInformacionDelProducto());
        vistaListaVentas.dispose();
    }
}
