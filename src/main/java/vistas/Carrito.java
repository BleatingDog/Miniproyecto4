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
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modelos.Almacenamiento;

public class Carrito extends javax.swing.JFrame {
    
    private final DefaultTableModel modeloTabla = new DefaultTableModel();
    private JTableHeader th;
    
    public Carrito(String titulo, long identificador, String opcion, Almacenamiento almacenamiento) {
        llenarColumnas();
        initComponents();
        diseñoTabla();
        GestorCarrito gestorCarrito = new GestorCarrito(this, identificador, opcion, almacenamiento);
        setVisible(true);
        setTitle(titulo);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    public final void llenarColumnas(){
        
        modeloTabla.addColumn("Producto");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Precio Unitario");
        modeloTabla.addColumn("Subtotal");
            
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

    public void anadirFilaTabla(Object[] fila) {
        modeloTabla.addRow(fila);
    }
    
    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtTotal() {
        return txtTotal;
    }

    public void setTxtTotal(JTextField txtTotal) {
        this.txtTotal = txtTotal;
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
    
    public void addBtnEliminarListener(MouseListener listenerBotones){
        btnEliminar.addMouseListener(listenerBotones);
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        btnRegresarVenta = new javax.swing.JButton();
        panelBanner = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        btnFinalizarVenta = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        tablaContenido = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();

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
        panelFondo.add(btnRegresarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 150, -1));
        btnRegresarVenta.setBackground(Color.WHITE);

        panelBanner.setForeground(new java.awt.Color(204, 204, 204));

        lblTitulo.setFont(new java.awt.Font("Agency FB", 1, 56)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Venta productos");

        lblTitulo2.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("Carrito");

        javax.swing.GroupLayout panelBannerLayout = new javax.swing.GroupLayout(panelBanner);
        panelBanner.setLayout(panelBannerLayout);
        panelBannerLayout.setHorizontalGroup(
            panelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBannerLayout.createSequentialGroup()
                .addGroup(panelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBannerLayout.createSequentialGroup()
                        .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBannerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelBannerLayout.setVerticalGroup(
            panelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBannerLayout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotal.setText("Total venta : ");

        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setText("$$$$$$$$$$$$$$$$");
        txtTotal.setBorder(null);
        txtTotal.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 427, Short.MAX_VALUE)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelFondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 850, 30));

        txtNombre.setEnabled(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        panelFondo.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 690, 30));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombre.setText("Nombre cliente ");
        panelFondo.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 150, 30));

        tablaContenido.setModel(modeloTabla);
        scroll.setViewportView(tablaContenido);

        panelFondo.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 850, 280));

        btnEliminar.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusPainted(false);
        btnEliminar.setRequestFocusEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        panelFondo.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 510, -1, -1));
        btnRegresarVenta.setBackground(Color.WHITE);

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

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFinalizarVenta;
    private javax.swing.JButton btnRegresarVenta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panelBanner;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tablaContenido;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
