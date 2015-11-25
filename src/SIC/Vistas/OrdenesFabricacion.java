/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Vistas;

import SIC.Entidades.Departamento;
import SIC.Entidades.Movimiento;
import SIC.Entidades.OrdenFabricacion;
import SIC.Entidades.OrdenFabricacionDetalle;
import SIC.Service.Comunes;
import SIC.Service.SICService;
import SIC.Vistas.tableModels.CargosTableModel;
import SIC.Vistas.tableModels.EncabezadoOrdenTableModel;
import java.awt.Frame;
import static java.lang.String.valueOf;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Escobar
 */
public class OrdenesFabricacion extends javax.swing.JFrame {

    OrdenFabricacion ordenFabricacion;
    OrdenFabricacionDetalle detalleActual;
    List<OrdenFabricacion> ordenes = new ArrayList<>();

    /**
     * Creates new form OrdenFabricacion
     */
    public OrdenesFabricacion() {
        initComponents();
        this.setTitle("ORDEN DE FABRICACIÓN");
        this.setLocationRelativeTo(null);
        departamento.setModel(Comunes.crearModeloComboBox(SICService.getServDepartamento().getListado(Departamento.class)));
        cargarOrdenes();
    }

    private void limpiar() {
        for (Object cajasTexto : jPanel3.getComponents()) {
            if (cajasTexto.getClass().getTypeName().equals("javax.swing.JTextField")) {
                ((JTextField) cajasTexto).setText("");
            }
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
        DefaultTableModel defaultTableModel =(DefaultTableModel) tablaOrden.getModel();
        while (defaultTableModel.getRowCount() > 0) {
            defaultTableModel.removeRow(0);
        }
        for (OrdenFabricacionDetalle ordenfab : ordenFabricacion.getOrdenFabricacionDetalleList()) {
            defaultTableModel.addRow(new Object[]{ordenfab.getOrdenFabricacion().getIdOrdenFabricacion(),
                ordenfab.getMaterial(), 
                ordenfab.getCantidadMaterial(),
                ordenfab.getPrecioUnitario(), 
                ordenfab.getTotalMaterial(), ordenfab.getCantidadObreros(),
                ordenfab.getPrecioHora(), ordenfab.getCantidadHoras(),
                ordenfab.getTotalManoObra(), ordenfab.getTasaCif(),
                ordenfab.getImporte()});
            JOptionPane.showMessageDialog(null, new Object[]{ordenfab.getOrdenFabricacion().getIdOrdenFabricacion(),
                ordenfab.getMaterial(), 
                ordenfab.getCantidadMaterial(),
                ordenfab.getPrecioUnitario(), 
                ordenfab.getTotalMaterial(), ordenfab.getCantidadObreros(),
                ordenfab.getPrecioHora(), ordenfab.getCantidadHoras(),
                ordenfab.getTotalManoObra(), ordenfab.getTasaCif(),
                ordenfab.getImporte()}.toString());
            costoTotal.setText(String.format("%.2f", ordenfab.getCostoTotal()));
            costoUnitario.setText(String.format("%.2f", ordenfab.getCostoUnitario(Integer.parseInt(cantidad.getText()))));
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        expedicion = new javax.swing.JTextField();
        orden = new javax.swing.JTextField();
        fechaCliente = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        articulo = new javax.swing.JTextField();
        iniciado = new javax.swing.JTextField();
        referencia = new javax.swing.JTextField();
        cantidad = new javax.swing.JTextField();
        terminado = new javax.swing.JTextField();
        especificacion = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaOrdenes = new javax.swing.JTable();
        guardar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        departamento = new javax.swing.JComboBox();
        nuevo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaOrden = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
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
        descripcion = new javax.swing.JTextField();
        cantidadMaterial = new javax.swing.JTextField();
        preciounitario = new javax.swing.JTextField();
        cantidadObreros = new javax.swing.JTextField();
        numHoras = new javax.swing.JTextField();
        precioHoras = new javax.swing.JTextField();
        tasa = new javax.swing.JTextField();
        nuevoDetalle = new javax.swing.JButton();
        eliminarDetalle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Orden de fabricacion");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("FECHA DE EXPEDICIÓN");

        jLabel2.setText("DEPARTAMENTO");

        jLabel3.setText("PRODUCCIÓN");

        jLabel4.setText("ARTICULO");

        jLabel5.setText("INICIADO");

        jLabel6.setText("REF PEPIDO N°");

        jLabel7.setText("N° DE ORDEN");

        jLabel8.setText("FECHA REQUERIDA POR CLIENTE ");

        jLabel10.setText("TERMINADO");

        jLabel11.setText("ESPECIFICACIONES ");

        expedicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expedicionActionPerformed(evt);
            }
        });

