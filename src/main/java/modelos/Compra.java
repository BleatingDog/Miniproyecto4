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

public class Compra implements Serializable{
    
    private Long nFactura;
    private Proveedor proveedor;
    private HashMap <Long, ArrayList<Object>> informacionDelProducto;
    private int precioTotal;

    public Compra(Long nFactura, Proveedor proveedor, HashMap<Long, ArrayList<Object>> informacionDelProducto, int precioTotal) {
        this.nFactura = nFactura;
        this.proveedor = proveedor;
        this.informacionDelProducto = informacionDelProducto;
        this.precioTotal = precioTotal;
    }

    public Long getnFactura() {
        return nFactura;
    }

    public void setnFactura(Long nFactura) {
        this.nFactura = nFactura;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
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
