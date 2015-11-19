/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Vistas;

import SIC.Entidades.Cuenta;
import SIC.Entidades.Movimiento;
import SIC.Service.SICService;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author charly
 */
public class RegistroAjustes extends javax.swing.JFrame {

    public MovimientosTableModel modeloTabla = new MovimientosTableModel();
    List<Cuenta> cuentas = SICService.getServCuenta().getListado();
    DefaultComboBoxModel comboAjustes = new DefaultComboBoxModel();

    public RegistroAjustes() {
        this.getContentPane().setBackground(new java.awt.Color(102, 177, 255));
        initComponents();
        inicializarColumnas();
        this.setLocationRelativeTo(null);
        NombreCuentaNueva.setVisible(false);
        Tipo.setVisible(false);
        cargarListaCuentas();
    }

    private void cargarListaCuentas() {
        comboAjustes = new DefaultComboBoxModel();

        for (Cuenta cuenta : cuentas) {
            comboAjustes.addElement(cuenta);
        }
        ComboListaCuentas.setModel(comboAjustes);
    }

    private void inicializarColumnas() {
        TableColumnModel tColumnModel = new DefaultTableColumnModel();
        for (int i = 0; i < 3; i++) {
            TableColumn col = new TableColumn(i);
            switch (i) {
                case 0:
                    col.setHeaderValue("Nombre de la cuenta");
                    break;
                case 1:
                    col.setHeaderValue("Tipo de Ajuste");
                    break;
                case 2:
                    col.setHeaderValue("Monto");
                    break;
            }
            tColumnModel.addColumn(col);
        }
        TablaAjustes.setColumnModel(tColumnModel);

    }
     public boolean isAdded(Cuenta cuenta) {
        for (Movimiento movimiento : modeloTabla.movimientos) {
            if (movimiento.getCuenta().equals(cuenta)) {
                return true;
            }
        }
        return false;
    }
     public boolean totalAjustes() {
        double resultadoAjustes = 0;
        for (Movimiento movimiento : modeloTabla.movimientos) {
            if (movimiento.getTipo() == "D") {
                resultadoAjustes += movimiento.getCantidad();
            } else {
                resultadoAjustes -= movimiento.getCantidad();
            }
        }
        if (resultadoAjustes == 0) {
            return true;
        } else {
            return false;
        }
    }
    private boolean validarMontoDeAjuste() {
        //valida si esta vacio
        if (MontoAjuste.getText().isEmpty()) {
            return false;
        }

        Double montoAjuste = 0.0;

        //Valida si es un numero, si lo es lo asigna a monto
        try {
            montoAjuste = Double.parseDouble(MontoAjuste.getText());
        } catch (Exception e) {
            return false;
        }

        //Valida si no es mayor que cero retorna falso
        if (montoAjuste < 0) {
            return false;
        }

        //Paso todas las restricciones, retorna true
        return true;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaAjustes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ComboListaCuentas = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        Tipo = new javax.swing.JComboBox();
        MontoAjuste = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        BotonAgregarAjuste = new javax.swing.JButton();
        NombreCuentaNueva = new javax.swing.JTextField();
        NuevaCuenta = new javax.swing.JCheckBox();
        AplicaIva = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        BotonGuardar = new javax.swing.JButton();
        BotonSalir = new javax.swing.JButton();
        BotonEliminar = new javax.swing.JButton();

        jRadioButton2.setText("jRadioButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO DE AJUSTES ");

        TablaAjustes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaAjustesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaAjustes);

        jLabel3.setText("MONTO ");

        jLabel4.setText("ACCION");

        ComboListaCuentas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("SELECCIONAR CUENTA A AJUSTAR");

        Tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoActionPerformed(evt);
            }
        });

        MontoAjuste.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MontoAjuste.setText("Monto");

        jRadioButton1.setText("Cargar");

        jRadioButton3.setText("Abonar");

        BotonAgregarAjuste.setText("Agregar Ajuste");
        BotonAgregarAjuste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarAjusteActionPerformed(evt);
            }
        });

        NombreCuentaNueva.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NombreCuentaNueva.setText("Nueva Cuenta");

        NuevaCuenta.setText("NC");
        NuevaCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevaCuentaActionPerformed(evt);
            }
        });

        AplicaIva.setText("IVA");
        AplicaIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AplicaIvaActionPerformed(evt);
            }
        });

        jLabel5.setText("Fecha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(ComboListaCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NombreCuentaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NuevaCuenta)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(AplicaIva)
                                        .addGap(108, 108, 108)
                                        .addComponent(MontoAjuste, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(BotonAgregarAjuste))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jRadioButton1)
                                        .addGap(10, 10, 10)
                                        .addComponent(jRadioButton3)))
                                .addGap(66, 66, 66))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(110, 110, 110))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboListaCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MontoAjuste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton3)
                    .addComponent(NuevaCuenta)
                    .addComponent(AplicaIva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonAgregarAjuste)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NombreCuentaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        BotonGuardar.setText("Guardar");
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });

        BotonSalir.setText("Salir");
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });

        BotonEliminar.setText("Eliminar");
        BotonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(BotonGuardar)
                        .addGap(60, 60, 60)
                        .addComponent(BotonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(BotonEliminar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(145, 145, 145))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonGuardar)
                    .addComponent(BotonSalir)
                    .addComponent(BotonEliminar))
                .addContainerGap(140, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoActionPerformed

    private void AplicaIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AplicaIvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AplicaIvaActionPerformed

    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed
        // TODO add your handling code here:
         if (totalAjustes()) {
            
            for(Movimiento ajusteNuevo:modeloTabla.movimientos)
            {   
                SICService.getServMovimiento().guardar(ajusteNuevo);
            }
            
            JOptionPane.showMessageDialog(null, "Transaccion exitosa");
            modeloTabla.movimientos.clear();
        } else {
            JOptionPane.showMessageDialog(null, "NO IGUALES");
        }
    }//GEN-LAST:event_BotonGuardarActionPerformed

    private void BotonAgregarAjusteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarAjusteActionPerformed
        // TODO add your handling code here:
        if (!validarMontoDeAjuste()) {
            JOptionPane.showMessageDialog(null, "El monto del Ajuste no es correcto");
            return;
        }
        //Obtiene el tipo de movimiento
        String tipo;
        if (jRadioButton1.isSelected()) {
            tipo = "D";
        } else {
            tipo = "H";
        }
        //Obtiene el monto
        Double cantidad = Double.parseDouble(MontoAjuste.getText());
        if (AplicaIva.isSelected()) {
            cantidad = cantidad + 0.13 * cantidad;
        }

        Movimiento movimiento = new Movimiento();
        movimiento.setFecha(new Date(fecha.getText()));
        movimiento.setCantidad(cantidad);
        movimiento.setTipo(tipo);
        Cuenta cuenta=new Cuenta();
        //Sino existe la crea
        if (NuevaCuenta.isSelected()) {
            String var = Tipo.getSelectedItem().toString();
            cuenta.setNombre(NombreCuentaNueva.getText());
            cuenta.setTipo(var);
            cuenta.getMovimientoList().add(movimiento);
            
            comboAjustes.addElement(cuenta);
            ComboListaCuentas.setVisible(true);
            NombreCuentaNueva.setVisible(false);
            Tipo.setVisible(false);
            NuevaCuenta.setSelected(false);
        } else {
            cuenta = (Cuenta) ComboListaCuentas.getSelectedItem();
        }
        
        movimiento.setCuenta(cuenta);
        
        if (ComboListaCuentas.isEnabled()) {
            if (isAdded(cuenta)) {
                JOptionPane.showMessageDialog(null, "YA EXISTE ESA CUENTA");
                return;
            }
            modeloTabla.movimientos.add(movimiento);
        } else {
            for (Movimiento mov : modeloTabla.movimientos) {
                if (mov.getCuenta().equals((Cuenta) ComboListaCuentas.getSelectedItem())) {
                    movimiento=mov;
                    break;
                }
            }
            ComboListaCuentas.setEnabled(true);
        }

        modeloTabla.fireTableDataChanged();
    }//GEN-LAST:event_BotonAgregarAjusteActionPerformed

    private void NuevaCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevaCuentaActionPerformed
        // TODO add your handling code here:
         if (NuevaCuenta.isSelected()) {
            ComboListaCuentas.setVisible(false);
            NombreCuentaNueva.setVisible(true);
            Tipo.setVisible(true);
        } else {
            ComboListaCuentas.setVisible(true);
            NombreCuentaNueva.setVisible(false);
            Tipo.setVisible(false);
        }
    }//GEN-LAST:event_NuevaCuentaActionPerformed

    private void TablaAjustesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaAjustesMouseClicked
        // TODO add your handling code here:
        int clicks = evt.getClickCount();
        int row = TablaAjustes.rowAtPoint(evt.getPoint());

        if (clicks == 2) {
            Movimiento movimiento = modeloTabla.movimientos.get(row);
            String tipo = (new StringBuffer().append(movimiento.getTipo())).toString();

            if ("D".equals(tipo)) {
                jRadioButton1.setSelected(true);
            } else {
                jRadioButton2.setSelected(true);
            }

            MontoAjuste.setText(String.valueOf(movimiento.getCantidad()));
            ComboListaCuentas.setSelectedItem(movimiento.getCuenta());
            ComboListaCuentas.setEnabled(false);

        }
    }//GEN-LAST:event_TablaAjustesMouseClicked

    private void BotonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarActionPerformed
        // TODO add your handling code here:
        int filaSelec = TablaAjustes.getSelectedRow();
        if (filaSelec == -1 || TablaAjustes.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Error no hay fila seleccionada");
        } else {
            modeloTabla.movimientos.remove(filaSelec);
        }
        TablaAjustes.repaint();
    }//GEN-LAST:event_BotonEliminarActionPerformed

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
        // TODO add your handling code here:
        System.exit(WIDTH);
    }//GEN-LAST:event_BotonSalirActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroAjustes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroAjustes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroAjustes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroAjustes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroAjustes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox AplicaIva;
    private javax.swing.JButton BotonAgregarAjuste;
    private javax.swing.JButton BotonEliminar;
    private javax.swing.JButton BotonGuardar;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JComboBox ComboListaCuentas;
    private javax.swing.JTextField MontoAjuste;
    private javax.swing.JTextField NombreCuentaNueva;
    private javax.swing.JCheckBox NuevaCuenta;
    private javax.swing.JTable TablaAjustes;
    private javax.swing.JComboBox Tipo;
    private javax.swing.JTextField fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
