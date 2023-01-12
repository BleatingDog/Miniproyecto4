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

public class Producto {
    
    private Long codigo;
    private String nombre;
    private int precio;
    private int cantidad;

    public Producto(Long codigo, String nombre, int precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        cantidad = 0;
    }    

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public void agregarExistencias(int existenciasCompradas) {
        this.cantidad += existenciasCompradas;
    }
    
    public void removerExistencias(int existenciasVendidas) {
        this.cantidad -= existenciasVendidas;
    }
    
}
