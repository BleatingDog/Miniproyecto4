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
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import modelos.Almacenamiento;
import vistas.GestionSupermercado;
import vistas.ListaClientes;
import vistas.ListaProductos;
import vistas.ListaProveedores;
import vistas.PlantillaCliente;
import vistas.PlantillaProducto;
import vistas.PlantillaProveedor;
import vistas.Ppal;

public class GestorGestionSupermercado {
    
    private GestionSupermercado vistaGestionSupermercado;
    private final Almacenamiento almacenamiento;
    private final String[] opciones = {
                                    "Agregar",
                                    "Actualizar",
                                    "Consultar",
                                    "Eliminar"
                                   };
    
    public GestorGestionSupermercado(GestionSupermercado vistaGestionSupermercado, Almacenamiento almacenamiento){
        this.vistaGestionSupermercado = vistaGestionSupermercado;
        this.almacenamiento = almacenamiento;
        this.vistaGestionSupermercado.addBtnClienteListener(new ManejadoraDeMouse());
        this.vistaGestionSupermercado.addBtnProductoListener(new ManejadoraDeMouse());
        this.vistaGestionSupermercado.addBtnProveedorListener(new ManejadoraDeMouse());
        this.vistaGestionSupermercado.addBtnRegresarListener(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
          if (e.getSource() == vistaGestionSupermercado.getBtnCliente()){
                if (e.getButton() == 1){
                    opcionesCliente();
                }
          }
          
          if (e.getSource() == vistaGestionSupermercado.getBtnProducto()){
                if (e.getButton() == 1){
                    opcionesProducto();
                }
          }
          
          if (e.getSource() == vistaGestionSupermercado.getBtnProveedor()){
                if (e.getButton() == 1){
                    opcionesProveedor();
                }
          }
          
          if (e.getSource() == vistaGestionSupermercado.getBtnRegresar()){
                if (e.getButton() == 1){
                    irPpal();
                }
          }
        }

    }
    
