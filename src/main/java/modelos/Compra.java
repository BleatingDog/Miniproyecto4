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
import java.util.HashMap;

public class Compra implements Serializable{
    
    private Long nFactura;
    private HashMap <Long, HashMap<String, Object>> informacionDelProducto;
    private int precioTotal;

    public Compra(Long nFactura, HashMap<Long, HashMap<String, Object>> informacionDelProducto, int precioTotal) {
        this.nFactura = nFactura;
        this.informacionDelProducto = informacionDelProducto;
        this.precioTotal = precioTotal;
    }

    public Long getnFactura() {
        return nFactura;
    }

    public void setnFactura(Long nFactura) {
        this.nFactura = nFactura;
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
    
}
