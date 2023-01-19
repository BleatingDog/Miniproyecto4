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

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import modelos.Almacenamiento;
import modelos.Producto;
import vistas.Ppal;
import vistas.Carrito;
import vistas.VentaProductos;


public class GestorVentaProductos {
    
    private final VentaProductos vistaVentaProductos;
    private final Almacenamiento almacenamiento;
    private ArrayList<Object[]> opcionComboProducto;
    private final long cedula;
    
    public GestorVentaProductos(VentaProductos vistaVentaProductos, long cedula, Almacenamiento almacenamiento){
        this.vistaVentaProductos = vistaVentaProductos;
        this.almacenamiento = almacenamiento;
        this.cedula = cedula;
        modificarVentana();
        produtosDisponibles();
        this.vistaVentaProductos.addBtnRegresarListener(new ManejadoraDeMouse());
        this.vistaVentaProductos.addBtnAgregarListener(new ManejadoraDeMouse());
        this.vistaVentaProductos.addBtnIrCarritoListener(new ManejadoraDeMouse());
        this.vistaVentaProductos.addComboListener(new ManejadoraDeLista());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaVentaProductos.getBtnAgregar()){
                if (e.getButton() == 1){
                    agregarAlCarritoVenta();
                }
            }
            
            if (e.getSource() == vistaVentaProductos.getBtnIrCarrito()){
                if (e.getButton() == 1){
                    irCarritoVenta(cedula);
                }
            }
            
            if (e.getSource() == vistaVentaProductos.getBtnRegresar()){
                if (e.getButton() == 1){
                    irPpal();
                }
            }
        }
    }
    
    class ManejadoraDeLista implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getSource() == vistaVentaProductos.getComboProducto()){
                vistaVentaProductos.reiniciarSpinner();
            }
        }
    }
    public final void modificarVentana(){
        vistaVentaProductos.getTxtCliente().setText(almacenamiento.getClientes().get(cedula).getNombre());
    }
    
    //Ingresa al comboBox los productos disponibles
    public final void produtosDisponibles(){
        vistaVentaProductos.limpiarProductosCombo();
        opcionComboProducto = new ArrayList();
        Iterator iteradorProductos = almacenamiento.getProductos().entrySet().iterator();
        while (iteradorProductos.hasNext()) {
            HashMap.Entry <Long, Producto> mapa = (HashMap.Entry) iteradorProductos.next();
            Producto producto = mapa.getValue();
            String productoStr;
            productoStr = mapa.getValue().getNombre();
            Object[] productoEscogido = new Object[1];
            productoEscogido[0] = producto;
            opcionComboProducto.add(productoEscogido);
            vistaVentaProductos.anadirProductosCombo(productoStr);
        }
    }
    public void agregarAlCarritoVenta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void irCarritoVenta(long cedulaCliente) {
        Carrito vistaCarrito = new Carrito("Registro de Ventas", cedulaCliente, almacenamiento);
        vistaVentaProductos.dispose();
    }
 
    public void irPpal() {
        Ppal vistaPpal = new Ppal("Supermercado - Universidad del Valle", almacenamiento);
        vistaVentaProductos.dispose();
    }
}