    public void opcionesCliente(){
        try {
            String resp = (String) JOptionPane.showInputDialog(vistaGestionSupermercado, 
                    "<html><p style = \" font:12px; \">¿Qué desea hacer?</p></html>", 
                    "Opciones clientes", JOptionPane.DEFAULT_OPTION, 
                    UIManager.getIcon("OptionPane.questionIcon"), opciones, opciones[0]);
            switch(resp) {
                case "Agregar" -> {
                    irAgregarCliente();
                }
                case "Actualizar" -> {
                    try{
                        String cedulaABuscar = (String) JOptionPane.showInputDialog(vistaGestionSupermercado, 
                                "<html><p style = \" font:12px; \">Ingrese la cédula del cliente "
                                + "a actualizar</p></html>", "Actualizar cliente", 
                                JOptionPane.DEFAULT_OPTION);
                        long cedula;
                        if (cedulaABuscar.isBlank()){
                            JOptionPane.showMessageDialog(vistaGestionSupermercado, 
                                    "<html><p style = \" font:12px; \">Por favor ingrese una "
                                    + "cédula</p></html>", "Error", JOptionPane.OK_OPTION, 
                                    UIManager.getIcon("OptionPane.errorIcon"));
                            return;
                        }
                        try{
                            cedula = Long.parseLong(cedulaABuscar);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Por favor ingrese una cédula "
                                    + "válida", "Error", JOptionPane.ERROR_MESSAGE);
                            return;  
                        }
                        if(!almacenamiento.getClientes().containsKey(cedula)){
                            JOptionPane.showMessageDialog(vistaGestionSupermercado, 
                                    "<html><p style = \" font:12px; \">No se encontró ningún "
                                    + "cliente registrado con esa cédula</p></html>", 
                                    "Cliente no encontrado", JOptionPane.OK_OPTION, 
                                    UIManager.getIcon("OptionPane.errorIcon"));
                            return;
                        }
                        irActualizarCliente(cedula);
                    } catch (NullPointerException np) {

                    }
                }
                case "Eliminar" -> {
                    try{
                        String cedulaABuscar = (String) JOptionPane.showInputDialog(vistaGestionSupermercado, 
                                "<html><p style = \" font:12px; \">Ingrese la cédula del cliente "
                                        + "a eliminar</p></html>", "Eliminar cliente", 
                                        JOptionPane.DEFAULT_OPTION);
                        long cedula;
                        if (cedulaABuscar.isBlank()){
                            JOptionPane.showMessageDialog(vistaGestionSupermercado, 
                                    "<html><p style = \" font:12px; \">Por favor ingrese una "
                                            + "cédula</p></html>", "Error", JOptionPane.OK_OPTION, 
                                            UIManager.getIcon("OptionPane.errorIcon"));
                            return;
                        }
                        try{
                            cedula = Long.parseLong(cedulaABuscar);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Por favor ingrese una cédula "
                                    + "válida", "Error", JOptionPane.ERROR_MESSAGE);
                            return;  
                        }
                        if(!almacenamiento.getClientes().containsKey(cedula)){
                            JOptionPane.showMessageDialog(vistaGestionSupermercado, 
                                    "<html><p style = \" font:12px; \">No se encontró ningún cliente"
                                    + " registrado con esa cédula</p></html>", 
                                    "Cliente no encontrado", JOptionPane.OK_OPTION, 
                                    UIManager.getIcon("OptionPane.errorIcon"));
                            return;
                        }
                        irEliminarCliente(cedula);
                    } catch (NullPointerException np) {

                    }
                }
                case "Consultar" -> {
                    irConsultarCliente();
                }
            }
        } catch (NullPointerException np) {
            
        }
    }
    public void irAgregarCliente() {
        PlantillaCliente vistaPlantillaCliente = new PlantillaCliente("Supermercado - Universidad del Valle", "Agregar", 0, almacenamiento);
        vistaGestionSupermercado.dispose();
    }
    public void irActualizarCliente(long cedula) {
        PlantillaCliente vistaPlantillaCliente = new PlantillaCliente("Supermercado - Universidad del Valle", "Actualizar", cedula, almacenamiento);
        vistaGestionSupermercado.dispose();
    }
    public void irEliminarCliente(long cedula) {
        PlantillaCliente vistaPlantillaCliente = new PlantillaCliente("Supermercado - Universidad del Valle", "Eliminar", cedula, almacenamiento);
        vistaGestionSupermercado.dispose();
    }
    public void irConsultarCliente() {
        ListaClientes vistaListaClientes = new ListaClientes("Supermercado - Universidad del Valle", almacenamiento);
        vistaGestionSupermercado.dispose();
    }

    public void opcionesProducto(){
        try {
            
            String resp = (String) JOptionPane.showInputDialog(vistaGestionSupermercado, 
                    "<html><p style = \" font:12px; \">¿Qué desea hacer?</p></html>", 
                    "Opciones productos", JOptionPane.DEFAULT_OPTION, 
                    UIManager.getIcon("OptionPane.questionIcon"), opciones, opciones[0]);
            switch(resp) {
                case "Agregar" -> {
                    irAgregarProducto();
                }
                case "Actualizar" -> {
                    try{
                        String codigoABuscar = (String) JOptionPane.showInputDialog(vistaGestionSupermercado, 
                                "<html><p style = \" font:12px; \">Ingrese el código del producto "
                                + "a actualizar</p></html>", "Actualizar producto", 
                                JOptionPane.DEFAULT_OPTION);
                        int codigo;
                        if (codigoABuscar.isBlank()){
                            JOptionPane.showMessageDialog(vistaGestionSupermercado, 
                                    "<html><p style = \" font:12px; \">Por favor ingrese un "
                                    + "código</p></html>", "Error", JOptionPane.OK_OPTION, 
                                    UIManager.getIcon("OptionPane.errorIcon"));
                            return;
                        }
                        try{
                            codigo = Integer.parseInt(codigoABuscar);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Por favor ingrese un código "
                                    + "válido", "Error", JOptionPane.ERROR_MESSAGE);
                            return;  
                        }
                        if(!almacenamiento.getProductos().containsKey(codigo)){
                            JOptionPane.showMessageDialog(vistaGestionSupermercado, 
                                    "<html><p style = \" font:12px; \">No se encontró ningún "
                                    + "producto registrado con ese código</p></html>", 
                                    "Producto no encontrado", JOptionPane.OK_OPTION, 
                                    UIManager.getIcon("OptionPane.errorIcon"));
                            return;
                        }
                        irActualizarProducto(codigo);
                    } catch (NullPointerException np) {

                    }
                }
                case "Eliminar" -> {
                    try{
                        String codigoABuscar = (String) JOptionPane.showInputDialog(vistaGestionSupermercado, 
                                "<html><p style = \" font:12px; \">Ingrese el código del producto "
                                + "a eliminar</p></html>", "Eliminar producto", 
                                JOptionPane.DEFAULT_OPTION);
                        int codigo;
                        if (codigoABuscar.isBlank()){
                            JOptionPane.showMessageDialog(vistaGestionSupermercado, 
                                    "<html><p style = \" font:12px; \">Por favor ingrese un "
                                    + "código</p></html>", "Error", JOptionPane.OK_OPTION, 
                                    UIManager.getIcon("OptionPane.errorIcon"));
                            return;
                        }
                        try{
                            codigo = Integer.parseInt(codigoABuscar);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Por favor ingrese un código "
                                    + "válido", "Error", JOptionPane.ERROR_MESSAGE);
                            return;  
                        }
                        if(!almacenamiento.getProductos().containsKey(codigo)){
                            JOptionPane.showMessageDialog(vistaGestionSupermercado, 
                                    "<html><p style = \" font:12px; \">No se encontró ningún "
                                    + "producto registrado con ese código</p></html>", 
                                    "Producto no encontrado", JOptionPane.OK_OPTION, 
                                    UIManager.getIcon("OptionPane.errorIcon"));
                            return;
                        }
                        irEliminarProducto(codigo);
                    } catch (NullPointerException np) {

                    }
                }
                case "Consultar" -> {
                    irConsultarProducto();
                }
            }
        } catch (NullPointerException np) {
            
        }
    }
    
    public void irAgregarProducto(){
        PlantillaProducto vistaPlantillaProducto = new PlantillaProducto("Supermercado - Universidad del Valle", "Agregar", 0, almacenamiento);
        vistaGestionSupermercado.dispose();
    }
    
    public void irActualizarProducto(int codigo){
        PlantillaProducto vistaPlantillaProducto = new PlantillaProducto("Supermercado - Universidad del Valle", "Actualizar", codigo, almacenamiento);
        vistaGestionSupermercado.dispose();
    }
    public void irEliminarProducto(int codigo){
        PlantillaProducto vistaPlantillaProducto = new PlantillaProducto("Supermercado - Universidad del Valle", "Eliminar", codigo, almacenamiento);
        vistaGestionSupermercado.dispose();
    }
    public void irConsultarProducto(){
        ListaProductos vistaListaProductos = new ListaProductos("Supermercado - Universidad del Valle", almacenamiento);
        vistaGestionSupermercado.dispose();
    }
    
    public void opcionesProveedor(){
        try {
            String resp = (String) JOptionPane.showInputDialog(vistaGestionSupermercado, 
                    "<html><p style = \" font:12px; \">¿Qué desea hacer?</p></html>", 
                    "Opciones proveedores", JOptionPane.DEFAULT_OPTION, 
                    UIManager.getIcon("OptionPane.questionIcon"), opciones, opciones[0]);
            switch(resp) {
                case "Agregar" -> {
                    if(almacenamiento.getProveedores().isEmpty){
                        JOptionPane.showMessageDialog(null, "Antes de agregar un proveedor, "
                                + "agregue un producto.", "Datos incompletos", 
                                JOptionPane.ERROR_MESSAGE);                    
                        return;
                    }
                    irAgregarProveedor();
                }
                case "Actualizar" -> {
                    try{
                        String nitABuscar = (String) JOptionPane.showInputDialog(vistaGestionSupermercado, 
                                "<html><p style = \" font:12px; \">Ingrese el NIT del proveedor "
                                + "a actualizar</p></html>", "Actualizar proveedor", 
                                JOptionPane.DEFAULT_OPTION);
                        long nit;
                        if (nitABuscar.isBlank()){
                            JOptionPane.showMessageDialog(vistaGestionSupermercado, 
                                    "<html><p style = \" font:12px; \">Por favor ingrese un "
                                    + "NIT</p></html>", "Error", JOptionPane.OK_OPTION, 
                                    UIManager.getIcon("OptionPane.errorIcon"));
                            return;
                        }
                        try{
                            nit = Long.parseLong(nitABuscar);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Por favor ingrese un NIT "
                                    + "válido", "Error", JOptionPane.ERROR_MESSAGE);
                            return;  
                        }
                        if(!almacenamiento.getProveedores().containsKey(nit)){
                            JOptionPane.showMessageDialog(vistaGestionSupermercado, 
                                    "<html><p style = \" font:12px; \">No se encontró ningún "
                                    + "proveedor registrado con ese NIT</p></html>", 
                                    "Proveedor no encontrado", JOptionPane.OK_OPTION, 
                                    UIManager.getIcon("OptionPane.errorIcon"));
                            return;
                        }
                        irActualizarProveedor(nit);
                    } catch (NullPointerException np) {

                    }
                }
                case "Eliminar" -> {
                    try{
                        String nitABuscar = (String) JOptionPane.showInputDialog(vistaGestionSupermercado, 
                                "<html><p style = \" font:12px; \">Ingrese el NIT del proveedor "
                                        + "a eliminar</p></html>", "Eliminar proveedor", 
                                        JOptionPane.DEFAULT_OPTION);
                        if (nitABuscar.isBlank()){
                            JOptionPane.showMessageDialog(vistaGestionSupermercado, 
                                    "<html><p style = \" font:12px; \">Por favor ingrese un "
                                            + "NIT</p></html>", "Error", JOptionPane.OK_OPTION, 
                                            UIManager.getIcon("OptionPane.errorIcon"));
                            return;
                        }
                        long nit;
                        try{
                            nit = Long.parseLong(nitABuscar);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Por favor ingrese un NIT "
                                    + "válido", "Error", JOptionPane.ERROR_MESSAGE);
                            return;  
                        }
                        if(!almacenamiento.getProveedores().containsKey(nit)){
                            JOptionPane.showMessageDialog(vistaGestionSupermercado, 
                                    "<html><p style = \" font:12px; \">No se encontró ningún proveedor"
                                    + " registrado con ese NIT</p></html>", 
                                    "Proveedor no encontrado", JOptionPane.OK_OPTION, 
                                    UIManager.getIcon("OptionPane.errorIcon"));
                            return;
                        }
                        irEliminarProveedor(nit);
                    } catch (NullPointerException np) {

                    }
                }
                case "Consultar" -> {
                    irConsultarCliente();
                }
            }
        } catch (NullPointerException np) {
            
        }
    }
    
    public void irAgregarProveedor(){
        PlantillaProveedor vistaPlantillaProveedor = new PlantillaProveedor("Supermercado - Universidad del Valle", "Agregar", 0, almacenamiento);
        vistaGestionSupermercado.dispose();
    }
    
    public void irActualizarProveedor(long nit){
        PlantillaProveedor vistaPlantillaProveedor = new PlantillaProveedor("Supermercado - Universidad del Valle", "Actualizar", nit, almacenamiento);
        vistaGestionSupermercado.dispose();
    }
    public void irEliminarProveedor(long nit){
        PlantillaProveedor vistaPlantillaProveedor = new PlantillaProveedor("Supermercado - Universidad del Valle", "Eliminar", nit, almacenamiento);
        vistaGestionSupermercado.dispose();
    }
    public void irConsultarProveedor(){
        ListaProveedores vistaListaProveedores = new ListaProveedores("Supermercado - Universidad del Valle", almacenamiento);
        vistaGestionSupermercado.dispose();
    }
    
    public void irPpal() {
        Ppal vistaPpal = new Ppal("Supermercado - Universidad del Valle", almacenamiento);
        vistaGestionSupermercado.dispose();
    }
}
