package SIC.Service;

import SIC.Entidades.Usuario;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author GALICIA
 */
public class ServUsuario extends BasicService{

    public ServUsuario(String persistenceUnit) {
        super();
    }

    public boolean login(String usuario,String clave){
      Query q=getEntityManager().createQuery("SELECT c FROM Usuario c WHERE c.clave = :clave AND c.usuario = :usuario");
      q.setParameter("usuario", usuario);
      q.setParameter("clave", clave);
      
      if(q.getSingleResult().equals(null))
          return false;
      
      return true;
    }
    
    public Usuario getUsuarioByCodigoEmpleado(String codigoEmpleado) {

        Query q = getEntityManager().createNamedQuery("Usuario.findByCodigoEmpleado");

        q.setParameter("codigoEmpleado", codigoEmpleado);
        
        try {
            return (Usuario) q.getSingleResult();
        } catch (Exception e) {
        }

        return null;
    }

    public List<Usuario> getListado() {
        Query q = getEntityManager().createNamedQuery("Usuario.findAll");
        return q.getResultList();
    }
}
