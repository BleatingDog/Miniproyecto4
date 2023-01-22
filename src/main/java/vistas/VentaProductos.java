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

import controladores.GestorVentaProductos;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import modelos.Almacenamiento;

public class VentaProductos extends javax.swing.JFrame {

    private DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
    private final Object[] parametrosSpinner;
    private final int value;
    private final int min;
    private final int max;
    private final int step;
    private final SpinnerNumberModel modeloSpinner;
    
    public VentaProductos(String titulo, long cedula, Almacenamiento almacenamiento, HashMap <Long, HashMap <String, Object>> articulosCarrito) {
        this.parametrosSpinner = establecerCantidadProducto();
        this.value = (Integer) parametrosSpinner[0];
        this.min = (Integer) parametrosSpinner[1];
        this.max = (Integer) parametrosSpinner[2];
        this.step = (Integer) parametrosSpinner[3];
        this.modeloSpinner = new SpinnerNumberModel(value, min, max, step);
        initComponents();
        GestorVentaProductos gestorVentaProductos = new GestorVentaProductos(this, cedula, almacenamiento, articulosCarrito);
        setVisible(true);
        setTitle(titulo);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public final Object[] establecerCantidadProducto(){
        Object[] parametros = new Object[4];
        
        Integer value = 1;
        Integer min = 1;
        Integer max = 1000; //Cantidad de existencias del producto
        Integer step = 1;
        
        parametros[0] = value;
        parametros[1] = min;
        parametros[2] = max;
        parametros[3] = step;
        return parametros;
        
    }
    public void anadirProductosCombo(String fila){
        modeloCombo.addElement(fila);
    }
    
    public void limpiarProductosCombo(){
        modeloCombo.removeAllElements();
    }

    public void reiniciarSpinner(){
        modeloSpinner.setValue(min);
    }
    
    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnIrCarrito() {
        return btnIrCarrito;
    }

    public void setBtnIrCarrito(JButton btnIrCarrito) {
        this.btnIrCarrito = btnIrCarrito;
    }

    public JButton getBtnRegresar() {
        return btnRegresar;
    }

    public void setBtnRegresar(JButton btnRegresar) {
        this.btnRegresar = btnRegresar;
    }

    public JComboBox<String> getComboProducto() {
        return comboProducto;
    }

    public void setComboProducto(JComboBox<String> comboProducto) {
        this.comboProducto = comboProducto;
    }

    public JTextField getTxtCliente() {
        return txtCliente;
    }

    public void setTxtCliente(JTextField txtCliente) {
        this.txtCliente = txtCliente;
    }

    public JSpinner getSpinner() {
        return spinner;
    }

    public void setSpinner(JSpinner spinner) {
        this.spinner = spinner;
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
    
    public void addComboListener(ItemListener listenerCombo){
        comboProducto.addItemListener(listenerCombo);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        btnIrCarrito = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblProducto = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        comboProducto = new javax.swing.JComboBox<>();
        spinner = new javax.swing.JSpinner();
        lblNombre3 = new javax.swing.JLabel();
        lblNombre4 = new javax.swing.JLabel();
        lblNombre5 = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        lblTitulo.setFont(new java.awt.Font("Agency FB", 1, 56)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Venta de Productos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        panelFondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 80));

        separador.setForeground(new java.awt.Color(0, 0, 0));
        panelFondo.add(separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 630, 30));

        btnIrCarrito.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        btnIrCarrito.setText("Ir al Carrito");
        btnIrCarrito.setEnabled(false);
        btnIrCarrito.setFocusPainted(false);
        btnIrCarrito.setRequestFocusEnabled(false);
        panelFondo.add(btnIrCarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 170, 40));
        btnIrCarrito.setBackground(Color.WHITE);

        btnRegresar.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setFocusPainted(false);
        btnRegresar.setRequestFocusEnabled(false);
        panelFondo.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 170, 40));
        btnRegresar.setBackground(Color.WHITE);

        btnAgregar.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        btnAgregar.setText("Agregar al Carrito");
        btnAgregar.setFocusPainted(false);
        btnAgregar.setRequestFocusEnabled(false);
        panelFondo.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, 210, 40));
        btnAgregar.setBackground(Color.WHITE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Información compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        lblProducto.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        lblProducto.setText("Producto");

        lblCantidad.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        lblCantidad.setText("Cantidad");

        comboProducto.setModel(modeloCombo);
        comboProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProducto)
                    .addComponent(lblCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre5, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProducto))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(lblNombre3)
                        .addGap(0, 0, 0)
                        .addComponent(lblNombre4)
                        .addGap(0, 0, 0)
                        .addComponent(lblNombre5))
                    .addComponent(lblCantidad))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        panelFondo.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 610, 210));

        lblCliente.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        lblCliente.setText("Cliente");
        panelFondo.add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        txtCliente.setEditable(false);
        txtCliente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelFondo.add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 510, 40));

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre4;
    private javax.swing.JLabel lblNombre5;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JSeparator separador;
    private javax.swing.JSpinner spinner;
    private javax.swing.JTextField txtCliente;
    // End of variables declaration//GEN-END:variables
}
