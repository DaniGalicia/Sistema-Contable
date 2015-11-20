/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Vistas;

import SIC.Vistas.tableModels.UsuariosTableModel;
import SIC.Entidades.Empleado;
import SIC.Entidades.Usuario;
import SIC.Service.SICService;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author dannier
 */
public class Usuarios extends javax.swing.JFrame {

    Empleado empleadoSelected;
    Usuario usuarioSelected;
    UsuariosTableModel usuarioTableModel = new UsuariosTableModel();

    /**
     * Creates new form Usuario
     */
    public Usuarios() {
        initComponents();
        inicializarColumnas();
        cargarDatos();
    }

    public void cargarDatos() {
        usuarioTableModel.usuarios.clear();
        usuarioTableModel.usuarios = SICService.getServUsuario().getListado();
        tablaUsuarios.repaint();
    }

    public void inicializarColumnas() {
        TableColumnModel tColumnModel = new DefaultTableColumnModel();
        for (int i = 0; i < 3; i++) {
            TableColumn col = new TableColumn(i);
            switch (i) {
                case 0:
                    col.setHeaderValue("Codigo empleado");
                    break;
                case 1:
                    col.setHeaderValue("Usuario");
                    break;
                case 2:
                    col.setHeaderValue("Contraseña");
                    break;
            }
            tColumnModel.addColumn(col);
        }
        tablaUsuarios.setColumnModel(tColumnModel);
    }

    private void actualizarTextos(boolean llenar) {
        if (llenar) {
            nombreEmpleado.setText(empleadoSelected.getNombres() + " " + empleadoSelected.getApellidos());
            clave.setText(usuarioSelected.getClave());
            usuario.setText(usuarioSelected.getUsuario());
        } else {
            nombreEmpleado.setText("");
            clave.setText("");
            usuario.setText("");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        codigoEmpleado = new javax.swing.JTextField();
        nombreEmpleado = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        clave = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Codigo Empleado");

        jLabel2.setText("Usuario");

        jLabel3.setText("Clave");

        codigoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoEmpleadoActionPerformed(evt);
            }
        });

        tablaUsuarios.setModel(usuarioTableModel);
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(codigoEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(usuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(43, 43, 43)
                        .addComponent(jButton3)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(nombreEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codigoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoEmpleadoActionPerformed
        // TODO add your handling code here:
        usuarioSelected = SICService.getServUsuario().getUsuarioByCodigoEmpleado(codigoEmpleado.getText());
        ///Si ya existe se prepara para editarlo
        if (usuarioSelected != null) {
            empleadoSelected = usuarioSelected.getEmpleado();
            codigoEmpleado.setEnabled(false);
            usuario.setEnabled(true);
            clave.setEnabled(true);
            actualizarTextos(true);
        } else {//Sino existe se prepara para agregarlo
            actualizarTextos(false);
            empleadoSelected = SICService.getServEmpleado().getEmpleadoByCodigo(codigoEmpleado.getText());
            if (empleadoSelected != null) {
                nombreEmpleado.setText(empleadoSelected.getNombres() + " " + empleadoSelected.getApellidos());
                usuario.setEnabled(true);
                clave.setEnabled(true);
            } else {
                nombreEmpleado.setText("Empleado no encontrado");
                usuario.setEnabled(false);
                clave.setEnabled(false);
            }
        }
    }//GEN-LAST:event_codigoEmpleadoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (usuarioSelected != null) {
            SICService.getServUsuario().eliminar(usuarioSelected);
            JOptionPane.showMessageDialog(null, "Eliminado con éxito");
            actualizarTextos(false);
            cargarDatos();
            codigoEmpleado.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "No hay usuario seleccionado");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked
        // TODO add your handling code here:
        int clics = evt.getClickCount();

        if (clics == 2 && tablaUsuarios.getSelectedRow() != -1) {
            usuarioSelected = usuarioTableModel.usuarios.get(tablaUsuarios.getSelectedRow());

            empleadoSelected = usuarioSelected.getEmpleado();
            codigoEmpleado.setText(empleadoSelected.getCodigoEmpleado());
            codigoEmpleado.setEnabled(false);
            actualizarTextos(true);
        }
    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        if (empleadoSelected == null || usuario.getText().isEmpty() || clave.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor complete los datos");
        } else {
            Usuario addUsuario;
            if (codigoEmpleado.isEnabled()) {
                addUsuario = new Usuario(empleadoSelected.getCodigoEmpleado());
            } else {
                addUsuario = usuarioSelected;
            }
 
            addUsuario.setUsuario(usuario.getText());
            addUsuario.setClave(clave.getText());
            SICService.getServUsuario().guardar(addUsuario);
            actualizarTextos(false);
            JOptionPane.showMessageDialog(null, "Datos guardados");
        }
        cargarDatos();
        codigoEmpleado.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField clave;
    private javax.swing.JTextField codigoEmpleado;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombreEmpleado;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
