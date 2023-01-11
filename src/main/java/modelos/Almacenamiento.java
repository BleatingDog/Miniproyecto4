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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

public class Almacenamiento {
    
    private HashMap <Long, Producto> productos;
    private HashMap <Long, Cliente> clientes;
    private HashMap <Long, Proveedor> proveedores;
    private HashMap <Long, Venta> ventas;
    
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
            
            ois.close();
            return true;
        } catch (FileNotFoundException e) {
            productos = new HashMap();
            clientes = new HashMap();
            proveedores = new HashMap();
            ventas = new HashMap();
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
    
    public boolean hacerBackUp(File ruta) throws IOException{
        
        try
        {
            OutputStream os = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(os);

            oos.writeObject(productos);
            oos.writeObject(clientes);
            oos.writeObject(proveedores);
            oos.writeObject(ventas);

            oos.close();
            return true;
        } catch (IOException e) {
            throw e;
        }
    }
    
    public boolean restaurarDatos(File ruta) throws IOException, ClassNotFoundException {
        
        try
        {
            InputStream is = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(is);

            productos = (HashMap) ois.readObject();
            clientes = (HashMap) ois.readObject();
            proveedores = (HashMap) ois.readObject();
            ventas = (HashMap) ois.readObject();

            ois.close();
            return true;
        } catch(IOException | ClassNotFoundException e) {
            throw e;
        }
    }

    /*public void anadirProducto(Producto producto) throws IOException {
        if (!productos.containsKey(producto.get())) {
            productos.put(producto.get(), producto);
            try
            {
                hacerBackUp();
            } catch (IOException e) {
                throw e;
            }
        }
    }
    
    public void modificarProducto(long algo, Producto producto) throws IOException {
        if (!productos.containsKey(producto.get())) {
            productos.remove(algo);
            productos.put(producto.get(), producto);
            try
            {
                hacerBackUp();
            } catch (IOException e) {
                throw e;
            }
        }
    }
    
    public void eliminarProducto(long algo) throws IOException {
        Producto producto = productos.get(algo);
        productos.remove(algo);
        
        //Medidas de eliminación
        for (int i=0; i<citas.size(); i++) {
            Cita cita = citas.get(i);
            if (cita.getAfiliado() == afiliado) {
                citas.remove(i);
            }
        }
        try
        {
            hacerBackUp();
        } catch (IOException e) {
            throw e;
        }
    }
    
    public void anadirCliente(Cliente cliente) throws IOException {
        if (!clientes.containsKey(cliente.get())) {
            clientes.put(cliente.get(), cliente);
            try
            {
                hacerBackUp();
            } catch (IOException e) {
                throw e;
            }
        }
    }
    
    public void modificarCliente(long algo, Cliente cliente) throws IOException {
        if (!clientes.containsKey(cliente.get())) {
            clientes.remove(algo);
            clientes.put(cliente.get(), cliente);
            try
            {
                hacerBackUp();
            } catch (IOException e) {
                throw e;
            }
        }
    }
    
    public void eliminarCliente(long aglo) throws IOException {
        Cliente cliente = clientes.get(algo);
        clientes.remove(algo);
        
        //Medidas de eliminación
        for (int i=0; i<citas.size(); i++) {
            Cita cita = citas.get(i);
            if (cita.getMedico() == medico) {
                citas.remove(i);
            }
        }
        try
        {
            hacerBackUp();
        } catch (IOException e) {
            throw e;
        }
    }
    
    public void anadirProveedor(Proveedor proveedor) throws IOException {
        if (!proveedores.containsKey(proveedor.get())) {
            proveedores.put(proveedor.get(), proveedor);
            try
            {
                hacerBackUp();
            } catch (IOException e) {
                throw e;
            }
        }
    }
    
    public void modificarProveedor(Long algo, Proveedor proveedor) throws IOException {
        if (!proveedores.containsKey(proveedor.get())) {
            proveedores.remove(algo);
            proveedores.put(proveedor.get(), proveedor);
            try
            {
                hacerBackUp();
            } catch (IOException e) {
                throw e;
            }
        }
    }
    
    public void eliminarProveedor(Long algo) throws IOException {
        Proveedor proveedor = proveedores.get(algo);
        proveedores.remove(algo);
        
        //Medidas de eliminación
        for (int i=0; i<citas.size(); i++) {
            Cita cita = citas.get(i);
            if (cita.getConsultorio() == consultorio) {
                citas.remove(i);
            }
        }
        try
        {
            hacerBackUp();
        } catch (IOException e) {
            throw e;
        }
    }
    
    public void anadirVenta(Venta venta) throws IOException {
        if (!ventas.containsKey(venta.get())) {
            ventas.put(venta.get(), venta);
            try
            {
                hacerBackUp();
            } catch (IOException e) {
                throw e;
            }
        }
    }
    
    public void modificarVenta(Long algo, Venta venta) throws IOException {
        if (!ventas.containsKey(venta.get())) {
            ventas.remove(algo);
            ventas.put(venta.get(), venta);
            try
            {
                hacerBackUp();
            } catch (IOException e) {
                throw e;
            }
        }
    }
    
    public void eliminarVenta(Long algo) throws IOException {
        Venta venta = ventas.get(algo);
        ventas.remove(algo);
        
        //Medidas de eliminación
        for (int i=0; i<citas.size(); i++) {
            Cita cita = citas.get(i);
            if (cita.getConsultorio() == consultorio) {
                citas.remove(i);
            }
        }
        try
        {
            hacerBackUp();
        } catch (IOException e) {
            throw e;
        }
    }*/
    
}
