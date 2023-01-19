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
import vistas.Ppal;
import vistas.Carrito;
import vistas.VentaProductos;


public class GestorVentaProductos {
    private final VentaProductos vistaVentaProductos;
    private final Almacenamiento almacenamiento; 
    
    public GestorVentaProductos(VentaProductos vistaVentaProductos, Almacenamiento almacenamiento){
        this.vistaVentaProductos = vistaVentaProductos;
        this.almacenamiento = almacenamiento;
        this.vistaVentaProductos.addBtnRegresarListener(new ManejadoraDeMouse());
        this.vistaVentaProductos.addBtnAgregarListener(new ManejadoraDeMouse());
        this.vistaVentaProductos.addBtnIrCarritoListener(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaVentaProductos.getBtnRegresar()){
                if (e.getButton() == 1){
                    irPpal();
                }
            }

            if (e.getSource() == vistaVentaProductos.getBtnAgregar()){
                if (e.getButton() == 1){
                    agregarAlCarritoVenta();
                }
            }
            
            if (e.getSource() == vistaVentaProductos.getBtnIrCarrito()){
                if (e.getButton() == 1){
                    irCarritoVenta();
                }
            }
        }

    }
    
    //Ingresa al comboBox los productos disponibles
    public void produtosDisponibles(){
        vistaVentaProductos.limpiarProductosCombo();
    }
    
    public void agregarAlCarritoVenta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void irCarritoVenta() {
        Carrito vistaCarrito = new Carrito("Registro de Ventas", almacenamiento);
        vistaVentaProductos.dispose();
    }
 
    public void irPpal() {
        Ppal vistaPpal = new Ppal("Supermercado - Universidad del Valle", almacenamiento);
        vistaVentaProductos.dispose();
    }
}
