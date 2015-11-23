/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Vistas;

import SIC.Vistas.tableModels.MovimientosTableModel;
import SIC.Entidades.Cuenta;
import SIC.Entidades.CuentaSaldada;
import SIC.Entidades.Movimiento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import SIC.Service.SICService;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author Escobar
 */
public class IngresoCuenta extends javax.swing.JFrame {

    public MovimientosTableModel modeloTabla = new MovimientosTableModel();
    List<Cuenta> cuentas = SICService.getServCuenta().getListado();
    DefaultComboBoxModel combo = new DefaultComboBoxModel();
    List<Cuenta> cuentasNuevas = new ArrayList<>();

    public IngresoCuenta() {
        this.getContentPane().setBackground(new java.awt.Color(102, 177, 255));
        initComponents();
        jTable1.setColumnModel(Comunes.crearModeloColumnas("Cuenta,Tipo,Monto"));
        this.setLocationRelativeTo(null);
        comboListaCuentas.setModel(Comunes.crearModeloComboBox(cuentas));
    }

    private void cargarListaCuentas() {
        combo = new DefaultComboBoxModel();

        for (Cuenta cuenta : cuentas) {
            combo.addElement(cuenta);

        }
        comboListaCuentas.setModel(combo);

    }

  /*  private void inicializarColumnas() {
        TableColumnModel tColumnModel = new DefaultTableColumnModel();
        for (int i = 0; i < 3; i++) {
            TableColumn col = new TableColumn(i);
            switch (i) {
                case 0:
                    col.setHeaderValue("Nombre de la cuenta");
                    break;
                case 1:
                    col.setHeaderValue("Tipo de transacción");
                    break;
                case 2:
                    col.setHeaderValue("Monto");
                    break;
            }
            tColumnModel.addColumn(col);
        }
        jTable1.setColumnModel(tColumnModel);
    }*/

    public boolean isAdded(Cuenta cuenta) {
        for (Movimiento movimiento : modeloTabla.movimientos) {
            if (movimiento.getCuenta().equals(cuenta)) {
                return true;
            }
        }
        return false;
    }

