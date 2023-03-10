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

import controladores.GestorListaProductos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modelos.Almacenamiento;

public class ListaProductos extends javax.swing.JFrame {
    
    private final DefaultTableModel modeloTabla = new DefaultTableModel();
    private JTableHeader th;
    
    public ListaProductos(String titulo, Almacenamiento almacenamiento) {
        llenarColumnas();
        initComponents();
        diseñoTabla();
        GestorListaProductos gestorListaProductos = new GestorListaProductos(this, almacenamiento);
        setVisible(true);
        setTitle(titulo);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    public final void llenarColumnas(){
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Stock");
        modeloTabla.addColumn("Código");
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

    public JButton getBtnRegresar() {
        return btnRegresar;
    }

    public void setBtnRegresar(JButton btnRegresar) {
        this.btnRegresar = btnRegresar;
    }

    public JTable getTablaContenido() {
        return tablaContenido;
    }

    public void setTablaContenido(JTable tablaContenido) {
        this.tablaContenido = tablaContenido;
    }
    
    public void addBtnRegresarListener(MouseListener listenerBotones){
        btnRegresar.addMouseListener(listenerBotones);
    }
    
    public void anadirFilaTabla(Object[] fila) {
        modeloTabla.addRow(fila);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        tablaContenido = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        btnRegresar = new javax.swing.JButton();
        panelBanner = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Agency FB", 1, 56)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Lista de productos");
        panelFondo.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 26, 900, -1));

        tablaContenido = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tablaContenido.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        tablaContenido.setModel(modeloTabla);
        tablaContenido.setFocusable(false);
        tablaContenido.setRowHeight(30);
        tablaContenido.setRowSelectionAllowed(false);
        tablaContenido.getTableHeader().setReorderingAllowed(false);
        scroll.setViewportView(tablaContenido);

        panelFondo.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 130, 756, 300));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        panelFondo.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 524, 756, 26));

        btnRegresar.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setFocusPainted(false);
        btnRegresar.setRequestFocusEnabled(false);
        panelFondo.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 462, -1, -1));
        btnRegresar.setBackground(Color.WHITE);

        panelBanner.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panelBannerLayout = new javax.swing.GroupLayout(panelBanner);
        panelBanner.setLayout(panelBannerLayout);
        panelBannerLayout.setHorizontalGroup(
            panelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        panelBannerLayout.setVerticalGroup(
            panelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        panelFondo.add(panelBanner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 110));

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
    private javax.swing.JButton btnRegresar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelBanner;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tablaContenido;
    // End of variables declaration//GEN-END:variables
}
