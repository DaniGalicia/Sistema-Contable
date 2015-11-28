/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import SIC.Entidades.OrdenFabricacion;
import SIC.Service.SICService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

/**
 *
 * @author dannier
 */
public class GenericReporte {

    private List lista = new ArrayList<>();
    private String archivoJasper;
    private Map<String, Object> mapa = new HashMap<>();
    private String nombrePdf = "reporte";

    public GenericReporte(String archivoJasper) {
        this.archivoJasper = archivoJasper;
    }

    public void generar() {
        try {
            JasperReport reporte = JasperCompileManager.compileReport("src/Reportes/" + archivoJasper + ".jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, mapa, new JRBeanCollectionDataSource(lista));
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(nombrePdf +".pdf"));
            exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(GenericReporte.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List getLista() {
        return lista;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }

    public String getArchivoJasper() {
        return archivoJasper;
    }

    public void setArchivoJasper(String archivoJasper) {
        this.archivoJasper = archivoJasper;
    }

    public Map<String, Object> getMapa() {
        return mapa;
    }

    public void setMapa(Map<String, Object> mapa) {
        this.mapa = mapa;
    }

    public String getNombrePdf() {
        return nombrePdf;
    }

    public void setNombrePdf(String nombrePdf) {
        this.nombrePdf = nombrePdf;
    }

}
