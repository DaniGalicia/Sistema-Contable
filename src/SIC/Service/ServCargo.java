package SIC.Service;

import SIC.Entidades.Cargo;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author GALICIA
 */
public class ServCargo extends BasicService{

    public ServCargo(String persistenceUnit) {
        super(persistenceUnit);
    }

    public Cargo getCargoByCodigo(String codigoCargo) {
        Query q = getEntityManager().createNamedQuery("Cargo.findByCodigoCargo");
               
        q.setParameter("codigoCargo", codigoCargo);

        return (Cargo) q.getSingleResult();

    }

    public List<Cargo> getListado() {
        Query q = getEntityManager().createNamedQuery("Cargo.findAll");
        return q.getResultList();
    }
}
