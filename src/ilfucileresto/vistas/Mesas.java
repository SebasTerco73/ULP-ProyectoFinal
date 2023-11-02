package ilfucileresto.vistas;

import ilfucileresto.AccesoADatos.MesaData;
import ilfucileresto.AccesoADatos.PedidoData;
import ilfucileresto.Entidades.Mesa;
import ilfucileresto.Entidades.Pedido;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Mesas extends javax.swing.JInternalFrame {

    MesaData mD = new MesaData();
    List<Mesa> mesas;
    HashMap<Integer, JButton> botones = new HashMap();

    public Mesas() {
        initComponents();
        mostrarMesas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        scroll1 = new javax.swing.JScrollPane();
        pnMesas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 32, 6));
        jPanel1.setPreferredSize(new java.awt.Dimension(659, 74));

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Mesas");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ilfucileresto/Imagenes/sincronizar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(518, 518, 518)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        scroll1.setPreferredSize(new java.awt.Dimension(956, 586));

        pnMesas.setPreferredSize(new java.awt.Dimension(954, 586));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 1, 1);
        flowLayout1.setAlignOnBaseline(true);
        pnMesas.setLayout(flowLayout1);
        scroll1.setViewportView(pnMesas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1129, Short.MAX_VALUE)
            .addComponent(scroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 1129, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scroll1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mesas = mD.listarMesas(false);
        for (Mesa mesa : mesas) {
            actualizarColor(mesa);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnMesas;
    private javax.swing.JScrollPane scroll1;
    // End of variables declaration//GEN-END:variables

    public void mostrarMesas() {
//        ImageIcon icono = new ImageIcon("C:/Users/ferge/Documents/GitHub/Ilfucileresto/src/ilfucileresto/Imagenes/comedor.png");
        ImageIcon icono = new ImageIcon(getClass().getResource("/ilfucileresto/Imagenes/comedor.png"));
        int contador = 0;
        int altoPlus = pnMesas.getHeight();
        mesas = mD.listarMesas(false);
        for (Mesa mesa : mesas) {
            JButton boton = new JButton();
            boton.setName("btnMesa" + (mesa.getIdMesa()));
            boton.setIcon(icono);
            boton.setText("Mesa Nº " + (mesa.getIdMesa()));
            boton.setHorizontalTextPosition(JButton.CENTER);
            boton.setVerticalTextPosition(JButton.TOP);
            if (mesa.getEstadoMesa() == 0) {
                boton.setBackground(Color.green);
            } else if (mesa.getEstadoMesa() == 1) {
                boton.setBackground(Color.red);
            }
            boton.setFocusable(false);
            boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (boton.getBackground() == Color.green) {
                        boton.setBackground(Color.red);
                        mesa.setEstadoMesa(1);
                        mD.modificarMesa(mesa);
                    } else {
                        PedidoData peD = new PedidoData();
                        List<Pedido> pedidos = peD.buscarPedidoAbiertoPorMesa(mesa);
                        if (!pedidos.isEmpty()) {
                            JOptionPane.showMessageDialog(rootPane, "La mesa no puede cambiar su estado a LIBRE por tener pedidos pendientes.");
                            return;
                        }
                        boton.setBackground(Color.green);
                        mesa.setEstadoMesa(0);
                        mD.modificarMesa(mesa);
                    }
                }
            });
            pnMesas.add(boton);
            boton.setVisible(true);
            contador += 1;
            if (contador == 7) {
                int ancho = pnMesas.getWidth();
                altoPlus += 200;
                pnMesas.setPreferredSize(new Dimension(ancho, altoPlus));
                pnMesas.revalidate();
                pnMesas.repaint();
                contador = 0;
            }
            botones.put(mesa.getIdMesa(), boton);
        }
    }

    public void actualizarColor(Mesa mesa) {
        JButton boton = botones.get(mesa.getIdMesa());
        if (mesa.getEstadoMesa() == 0) {
            boton.setBackground(Color.green);
        } else if (mesa.getEstadoMesa() == 1) {
            boton.setBackground(Color.red);
        }
    }
}
