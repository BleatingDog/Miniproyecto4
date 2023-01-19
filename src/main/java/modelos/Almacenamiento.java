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

package modelos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;

public class Almacenamiento {
    
    private HashMap <Long, Producto> productos;
    private HashMap <Long, Cliente> clientes;
    private HashMap <Long, Proveedor> proveedores;
    private HashMap <Long, Venta> ventas;
    private HashMap <Long, Compra> compras;
    
    public Almacenamiento () throws IOException, ClassNotFoundException {
        try
        {
            restaurarDatos();
        } catch (IOException | ClassNotFoundException e) {
            throw e;
        }
    }
    
    public boolean hacerBackUp() throws IOException{
        
        try
        {
            OutputStream os = new FileOutputStream("Datos.bin");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            
            oos.writeObject(productos);
            oos.writeObject(clientes);
            oos.writeObject(proveedores);
            oos.writeObject(ventas);
            oos.writeObject(compras);
            
            oos.close();
            return true;
        } catch (IOException e) {
            throw e;
        }
    }
    
    public boolean restaurarDatos() throws IOException, ClassNotFoundException {
        
        try
        {
            InputStream is = new FileInputStream("Datos.bin");
            ObjectInputStream ois = new ObjectInputStream(is);
            
            productos = (HashMap) ois.readObject();
            clientes = (HashMap) ois.readObject();
            proveedores = (HashMap) ois.readObject();
            ventas = (HashMap) ois.readObject();
            compras = (HashMap) ois.readObject();
            
            ois.close();
            return true;
        } catch (FileNotFoundException e) {
            productos = new HashMap();
            clientes = new HashMap();
            proveedores = new HashMap();
            ventas = new HashMap();
            compras = new HashMap();
            try
            {
                hacerBackUp();
            } catch (IOException ex) {
                throw ex;
            }
            return true;
        } catch(IOException | ClassNotFoundException e) {
            throw e;
        }
    }

    public boolean anadirProducto(Producto producto) throws IOException {
        if (!productos.containsKey(producto.getCodigo())) {
            productos.put(producto.getCodigo(), producto);
            try
            {
                hacerBackUp();
                return true;
            } catch (IOException e) {
                throw e;
            }
        }
        return false;
    }
    
    public boolean modificarProducto(Producto cambiosProducto) throws IOException {
        if (productos.containsKey(cambiosProducto.getCodigo())) {
            Producto producto = productos.get(cambiosProducto.getCodigo());
            producto.setNombre(cambiosProducto.getNombre());
            producto.setPrecio(cambiosProducto.getPrecio());
            try
            {
                hacerBackUp();
                return true;
            } catch (IOException e) {
                throw e;
            }
        }
        return false;
    }
    
    public boolean eliminarProducto(long codigo) throws IOException {
        boolean sePuedeEliminar = true;
        
        //Medidas de eliminación
        Iterator iteradorVentas = ventas.entrySet().iterator();
        while (iteradorVentas.hasNext()) {
            HashMap.Entry <Long, Venta> mapa = (HashMap.Entry) iteradorVentas.next();
            Venta venta = mapa.getValue();
            if (venta.getInformacionDelProducto().containsKey(codigo)) {
                sePuedeEliminar = false;
            }
        }
        Iterator iteradorProveedores = proveedores.entrySet().iterator();
        while (iteradorProveedores.hasNext()) {
            HashMap.Entry <Long, Proveedor> mapa = (HashMap.Entry) iteradorProveedores.next();
            Proveedor proveedor = mapa.getValue();
            if (proveedor.getProductos().contains(productos.get(codigo))) {
                sePuedeEliminar = false;
            }
        }
        if (sePuedeEliminar) {
            productos.remove(codigo);
            try
            {
                hacerBackUp();
                return true;
            } catch (IOException e) {
                throw e;
            }
        }
        return false;
    }
    
