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

import modelos.Almacenamiento;
import vistas.ListaClientes;
import vistas.ListaProveedores;

public class GestorListaProveedores {
    
    private final ListaProveedores vistaListaProveedores;
    private final Almacenamiento almacenamiento;

    public GestorListaProveedores(ListaProveedores vistaListaProveedores, Almacenamiento almacenamiento) {
        this.vistaListaProveedores = vistaListaProveedores;
        this.almacenamiento = almacenamiento;
    } 
}
