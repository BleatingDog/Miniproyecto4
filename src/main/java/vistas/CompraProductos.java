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

import controladores.GestorCompraProductos;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import modelos.Almacenamiento;

public class CompraProductos extends javax.swing.JFrame {

    private final DefaultComboBoxModel modeloComboProducto = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modeloComboProveedor = new DefaultComboBoxModel();
    private final Object[] parametrosSpinner;
    private final int value;
    private final int min;
    private final int max;
    private final int step;
    private final SpinnerNumberModel modeloSpinner;
    
    public CompraProductos(String titulo, Almacenamiento almacenamiento, HashMap <Long, HashMap <String, Object>> articulosCarrito) {
        this.parametrosSpinner = establecerCantidadProducto();
        this.value = (Integer) parametrosSpinner[0];
        this.min = (Integer) parametrosSpinner[1];
        this.max = (Integer) parametrosSpinner[2];
        this.step = (Integer) parametrosSpinner[3];
        this.modeloSpinner = new SpinnerNumberModel(value, min, max, step);
        initComponents();
        GestorCompraProductos gestorCompraProductos = new GestorCompraProductos(this, almacenamiento, articulosCarrito);
        setVisible(true);
        setTitle(titulo);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public final Object[] establecerCantidadProducto(){
        Object[] parametros = new Object[4];
        
        Integer value = 1;
        Integer min = 1;
        Integer max = 1000;
        Integer step = 1;
        
        parametros[0] = value;
        parametros[1] = min;
        parametros[2] = max;
        parametros[3] = step;
        return parametros;
        
    }
    
    public DefaultComboBoxModel getModeloComboProducto() {
        return modeloComboProducto;
    }
    
    public void reiniciarSpinner(){
        modeloSpinner.setValue(1);
    }
    
    public void anadirProductosCombo(String producto){
        modeloComboProducto.addElement(producto);
    }
    
    public void anadirProveedoresCombo(String proveedor){
        modeloComboProveedor.addElement(proveedor);
    }
    
    public void limpiarProductosCombo(){
        modeloComboProducto.removeAllElements();
    }
    
    public void limpiarProveedoresCombo(){
        modeloComboProveedor.removeAllElements();
    }

    public JComboBox<String> getComboProducto() {
        return comboProducto;
    }

    public void setComboProducto(JComboBox<String> comboProducto) {
        this.comboProducto = comboProducto;
    }

    public JComboBox<String> getComboProveedor() {
        return comboProveedor;
    }

    public void setComboProveedor(JComboBox<String> comboProveedor) {
        this.comboProveedor = comboProveedor;
    }
    
    
    public JSpinner getSpinner() {
        return spinner;
    }
    public void setSpinner(JSpinner spinner) {
        this.spinner = spinner;
    }
    
    public JButton getBtnAgregar() {
        return btnAgregar;
    }
    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }
    
    public JButton getBtnRegresar() {
        return btnRegresar;
    }
    public void setBtnRegresar(JButton btnRegresar) {
        this.btnRegresar = btnRegresar;
    }
    
    public JButton getBtnIrCarrito() {
        return btnIrCarrito;
    }
    public void setBtnIrCarrito(JButton btnIrCarrito) {
        this.btnIrCarrito = btnIrCarrito;
    }
    
    //Listeners
    public void addBtnIrCarritoListener(MouseListener listenerBotones){
        btnIrCarrito.addMouseListener(listenerBotones);
    }
    public void addBtnRegresarListener(MouseListener listenerBotones){
        btnRegresar.addMouseListener(listenerBotones);
    }
    public void addBtnAgregarListener(MouseListener listenerBotones){
        btnAgregar.addMouseListener(listenerBotones);
    }
    public void addProductoComboListener(ItemListener listenerCombo){
        comboProducto.addItemListener(listenerCombo);
    }
    public void addProveedorComboListener(ItemListener listenerCombo){
        comboProveedor.addItemListener(listenerCombo);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        lblNombre2 = new javax.swing.JLabel();
        comboProveedor = new javax.swing.JComboBox<>();
        comboProducto = new javax.swing.JComboBox<>();
        spinner = new javax.swing.JSpinner();
        lblNombre3 = new javax.swing.JLabel();
        lblNombre4 = new javax.swing.JLabel();
        lblNombre5 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnIrCarrito = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        lblTitulo.setFont(new java.awt.Font("Agency FB", 1, 56)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Compra de Productos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelFondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 80));

        separador.setForeground(new java.awt.Color(0, 0, 0));
        panelFondo.add(separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 630, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Información compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        lblNombre.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        lblNombre.setText("Producto");

        lblNombre1.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        lblNombre1.setText("Cantidad");

        lblNombre2.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        lblNombre2.setText("Proveedor");

        comboProveedor.setModel(modeloComboProveedor);
        comboProveedor.setAutoscrolls(true);
        comboProveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        comboProducto.setModel(modeloComboProducto);
        comboProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        comboProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        spinner.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        spinner.setModel(modeloSpinner);
        spinner.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        spinner.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblNombre3.setFont(new java.awt.Font("Agency FB", 1, 15)); // NOI18N
        lblNombre3.setText("Máximo 1000 productos, si desea ingresar");

        lblNombre4.setFont(new java.awt.Font("Agency FB", 1, 15)); // NOI18N
        lblNombre4.setText("la cantidad por teclado recuerde presionar");

        lblNombre5.setFont(new java.awt.Font("Agency FB", 1, 15)); // NOI18N
        lblNombre5.setText("enter para confirmar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre5, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre2)
                            .addComponent(lblNombre1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboProveedor, 0, 227, Short.MAX_VALUE)
                            .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboProducto))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre2)
                    .addComponent(comboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre1)
                    .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblNombre3)
                .addGap(0, 0, 0)
                .addComponent(lblNombre4)
                .addGap(0, 0, 0)
                .addComponent(lblNombre5)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        lblNombre3.getAccessibleContext().setAccessibleName("Máximo 1000 productos, si desea ingresar\nla cantidad por teclado recuerde presionar\nenter para confirmar");

        panelFondo.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 560, 280));

        btnRegresar.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setFocusPainted(false);
        btnRegresar.setRequestFocusEnabled(false);
        panelFondo.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 170, 40));
        btnRegresar.setBackground(Color.WHITE);

        btnAgregar.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        btnAgregar.setText("Agregar al carrito");
        btnAgregar.setFocusPainted(false);
        btnAgregar.setRequestFocusEnabled(false);
        panelFondo.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 190, 40));
        btnAgregar.setBackground(Color.WHITE);

        btnIrCarrito.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        btnIrCarrito.setText("Ir al Carrito");
        btnIrCarrito.setEnabled(false);
        btnIrCarrito.setFocusPainted(false);
        btnIrCarrito.setRequestFocusEnabled(false);
        panelFondo.add(btnIrCarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 170, 40));
        btnIrCarrito.setBackground(Color.WHITE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnIrCarrito;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comboProducto;
    private javax.swing.JComboBox<String> comboProveedor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre4;
    private javax.swing.JLabel lblNombre5;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JSeparator separador;
    private javax.swing.JSpinner spinner;
    // End of variables declaration//GEN-END:variables
}