    public boolean anadirCliente(Cliente cliente) throws IOException {
        if (!clientes.containsKey(cliente.getCedula())) {
            clientes.put(cliente.getCedula(), cliente);
            try
            {
                hacerBackUp();
                return true;
            } catch (IOException e) {
                throw e;
            }
        }
        return false;
    }
    
    public boolean modificarCliente(Cliente cambiosCliente) throws IOException {
        if (clientes.containsKey(cambiosCliente.getCedula())) {
            Cliente cliente = clientes.get(cambiosCliente.getCedula());
            cliente.setNombre(cambiosCliente.getNombre());
            cliente.setTelefono(cambiosCliente.getTelefono());
            try
            {
                hacerBackUp();
                return true;
            } catch (IOException e) {
                throw e;
            }
        }
        return false;
    }
    
    public boolean eliminarCliente(long cedula) throws IOException {
        boolean sePuedeEliminar = true;
        
        //Medidas de eliminación
        Iterator iteradorVentas = ventas.entrySet().iterator();
        while (iteradorVentas.hasNext()) {
            HashMap.Entry <Long, Venta> mapa = (HashMap.Entry) iteradorVentas.next();
            Venta venta = mapa.getValue();
            if (venta.getCliente().getCedula() == cedula) {
                sePuedeEliminar = false;
            }
        }
        if (sePuedeEliminar) {
            clientes.remove(cedula);
            try
            {
                hacerBackUp();
                return true;
            } catch (IOException e) {
                throw e;
            }
        }
        return false;
    }
    
    public boolean anadirProveedor(Proveedor proveedor) throws IOException {
        if (!proveedores.containsKey(proveedor.getNIT())) {
            proveedores.put(proveedor.getNIT(), proveedor);
            try
            {
                hacerBackUp();
                return true;
            } catch (IOException e) {
                throw e;
            }
        }
        return false;
    }
    
    public boolean modificarProveedor(Proveedor cambiosProveedor) throws IOException {
        if (proveedores.containsKey(cambiosProveedor.getNIT())) {
            Proveedor proveedor = proveedores.get(cambiosProveedor.getNIT());
            proveedor.setNombre(cambiosProveedor.getNombre());
            proveedor.setProductos(cambiosProveedor.getProductos());
            try
            {
                hacerBackUp();
                return true;
            } catch (IOException e) {
                throw e;
            }
        }
        return false;
    }
    
    public boolean eliminarProveedor(Long NIT) throws IOException {
        boolean sePuedeEliminar = true;
        
        //Medidas de eliminación
        Iterator iteradorCompras = compras.entrySet().iterator();
        while (iteradorCompras.hasNext()) {
            HashMap.Entry <Long, Compra> mapa = (HashMap.Entry) iteradorCompras.next();
            Compra compra = mapa.getValue();
            if (compra.getProveedor().getNIT().equals(NIT)) {
                sePuedeEliminar = false;
            }
        }
        if (sePuedeEliminar) {
            proveedores.remove(NIT);
            try
            {
                hacerBackUp();
                return true;
            } catch (IOException e) {
                throw e;
            }
        }
        return false;
    }
    
    public boolean anadirVenta(Venta venta) throws IOException {
        if (!ventas.containsKey(venta.getnFactura())) {
            ventas.put(venta.getnFactura(), venta);
            try
            {
                hacerBackUp();
                return true;
            } catch (IOException e) {
                throw e;
            }
        }
        return false;
    }
    
    public boolean anadirCompra(Compra compra) throws IOException {
        if (!compras.containsKey(compra.getnFactura())) {
            compras.put(compra.getnFactura(), compra);
            try
            {
                hacerBackUp();
                return true;
            } catch (IOException e) {
                throw e;
            }
        }
        return false;
    }

    public HashMap<Long, Producto> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<Long, Producto> productos) {
        this.productos = productos;
    }

    public HashMap<Long, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<Long, Cliente> clientes) {
        this.clientes = clientes;
    }

    public HashMap<Long, Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(HashMap<Long, Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public HashMap<Long, Venta> getVentas() {
        return ventas;
    }
    
    public HashMap<Long, Compra> getCompras() {
        return compras;
    }
    
}
