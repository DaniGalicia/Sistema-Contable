package SIC.Service;

import SIC.Entidades.EstadoFinanciero;
import SIC.Entidades.Periodo;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author GALICIA
 */
public class ServEstadoFinanciero extends BasicService {

    public EstadoFinanciero getEstadoFinacieroPeriodoActivo(String idTipoEstadoFinanciero,Periodo periodo) {

        List<EstadoFinanciero> lista = getListado(EstadoFinanciero.class);

        for (EstadoFinanciero estadoFinanciero : lista) {
            if (estadoFinanciero.getPeriodo().equals(periodo)&& estadoFinanciero.getTipoEstadoFinanciero().getIdTipoEstadoFinanciero().equals(idTipoEstadoFinanciero)) {
                return estadoFinanciero;
            }
        }

        return null;
    }
}
