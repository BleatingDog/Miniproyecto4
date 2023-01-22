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

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

public class Venta implements Serializable{
    
    private Long nFactura;
    private Cliente cliente;
    private HashMap <Long, HashMap<String, Object>> informacionDelProducto;
    private int precioTotal;
    private LocalDate fecha;
    private LocalTime hora;

    public Venta(Long nFactura, Cliente cliente, HashMap<Long, HashMap<String, Object>> informacionDelProducto, int precioTotal) {
        this.nFactura = nFactura;
        this.cliente = cliente;
        this.informacionDelProducto = informacionDelProducto;
        this.precioTotal = precioTotal;
        fecha = LocalDate.now();
        hora = LocalTime.now();
    }

    public Long getnFactura() {
        return nFactura;
    }

    public void setnFactura(Long nFactura) {
        this.nFactura = nFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public HashMap<Long, HashMap<String, Object>> getInformacionDelProducto() {
        return informacionDelProducto;
    }

    public void setInformacionDelProducto(HashMap<Long, HashMap<String, Object>> informacionDelProducto) {
        this.informacionDelProducto = informacionDelProducto;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }
    
}
