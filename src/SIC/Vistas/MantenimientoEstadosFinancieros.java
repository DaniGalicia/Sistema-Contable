/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Vistas;

import SIC.Service.Comunes;
import SIC.Entidades.CuentaSaldada;
import SIC.Entidades.EstadoFinanciero;
import SIC.Entidades.EstadoFinancieroPK;
import SIC.Entidades.TipoEstadoFinanciero;
import SIC.Service.SICService;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP TouchSmart
 */
public class MantenimientoEstadosFinancieros extends javax.swing.JDialog {

    List<CuentaSaldada> cuentasSaldadas=new ArrayList<>();

    public MantenimientoEstadosFinancieros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tiposEstadoFinanciero.setModel(Comunes.crearModeloComboBox(SICService.getServTipoEstadoFinanciero().getListado()));
this.rootPane.setContentPane(new Inicio());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCuentasEF = new javax.swing.JTable();
        tiposEstadoFinanciero = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        botonGenerar = new javax.swing.JButton();
        total = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estados finacieros");
        setModal(true);

        tablaCuentasEF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cuenta", "Debe", "Haber"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCuentasEF.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaCuentasEF);
        if (tablaCuentasEF.getColumnModel().getColumnCount() > 0) {
            tablaCuentasEF.getColumnModel().getColumn(0).setResizable(false);
            tablaCuentasEF.getColumnModel().getColumn(1).setResizable(false);
            tablaCuentasEF.getColumnModel().getColumn(2).setResizable(false);
        }

        tiposEstadoFinanciero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Estado");

        botonGenerar.setText("Generar");
        botonGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarActionPerformed(evt);
            }
        });

        total.setText("Total:");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel2)
                                .addGap(12, 12, 12)
                                .addComponent(tiposEstadoFinanciero, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(botonGenerar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addComponent(total)))
                        .addGap(0, 439, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addComponent(tiposEstadoFinanciero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonGenerar)
                        .addComponent(jButton1)))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(total))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarActionPerformed
        // TODO add your handling code here:
        cuentasSaldadas.clear();
        TipoEstadoFinanciero tipoEstadoFinancieroSelected = (TipoEstadoFinanciero) tiposEstadoFinanciero.getSelectedItem();
        if (tipoEstadoFinancieroSelected.getIdTipoEstadoFinanciero().equals("EC")) {
            EstadoFinanciero estadoResultados = SICService.getServEstadoFinanciero().getEstadoFinacieroPeriodoActivo();
            if (estadoResultados != null) {
                cuentasSaldadas = SICService.getServCuentaSaldada().findByTipoCuenta("K");
                cargarDatos(new Object[]{"Reinversion(50% utilidad)",estadoResultados.getSaldo()*0.5,""});
                
            } else {
                JOptionPane.showMessageDialog(null, "Falta el estado de resultados", "Generar estado financiero", JOptionPane.ERROR_MESSAGE);
            }

        } else if (tipoEstadoFinancieroSelected.getIdTipoEstadoFinanciero().equals("ER")) {
            cuentasSaldadas = SICService.getServCuentaSaldada().findByTipoCuenta("R");
        } else if (tipoEstadoFinancieroSelected.getIdTipoEstadoFinanciero().equals("BG")) {
            cuentasSaldadas = SICService.getServCuentaSaldada().findByTipoCuenta("A");
            cuentasSaldadas.addAll(SICService.getServCuentaSaldada().findByTipoCuenta("P"));

            //Balance comprobacion
        } else if (tipoEstadoFinancieroSelected.getIdTipoEstadoFinanciero().equals("BC")) {
            cuentasSaldadas = SICService.getServCuentaSaldada().getListado();
            cuentasSaldadas.removeIf(cs -> cs.getCuenta().getTipoCuenta().getIdTipoCuenta().equals("R"));
        }


        double t = 0;
        for (CuentaSaldada cuentaSaldada : cuentasSaldadas) {
            t += cuentaSaldada.getSaldo();
        }

        if (t > 0) {
            total.setText("Saldo deudor: " + t);
        } else {
            t = -t;
            total.setText("Saldo acreedor: " + t);
        }
        
        if(tipoEstadoFinancieroSelected.getIdTipoEstadoFinanciero().equals("BC") && t!=0)
            JOptionPane.showMessageDialog(null, "Datos inconsistentes","Balance comprobacion",JOptionPane.ERROR_MESSAGE);
            
        
        //cargarDatos(null);
    }//GEN-LAST:event_botonGenerarActionPerformed

    @SuppressWarnings("empty-statement")
    private void cargarDatos(Object[] valor) {

        DefaultTableModel defaultTableModel = (DefaultTableModel) tablaCuentasEF.getModel();
        if (valor == null) {
            while(defaultTableModel.getRowCount()>0)
                defaultTableModel.removeRow(0);
            
            for (CuentaSaldada cuenta : cuentasSaldadas) {
                Double saldo = cuenta.getSaldo();
                String debe = "", haber = "";
                if (saldo < 0) {
                    saldo = -saldo;
                    haber = saldo.toString();
                } else {
                    debe = saldo.toString();
                }

                defaultTableModel.addRow(new Object[]{cuenta.getCuenta().getNombre(), debe, haber});

            }
            tablaCuentasEF.setModel(defaultTableModel);
        }else{
            defaultTableModel.addRow(valor);
        }

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        EstadoFinanciero estadoFinanciero = new EstadoFinanciero();
        estadoFinanciero.setTipoEstadoFinanciero((TipoEstadoFinanciero) tiposEstadoFinanciero.getSelectedItem());
        double t = 0;
        for (CuentaSaldada cuentaSaldada : cuentasSaldadas) {
            t += cuentaSaldada.getSaldo();
        }
        estadoFinanciero.setSaldo(t);

        EstadoFinancieroPK estadoFinancieroPK = new EstadoFinancieroPK(BigInteger.valueOf(12), BigInteger.ONE);
        estadoFinanciero.setEstadoFinancieroPK(estadoFinancieroPK);
        SICService.getServCargo().guardar(estadoFinanciero);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGenerar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCuentasEF;
    private javax.swing.JComboBox<String> tiposEstadoFinanciero;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
