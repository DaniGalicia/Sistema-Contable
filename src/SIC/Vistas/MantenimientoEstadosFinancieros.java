/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Vistas;

import Reportes.GenericReporte;
import SIC.Entidades.Cuenta;
import SIC.Service.Comunes;
import SIC.Entidades.CuentaSaldada;
import SIC.Entidades.EstadoFinanciero;
import SIC.Entidades.TipoCuenta;
import SIC.Entidades.TipoEstadoFinanciero;
import SIC.Service.SICService;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP TouchSmart
 */
public class MantenimientoEstadosFinancieros extends javax.swing.JDialog {

    List<CuentaSaldada> cuentasSaldadas = new ArrayList<>();
    private boolean guarda=false;

    public MantenimientoEstadosFinancieros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tiposEstadoFinanciero.setModel(Comunes.crearModeloComboBox(SICService.getServTipoEstadoFinanciero().getListado(TipoEstadoFinanciero.class)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCuentasEF = new javax.swing.JTable();
        tiposEstadoFinanciero = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        botonGenerar = new javax.swing.JButton();
        total = new javax.swing.JLabel();
        exportarPdf = new javax.swing.JButton();

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

        exportarPdf.setText("Exportar a pdf");
        exportarPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tiposEstadoFinanciero, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonGenerar)
                .addGap(43, 43, 43)
                .addComponent(exportarPdf)
                .addGap(166, 166, 166))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(total)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(exportarPdf)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(total)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private double verificarDualidad() {
        double saldo = 0;
        for (CuentaSaldada cuentaSaldada : cuentasSaldadas) {
            saldo += cuentaSaldada.getSaldo();
        }

        return saldo;
    }

    private void prepararBalanceGeneral() {

        cuentasSaldadas = SICService.getServCuentaSaldada().findByTiposCuenta("A,P");
        EstadoFinanciero estadoCapital = SICService.getServEstadoFinanciero().getEstadoFinacieroPeriodoActivo("EC");
        EstadoFinanciero estadoResultados = SICService.getServEstadoFinanciero().getEstadoFinacieroPeriodoActivo("ER");

        if (estadoResultados != null && estadoCapital!=null) {
            Cuenta utilidad = (Cuenta) SICService.getServCuenta().getByPK(Cuenta.class, "3104");
            utilidad.setNombre("Revinversion (50%) utilidad");
            CuentaSaldada cs = new CuentaSaldada();
            cs.setCuenta(utilidad);
            cs.setPeriodo(SICService.getServPeriodo().getActivo());

            //Si el resultado es ganancia entonces se reinvierte el 50%
            //sino se agrega como una desinversion
            if (estadoResultados.getSaldo() > 0) {
                cs.setSaldo(estadoResultados.getSaldo() * 0.5);
            } else {
                cs.setSaldo(estadoResultados.getSaldo());
            }
            cuentasSaldadas.add(cs);
            
            CuentaSaldada cc=new CuentaSaldada();
            Cuenta c=new Cuenta("0101", "Capital contable");
            c.setTipoCuenta((TipoCuenta) SICService.getServTipoCuenta().getByPK(TipoCuenta.class,"K"));
           cc.setCuenta(c);
           cc.setSaldo(estadoCapital.getSaldo());
           cuentasSaldadas.add(cc);

        } else {
            JOptionPane.showMessageDialog(this, "Aun no ha generado estados financieros", "Generar estado financiero", JOptionPane.ERROR_MESSAGE);
            guarda=false;
        }

    }

    private double calcularSaldo(){
        double ret=0;
        for(CuentaSaldada cuentaSaldada:cuentasSaldadas){
            if(cuentaSaldada.getSaldo() > 0)
                ret+=cuentaSaldada.getSaldo();
        
        }
        return  ret;
    }
    private void botonGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarActionPerformed

        guarda=true;
        cuentasSaldadas.clear();
        TipoEstadoFinanciero tipoEstadoFinancieroSelected = (TipoEstadoFinanciero) tiposEstadoFinanciero.getSelectedItem();

        if (tipoEstadoFinancieroSelected.getIdTipoEstadoFinanciero().equals("EC")) {
            prepareEstadoCapital();
        } else if (tipoEstadoFinancieroSelected.getIdTipoEstadoFinanciero().equals("ER")) {
            cuentasSaldadas = SICService.getServCuentaSaldada().findByTipoCuenta("R");  
        } else if (tipoEstadoFinancieroSelected.getIdTipoEstadoFinanciero().equals("BG")) {
            prepararBalanceGeneral();
            //Balance comprobacion, todas las cuentas
        } else if (tipoEstadoFinancieroSelected.getIdTipoEstadoFinanciero().equals("BC")) {
            cuentasSaldadas = SICService.getServCuentaSaldada().getListado(CuentaSaldada.class);
        }

