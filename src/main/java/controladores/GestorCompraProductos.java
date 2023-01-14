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
import vistas.CompraProductos;
import vistas.Ppal;


public class GestorCompraProductos {
    private final CompraProductos vistaCompraProductos;
    private final Almacenamiento almacenamiento; 
    
    public GestorCompraProductos(CompraProductos vistaCompraProductos, Almacenamiento almacenamiento){
        this.vistaCompraProductos = vistaCompraProductos;
        this.almacenamiento = almacenamiento;
        this.vistaCompraProductos.addBtnRegresarListener(new ManejadoraDeMouse());
        this.vistaCompraProductos.addBtnAgregarListener(new ManejadoraDeMouse());
        this.vistaCompraProductos.addBtnIrCarritoListener(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaCompraProductos.getBtnRegresar()){
                if (e.getButton() == 1){
                    irPpal();
                }
            }

            if (e.getSource() == vistaCompraProductos.getBtnAgregar()){
                if (e.getButton() == 1){
                    AgregarAlCarritoCompra();
                }
            }
            
            if (e.getSource() == vistaCompraProductos.getBtnIrCarrito()){
                if (e.getButton() == 1){
                    IrCarritoCompra();
                }
            }
        }

    }
    
public void AgregarAlCarritoCompra() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void IrCarritoCompra() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
    public void irPpal() {
        Ppal vistaPpal = new Ppal("Supermercado - Universidad del Valle", almacenamiento);
        vistaCompraProductos.dispose();
    }
}
