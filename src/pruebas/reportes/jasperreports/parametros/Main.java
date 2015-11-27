/*
 * Main.java
 *
 * Creada el 01-dic-2010, 12:03:11
 *
 * Clase Java desarrollada por Alex para el blog http://javatutoriales.blogspot.com/ el día 01-dic-2010
 *
 * Para informacion sobre el uso de esta clase, asi como bugs, actualizaciones, o mejoras enviar un mail a
 * programadorjavablog@gmail.com
 *
 * No olviden hacerse fans del grupo de Java Tutoriales en facebook  http://www.facebook.com/pages/Java-Tutoriales/121935157864634
 *
 */
package pruebas.reportes.jasperreports.parametros;

import SIC.Entidades.Departamento;
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
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * @author Alex
 * @version 1.0
 * @author-mail programadorjavablog@gmail.com
 * @date 01-dic-2010
 */
public class Main
{
    /**
     * @param args argumentos recibidos por la linea de comandos
     */
    public static void main(String[] args) throws Exception
    {
        List<Participante> listaPariticipantes = new ArrayList<Participante>();
        for (int i = 1; i <= 10; i++)
        {
            Participante p = new Participante(i, "Participante " + i, "Usuario " + i, "Pass " + i, "Comentarios para " + i);
            p.setPuntos(i);
            
            listaPariticipantes.add(p);
        }

        JasperReport reporte = (JasperReport) JasperCompileManager.compileReport("src/SIC/Imagenes/OrdenFabricacion.jrxml");

        Map<String, Object> parametros = new HashMap<String,Object>();
        parametros.put("autor", new Departamento());
        parametros.put("titulo", "Reporte Participantes");

        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(listaPariticipantes));

        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reporte3PDF.pdf"));
        exporter.exportReport();
    }
}
