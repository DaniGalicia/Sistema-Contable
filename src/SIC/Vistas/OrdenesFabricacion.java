/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Vistas;

import Reportes.GenericReporte;
import SIC.Entidades.Departamento;
import SIC.Entidades.OrdenFabricacion;
import SIC.Entidades.OrdenFabricacionDetalle;
import SIC.Service.Comunes;
import SIC.Service.SICService;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Escobar
 */
public class OrdenesFabricacion extends javax.swing.JDialog {

    OrdenFabricacion ordenFabricacion;
    OrdenFabricacionDetalle detalleActual;
    List<OrdenFabricacion> ordenes = new ArrayList<>();
    List<OrdenFabricacionDetalle> ordendetalle = new ArrayList<>();

    /**
     * Creates new form OrdenFabricacion
     */
    public OrdenesFabricacion(java.awt.Frame parent, boolean modal) {
        super(parent,modal);
        initComponents();
        this.setLocationRelativeTo(null);
        departamento.setModel(Comunes.crearModeloComboBox(SICService.getServDepartamento().getListado(Departamento.class)));
        cargarOrdenes();
                  
    }

    private void limpiar() {
        for (Object cajasTexto : jPanel3.getComponents()) {
          //Solo funciona en java 8
          /*
            if (cajasTexto.getClass().getTypeName().equals("javax.swing.JTextField")) {
                ((JTextField) cajasTexto).setText("");
            }*/
        }
    }