        orden.setEnabled(false);
        orden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordenActionPerformed(evt);
            }
        });

        jLabel12.setText("CANTIDAD");

        cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadActionPerformed(evt);
            }
        });

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

        guardar.setText("GUARDAR");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        eliminar.setText("ELIMINAR");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        departamento.setEditable(true);
        departamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        nuevo.setText("NUEVO");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(expedicion, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(articulo)
                            .addComponent(iniciado)
                            .addComponent(referencia)
                            .addComponent(departamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orden, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(terminado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(especificacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(nuevo)
                        .addGap(39, 39, 39)
                        .addComponent(guardar)
                        .addGap(48, 48, 48)
                        .addComponent(eliminar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(266, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orden, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(expedicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(fechaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel12))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(iniciado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(terminado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(referencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel11))
                    .addComponent(especificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(eliminar)
                    .addComponent(nuevo))
                .addContainerGap(192, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ENCABEZADO", jPanel1);

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

        jLabel13.setText("MATERIALES");

        jLabel14.setText("MANO DE OBRA");

        jLabel15.setText("COSTOS INDIRECTOS FAB.");

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

        descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripcionActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel23))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(170, 170, 170))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel20))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(preciounitario, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cantidadMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(82, 82, 82))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(precioHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cantidadObreros, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel18)))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(tasa, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(155, 155, 155))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel19)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(nuevoDetalle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(nuevoDetalle)
                .addGap(34, 34, 34)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidadMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(numHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(preciounitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(precioHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(27, 27, 27))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidadObreros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        eliminarDetalle.setText("ELIMINAR");
        eliminarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarDetalleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jLabel13)
                                .addGap(188, 188, 188)
                                .addComponent(jLabel14)
                                .addGap(107, 107, 107)
                                .addComponent(jLabel15))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(184, 184, 184)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel17)
                                                    .addComponent(guardarOrden)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(eliminarDetalle)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel16)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(costoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(costoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(finalizar)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 128, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(costoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(eliminarDetalle)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(costoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarOrden)
                    .addComponent(finalizar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("ORDEN", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 19, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ordenActionPerformed

    private void expedicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expedicionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_expedicionActionPerformed

    private void cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadActionPerformed

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
        if (cantidadMaterial.getText().isEmpty() && descripcion.getText().isEmpty()
                && preciounitario.getText().isEmpty() && cantidadObreros.getText().isEmpty() && numHoras.getText().isEmpty()
                && precioHoras.getText().isEmpty() && tasa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Datos incompletos");
        } else {
            OrdenFabricacionDetalle detalle = new OrdenFabricacionDetalle();
            detalle.setMaterial(descripcion.getText());
            detalle.setCantidadMaterial(BigInteger.valueOf(Long.valueOf(cantidadMaterial.getText())));
            detalle.setPrecioUnitario(Double.parseDouble(preciounitario.getText()));
            detalle.setCantidadObreros(BigInteger.valueOf(Long.valueOf(cantidadObreros.getText())));
            detalle.setCantidadHoras(BigInteger.valueOf(Long.valueOf(numHoras.getText())));
            detalle.setPrecioHora(Double.parseDouble(precioHoras.getText()));
            detalle.setTasaCif(Double.parseDouble(tasa.getText()));
            detalle.setOrdenFabricacion(ordenFabricacion);

            if (SICService.getServOrdenFabricacionDetalle().guardar(detalle)) {
                JOptionPane.showMessageDialog(null, "Guardado");
                cargarOrdenDetalle();
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al guardar");
            }
        }

    }//GEN-LAST:event_guardarOrdenActionPerformed

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


    private void tablaOrdenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaOrdenesMouseClicked
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
        int filaSelec = tablaOrdenes.getSelectedRow();
        ordenFabricacion = ordenes.get(filaSelec);
        DefaultTableModel defaultTableModel = (DefaultTableModel) tablaOrdenes.getModel();
        DateFormat fechas = new SimpleDateFormat("dd/MM/yyyy");
        String fecha1 = new String();
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
    }//GEN-LAST:event_tablaOrdenesMouseClicked

    private void tablaOrdenesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaOrdenesMousePressed


    }//GEN-LAST:event_tablaOrdenesMousePressed

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

    private void cantidadMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadMaterialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadMaterialActionPerformed

    private void descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descripcionActionPerformed

    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed
        ordenFabricacion.setFinalizada("1");
        SICService.getServOrdenFabricacion().guardar(ordenFabricacion);
    }//GEN-LAST:event_finalizarActionPerformed

    private void nuevoDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoDetalleActionPerformed
        limpiar();
    }//GEN-LAST:event_nuevoDetalleActionPerformed

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
        detalleActual = null;
        int filaSelec = tablaOrden.getSelectedRow();
        ordenFabricacion.getOrdenFabricacionDetalleList();
        detalleActual=ordenFabricacion.getOrdenFabricacionDetalleList().get(filaSelec);
        DefaultTableModel defaultTableModel = (DefaultTableModel) tablaOrden.getModel();
        descripcion.setText(detalleActual.getMaterial());
        cantidadMaterial.setText(detalleActual.getCantidadMaterial().toString());
        preciounitario.setText(detalleActual.getPrecioUnitario().toString());
        cantidadObreros.setText(detalleActual.getCantidadObreros().toString());
        numHoras.setText(detalleActual.getCantidadHoras().toString());
        precioHoras.setText(detalleActual.getPrecioHora().toString());
        tasa.setText(detalleActual.getTasaCif().toString());
    }//GEN-LAST:event_tablaOrdenMousePressed

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
            java.util.logging.Logger.getLogger(OrdenesFabricacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdenesFabricacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdenesFabricacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdenesFabricacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdenesFabricacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField articulo;
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField cantidadMaterial;
    private javax.swing.JTextField cantidadObreros;
    private javax.swing.JTextField costoTotal;
    private javax.swing.JTextField costoUnitario;
    private javax.swing.JComboBox departamento;
    private javax.swing.JTextField descripcion;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton eliminarDetalle;
    private javax.swing.JTextField especificacion;
    private javax.swing.JTextField expedicion;
    private javax.swing.JTextField fechaCliente;
    private javax.swing.JButton finalizar;
    private javax.swing.JButton guardar;
    private javax.swing.JButton guardarOrden;
    private javax.swing.JTextField iniciado;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