        double t = verificarDualidad();
        if (t > 0) {
            total.setText("Saldo deudor: " + t);
        } else {
            t = -t;
            total.setText("Saldo acreedor: " + t);
        }

        if (tipoEstadoFinancieroSelected.getIdTipoEstadoFinanciero().equals("BC") && t != 0) {
            JOptionPane.showMessageDialog(null, "Datos inconsistentes", "Balance comprobacion", JOptionPane.ERROR_MESSAGE);
            guarda=false;
        }
        if (SICService.getServEstadoFinanciero().getEstadoFinacieroPeriodoActivo(tipoEstadoFinancieroSelected.getIdTipoEstadoFinanciero()) == null && guarda==true) {
           
            EstadoFinanciero estadoFinanciero = new EstadoFinanciero();
            estadoFinanciero.setPeriodo(SICService.getServPeriodo().getActivo());
            estadoFinanciero.setTipoEstadoFinanciero(tipoEstadoFinancieroSelected);
            
            if(tipoEstadoFinancieroSelected.getIdTipoEstadoFinanciero().equals("EC"))
                estadoFinanciero.setSaldo(verificarDualidad());
            else
                estadoFinanciero.setSaldo(verificarDualidad());
                
            JOptionPane.showMessageDialog(rootPane, estadoFinanciero.getSaldo());
            SICService.getServEstadoFinanciero().guardar(estadoFinanciero);
        }
        insertarDato();
    }//GEN-LAST:event_botonGenerarActionPerformed

    /* Recibe el objeto que se insertará 
       si recibe null insertará una lista 
     */
    private void insertarDato() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tablaCuentasEF.getModel();
        while (defaultTableModel.getRowCount() > 0) {
            defaultTableModel.removeRow(0);
        }

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
    }

    private void exportarPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarPdfActionPerformed
        // TODO add your handling code here:

        String tipo = ((TipoEstadoFinanciero) tiposEstadoFinanciero.getSelectedItem()).getIdTipoEstadoFinanciero();
        GenericReporte reporte = null;
        if (tipo.equals("BC")) {
            reporte = new GenericReporte("BalanceComprobacion");
            reporte.getMapa().put("periodo", SICService.getServPeriodo().getActivo());
            reporte.getMapa().put("nombreEstadoFinanciero", "Balance comprobacion");
        } else if (tipo.equals("BG")) {
            reporte = new GenericReporte("BalanceGeneral");
            reporte.getMapa().put("periodo", SICService.getServPeriodo().getActivo());
            reporte.getMapa().put("nombreEstadoFinanciero", "Balance comprobacion");
        } else if (tipo.equals("EC")) {
            reporte = new GenericReporte("EstadoCapital");
            reporte.getMapa().put("periodo", SICService.getServPeriodo().getActivo());

        } else if (tipo.equals("ER")) {
            reporte = new GenericReporte("EstadoResultado");
            reporte.getMapa().put("periodo", SICService.getServPeriodo().getActivo());
        }
        reporte.setLista(cuentasSaldadas);
        reporte.generar();
        JOptionPane.showMessageDialog(this, "Archivo generado");
    }//GEN-LAST:event_exportarPdfActionPerformed

    private void prepareEstadoCapital() {
        EstadoFinanciero estadoResultados = SICService.getServEstadoFinanciero().getEstadoFinacieroPeriodoActivo("ER");

        if (estadoResultados != null) {
            cuentasSaldadas = SICService.getServCuentaSaldada().findByTipoCuenta("K");
            Cuenta utilidad = (Cuenta) SICService.getServCuenta().getByPK(Cuenta.class, "3104");
            utilidad.setNombre("Revinversion (50%) utilidad");
            CuentaSaldada cs = new CuentaSaldada();
            cs.setCuenta(utilidad);
            cs.setPeriodo(SICService.getServPeriodo().getActivo());

            //Si el resultado es ganancia entonces se reinvierte el 50%
            //sino se agrega como una desinversion
            if (estadoResultados.getSaldo() > 0) {
                cs.setSaldo(estadoResultados.getSaldo() * 0.5);
            } else {
                cs.setSaldo(estadoResultados.getSaldo());
            }
            cuentasSaldadas.add(cs);

        } else {
            JOptionPane.showMessageDialog(this, "Falta el estado de resultados", "Generar estado financiero", JOptionPane.ERROR_MESSAGE);
            guarda=false;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGenerar;
    private javax.swing.JButton exportarPdf;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCuentasEF;
    private javax.swing.JComboBox<String> tiposEstadoFinanciero;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
