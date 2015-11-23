/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Vistas;

import SIC.Vistas.tableModels.CargosTableModel;
import SIC.Entidades.Cargo;
import SIC.Service.SICService;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.xml.ws.Service;

public class Cargos extends javax.swing.JFrame {

    public CargosTableModel CargoTModel = new CargosTableModel();
    Cargo cargoActual;
    boolean guardar;

    public Cargos() {

        initComponents();
       tablaCargos.setColumnModel(Comunes.crearModeloColumnas("Sueldo, Nombre Cargo"));
        cargarListaCargos();
        this.setLocationRelativeTo(null);

    }

  /*  private void inicializarColumnas() {
        TableColumnModel tColumnModel = new DefaultTableColumnModel();
        for (int i = 0; i < 2; i++) {
            TableColumn col = new TableColumn(i);
            switch (i) {
                case 0:
                    col.setHeaderValue("Sueldo");
                    break;
                case 1:
                    col.setHeaderValue("Nombre Cargo");
                    break;
            }
            tColumnModel.addColumn(col);
        }
        tablaCargos.setColumnModel(tColumnModel);
    }
*/
    private void cargarListaCargos() {
        CargoTModel.cargos.clear();
        CargoTModel.cargos = SICService.getServCargo().getListado();
        tablaCargos.repaint();
    }

    private void actualizarTextos(boolean llenar) {
        if (llenar) {

            nombreTxt.setText(cargoActual.getNombreCargo());
            sueldoTxt.setText(String.valueOf(cargoActual.getSueldo()));

        } else {
            nombreTxt.setText("");
            sueldoTxt.setText("");

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entityManager1 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SistemaContablePU").createEntityManager();
        BtonGuardarCargo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCargos = new javax.swing.JTable();
        BtonEliminarCargo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        sueldoTxt = new javax.swing.JTextField();
        nombreTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrar cargos");

        BtonGuardarCargo.setText("Guardar");
        BtonGuardarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtonGuardarCargoActionPerformed(evt);
            }
        });

        tablaCargos.setModel(CargoTModel);
        tablaCargos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCargosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCargos);

        BtonEliminarCargo.setText("Eliminar");
        BtonEliminarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtonEliminarCargoActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setText("Sueldo:");

        jLabel2.setText("Nombre:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(11, 11, 11)
                        .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(sueldoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(sueldoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(BtonGuardarCargo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BtonEliminarCargo))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtonGuardarCargo)
                    .addComponent(BtonEliminarCargo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtonGuardarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtonGuardarCargoActionPerformed
        // TODO add your handling code here:

        if (nombreTxt.getText().isEmpty() || sueldoTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Datos incorrectos");
        } else {
            
            try {
              String nombre = nombreTxt.getText();
              Float sueldo = Float.parseFloat(sueldoTxt.getText());
                if (sueldo >= 0) {
                    if (cargoActual == null) {
                        cargoActual = new Cargo();
                    }
                }
                cargoActual.setNombreCargo(nombre);
                cargoActual.setSueldo(sueldo);
                actualizarTextos(false);
                JOptionPane.showMessageDialog(null, "Datos guardados");
                

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El dato es incorrecto, ingrese nuevamente");
            }
        }
        SICService.getServCargo().guardar(cargoActual);
        actualizarTextos(false);
        JOptionPane.showMessageDialog(null, "Datos guardados");

        //Independientemente si era actualizacion o nuevo, despues de la operacion se
        //debe dejar como nulo, tambien se debe actualizar la lista
        cargoActual = null;
        cargarListaCargos();
    }//GEN-LAST:event_BtonGuardarCargoActionPerformed

    private void BtonEliminarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtonEliminarCargoActionPerformed
        // TODO add your handling code here:

        if (cargoActual != null) {
            SICService.getServCargo().eliminar(cargoActual);
            JOptionPane.showMessageDialog(null, "Eliminado con éxito");
            actualizarTextos(false);
            cargarListaCargos();
            cargoActual = null;
        } else {
            JOptionPane.showMessageDialog(null, "No hay cargo seleccionado");
        }


    }//GEN-LAST:event_BtonEliminarCargoActionPerformed

    private void tablaCargosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCargosMouseClicked
        // TODO add your handling code here:
        cargoActual = null;
        int clics = evt.getClickCount();
        int row = tablaCargos.rowAtPoint(evt.getPoint());
        if (clics == 2) {
            cargoActual = CargoTModel.cargos.get(row);
            nombreTxt.setText(cargoActual.getNombreCargo());
            sueldoTxt.setText(String.valueOf(cargoActual.getSueldo()));
        }
    }//GEN-LAST:event_tablaCargosMouseClicked

    /**
     * no
     *
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
            java.util.logging.Logger.getLogger(Cargos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cargos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cargos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cargos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cargos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtonEliminarCargo;
    private javax.swing.JButton BtonGuardarCargo;
    private javax.persistence.EntityManager entityManager1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JTextField sueldoTxt;
    private javax.swing.JTable tablaCargos;
    // End of variables declaration//GEN-END:variables
}
