package ilfucileresto.vistas;

import ilfucileresto.AccesoADatos.DetallePedidoData;
import ilfucileresto.AccesoADatos.EmpleadoData;
import ilfucileresto.AccesoADatos.MesaData;
import ilfucileresto.AccesoADatos.PedidoData;
import ilfucileresto.AccesoADatos.ProductoData;
import ilfucileresto.Entidades.DetallePedido;
import ilfucileresto.Entidades.Empleado;
import ilfucileresto.Entidades.Mesa;
import ilfucileresto.Entidades.Pedido;
import ilfucileresto.Entidades.Producto;
import java.awt.Color;
import java.awt.Component;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIDefaults;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Pedidos extends javax.swing.JInternalFrame {

    private ProductoData pD = new ProductoData();
    private MesaData mD = new MesaData();
    private EmpleadoData eD = new EmpleadoData();
    private PedidoData peD = new PedidoData();
    private DetallePedidoData dpD = new DetallePedidoData();

    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (value != null) {
                table.setRowHeight(row, component.getPreferredSize().height);
                table.getColumnModel().getColumn(column).setPreferredWidth(component.getPreferredSize().width);
            }
            return component;
        }
    };

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    private DefaultTableModel modeloVacio = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    private DefaultTableModel modeloDetalle = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    private DefaultTableModel modeloDetallePedido = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    public Pedidos() {
        initComponents();
        cargarColumnasProductos();
        cargarColumnasPedidos();
        cargarColumnasDetallePedidos();
        cargarColumnasDetalle();
        mostrarDatosTablaProductos();
        cargarComboMesas();
        cargarComboMozos(cboMozo);
        cargarComboMozos(cboMozos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Solapas = new javax.swing.JTabbedPane();
        pnAgregarPedido = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPedido = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        cboMozo = new javax.swing.JComboBox<>();
        cboMesas = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnDescartar = new javax.swing.JButton();
        lblModo = new javax.swing.JLabel();
        lblPedido = new javax.swing.JLabel();
        pnVerPedido = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaDetalle = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtTotal = new javax.swing.JTextField();
        btnPago = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaDetallePedido = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cboMozos = new javax.swing.JComboBox<>();
        btnModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 32, 6));
        jPanel1.setPreferredSize(new java.awt.Dimension(659, 74));

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Pedidos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(487, 487, 487))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        UIDefaults color=new UIDefaults();
        color.put("TabbedPane:TabbedPaneTab[Enabled].textForeground",new Color(102,32,6));
        Solapas.putClientProperty("Nimbus.Overrides", color);
        Solapas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Solapas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SolapasMouseClicked(evt);
            }
        });

        pnAgregarPedido.setForeground(new java.awt.Color(51, 51, 255));
        pnAgregarPedido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tbPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbPedido);

        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbProductos);

        cboMozo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cboMozoPopupMenuWillBecomeVisible(evt);
            }
        });

        cboMesas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cboMesasFocusGained(evt);
            }
        });
        cboMesas.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cboMesasPopupMenuWillBecomeVisible(evt);
            }
        });
        cboMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboMesasMouseClicked(evt);
            }
        });
        cboMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMesasActionPerformed(evt);
            }
        });
        cboMesas.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cboMesasPropertyChange(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mozo:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Mesa:");

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAceptar.setText("Confirmar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAgregar.setFocusPainted(false);
        btnAgregar.setOpaque(false);
        //btnAgregar.setBorderPainted(false);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setBackground(new Color(173, 89, 42,200));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ilfucileresto/Imagenes/flechas-a-la-derecha-verde.png"))); // NOI18N
        btnAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregar.setBorderPainted(false);
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAgregarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAgregarMouseReleased(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnDescartar.setFocusPainted(false);
        btnDescartar.setOpaque(false);
        btnDescartar.setBorderPainted(false);
        btnDescartar.setContentAreaFilled(false);
        btnDescartar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDescartar.setBackground(new java.awt.Color(224, 154, 114));
        btnDescartar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ilfucileresto/Imagenes/flechas-izquierda.png"))); // NOI18N
        btnDescartar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDescartarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDescartarMouseReleased(evt);
            }
        });
        btnDescartar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescartarActionPerformed(evt);
            }
        });

        lblModo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblModo.setText("Nuevo Pedido");

        lblPedido.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout pnAgregarPedidoLayout = new javax.swing.GroupLayout(pnAgregarPedido);
        pnAgregarPedido.setLayout(pnAgregarPedidoLayout);
        pnAgregarPedidoLayout.setHorizontalGroup(
            pnAgregarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAgregarPedidoLayout.createSequentialGroup()
                .addContainerGap(535, Short.MAX_VALUE)
                .addGroup(pnAgregarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDescartar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(62, 62, 62)
                .addGroup(pnAgregarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnAgregarPedidoLayout.createSequentialGroup()
                        .addGroup(pnAgregarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnAgregarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pnAgregarPedidoLayout.createSequentialGroup()
                                    .addComponent(btnAceptar)
                                    .addGap(30, 30, 30)
                                    .addComponent(btnCancelar))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnAgregarPedidoLayout.createSequentialGroup()
                                .addGroup(pnAgregarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboMozo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(pnAgregarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(cboMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(62, 62, 62))
                    .addGroup(pnAgregarPedidoLayout.createSequentialGroup()
                        .addComponent(lblModo)
                        .addGap(18, 18, 18)
                        .addComponent(lblPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147))))
            .addGroup(pnAgregarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnAgregarPedidoLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(652, Short.MAX_VALUE)))
        );
        pnAgregarPedidoLayout.setVerticalGroup(
            pnAgregarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAgregarPedidoLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(pnAgregarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModo)
                    .addComponent(lblPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnAgregarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnAgregarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnAgregarPedidoLayout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnDescartar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(226, 226, 226))
                    .addGroup(pnAgregarPedidoLayout.createSequentialGroup()
                        .addGroup(pnAgregarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboMozo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(pnAgregarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addGroup(pnAgregarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnAgregarPedidoLayout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );

        Solapas.addTab("Agregar Pedido", pnAgregarPedido);

        jPanel2.setBackground(new java.awt.Color(255, 231, 168));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tablaDetalle);

        jPanel5.setBackground(new java.awt.Color(203, 101, 59));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Detalle del Pedido");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(22, 22, 22))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Total");

        jtTotal.setEditable(false);

        btnPago.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPago.setText("Pagó");
        btnPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPago, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1))
                    .addComponent(jtTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btnPago, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );

        jPanel3.setBackground(new java.awt.Color(255, 221, 164));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Mozo:");

        tablaDetallePedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaDetallePedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDetallePedidoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaDetallePedido);

        jPanel4.setBackground(new java.awt.Color(203, 101, 59));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Pedidos del dia");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        cboMozos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMozosItemStateChanged(evt);
            }
        });
        cboMozos.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cboMozosPopupMenuWillBecomeVisible(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboMozos, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnModificar))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboMozos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout pnVerPedidoLayout = new javax.swing.GroupLayout(pnVerPedido);
        pnVerPedido.setLayout(pnVerPedidoLayout);
        pnVerPedidoLayout.setHorizontalGroup(
            pnVerPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnVerPedidoLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnVerPedidoLayout.setVerticalGroup(
            pnVerPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Solapas.addTab("Ver Pedidos", pnVerPedido);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1139, Short.MAX_VALUE)
            .addComponent(Solapas, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Solapas))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboMozosPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboMozosPopupMenuWillBecomeVisible
        Empleado emp = (Empleado) cboMozos.getSelectedItem();
        cboMozos.removeAllItems();
        List<Empleado> empleados = eD.listarEmpleados();
        cargarComboMozos(cboMozos);
        cboMozos.setSelectedItem(emp);
    }//GEN-LAST:event_cboMozosPopupMenuWillBecomeVisible

    private void cboMozosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMozosItemStateChanged
        if (cboMozos.getSelectedItem() != null) {
            cargarTablaPedidos();
        } else {
            modeloDetallePedido.setRowCount(0);
        }
    }//GEN-LAST:event_cboMozosItemStateChanged

    private void tablaDetallePedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDetallePedidoMouseClicked
        if (modeloDetallePedido.getRowCount() >= 0) {
            cargarTablaDetallePedidos();
            String pago = (String) modeloDetallePedido.getValueAt(tablaDetallePedido.getSelectedRow(), 3);
            if (pago.equals("Pago") || pago.equals("Cancelado")) {
                btnPago.setEnabled(false);
                btnModificar.setEnabled(false);
            } else if (pago.equals("Sin pagar")) {
                btnPago.setEnabled(true);
                btnModificar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_tablaDetallePedidoMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (tablaDetallePedido.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un pedido");
            return;
        }
        Solapas.setSelectedIndex(0);
        lblModo.setText("Modificar Pedido");
        String num = modeloDetallePedido.getValueAt(tablaDetallePedido.getSelectedRow(), 0).toString();
        lblPedido.setText("N°" + num);

        int e = (Integer) tablaDetallePedido.getValueAt(tablaDetallePedido.getSelectedRow(), 0);
        Pedido p = peD.buscarPedido(e);
        int idEmpleado = p.getEmpleado().getIdEmpleado();
        Empleado mozo = eD.buscarEmpleado(idEmpleado);
        cboMozo.setSelectedItem(mozo);
        cboMesas.setSelectedItem(p.getMesa());
        List<DetallePedido> dp = dpD.listarDetallePedidosPorId(e);
        modeloVacio.setRowCount(0);
        for (DetallePedido d : dp) {
            for (int i = 0; i < d.getCantidad(); i++) {
                modeloVacio.addRow(new Object[]{d.getProducto().getIdProducto(), d.getProducto().getNombreProducto(),
                    d.getProducto().getPrecioUnitario()});
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnDescartarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescartarActionPerformed
        if (tbPedido.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto.");
            return;
        }
        Integer codigo = (Integer) modeloVacio.getValueAt(tbPedido.getSelectedRow(), 0);
        String descripcion = (String) modeloVacio.getValueAt(tbPedido.getSelectedRow(), 1);
        Double precioUnitario = (Double) modeloVacio.getValueAt(tbPedido.getSelectedRow(), 2);
        modeloVacio.removeRow(tbPedido.getSelectedRow());
        Producto seleccionado = pD.buscarProducto(codigo);
        seleccionado.setStock(seleccionado.getStock() + 1);
        if (seleccionado.getStock() == 1) {
            seleccionado.setEstado(true);
        }
        pD.modificarProducto(seleccionado);
        mostrarDatosTablaProductos();
    }//GEN-LAST:event_btnDescartarActionPerformed

    private void btnDescartarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescartarMouseReleased
        btnDescartar.setContentAreaFilled(false);
        btnDescartar.setBackground(new Color(173, 89, 42, 200));
    }//GEN-LAST:event_btnDescartarMouseReleased

    private void btnDescartarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescartarMousePressed
        btnDescartar.setContentAreaFilled(true);
        btnDescartar.setBackground(new Color(254, 89, 68));
    }//GEN-LAST:event_btnDescartarMousePressed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (tbProductos.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto.");
            return;
        }
        int fila = tbProductos.getSelectedRow();
        Integer codigo = (Integer) modelo.getValueAt(tbProductos.getSelectedRow(), 0);
        String descripcion = (String) modelo.getValueAt(tbProductos.getSelectedRow(), 1);
        Double precioUnitario = (Double) modelo.getValueAt(tbProductos.getSelectedRow(), 2);
        modeloVacio.addRow(new Object[]{codigo, descripcion, precioUnitario});
        Producto seleccionado = pD.buscarProducto(codigo);
        seleccionado.setStock(seleccionado.getStock() - 1);
        if (seleccionado.getStock() == 0) {
            seleccionado.setEstado(false);
        }
        pD.modificarProducto(seleccionado);
        mostrarDatosTablaProductos();
        if (fila < tbProductos.getRowCount()) {
            tbProductos.setRowSelectionInterval(fila, fila);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAgregarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseReleased
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setBackground(new Color(173, 89, 42, 200));
    }//GEN-LAST:event_btnAgregarMouseReleased

    private void btnAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMousePressed
        btnAgregar.setContentAreaFilled(true);
        btnAgregar.setBackground(new Color(129, 239, 108));
    }//GEN-LAST:event_btnAgregarMousePressed

    private void btnAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseExited

    }//GEN-LAST:event_btnAgregarMouseExited

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int x = JOptionPane.showConfirmDialog(this, "¿Desea cancelar el pedido? Los productos ingresados se perderán.", "Cancelar Pedido", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {
            for (int i = 0; i < tbPedido.getRowCount(); i++) {
                Integer codigo = (Integer) modeloVacio.getValueAt(i, 0);
                String descripcion = (String) modeloVacio.getValueAt(i, 1);
                Double precioUnitario = (Double) modeloVacio.getValueAt(i, 2);
                Producto seleccionado = pD.buscarProducto(codigo);
                seleccionado.setStock(seleccionado.getStock() + 1);
                if (seleccionado.getStock() == 1) {
                    seleccionado.setEstado(true);
                }
                pD.modificarProducto(seleccionado);
            }
            if (lblModo.getText().equals("Modificar Pedido")) {
                int num = (Integer) modeloDetallePedido.getValueAt(tablaDetallePedido.getSelectedRow(), 0);
                Pedido pedido = peD.buscarPedido(num);
                pedido.setEstado(0);
                peD.modificarPedido(pedido);
                Mesa mesa = mD.buscarMesa(pedido.getMesa().getIdMesa());
                List<Pedido> pedidos = peD.buscarPedidoAbiertoPorMesa(mesa);

                if (pedidos.size() < 1) {
                    mesa.setEstadoMesa(0);
                    mD.modificarMesa(mesa);
                }
            }
            modeloVacio.setRowCount(0);
            mostrarDatosTablaProductos();
            lblModo.setText("Nuevo Pedido");
            lblPedido.setText("");
            cargarTablaPedidos();

        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (cboMozo.getSelectedItem() == null || cboMesas.getSelectedItem() == null || tbPedido.getRowCount() < 0) {
            JOptionPane.showMessageDialog(this, "Debe completar todos los datos.");
            return;
        }
        Pedido pedido;
        if (lblModo.getText().equals("Modificar Pedido")) {
            int id = (Integer) tablaDetalle.getValueAt(0, 0);
            pedido = peD.buscarPedido(id);
        } else {
            pedido = new Pedido();
        }
        DetallePedido dp = new DetallePedido();
        Empleado e = (Empleado) cboMozo.getSelectedItem();
        Mesa m = (Mesa) cboMesas.getSelectedItem();
        pedido.setEmpleado(e);
        pedido.setMesa(m);
        pedido.setFechaHora(LocalDateTime.now());
        pedido.setPago(false);
        pedido.setEstado(1);
        dp.setPedido(pedido);
        if (lblModo.getText().equals("Modificar Pedido")) {
            dpD.eliminarDetallePedido(pedido);
        } else {
            peD.guardarPedido(pedido);
        }
        Map<Integer, Integer> conteoProductos = new HashMap<>();
        for (int fila = 0; fila < modeloVacio.getRowCount(); fila++) {
            Integer producto = (Integer) modeloVacio.getValueAt(fila, 0);
            conteoProductos.put(producto, conteoProductos.getOrDefault(producto, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : conteoProductos.entrySet()) {
            int key = Integer.valueOf(entry.getKey());
            Producto pro = pD.buscarProducto(key);
            Integer value = entry.getValue();
            dpD.agregarDetallePedido(pedido, pro, value);
        }
        double total = dpD.calcularTotal(pedido);
        pedido.setImporte(total);
        peD.modificarPedido(pedido);
        cboMesas.setSelectedIndex(0);
        cboMozo.setSelectedIndex(0);
        modeloVacio.setRowCount(0);
        lblModo.setText("Nuevo Pedido");
        lblPedido.setText("");

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void cboMesasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cboMesasPropertyChange

    }//GEN-LAST:event_cboMesasPropertyChange

    private void cboMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMesasActionPerformed

    }//GEN-LAST:event_cboMesasActionPerformed

    private void cboMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboMesasMouseClicked

    }//GEN-LAST:event_cboMesasMouseClicked

    private void cboMesasPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboMesasPopupMenuWillBecomeVisible
        Mesa seleccionada = (Mesa) cboMesas.getSelectedItem();
        cargarComboMesas();
        cboMesas.setSelectedItem(seleccionada);
    }//GEN-LAST:event_cboMesasPopupMenuWillBecomeVisible

    private void cboMesasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cboMesasFocusGained

    }//GEN-LAST:event_cboMesasFocusGained

    private void cboMozoPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboMozoPopupMenuWillBecomeVisible

    }//GEN-LAST:event_cboMozoPopupMenuWillBecomeVisible

    private void tbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMouseClicked

    }//GEN-LAST:event_tbProductosMouseClicked

    private void btnPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoActionPerformed

        if (tablaDetallePedido.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un pedido.");
            return;
        }

        int x = JOptionPane.showConfirmDialog(this, "¿Desea cerrar la mesa?. La cuenta se guardará como 'PAGÓ'", "Cerrar Cuenta", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {
            int idPedido = (Integer) modeloDetallePedido.getValueAt(tablaDetallePedido.getSelectedRow(), 0);
            Pedido pedido = peD.buscarPedido(idPedido);
            Mesa mesa = pedido.getMesa();
            

            pedido.setPago(true);
            peD.modificarPedido(pedido);
            List<Pedido> pedidos = peD.buscarPedidoAbiertoPorMesa(mesa);

            if (pedidos.size() < 1) {
                mesa.setEstadoMesa(0);
                mD.modificarMesa(mesa);
            }

            cargarTablaPedidos();
            cargarTablaDetallePedidos();
        }


    }//GEN-LAST:event_btnPagoActionPerformed

    private void SolapasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SolapasMouseClicked

        cargarTablaPedidos();
        cargarTablaDetallePedidos();
    }//GEN-LAST:event_SolapasMouseClicked

    public void cargarColumnasProductos() {
        modelo.addColumn("Codigo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("PrecioUnitario");
        modelo.addColumn("Stock");
        tbProductos.setModel(modelo);
    }

    public void cargarColumnasPedidos() {
        modeloVacio.addColumn("Codigo");
        modeloVacio.addColumn("Descripcion");
        modeloVacio.addColumn("PrecioUnitario");
        tbPedido.setModel(modeloVacio);
    }

    public void cargarColumnasDetalle() {
        modeloDetalle.addColumn("IdPedido");
        modeloDetalle.addColumn("Producto");
        modeloDetalle.addColumn("Cantidad");
        modeloDetalle.addColumn("Subtotal");
        tablaDetalle.setModel(modeloDetalle);
    }

    public void cargarColumnasDetallePedidos() {
        modeloDetallePedido.addColumn("Pedido");
        modeloDetallePedido.addColumn("Mesa");
        modeloDetallePedido.addColumn("Fecha");
        modeloDetallePedido.addColumn("Estado");
        tablaDetallePedido.setModel(modeloDetallePedido);
        tablaDetallePedido.setDefaultRenderer(Object.class, renderer);
    }

    public void mostrarDatosTablaProductos() {
        String estado;
        List<Producto> productos = pD.listarProductos();
        modelo.setRowCount(0);
        for (Producto producto : productos) {
            if (producto.isEstado()) {
                modelo.addRow(new Object[]{producto.getIdProducto(), producto.getNombreProducto(), producto.getPrecioUnitario(), producto.getStock()});
            }
        }
    }

    public void cargarComboMesas() {
        cboMesas.removeAllItems();
        List<Mesa> mesas = mD.listarMesas(true);
        cboMesas.addItem(null);
        for (Mesa mesa : mesas) {
            cboMesas.addItem(mesa);
        }
    }

    public void cargarComboMozos(JComboBox cbo) {
        cbo.removeAllItems();
        List<Empleado> empleados = eD.listarEmpleados();
        cbo.addItem(null);
        for (Empleado mozo : empleados) {
            if (mozo.getPuesto().equals("MESERO") && mozo.isEstado()) {
                cbo.addItem(mozo);
            }
        }

    }

    public void cargarTablaPedidos() {
        if (cboMozos.getSelectedItem() == null) {
            return;
        }
        Empleado e = (Empleado) cboMozos.getSelectedItem();
        List<Pedido> detalles = peD.listarPedidosPorMesero(e, LocalDate.now());
        //List<DetallePedido> detalles = dpD.listarDetallePedidosPorEmpleadoPreciosHora(e.getIdEmpleado());
        modeloDetallePedido.setRowCount(0);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String pago = "";
        for (Pedido p : detalles) {
            if (p.isPago()) {
                pago = "Pago";
            } else {
                if (p.getEstado() == 0) {
                    pago = "Cancelado";
                } else {
                    pago = "Sin pagar";
                }

            }
            String fecha = p.getFechaHora().format(formato);
            modeloDetallePedido.addRow(new Object[]{p.getIdPedido(), p.getMesa().getIdMesa(),
                fecha, pago});
        }
    }

    public void cargarTablaDetallePedidos() {
        if (tablaDetallePedido.getSelectedRow() >= 0) {
            int x = (Integer) tablaDetallePedido.getValueAt(tablaDetallePedido.getSelectedRow(), 0);
            List<DetallePedido> dp = dpD.listarDetallePedidosPorId(x);
            Set<DetallePedido> setDP = new HashSet<>(dp);
            modeloDetalle.setRowCount(0);
            for (DetallePedido d : setDP) {
                double sub = dpD.calcularSubtotal(d.getProducto(), d.getCantidad());
                modeloDetalle.addRow(new Object[]{d.getPedido().getIdPedido(), d.getProducto().getNombreProducto(), d.getCantidad(), sub});
            }
            Pedido p = peD.buscarPedido(x);
            jtTotal.setText(dpD.calcularTotal(p) + "");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Solapas;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDescartar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnPago;
    private javax.swing.JComboBox<Mesa> cboMesas;
    private javax.swing.JComboBox<Empleado> cboMozo;
    private javax.swing.JComboBox<Empleado> cboMozos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jtTotal;
    private javax.swing.JLabel lblModo;
    private javax.swing.JLabel lblPedido;
    private javax.swing.JPanel pnAgregarPedido;
    private javax.swing.JPanel pnVerPedido;
    private javax.swing.JTable tablaDetalle;
    private javax.swing.JTable tablaDetallePedido;
    private javax.swing.JTable tbPedido;
    private javax.swing.JTable tbProductos;
    // End of variables declaration//GEN-END:variables
}
