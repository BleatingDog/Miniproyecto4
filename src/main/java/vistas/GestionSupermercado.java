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

import controladores.GestorGestionSupermercado;
import java.awt.Color;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import modelos.Almacenamiento;

public class GestionSupermercado extends javax.swing.JFrame {

    public GestionSupermercado(String titulo, Almacenamiento almacenamiento) {
        initComponents();
        GestorGestionSupermercado gestorGestionSupermercado = new GestorGestionSupermercado(this, almacenamiento);
        setVisible(true);
        setTitle(titulo);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public JButton getBtnProducto() {
        return btnProducto;
    }

    public void setBtnProducto(JButton btnProducto) {
        this.btnProducto = btnProducto;
    }

    public JButton getBtnRegresar() {
        return btnRegresar;
    }

    public void setBtnRegresar(JButton btnRegresar) {
        this.btnRegresar = btnRegresar;
    }

    public JButton getBtnCliente() {
        return btnCliente;
    }

    public void setBtnCliente(JButton btnCliente) {
        this.btnCliente = btnCliente;
    }

    public JButton getBtnProveedor() {
        return btnProveedor;
    }

    public void setBtnProveedor(JButton btnProveedor) {
        this.btnProveedor = btnProveedor;
    }
    
    public void addBtnClienteListener(MouseListener listenerBotones){
        btnCliente.addMouseListener(listenerBotones);
    }
    
    public void addBtnProductoListener(MouseListener listenerBotones){
        btnProducto.addMouseListener(listenerBotones);
    }
    
    public void addBtnProveedorListener(MouseListener listenerBotones){
        btnProveedor.addMouseListener(listenerBotones);
    }
    
    public void addBtnRegresarListener(MouseListener listenerBotones){
        btnRegresar.addMouseListener(listenerBotones);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        btnProducto = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();

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
            .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
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

        panelFondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 170));

        separador.setForeground(new java.awt.Color(0, 0, 0));
        panelFondo.add(separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 450, 30));

        btnProducto.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnProducto.setText("Producto");
        btnProducto.setFocusPainted(false);
        btnProducto.setRequestFocusEnabled(false);
        panelFondo.add(btnProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, -1, -1));
        btnProducto.setBackground(Color.WHITE);

        btnRegresar.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setFocusPainted(false);
        btnRegresar.setRequestFocusEnabled(false);
        panelFondo.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 110, -1));
        btnRegresar.setBackground(Color.WHITE);

        btnCliente.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnCliente.setText("Cliente");
        btnCliente.setFocusPainted(false);
        btnCliente.setRequestFocusEnabled(false);
        panelFondo.add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, -1, -1));
        btnCliente.setBackground(Color.WHITE);

        btnProveedor.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnProveedor.setText("Proveedor");
        btnProveedor.setFocusPainted(false);
        btnProveedor.setRequestFocusEnabled(false);
        panelFondo.add(btnProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, -1, -1));
        btnProveedor.setBackground(Color.WHITE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnProducto;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JSeparator separador;
    // End of variables declaration//GEN-END:variables
}
