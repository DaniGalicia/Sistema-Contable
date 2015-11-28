
package pruebas.reportes.jasperreports.parametros;

import SIC.Entidades.OrdenFabricacion;
import SIC.Entidades.OrdenFabricacionDetalle;
import SIC.Service.SICService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;



public class Main
{
    /**
     * @param args argumentos recibidos por la linea de comandos
     */
    public static void main(String[] args) throws Exception
    {
       

        JasperReport reporte = JasperCompileManager.compileReport("src/Reportes/OrdenFabricacion.jrxml");

        
        
        OrdenFabricacion or=(OrdenFabricacion) SICService.getServOrdenFabricacion().getByPK(OrdenFabricacion.class, BigDecimal.valueOf(29));

        Map<String, Object> parametros = new HashMap<String,Object>();
        parametros.put("orden",or);

        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(or.getOrdenFabricacionDetalleList()));

        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reporte3PDF.pdf"));
        exporter.exportReport();
    }
}
