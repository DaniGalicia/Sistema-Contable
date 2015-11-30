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

        contenedor = new javax.swing.JTabbedPane();
        registroOrden = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaOrdenes = new javax.swing.JTable();
        guardar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        expedicion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        departamento = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        orden = new javax.swing.JTextField();
        cantidad = new javax.swing.JTextField();
        fechaCliente = new javax.swing.JTextField();
        terminado = new javax.swing.JTextField();
        especificacion = new javax.swing.JTextField();
        articulo = new javax.swing.JTextField();
        iniciado = new javax.swing.JTextField();
        referencia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nuevo = new javax.swing.JButton();
        ordenDetalle = new javax.swing.JPanel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Orden de fabricacion");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registroOrden.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaOrdenesMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaOrdenesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaOrdenes);

        registroOrden.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 296, 920, 140));

        guardar.setText("GUARDAR");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        registroOrden.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 480, -1, -1));

        eliminar.setText("ELIMINAR");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        registroOrden.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, -1, -1));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("FECHA DE EXPEDICIÓN");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 120, -1));

        expedicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expedicionActionPerformed(evt);
            }
        });
        jPanel6.add(expedicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 160, -1));

        jLabel2.setText("DEPARTAMENTO");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        departamento.setEditable(true);
        departamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel6.add(departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 160, -1));

        jLabel3.setText("PRODUCCIÓN");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, -1, -1));

        jLabel4.setText("ARTICULO");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel5.setText("INICIADO");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel6.setText("REF PEPIDO N°");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel8.setText("FECHA REQUERIDA POR CLIENTE ");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));

        jLabel12.setText("CANTIDAD");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, -1));

        jLabel10.setText("TERMINADO");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, -1, -1));

        jLabel11.setText("ESPECIFICACIONES ");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, -1, -1));

        orden.setEnabled(false);
        orden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordenActionPerformed(evt);
            }
        });
        jPanel6.add(orden, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 160, -1));

        cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadActionPerformed(evt);
            }
        });
        jPanel6.add(cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, 160, -1));
        jPanel6.add(fechaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 160, -1));
        jPanel6.add(terminado, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 160, -1));
        jPanel6.add(especificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, 160, -1));
        jPanel6.add(articulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 160, -1));
        jPanel6.add(iniciado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 160, -1));
        jPanel6.add(referencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 160, -1));

        jLabel7.setText("N° DE ORDEN");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, -1, -1));

        nuevo.setText("NUEVO");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jPanel6.add(nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        registroOrden.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 28, -1, -1));

        contenedor.addTab("ENCABEZADO", registroOrden);

        ordenDetalle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        ordenDetalle.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 266, 930, 150));

        jLabel13.setText("MATERIALES");
        ordenDetalle.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 246, -1, -1));

        jLabel14.setText("MANO DE OBRA");
        ordenDetalle.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 246, -1, -1));

        jLabel15.setText("COSTOS INDIRECTOS FAB.");
        ordenDetalle.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 246, -1, -1));

        jLabel16.setText("COSTO TOTAL");
        ordenDetalle.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, -1, -1));

        jLabel17.setText("COSTO UNITARIO");
        ordenDetalle.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 460, -1, -1));
        ordenDetalle.add(costoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, 81, -1));
        ordenDetalle.add(costoUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, 81, -1));

        guardarOrden.setText("GUARDAR");
        guardarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarOrdenActionPerformed(evt);
            }
        });
        ordenDetalle.add(guardarOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 140, -1));

        finalizar.setText("FINALIZAR");
        finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarActionPerformed(evt);
            }
        });
        ordenDetalle.add(finalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 520, 140, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("Material");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        jLabel18.setText("Mano De Obra");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 48, -1, -1));

        jLabel19.setText("Costos Indirectos de Fabricación");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, -1, -1));

        jLabel20.setText("Descripción");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel21.setText("Cantidad");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 54, -1));

        jLabel22.setText("Precio Unitario");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel23.setText("Cantidad Obreros");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, -1));

        jLabel24.setText("N° de Horas");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 92, -1));

        jLabel25.setText("Precio Por Hora");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));

        jLabel26.setText("Tasa sobre costo primo");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, -1, 24));

        cantidadMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadMaterialActionPerformed(evt);
            }
        });
        jPanel3.add(cantidadMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 140, -1));
        jPanel3.add(preciounitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 140, -1));
        jPanel3.add(cantidadObreros, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 76, -1));
        jPanel3.add(numHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 76, -1));
        jPanel3.add(precioHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 76, -1));
        jPanel3.add(tasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, 95, -1));

        nuevoDetalle.setText("NUEVO DETALLE");
        nuevoDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoDetalleActionPerformed(evt);
            }
        });
        jPanel3.add(nuevoDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        descripcion.setColumns(20);
        descripcion.setRows(5);
        jScrollPane3.setViewportView(descripcion);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 140, 70));

        ordenDetalle.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 29, 1415, 199));

        eliminarDetalle.setText("ELIMINAR");
        eliminarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarDetalleActionPerformed(evt);
            }
        });
        ordenDetalle.add(eliminarDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));

        jButton1.setText("EXPORTAR A PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ordenDetalle.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 520, 140, -1));

        contenedor.addTab("ORDEN", ordenDetalle);

        getContentPane().add(contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 19, 960, 590));

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
            contenedor.setEnabledAt(1, true);
            contenedor.setSelectedIndex(1);
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
        JOptionPane.showMessageDialog(rootPane, "Archivo generado");
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField articulo;
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField cantidadMaterial;
    private javax.swing.JTextField cantidadObreros;
    private javax.swing.JTabbedPane contenedor;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton nuevo;
    private javax.swing.JButton nuevoDetalle;
    private javax.swing.JTextField numHoras;
    private javax.swing.JTextField orden;
    private javax.swing.JPanel ordenDetalle;
    private javax.swing.JTextField precioHoras;
    private javax.swing.JTextField preciounitario;
    private javax.swing.JTextField referencia;
    private javax.swing.JPanel registroOrden;
    private javax.swing.JTable tablaOrden;
    private javax.swing.JTable tablaOrdenes;
    private javax.swing.JTextField tasa;
    private javax.swing.JTextField terminado;
    // End of variables declaration//GEN-END:variables
}
