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

public class GestorListaClientes {
    
    private final ListaClientes vistaListaClientes;
    private final Almacenamiento almacenamiento;

    public GestorListaClientes(ListaClientes vistaListaClientes, Almacenamiento almacenamiento) {
        this.vistaListaClientes = vistaListaClientes;
        this.almacenamiento = almacenamiento;
    } 
}
