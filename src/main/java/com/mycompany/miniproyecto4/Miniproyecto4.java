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

package com.mycompany.miniproyecto4;

import javax.swing.JOptionPane;
import modelos.Almacenamiento;
import vistas.Ppal;

public class Miniproyecto4 {

    public static void main(String[] args) {
        try {
            Almacenamiento almacenamiento = new Almacenamiento();
            Ppal ventanaPpal = new Ppal("Supermercado - Universidad del Valle", almacenamiento);    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
