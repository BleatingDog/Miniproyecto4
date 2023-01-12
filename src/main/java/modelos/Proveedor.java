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

import java.util.ArrayList;

public class Proveedor {
    
    private Long NIT;
    private String nombre;
    private ArrayList<Producto> productos;

    public Proveedor(Long NIT, String nombre, ArrayList<Producto> productos) {
        this.NIT = NIT;
        this.nombre = nombre;
        this.productos = productos;
    }

    public Long getNIT() {
        return NIT;
    }

    public void setNIT(Long NIT) {
        this.NIT = NIT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    
}
