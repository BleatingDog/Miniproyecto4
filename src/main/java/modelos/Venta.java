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
import java.util.ArrayList;
import java.util.HashMap;

public class Venta implements Serializable{
    
    private Long nFactura;
    private Cliente cliente;
    private HashMap <Long, ArrayList<Object>> informacionDelProducto;
    private int precioTotal;

    public Venta(Long nFactura, Cliente cliente, HashMap<Long, ArrayList<Object>> informacionDelProducto, int precioTotal) {
        this.nFactura = nFactura;
        this.cliente = cliente;
        this.informacionDelProducto = informacionDelProducto;
        this.precioTotal = precioTotal;
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

    public HashMap<Long, ArrayList<Object>> getInformacionDelProducto() {
        return informacionDelProducto;
    }

    public void setInformacionDelProducto(HashMap<Long, ArrayList<Object>> informacionDelProducto) {
        this.informacionDelProducto = informacionDelProducto;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }
    
}