    private boolean validarFecha(JTextField fecha) {
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

    private boolean validarCantidad(JTextField numero) {
        if (numero.getText().isEmpty()) {
            return false;
        }
        int var = 0;
        try {
            var = Integer.parseInt(numero.getText());
        } catch (Exception e) {
            return false;
        }
        if (var < 0) {
            return false;
        }
        return true;
    }

    private boolean validarMonto(JTextField monto) {
        if (monto.getText().isEmpty()) {
            return false;
        }
        Double numero = 0.0;
        try {
            numero = Double.parseDouble(monto.getText());
        } catch (Exception e) {
            return false;
        }
        if (numero < 0) {
            return false;
        }
        return true;
    }

    private void cargarOrdenes() {
        ordenes = (List<OrdenFabricacion>) SICService.getServOrdenFabricacion().getListado(OrdenFabricacion.class);
        DefaultTableModel defaultTableModel = (DefaultTableModel) tablaOrdenes.getModel();
        DateFormat fechas = new SimpleDateFormat("dd/MM/yyyy");
        while (defaultTableModel.getRowCount() > 0) {
            defaultTableModel.removeRow(0);
        }
        for (OrdenFabricacion ordenfabricacion : ordenes) {
            Date aux = ordenfabricacion.getFechaExpedicion();
            Date aux1 = ordenfabricacion.getFechaEntrega();
            String fecha1 = fechas.format(aux);
            String fecha2 = fechas.format(aux1);
            defaultTableModel.addRow(new Object[]{ordenfabricacion.getIdOrdenFabricacion(),
                fecha1, fecha2});
        }
    }

    private void cargarOrdenDetalle() {
        ordendetalle=ordenFabricacion.getOrdenFabricacionDetalleList();
        DefaultTableModel defaultTableModel =(DefaultTableModel) tablaOrden.getModel();
        /*while (defaultTableModel.getRowCount() > 0) {
            defaultTableModel.removeRow(0);
        }*/
        int rowCount = defaultTableModel.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
        defaultTableModel.removeRow(i);
        }
        for (OrdenFabricacionDetalle ordenfab : ordendetalle) {
            defaultTableModel.addRow(new Object[]{ordenfab.getOrdenFabricacion().getIdOrdenFabricacion(),
                ordenfab.getMaterial(), 
                ordenfab.getCantidadMaterial(),
                ordenfab.getPrecioUnitario(), 
                ordenfab.getTotalMaterial(), ordenfab.getCantidadObreros(),
                ordenfab.getPrecioHora(), ordenfab.getCantidadHoras(),
                ordenfab.getTotalManoObra(), ordenfab.getTasaCif(),
                ordenfab.getImporte()});
            costoTotal.setText(String.format("%.2f", ordenfab.getCostoTotal()));
            costoUnitario.setText(String.format("%.2f", ordenfab.getCostoUnitario(Integer.parseInt(cantidad.getText()))));
    }
    defaultTableModel.fireTableDataChanged();
 }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        expedicion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        departamento = new javax.swing.JComboBox();
        nuevo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        referencia = new javax.swing.JTextField();
        articulo = new javax.swing.JTextField();
        iniciado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        orden = new javax.swing.JTextField();
        fechaCliente = new javax.swing.JTextField();
        cantidad = new javax.swing.JTextField();
        terminado = new javax.swing.JTextField();
        especificacion = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        eliminar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaOrdenes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        costoTotal = new javax.swing.JTextField();
        costoUnitario = new javax.swing.JTextField();
        guardarOrden = new javax.swing.JButton();
        finalizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        cantidadMaterial = new javax.swing.JTextField();
        preciounitario = new javax.swing.JTextField();
        cantidadObreros = new javax.swing.JTextField();
        numHoras = new javax.swing.JTextField();
        precioHoras = new javax.swing.JTextField();
        tasa = new javax.swing.JTextField();
        nuevoDetalle = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        eliminarDetalle = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaOrden = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Orden de fabricacion");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingreso de Datos"));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("FECHA DE EXPEDICIÓN");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, -1));

        expedicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expedicionActionPerformed(evt);
            }
        });
        jPanel6.add(expedicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 160, -1));

        jLabel2.setText("DEPARTAMENTO");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        departamento.setEditable(true);
        departamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel6.add(departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 160, -1));

        nuevo.setText("NUEVO");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jPanel6.add(nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Produccion"));

        jLabel6.setText("REF PEPIDO N°");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("ARTICULO");

        jLabel5.setText("INICIADO");

        jLabel7.setText("N° DE ORDEN");

        jLabel8.setText("FECHA REQUERIDA POR CLIENTE ");

        jLabel12.setText("CANTIDAD");

        jLabel10.setText("TERMINADO");

        jLabel11.setText("ESPECIFICACIONES ");

        orden.setEnabled(false);
        orden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordenActionPerformed(evt);
            }
        });

        cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(articulo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iniciado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(referencia, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(orden, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fechaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(terminado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(especificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addGap(134, 134, 134))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(orden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fechaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel8)
                                            .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel12)
                                            .addComponent(terminado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(iniciado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(referencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addGap(8, 8, 8)))))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(especificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Orden"));

        eliminar.setText("ELIMINAR");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        guardar.setText("GUARDAR");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(140, 240, 240));

        tablaOrdenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° de Orden", "Fecha Expedición", "Fecha Entrega"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaOrdenes.getTableHeader().setReorderingAllowed(false);
        tablaOrdenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaOrdenesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaOrdenesMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tablaOrdenes);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(eliminar)
                        .addGap(111, 111, 111)
                        .addComponent(guardar))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminar)
                    .addComponent(guardar))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("ENCABEZADO", jPanel1);

        jLabel16.setText("COSTO TOTAL");

        jLabel17.setText("COSTO UNITARIO");

        guardarOrden.setText("GUARDAR");
        guardarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarOrdenActionPerformed(evt);
            }
        });

        finalizar.setText("FINALIZAR");
        finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle Orden"));

        jLabel9.setText("Material");

        jLabel18.setText("Mano De Obra");

        jLabel19.setText("Costos Indirectos de Fabricación");

        jLabel20.setText("Descripción");

        jLabel21.setText("Cantidad");

        jLabel22.setText("Precio Unitario");

        jLabel23.setText("Cantidad Obreros");

        jLabel24.setText("N° de Horas");

        jLabel25.setText("Precio Por Hora");

        jLabel26.setText("Tasa sobre costo primo");

        cantidadMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadMaterialActionPerformed(evt);
            }
        });

        nuevoDetalle.setText("NUEVO DETALLE");
        nuevoDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoDetalleActionPerformed(evt);
            }
        });

        descripcion.setColumns(20);
        descripcion.setRows(5);
        jScrollPane3.setViewportView(descripcion);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel9)
                .addGap(252, 252, 252)
                .addComponent(jLabel18)
                .addGap(171, 171, 171)
                .addComponent(jLabel19))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel20)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cantidadObreros, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(tasa, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(cantidadMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jLabel25)
                .addGap(76, 76, 76)
                .addComponent(precioHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(nuevoDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel22)
                .addGap(11, 11, 11)
                .addComponent(preciounitario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(tasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel24))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cantidadObreros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(numHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(precioHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(cantidadMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nuevoDetalle))))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(preciounitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        eliminarDetalle.setText("ELIMINAR");
        eliminarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarDetalleActionPerformed(evt);
            }
        });

        jButton1.setText("EXPORTAR A PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Orden Fabricacion"));

        jLabel13.setText("MATERIALES");

        jLabel14.setText("MANO DE OBRA");

        jLabel15.setText("COSTOS INDIRECTOS FAB.");

        tablaOrden.setAutoCreateRowSorter(true);
        tablaOrden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Orden", "Material", "Cantidad", "PU", "Total", "# Obreros", "Hora", "# Hora", "Total", "Tasa", "Importe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaOrden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaOrdenMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaOrden);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(184, 184, 184)
                .addComponent(jLabel15)
                .addGap(90, 90, 90))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jLabel16)
                .addGap(10, 10, 10)
                .addComponent(costoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(jLabel17)
                .addGap(2, 2, 2)
                .addComponent(costoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(eliminarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(guardarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(costoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(costoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eliminarDetalle)
                    .addComponent(guardarOrden)
                    .addComponent(finalizar)
                    .addComponent(jButton1)))
        );

        jTabbedPane1.addTab("ORDEN", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarOrdenActionPerformed
        if (!validarCantidad(cantidadMaterial)) {
            JOptionPane.showMessageDialog(null, "La cantidad de material no es correcta");
            return;
        }
        if (!validarMonto(preciounitario)) {
            JOptionPane.showMessageDialog(null, "El precio del material no es correcto");
            return;
        }
        if (!validarCantidad(cantidadObreros)) {
            JOptionPane.showMessageDialog(null, "La cantidad de obreros no es correcta");
            return;
        }
        if (!validarMonto(numHoras)) {
            JOptionPane.showMessageDialog(null, "La cantidad de horas no es correcta");
            return;
        }
        if (!validarMonto(precioHoras)) {
            JOptionPane.showMessageDialog(null, "El precio de la hora no es correcta");
            return;
        }
        if (!validarMonto(tasa) || Double.parseDouble(tasa.getText()) > 1) {
            JOptionPane.showMessageDialog(null, "La tasa no es correcta");
            return;
        }
        if(detalleActual!=null){
            OrdenFabricacionDetalle orden2 = (OrdenFabricacionDetalle)SICService.getServOrdenFabricacionDetalle().getByPK(OrdenFabricacionDetalle.class, detalleActual.getIdOrdenFrabricacionDetalle());
            orden2.setMaterial(descripcion.getText());
            orden2.setCantidadMaterial(BigInteger.valueOf(Long.valueOf(cantidadMaterial.getText())));
            orden2.setPrecioUnitario(Double.parseDouble(preciounitario.getText()));
            orden2.setCantidadObreros(BigInteger.valueOf(Long.valueOf(cantidadObreros.getText())));
            orden2.setCantidadHoras(BigInteger.valueOf(Long.valueOf(numHoras.getText())));          
            orden2.setPrecioHora(Double.parseDouble(precioHoras.getText()));           
            orden2.setTasaCif(Double.parseDouble(tasa.getText()));
            orden2.setOrdenFabricacion(ordenFabricacion);
            if (SICService.getServOrdenFabricacionDetalle().guardar(orden2)) {
                cargarOrdenDetalle();
                JOptionPane.showMessageDialog(null, "Guardado");  
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al guardar");
            }
        }else{
        if (cantidadMaterial.getText().isEmpty() && descripcion.getText().isEmpty()
                && preciounitario.getText().isEmpty() && cantidadObreros.getText().isEmpty() && numHoras.getText().isEmpty()
                && precioHoras.getText().isEmpty() && tasa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Datos incompletos");
        } else {
            OrdenFabricacionDetalle detalle= new OrdenFabricacionDetalle();
            detalle.setMaterial(descripcion.getText());
            detalle.setCantidadMaterial(BigInteger.valueOf(Long.valueOf(cantidadMaterial.getText())));
            detalle.setPrecioUnitario(Double.parseDouble(preciounitario.getText()));
            detalle.setCantidadObreros(BigInteger.valueOf(Long.valueOf(cantidadObreros.getText())));
            detalle.setCantidadHoras(BigInteger.valueOf(Long.valueOf(numHoras.getText())));
            detalle.setPrecioHora(Double.parseDouble(precioHoras.getText()));
            detalle.setTasaCif(Double.parseDouble(tasa.getText()));
            detalle.setOrdenFabricacion(ordenFabricacion);
            if (SICService.getServOrdenFabricacionDetalle().guardar(detalle)) {
                cargarOrdenDetalle();
                JOptionPane.showMessageDialog(null, "Guardado");
                
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al guardar");
            }
        }

     }
    cargarOrdenDetalle();
    }//GEN-LAST:event_guardarOrdenActionPerformed


    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed
        ordenFabricacion.setFinalizada("1");
        SICService.getServOrdenFabricacion().guardar(ordenFabricacion);
        guardar.setEnabled(false);
        guardarOrden.setEnabled(false);
        finalizar.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Orden Finalizada");
        
        
    }//GEN-LAST:event_finalizarActionPerformed

    private void eliminarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarDetalleActionPerformed
        if (detalleActual != null) {
            SICService.getServOrdenFabricacion().eliminar(detalleActual);
            JOptionPane.showMessageDialog(null, "Eliminado con éxito");
            cargarOrdenes();
            detalleActual = null;
        } else {
            JOptionPane.showMessageDialog(null, "No hay detalle seleccionado");
        }
    }//GEN-LAST:event_eliminarDetalleActionPerformed

    private void tablaOrdenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaOrdenMousePressed
        int filaSelec = tablaOrden.getSelectedRow();
        ordenFabricacion.getOrdenFabricacionDetalleList();
        detalleActual = ordenFabricacion.getOrdenFabricacionDetalleList().get(filaSelec);
        descripcion.setText(detalleActual.getMaterial());
        cantidadMaterial.setText(detalleActual.getCantidadMaterial().toString());
        preciounitario.setText(detalleActual.getPrecioUnitario().toString());
        cantidadObreros.setText(detalleActual.getCantidadObreros().toString());
        numHoras.setText(detalleActual.getCantidadHoras().toString());
        precioHoras.setText(detalleActual.getPrecioHora().toString());
        tasa.setText(detalleActual.getTasaCif().toString());

    }//GEN-LAST:event_tablaOrdenMousePressed

    private void cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadActionPerformed

    private void ordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ordenActionPerformed

    private void expedicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expedicionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_expedicionActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        expedicion.setText(null);
        orden.setText(null);
        fechaCliente.setText(null);
        cantidad.setText(null);
        articulo.setText(null);
        iniciado.setText(null);
        terminado.setText(null);
        referencia.setText(null);
        especificacion.setText(null);
        departamento.setSelectedIndex(0);
    }//GEN-LAST:event_nuevoActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if (ordenFabricacion != null) {
            SICService.getServOrdenFabricacion().eliminar(ordenFabricacion);
            JOptionPane.showMessageDialog(null, "Eliminado con éxito");
            cargarOrdenes();
            ordenFabricacion = null;
        } else {
            JOptionPane.showMessageDialog(null, "No hay cargo seleccionado");
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        if (!validarFecha(expedicion)) {
            JOptionPane.showMessageDialog(null, "La fecha de expeición debe ser en el formato dd/mm/yyyy");
            return;
        }
        if (!validarFecha(fechaCliente)) {
            JOptionPane.showMessageDialog(null, "La fecha requerida por el cliente debe ser en el formato dd/mm/yyyy");
            return;
        }
        if (!validarFecha(iniciado)) {
            JOptionPane.showMessageDialog(null, "La fecha de inicio debe ser en el formato dd/mm/yyyy");
            return;
        }
        if (!validarFecha(terminado)) {
            JOptionPane.showMessageDialog(null, "La fecha de terminación debe ser en el formato dd/mm/yyyy");
            return;
        }
        if (!validarCantidad(cantidad)) {
            JOptionPane.showMessageDialog(null, "La cantidad no es correcta");
            return;
        }
        if (!validarCantidad(referencia)) {
            JOptionPane.showMessageDialog(null, "El número de referencia no es correcto");
            return;
        }
        if (!orden.getText().isEmpty()) {
            OrdenFabricacion orden1 = (OrdenFabricacion) SICService.getServOrdenFabricacion().getByPK(OrdenFabricacion.class, BigDecimal.valueOf(Long.valueOf(orden.getText())));
            orden1.setRefPedido(referencia.getText());
            orden1.setFechaExpedicion(new Date(expedicion.getText()));
            orden1.setDepartamento((Departamento) departamento.getSelectedItem());
            orden1.setFechaEntrega(new Date(fechaCliente.getText()));
            orden1.setCantidad(BigInteger.valueOf(Long.valueOf(cantidad.getText())));
            orden1.setArticulo(articulo.getText());
            orden1.setFechaIniciado(new Date(iniciado.getText()));
            orden1.setFechaFinalizado(new Date(terminado.getText()));
            orden1.setEspecificaciones(especificacion.getText());
            if (SICService.getServOrdenFabricacion().guardar(orden1)) {
                JOptionPane.showMessageDialog(null, "Guardado");
                orden.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al guardar");
            }
        } else {
            if (referencia.getText().isEmpty() && orden.getText().isEmpty()
                && fechaCliente.getText().isEmpty() && cantidad.getText().isEmpty() && iniciado.getText().isEmpty()
                && terminado.getText().isEmpty() && referencia.getText().isEmpty() && especificacion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Datos incompletos");
            } else {
                OrdenFabricacion ordenFab = new OrdenFabricacion();
                ordenFab.setRefPedido(referencia.getText());
                ordenFab.setFechaExpedicion(new Date(expedicion.getText()));
                ordenFab.setDepartamento((Departamento) departamento.getSelectedItem());
                ordenFab.setFechaEntrega(new Date(fechaCliente.getText()));
                ordenFab.setCantidad(BigInteger.valueOf(Long.valueOf(cantidad.getText())));
                ordenFab.setArticulo(articulo.getText());
                ordenFab.setFechaIniciado(new Date(iniciado.getText()));
                ordenFab.setFechaFinalizado(new Date(terminado.getText()));
                ordenFab.setEspecificaciones(especificacion.getText());

                if (SICService.getServOrdenFabricacion().guardar(ordenFab)) {
                    JOptionPane.showMessageDialog(null, "Guardado");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un error al guardar");
                }
            }
        }
        cargarOrdenes();
    }//GEN-LAST:event_guardarActionPerformed

    private void tablaOrdenesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaOrdenesMousePressed

    }//GEN-LAST:event_tablaOrdenesMousePressed

    private void tablaOrdenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaOrdenesMouseClicked
        ordenFabricacion=null;
        if (evt.getClickCount() == 2) {
            jTabbedPane1.setEnabledAt(1, true);
            jTabbedPane1.setSelectedIndex(1);
            ordenFabricacion = ordenes.get(tablaOrdenes.getSelectedRow());
            cargarOrdenDetalle();
            
        } else {
            if (evt.getClickCount() == 1) {
                int filaSelec = tablaOrdenes.getSelectedRow();
                ordenFabricacion = ordenes.get(filaSelec);
            }
        }
        DateFormat fechas = new SimpleDateFormat("dd/MM/yyyy");
        String fecha1;
        Date aux = new Date();
        aux = ordenFabricacion.getFechaExpedicion();
        fecha1 = fechas.format(aux);
        expedicion.setText(fecha1);
        aux = ordenFabricacion.getFechaEntrega();
        fecha1 = fechas.format(aux);
        fechaCliente.setText(fecha1);
        aux = ordenFabricacion.getFechaIniciado();
        fecha1 = fechas.format(aux);
        iniciado.setText(fecha1);
        aux = ordenFabricacion.getFechaFinalizado();
        fecha1 = fechas.format(aux);
        terminado.setText(fecha1);
        orden.setText(ordenFabricacion.getIdOrdenFabricacion().toString());
        cantidad.setText(ordenFabricacion.getCantidad().toString());
        articulo.setText(ordenFabricacion.getArticulo());
        referencia.setText(ordenFabricacion.getRefPedido());
        especificacion.setText(ordenFabricacion.getEspecificaciones());
        departamento.setSelectedItem(ordenFabricacion.getDepartamento());
        if(ordenFabricacion.getFinalizada().equals("1")){
            guardar.setEnabled(false);
            guardarOrden.setEnabled(false);
            finalizar.setEnabled(false);
            nuevoDetalle.setEnabled(false);
        }
        else{
            guardar.setEnabled(true);
            guardarOrden.setEnabled(true);
            finalizar.setEnabled(true);
            nuevoDetalle.setEnabled(true);
        }
    }//GEN-LAST:event_tablaOrdenesMouseClicked

    private void nuevoDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoDetalleActionPerformed
        limpiar();
        detalleActual=null;
    }//GEN-LAST:event_nuevoDetalleActionPerformed

    private void cantidadMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadMaterialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadMaterialActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        GenericReporte reporte = new GenericReporte("OrdenFabricacion");
        reporte.getMapa().put("orden",ordenFabricacion);
        //reporte.getMapa().put("nombreEstadoFinanciero", "Orden de Fabricación");
        reporte.setLista(ordendetalle);
        reporte.generar();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField articulo;
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField cantidadMaterial;
    private javax.swing.JTextField cantidadObreros;
    private javax.swing.JTextField costoTotal;
    private javax.swing.JTextField costoUnitario;
    private javax.swing.JComboBox departamento;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton eliminarDetalle;
    private javax.swing.JTextField especificacion;
    private javax.swing.JTextField expedicion;
    private javax.swing.JTextField fechaCliente;
    private javax.swing.JButton finalizar;
    private javax.swing.JButton guardar;
    private javax.swing.JButton guardarOrden;
    private javax.swing.JTextField iniciado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton nuevo;
    private javax.swing.JButton nuevoDetalle;
    private javax.swing.JTextField numHoras;
    private javax.swing.JTextField orden;
    private javax.swing.JTextField precioHoras;
    private javax.swing.JTextField preciounitario;
    private javax.swing.JTextField referencia;
    private javax.swing.JTable tablaOrden;
    private javax.swing.JTable tablaOrdenes;
    private javax.swing.JTextField tasa;
    private javax.swing.JTextField terminado;
    // End of variables declaration//GEN-END:variables
}
