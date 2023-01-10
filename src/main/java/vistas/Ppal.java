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

package vistas;

import controladores.GestorPpal;
import java.awt.Color;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class Ppal extends javax.swing.JFrame {

    public Ppal(String titulo) {
        initComponents();
        GestorPpal gestorPpal = new GestorPpal();
        setVisible(true);
        setTitle(titulo);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public JButton getBtnCompra() {
        return btnCompra;
    }

    public void setBtnCompra(JButton btnCompra) {
        this.btnCompra = btnCompra;
    }

    public JButton getBtnGestion() {
        return btnGestion;
    }

    public void setBtnGestion(JButton btnGestion) {
        this.btnGestion = btnGestion;
    }

    public JButton getBtnVenta() {
        return btnVenta;
    }

    public void setBtnVenta(JButton btnVenta) {
        this.btnVenta = btnVenta;
    }
    public void addBtnVentaListener(MouseListener listenerBotones){
        btnVenta.addMouseListener(listenerBotones);
    }
    
    public void addBtnCompraListener(MouseListener listenerBotones){
        btnCompra.addMouseListener(listenerBotones);
    }
    
    public void addBtnGestionListener(MouseListener listenerBotones){
        btnGestion.addMouseListener(listenerBotones);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        btnCompra = new javax.swing.JButton();
        btnGestion = new javax.swing.JButton();
        btnVenta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        lblTitulo.setFont(new java.awt.Font("Agency FB", 1, 56)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Supermercado");

        lblTitulo1.setFont(new java.awt.Font("Agency FB", 1, 56)); // NOI18N
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("Universidad del Valle");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo1)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        panelFondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 170));

        separador.setForeground(new java.awt.Color(0, 0, 0));
        panelFondo.add(separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 720, 30));

        btnCompra.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnCompra.setText("Compra de productos");
        btnCompra.setFocusPainted(false);
        btnCompra.setRequestFocusEnabled(false);
        panelFondo.add(btnCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, -1, -1));
        btnCompra.setBackground(Color.WHITE);

        btnGestion.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnGestion.setText("Gestión de supermercado");
        btnGestion.setFocusPainted(false);
        btnGestion.setRequestFocusEnabled(false);
        panelFondo.add(btnGestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, -1, -1));
        btnGestion.setBackground(Color.WHITE);

        btnVenta.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnVenta.setText("Venta de productos");
        btnVenta.setFocusPainted(false);
        btnVenta.setRequestFocusEnabled(false);
        panelFondo.add(btnVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, -1));
        btnVenta.setBackground(Color.WHITE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompra;
    private javax.swing.JButton btnGestion;
    private javax.swing.JButton btnVenta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JSeparator separador;
    // End of variables declaration//GEN-END:variables
}
