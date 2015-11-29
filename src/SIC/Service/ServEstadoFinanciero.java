package SIC.Service;

import SIC.Entidades.EstadoFinanciero;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author GALICIA
 */
public class ServEstadoFinanciero extends BasicService {

    public EstadoFinanciero getEstadoFinacieroPeriodoActivo(String idTipoEstadoFinanciero) {

        List<EstadoFinanciero> lista = getListado(EstadoFinanciero.class);

        for (EstadoFinanciero estadoFinanciero : lista) {
            if (estadoFinanciero.getPeriodo().equals(SICService.getServPeriodo().getActivo()) && estadoFinanciero.getTipoEstadoFinanciero().getIdTipoEstadoFinanciero().equals(idTipoEstadoFinanciero)) {
                return estadoFinanciero;
            }
        }

        return null;
    }
}