    public boolean total() {
        double resultado = 0;
        for (Movimiento movimiento : modeloTabla.movimientos) {
            if (movimiento.getTipo() == "D") {
                resultado += movimiento.getCantidad();
            } else {
                resultado -= movimiento.getCantidad();
            }
        }
        if (resultado == 0) {
            return true;
        }

        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoMovimiento = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        comboListaCuentas = new javax.swing.JComboBox();
        montoMovimiento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nuevaCuenta = new javax.swing.JCheckBox();
        aplicaIva = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        fecha = new javax.swing.JFormattedTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de transacciones");
        setAutoRequestFocus(false);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingreso de datos"));

        comboListaCuentas.setEditable(true);
        comboListaCuentas.setMaximumSize(new java.awt.Dimension(28, 20));
        comboListaCuentas.setName(""); // NOI18N
        comboListaCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboListaCuentasActionPerformed(evt);
            }
        });

        montoMovimiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        montoMovimiento.setToolTipText("");
        montoMovimiento.setMaximumSize(new java.awt.Dimension(7, 70));
        montoMovimiento.setMinimumSize(new java.awt.Dimension(7, 70));
        montoMovimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                montoMovimientoFocusGained(evt);
            }
        });
        montoMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                montoMovimientoActionPerformed(evt);
            }
        });

        jLabel2.setText("Fecha");

        tipoMovimiento.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Cargar");
        jRadioButton1.setToolTipText("Cargar");
        jRadioButton1.setActionCommand("D");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        tipoMovimiento.add(jRadioButton2);
        jRadioButton2.setText("Abonar");
        jRadioButton2.setActionCommand("H");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Monto");

        jLabel4.setText("ACCION");

        nuevaCuenta.setText("NC");
        nuevaCuenta.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nuevaCuentaStateChanged(evt);
            }
        });
        nuevaCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaCuentaActionPerformed(evt);
            }
        });

        aplicaIva.setText("IVA");

        jLabel6.setText("Cuenta");

        fecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167)
                        .addComponent(jLabel4)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jRadioButton1))
                        .addGap(7, 7, 7)
                        .addComponent(jRadioButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12)
                        .addComponent(comboListaCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204)
                        .addComponent(nuevaCuenta)
                        .addGap(12, 12, 12)
                        .addComponent(aplicaIva))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(montoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2))
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jRadioButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jRadioButton2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel6))
                    .addComponent(comboListaCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(nuevaCuenta))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(aplicaIva)))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3))
                    .addComponent(montoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButton2.setText("Saldar cuentas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Guardar transaccion");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        botonEliminar.setText("Eliminar seleccionada");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Estados financieros");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cuentas afectadas por la transaccion"));

        jTable1.setModel(modeloTabla);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(botonEliminar))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(botonEliminar))
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton2)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!validarFecha()) {
            JOptionPane.showMessageDialog(null, "La fecha debe ser en el formato dd/mm/yyyy");
            return;
        }
        if (!validarMonto()) {
            JOptionPane.showMessageDialog(null, "El monto no es correcto");
            return;
        }
        if (!isAdded((Cuenta) comboListaCuentas.getSelectedItem())) {
            Movimiento movimiento = new Movimiento();
            //Obtiene el tipo de movimiento
            Double cantidad = Double.parseDouble(montoMovimiento.getText());
            if (aplicaIva.isSelected()) {
                cantidad = cantidad + 0.13 * cantidad;
            }
            movimiento.setFecha(new Date(fecha.getText()));
            movimiento.setCantidad(cantidad);
            movimiento.setTipo(tipoMovimiento.getSelection().getActionCommand());
            movimiento.setCuenta((Cuenta) comboListaCuentas.getSelectedItem());
            modeloTabla.movimientos.add(movimiento);
            modeloTabla.fireTableDataChanged();
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        for (Cuenta cuenta : SICService.getServCuenta().getListado()) {
            if (cuenta.getMovimientoList().isEmpty()) {
                continue;
            }

            double saldo = 0;
            for (Movimiento movimiento : cuenta.getMovimientoList()) {
                if (movimiento.getTipo().equals("D")) {
                    saldo += movimiento.getCantidad();
                } else {
                    saldo -= movimiento.getCantidad();
                }
            }
//Almacena las cuentas
            if (saldo != 0) {
                CuentaSaldada cuentaSaldada = new CuentaSaldada();
                cuentaSaldada.setCuenta(cuenta);
                cuentaSaldada.setPeriodo(SICService.getServPeriodo().getActivo());
                cuentaSaldada.setSaldo(saldo);
                SICService.getServCuentaSaldada().guardar(cuentaSaldada);
            }

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (total()) {

            for (Movimiento mNuevo : modeloTabla.movimientos) {
                SICService.getServMovimiento().guardar(mNuevo);
            }

            JOptionPane.showMessageDialog(null, "Transaccion exitosa");
            modeloTabla.movimientos.clear();
        } else {
            JOptionPane.showMessageDialog(null, "No se puedes guardar", "Registrar transaccion", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private boolean validarMonto() {
        //valida si esta vacio
        if (montoMovimiento.getText().isEmpty()) {
            return false;
        }

        Double monto = 0.0;

        //Valida si es un numero, si lo es lo asigna a monto
        try {
            monto = Double.parseDouble(montoMovimiento.getText());
        } catch (Exception e) {
            return false;
        }

        //Valida si no es mayor que cero retorna falso
        if (monto < 0) {
            return false;
        }

        //Paso todas las restricciones, retorna true
        return true;
    }

    private boolean validarFecha() {
        //valida si esta vacio
        if (fecha.getText().isEmpty()) {
            return false;
        }
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha.getText());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int clicks = evt.getClickCount();
        int row = jTable1.rowAtPoint(evt.getPoint());

        if (clicks == 2) {
            Movimiento movimiento = modeloTabla.movimientos.get(row);
            String tipo = (new StringBuffer().append(movimiento.getTipo())).toString();

            if ("D".equals(tipo)) {
                jRadioButton1.setSelected(true);
            } else {
                jRadioButton2.setSelected(true);
            }

            montoMovimiento.setText(String.valueOf(movimiento.getCantidad()));
            comboListaCuentas.setSelectedItem(movimiento.getCuenta());
            comboListaCuentas.setEnabled(false);

        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        int filaSelec = jTable1.getSelectedRow();
        if (filaSelec == -1 || jTable1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Error no hay fila seleccionada");
        } else {
            modeloTabla.movimientos.remove(filaSelec);
        }
        jTable1.repaint();
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //MantenimientoEstadosFinancieros mantenimientoEstadosFinancieros = new MantenimientoEstadosFinancieros();
        //mantenimientoEstadosFinancieros.setVisible(true);
        new MantenimientoEstadosFinancieros(this, true).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void nuevaCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaCuentaActionPerformed

    }//GEN-LAST:event_nuevaCuentaActionPerformed

    private void nuevaCuentaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nuevaCuentaStateChanged

    }//GEN-LAST:event_nuevaCuentaStateChanged

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void montoMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_montoMovimientoActionPerformed

    }//GEN-LAST:event_montoMovimientoActionPerformed

    private void montoMovimientoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_montoMovimientoFocusGained

    }//GEN-LAST:event_montoMovimientoFocusGained

    private void comboListaCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboListaCuentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboListaCuentasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IngresoCuenta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresoCuenta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresoCuenta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresoCuenta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresoCuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox aplicaIva;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JComboBox comboListaCuentas;
    private javax.swing.JFormattedTextField fecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField montoMovimiento;
    private javax.swing.JCheckBox nuevaCuenta;
    private javax.swing.ButtonGroup tipoMovimiento;
    // End of variables declaration//GEN-END:variables
}
