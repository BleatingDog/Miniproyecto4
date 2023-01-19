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

import controladores.GestorCarrito;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modelos.Almacenamiento;

public class Carrito extends javax.swing.JFrame {
    
    private final DefaultTableModel modeloTabla = new DefaultTableModel();
    private JTableHeader th;
    
    public Carrito(String titulo, Almacenamiento almacenamiento) {
        llenarColumnas();
        initComponents();
        diseñoTabla();
        GestorCarrito gestorRegistroVentas = new GestorCarrito(this, almacenamiento);
        setVisible(true);
        setTitle(titulo);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    public final void llenarColumnas(){
        modeloTabla.addColumn("Producto");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Precio Unitario");
        modeloTabla.addColumn("Precio Total");
    }

    public final void diseñoTabla(){
        
        //Fuente de cabecera
        th = tablaContenido.getTableHeader();
        Font fuente = new Font("Agency FB", Font.BOLD, 22);
        th.setFont(fuente);
        
        //Color cabecera
        tablaContenido.setOpaque(false);
        Color colorCabecera = new Color(204, 204, 204);
        th.setBackground(colorCabecera);
        
        //Color fondo
        Color colorFondo = new Color(255, 255, 255);
        scroll.getViewport().setBackground(colorFondo);
    }

    public JButton getBtnRegresarVenta() {
        return btnRegresarVenta;
    }

    public void setBtnRegresarVenta(JButton btnRegresarVenta) {
        this.btnRegresarVenta = btnRegresarVenta;
    }
    
    public JButton getBtnFinalizarVenta() {
        return btnFinalizarVenta;
    }

    public void setBtnFinalizarVenta(JButton btnFinalizarVenta) {
        this.btnFinalizarVenta = btnFinalizarVenta;
    }
    
    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setJTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }
    
    public JTextField getjTextField2() {
        return jTextField1;
    }

    public void setJTextField2(JTextField jTextField2) {
        this.jTextField2 = jTextField2;
    }
    
    

    public JTable getTablaContenido() {
        return tablaContenido;
    }

    public void setTablaContenido(JTable tablaContenido) {
        this.tablaContenido = tablaContenido;
    }
    
    public void addBtngetBtnRegresarVentaListener(MouseListener listenerBotones){
        btnRegresarVenta.addMouseListener(listenerBotones);
    }
    
    public void addBtnFinalizarVentaListener(MouseListener listenerBotones){
        btnFinalizarVenta.addMouseListener(listenerBotones);
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        btnRegresarVenta = new javax.swing.JButton();
        panelBanner = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        btnFinalizarVenta = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        scroll = new javax.swing.JScrollPane();
        tablaContenido = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        panelFondo.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 570, 860, 20));

        btnRegresarVenta.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnRegresarVenta.setText("Regresar");
        btnRegresarVenta.setFocusPainted(false);
        btnRegresarVenta.setRequestFocusEnabled(false);
        btnRegresarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarVentaActionPerformed(evt);
            }
        });
        panelFondo.add(btnRegresarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 200, -1));
        btnRegresarVenta.setBackground(Color.WHITE);

        panelBanner.setForeground(new java.awt.Color(204, 204, 204));

        lblTitulo.setFont(new java.awt.Font("Agency FB", 1, 56)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Venta Productos");

        lblTitulo1.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("Carrito de Ventas");

        javax.swing.GroupLayout panelBannerLayout = new javax.swing.GroupLayout(panelBanner);
        panelBanner.setLayout(panelBannerLayout);
        panelBannerLayout.setHorizontalGroup(
            panelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBannerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelBannerLayout.createSequentialGroup()
                .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelBannerLayout.setVerticalGroup(
            panelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBannerLayout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelFondo.add(panelBanner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 110));

        btnFinalizarVenta.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnFinalizarVenta.setText("Finalizar Venta");
        btnFinalizarVenta.setFocusPainted(false);
        btnFinalizarVenta.setRequestFocusEnabled(false);
        btnFinalizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarVentaActionPerformed(evt);
            }
        });
        panelFondo.add(btnFinalizarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 510, -1, -1));
        btnRegresarVenta.setBackground(Color.WHITE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Total Venta : ");

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("$$$$$$$$$$$$$$$$");
        jTextField2.setBorder(null);
        jTextField2.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 427, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelFondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 850, 30));

        jTextField1.setEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        panelFondo.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 690, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Nombre cliente ");
        panelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 150, 30));

        tablaContenido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaContenido.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        tablaContenido.setModel(modeloTabla);
        tablaContenido.setRowSelectionAllowed(false);
        scroll.setViewportView(tablaContenido);

        jScrollPane1.setViewportView(scroll);

        panelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 850, 300));

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

    private void btnRegresarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarVentaActionPerformed

    private void btnFinalizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFinalizarVentaActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizarVenta;
    private javax.swing.JButton btnRegresarVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JPanel panelBanner;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tablaContenido;
    // End of variables declaration//GEN-END:variables
}
