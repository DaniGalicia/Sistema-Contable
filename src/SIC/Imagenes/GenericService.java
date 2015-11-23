
import java.beans.Beans;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import javax.persistence.*;
import sv.gob.mined.accesodatos.AdministradorEntidades;


public class GenericService
{
/*
    public GenericService()
    {
    }

    public GenericService(EntityManager em)
    {
        try
        {
            this.em = em;
        }
        catch(Exception ex) { }
    }



    public static List getListaObjetosLimitados(String persistenceUnit, Class clazz, int limite)
    {
        String clazzName = clazz.getSimpleName();
        query = Beans.isDesignTime() ? null : ((Query) (AdministradorEntidades.getEntityManager(persistenceUnit).createQuery((new StringBuilder()).append("SELECT c FROM ").append(clazzName).append(" c").toString(), clazz)));
        query.setMaxResults(limite);
        return query.getResultList();
    }

    public static List getListaObjetos(String persistenceUnit, Class clase, String orden)
    {
        String clazzName = clase.getSimpleName();
        String ordenamiento = "";
        if(orden.indexOf(",") > -1)
        {
            String as[] = orden.split(",");
            int i = as.length;
            for(int j = 0; j < i; j++)
            {
                String atributosOrden = as[j];
                if(ordenamiento.equals(""))
                    ordenamiento = (new StringBuilder()).append("c.").append(atributosOrden).toString();
                else
                    ordenamiento = (new StringBuilder()).append(ordenamiento).append(", c.").append(atributosOrden).toString();
            }

        } else
        {
            ordenamiento = (new StringBuilder()).append("c.").append(orden).toString();
        }
        query = AdministradorEntidades.getEntityManager(persistenceUnit).createQuery((new StringBuilder()).append("SELECT c FROM ").append(clazzName).append(" c order by ").append(ordenamiento).toString());
        return query.getResultList();
    }

    public static List getListaObjetosByCriteriaVersion2(String persistenceUnit, Class clazz, List filtros)
    {
        String clazzName = clazz.getSimpleName();
        String criterio = "";
        String oldAndOr = "";
        String andOr;
        for(Iterator iterator = filtros.iterator(); iterator.hasNext(); oldAndOr = andOr)
        {
            FiltroOld filtro = (FiltroOld)iterator.next();
            String atributo = filtro.getAtributo();
            String operador = filtro.getOperador();
            String valor = filtro.getValor();
            andOr = filtro.getAndOr();
            if(andOr.equals("") || andOr == null)
                andOr = "AND";
            if(operador.equals("like"))
                valor = (new StringBuilder()).append("\"%").append(valor).append("%\"").toString();
            else
                try
                {
                    int dot = atributo.lastIndexOf(".");
                    String fieldType;
                    if(dot == -1)
                    {
                        fieldType = clazz.getDeclaredField(atributo).getType().toString();
                    } else
                    {
                        String clase = clazz.getDeclaredField(atributo.substring(0, dot)).getType().getName();
                        String field = atributo.substring(dot + 1);
                        Class internalClass = Class.forName(clase);
                        fieldType = internalClass.getDeclaredField(field).getType().toString();
                    }
                    if(fieldType.equals("class java.lang.String"))
                        valor = (new StringBuilder()).append("\"").append(valor).append("\"").toString();
                    if(fieldType.equals("class java.lang.Character"))
                        valor = (new StringBuilder()).append("'").append(valor).append("'").toString();
                    if(fieldType.equals("class java.lang.Boolean"))
                        valor = (new StringBuilder()).append("'").append(valor).append("'").toString();
                    if(fieldType.equals("class java.util.Date") && valor.toString().length() == 10)
                        valor = (new StringBuilder()).append("'").append(valor).append("'").toString();
                    if(fieldType.equals("class java.util.Date") && valor.toString().length() == 7)
                        valor = (new StringBuilder()).append("'01/").append(valor).append("'").toString();
                }
                catch(Exception ex) { }
            atributo = (new StringBuilder()).append("c.").append(atributo).toString();
            if(criterio.equals(""))
            {
                criterio = (new StringBuilder()).append(criterio).append(" where (").append(atributo).append(" ").append(operador).append(" ").append(valor).toString();
                continue;
            }
            if(!oldAndOr.equals(andOr))
                criterio = (new StringBuilder()).append(criterio).append(") ").append(oldAndOr).append(" ( ").append(atributo).append(" ").append(operador).append(" ").append(valor).toString();
            else
                criterio = (new StringBuilder()).append(criterio).append(" ").append(oldAndOr).append(" ").append(atributo).append(" ").append(operador).append(" ").append(valor).toString();
        }

        if(!"".equals(criterio))
            criterio = (new StringBuilder()).append(criterio).append(" ) ").toString();
        query = AdministradorEntidades.getEntityManager(persistenceUnit).createQuery((new StringBuilder()).append("SELECT c FROM ").append(clazzName).append(" c ").append(criterio).toString(), clazz);
        return query.getResultList();
    }

    public static List getListaObjetosByCriteria(String persistenceUnit, Class clazz, List filtros)
    {
        String clazzName = clazz.getSimpleName();
        String criterio = "";
        String querySentence = (new StringBuilder()).append("SELECT c FROM ").append(clazzName).append(" c ").toString();
        Map utilizados = new HashMap();
        String oldAndOr = "";
        String andOr;
        for(Iterator iterator = filtros.iterator(); iterator.hasNext(); oldAndOr = andOr)
        {
            Filtro filtro = (Filtro)iterator.next();
            String atributo = filtro.getAtributo();
            String parametro = filtro.getAtributo();
            String operador = filtro.getOperador();
            andOr = filtro.getAndOr().trim();
            Object valor = filtro.getValor();
            Object fieldTypeAttribute = filtro.getFieldType();
            if(andOr.equals("") || andOr == null || !andOr.equals("OR") && !andOr.equals("AND"))
                andOr = "AND";
            try
            {
                int dot = parametro.lastIndexOf(".");
                if(dot > -1)
                    parametro = parametro.substring(dot + 1);
            }
            catch(Exception ex) { }
            if(utilizados.containsKey(parametro))
            {
                if(!operador.equalsIgnoreCase("IS"))
                {
                    int i = Integer.parseInt(utilizados.get(parametro).toString());
                    i++;
                    utilizados.put(parametro, Integer.valueOf(i));
                    parametro = (new StringBuilder()).append(parametro).append(i).toString();
                    utilizados.put(parametro, Integer.valueOf(i));
                }
            } else
            if(!operador.equalsIgnoreCase("IS"))
                utilizados.put(parametro, Integer.valueOf(0));
            parametro = (new StringBuilder()).append(" :").append(parametro).toString();
            atributo = (new StringBuilder()).append("c.").append(atributo).toString();
            if(operador.toUpperCase().equals("LIKE"))
            {
                if(fieldTypeAttribute != null)
                {
                    if(!fieldTypeAttribute.toString().equals("class java.lang.String") && !fieldTypeAttribute.toString().equals("class java.lang.Character"))
                        atributo = (new StringBuilder()).append(" UPPER(FUNC('TO_CHAR',").append(atributo).append(", '999999999999999D')").append(") ").toString();
                    else
                        atributo = (new StringBuilder()).append(" UPPER(").append(atributo).append(") ").toString();
                } else
                {
                    atributo = (new StringBuilder()).append(" UPPER(").append(atributo).append(") ").toString();
                }
                parametro = (new StringBuilder()).append(" ").append(parametro).append(" ").toString();
            }
            if(operador.equalsIgnoreCase("IS"))
                parametro = (new StringBuilder()).append(" ").append(valor.toString()).toString();
            if(criterio.equals(""))
            {
                criterio = (new StringBuilder()).append(criterio).append(" WHERE (").append(atributo).append(" ").append(operador).append(parametro).toString();
                continue;
            }
            if(!oldAndOr.equals(andOr))
                criterio = (new StringBuilder()).append(criterio).append(") ").append(oldAndOr).append(" ( ").append(atributo).append(" ").append(operador).append(parametro).toString();
            else
                criterio = (new StringBuilder()).append(criterio).append(" ").append(oldAndOr).append(" ").append(atributo).append(" ").append(operador).append(parametro).toString();
        }

        if(!"".equals(criterio))
            criterio = (new StringBuilder()).append(criterio).append(" ) ").toString();
        querySentence = (new StringBuilder()).append(querySentence).append(criterio).toString();
        query = AdministradorEntidades.getEntityManager(persistenceUnit).createQuery(querySentence);
        utilizados.clear();
        Iterator iterator1 = filtros.iterator();
        do
        {
            if(!iterator1.hasNext())
                break;
            Filtro filtro1 = (Filtro)iterator1.next();
            if(!"null".equals(filtro1.getValor().toString()))
            {
                String atributo = filtro1.getAtributo();
                String operador = filtro1.getOperador();
                Object valor = filtro1.getValor();
                if(operador.toUpperCase().equals("LIKE"))
                {
                    valor = (new StringBuilder()).append("%").append(valor.toString().toUpperCase().trim()).append("%").toString();
                    int dot = atributo.lastIndexOf(".");
                    if(dot > -1)
                        atributo = atributo.substring(dot + 1);
                    if(utilizados.containsKey(atributo))
                    {
                        int i = Integer.parseInt(utilizados.get(atributo).toString());
                        i++;
                        utilizados.put(atributo, Integer.valueOf(i));
                        atributo = (new StringBuilder()).append(atributo).append(i).toString();
                        utilizados.put(atributo, Integer.valueOf(i));
                    } else
                    {
                        utilizados.put(atributo, Integer.valueOf(0));
                    }
                    query.setParameter(atributo, valor);
                } else
                {
                    try
                    {
                        int dot = atributo.lastIndexOf(".");
                        Class fieldType;
                        if(dot == -1)
                        {
                            fieldType = clazz.getDeclaredField(atributo).getType();
                        } else
                        {
                            fieldType = getFieldType(clazz, atributo);
                            atributo = atributo.substring(atributo.lastIndexOf(".") + 1);
                        }
                        if(utilizados.containsKey(atributo))
                        {
                            if(!operador.equalsIgnoreCase("IS"))
                            {
                                int i = Integer.parseInt(utilizados.get(atributo).toString());
                                i++;
                                utilizados.put(atributo, Integer.valueOf(i));
                                atributo = (new StringBuilder()).append(atributo).append(i).toString();
                                utilizados.put(atributo, Integer.valueOf(i));
                            }
                        } else
                        if(!operador.equalsIgnoreCase("IS"))
                            utilizados.put(atributo, Integer.valueOf(0));
                        if(fieldType.isInstance(new String()))
                            query.setParameter(atributo, (String)valor);
                        else
                        if(fieldType.isInstance(Character.valueOf(" ".charAt(0))) || fieldType.getName().equals("char"))
                            query.setParameter(atributo, Character.valueOf(valor.toString().charAt(0)));
                        else
                        if(fieldType.isInstance(Boolean.valueOf("true")))
                            query.setParameter(atributo, (Boolean)valor);
                        else
                        if(fieldType.isInstance(new Date()))
                            query.setParameter(atributo, (Date)valor, TemporalType.DATE);
                        else
                        if(fieldType.isInstance(new Integer(0)))
                            query.setParameter(atributo, (Integer)valor);
                        else
                        if(fieldType.isInstance(new Double(0.0D)))
                            query.setParameter(atributo, (Double)valor);
                        else
                        if(fieldType.isInstance(new BigDecimal(0)))
                            query.setParameter(atributo, (BigDecimal)valor);
                        else
                        if(fieldType.isInstance(new Float("0")))
                            query.setParameter(atributo, (Float)valor);
                        else
                        if(fieldType.isInstance(new Long("0")))
                            query.setParameter(atributo, (Long)valor);
                        else
                        if(fieldType.isInstance(new Short("0")))
                            query.setParameter(atributo, (Short)valor);
                        else
                        if(fieldType.isInstance(new BigInteger("0")))
                            query.setParameter(atributo, (BigInteger)valor);
                    }
                    catch(Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        } while(true);
        utilizados = null;
        return query.getResultList();
    }

    public static List getCantidadListaObjetosByCriteria(String persistenceUnit, Class clazz, List filtros)
    {
        String clazzName = clazz.getSimpleName();
        String criterio = "";
        String querySentence = (new StringBuilder()).append("SELECT count(c) FROM ").append(clazzName).append(" c ").toString();
        Map utilizados = new HashMap();
        String oldAndOr = "";
        String andOr;
        for(Iterator iterator = filtros.iterator(); iterator.hasNext(); oldAndOr = andOr)
        {
            Filtro filtro = (Filtro)iterator.next();
            String atributo = filtro.getAtributo();
            String parametro = filtro.getAtributo();
            String operador = filtro.getOperador();
            andOr = filtro.getAndOr().trim();
            Object fieldTypeAttribute = filtro.getFieldType();
            if(andOr.equals("") || andOr == null || !andOr.equals("OR") && !andOr.equals("AND"))
                andOr = "AND";
            try
            {
                int dot = parametro.lastIndexOf(".");
                if(dot > -1)
                    parametro = parametro.substring(dot + 1);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            if(utilizados.containsKey(parametro))
            {
                int i = Integer.parseInt(utilizados.get(parametro).toString());
                i++;
                utilizados.put(parametro, Integer.valueOf(i));
                parametro = (new StringBuilder()).append(parametro).append(i).toString();
                utilizados.put(parametro, Integer.valueOf(i));
            } else
            {
                utilizados.put(parametro, Integer.valueOf(0));
            }
            parametro = (new StringBuilder()).append(" :").append(parametro).toString();
            atributo = (new StringBuilder()).append("c.").append(atributo).toString();
            if(operador.toUpperCase().equals("LIKE"))
            {
                if(fieldTypeAttribute != null)
                {
                    if(!fieldTypeAttribute.toString().equals("class java.lang.String") && !fieldTypeAttribute.toString().equals("class java.lang.Character"))
                        atributo = (new StringBuilder()).append(" UPPER(FUNC('TO_CHAR',").append(atributo).append(", '999999999999999D')").append(") ").toString();
                    else
                        atributo = (new StringBuilder()).append(" UPPER(").append(atributo).append(") ").toString();
                } else
                {
                    atributo = (new StringBuilder()).append(" UPPER(").append(atributo).append(") ").toString();
                }
                parametro = (new StringBuilder()).append(" ").append(parametro).append(" ").toString();
            }
            if(criterio.equals(""))
            {
                criterio = (new StringBuilder()).append(criterio).append(" where (").append(atributo).append(" ").append(operador).append(parametro).toString();
                continue;
            }
            if(!oldAndOr.equals(andOr))
                criterio = (new StringBuilder()).append(criterio).append(") ").append(oldAndOr).append(" ( ").append(atributo).append(" ").append(operador).append(parametro).toString();
            else
                criterio = (new StringBuilder()).append(criterio).append(" ").append(oldAndOr).append(" ").append(atributo).append(" ").append(operador).append(parametro).toString();
        }

        if(!"".equals(criterio))
            criterio = (new StringBuilder()).append(criterio).append(" ) ").toString();
        querySentence = (new StringBuilder()).append(querySentence).append(criterio).toString();
        query = Beans.isDesignTime() ? null : ((Query) (AdministradorEntidades.getEntityManager(persistenceUnit).createQuery(querySentence, clazz)));
        utilizados.clear();
        Iterator iterator1 = filtros.iterator();
        do
        {
            if(!iterator1.hasNext())
                break;
            Filtro filtro1 = (Filtro)iterator1.next();
            String atributo = filtro1.getAtributo();
            String operador = filtro1.getOperador();
            Object valor = filtro1.getValor();
            if(operador.toUpperCase().equals("LIKE"))
            {
                valor = (new StringBuilder()).append("%").append(valor.toString().toUpperCase().trim()).append("%").toString();
                int dot = atributo.lastIndexOf(".");
                if(dot > -1)
                    atributo = atributo.substring(dot + 1);
                if(utilizados.containsKey(atributo))
                {
                    int i = Integer.parseInt(utilizados.get(atributo).toString());
                    i++;
                    utilizados.put(atributo, Integer.valueOf(i));
                    atributo = (new StringBuilder()).append(atributo).append(i).toString();
                    utilizados.put(atributo, Integer.valueOf(i));
                } else
                {
                    utilizados.put(atributo, Integer.valueOf(0));
                }
                query.setParameter(atributo, valor);
            } else
            {
                try
                {
                    int dot = atributo.lastIndexOf(".");
                    Class fieldType;
                    if(dot == -1)
                    {
                        fieldType = clazz.getDeclaredField(atributo).getType();
                    } else
                    {
                        fieldType = getFieldType(clazz, atributo);
                        atributo = atributo.substring(atributo.lastIndexOf(".") + 1);
                    }
                    if(utilizados.containsKey(atributo))
                    {
                        int i = Integer.parseInt(utilizados.get(atributo).toString());
                        i++;
                        utilizados.put(atributo, Integer.valueOf(i));
                        atributo = (new StringBuilder()).append(atributo).append(i).toString();
                        utilizados.put(atributo, Integer.valueOf(i));
                    } else
                    {
                        utilizados.put(atributo, Integer.valueOf(0));
                    }
                    if(fieldType.isInstance(new String()))
                        query.setParameter(atributo, (String)valor);
                    else
                    if(fieldType.isInstance(Character.valueOf(" ".charAt(0))) || fieldType.getName().equals("char"))
                        query.setParameter(atributo, Character.valueOf(valor.toString().charAt(0)));
                    else
                    if(fieldType.isInstance(Boolean.valueOf("true")))
                        query.setParameter(atributo, (Boolean)valor);
                    else
                    if(fieldType.isInstance(new Date()))
                        query.setParameter(atributo, (Date)valor, TemporalType.DATE);
                    else
                    if(fieldType.isInstance(new Integer(0)))
                        query.setParameter(atributo, (Integer)valor);
                    else
                    if(fieldType.isInstance(new Double(0.0D)))
                        query.setParameter(atributo, (Double)valor);
                    else
                    if(fieldType.isInstance(new BigDecimal(0)))
                        query.setParameter(atributo, (BigDecimal)valor);
                    else
                    if(fieldType.isInstance(new Float("0")))
                        query.setParameter(atributo, (Float)valor);
                    else
                    if(fieldType.isInstance(new Long("0")))
                        query.setParameter(atributo, (Long)valor);
                    else
                    if(fieldType.isInstance(new Short("0")))
                        query.setParameter(atributo, (Short)valor);
                    else
                    if(fieldType.isInstance(new BigInteger("0")))
                        query.setParameter(atributo, (BigInteger)valor);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        } while(true);
        utilizados = null;
        return Beans.isDesignTime() ? Collections.emptyList() : query.getResultList();
    }

    public static List getListaObjetosByCriteria(String persistenceUnit, Class clazz, List filtros, String orden)
        throws Exception
    {
        String clazzName = clazz.getSimpleName();
        String criterio = "";
        String querySentence = (new StringBuilder()).append("SELECT c FROM ").append(clazzName).append(" c ").toString();
        Map utilizados = new HashMap();
        String ordenamiento = "";
        if(!orden.trim().equals(""))
            if(orden.indexOf(",") > -1)
            {
                String as[] = orden.split(",");
                int j = as.length;
                for(int k = 0; k < j; k++)
                {
                    String atributosOrden = as[k];
                    if(ordenamiento.equals(""))
                        ordenamiento = (new StringBuilder()).append("c.").append(atributosOrden).toString();
                    else
                        ordenamiento = (new StringBuilder()).append(ordenamiento).append(", c.").append(atributosOrden).toString();
                }

            } else
            {
                ordenamiento = (new StringBuilder()).append("c.").append(orden).toString();
            }
        String oldAndOr = "";
        String andOr;
        for(Iterator iterator = filtros.iterator(); iterator.hasNext(); oldAndOr = andOr)
        {
            Filtro filtro = (Filtro)iterator.next();
            String atributo = filtro.getAtributo();
            String parametro = filtro.getAtributo();
            String operador = filtro.getOperador();
            andOr = filtro.getAndOr().trim();
            Object fieldTypeAttribute = filtro.getFieldType();
            if(andOr.equals("") || andOr == null || !andOr.equals("OR") && !andOr.equals("AND"))
                andOr = "AND";
            int dot = parametro.lastIndexOf(".");
            if(dot > -1)
                parametro = parametro.substring(dot + 1);
            if(utilizados.containsKey(parametro))
            {
                int i = Integer.parseInt(utilizados.get(parametro).toString());
                i++;
                utilizados.put(parametro, Integer.valueOf(i));
                parametro = (new StringBuilder()).append(parametro).append(i).toString();
                utilizados.put(parametro, Integer.valueOf(i));
            } else
            {
                utilizados.put(parametro, Integer.valueOf(0));
            }
            parametro = (new StringBuilder()).append(" :").append(parametro).toString();
            atributo = (new StringBuilder()).append("c.").append(atributo).toString();
            if(operador.toUpperCase().equals("LIKE"))
            {
                if(fieldTypeAttribute != null)
                {
                    if(!fieldTypeAttribute.toString().equals("class java.lang.String") && !fieldTypeAttribute.toString().equals("class java.lang.Character"))
                        atributo = (new StringBuilder()).append(" UPPER(FUNC('TO_CHAR',").append(atributo).append(", '999999999999999D')").append(") ").toString();
                    else
                        atributo = (new StringBuilder()).append(" UPPER(").append(atributo).append(") ").toString();
                } else
                {
                    atributo = (new StringBuilder()).append(" UPPER(").append(atributo).append(") ").toString();
                }
                parametro = (new StringBuilder()).append(" ").append(parametro).append(" ").toString();
            }
            if(criterio.equals(""))
            {
                criterio = (new StringBuilder()).append(criterio).append(" where (").append(atributo).append(" ").append(operador).append(parametro).toString();
                continue;
            }
            if(!oldAndOr.equals(andOr))
                criterio = (new StringBuilder()).append(criterio).append(") ").append(oldAndOr).append(" ( ").append(atributo).append(" ").append(operador).append(parametro).toString();
            else
                criterio = (new StringBuilder()).append(criterio).append(" ").append(oldAndOr).append(" ").append(atributo).append(" ").append(operador).append(parametro).toString();
        }

        if(!"".equals(criterio))
            criterio = (new StringBuilder()).append(criterio).append(" ) ").toString();
        querySentence = (new StringBuilder()).append(querySentence).append(criterio).toString();
        if(!ordenamiento.equals(""))
            querySentence = (new StringBuilder()).append(querySentence).append(" order by ").append(ordenamiento).toString();
        query = Beans.isDesignTime() ? null : AdministradorEntidades.getEntityManager(persistenceUnit).createQuery(querySentence);
        utilizados.clear();
        Iterator iterator1 = filtros.iterator();
        do
        {
            if(!iterator1.hasNext())
                break;
            Filtro filtro1 = (Filtro)iterator1.next();
            String atributo = filtro1.getAtributo();
            String operador = filtro1.getOperador();
            Object valor = filtro1.getValor();
            if(operador.toUpperCase().equals("LIKE"))
            {
                valor = (new StringBuilder()).append("%").append(valor.toString().toUpperCase().trim()).append("%").toString();
                int dot = atributo.lastIndexOf(".");
                if(dot > -1)
                    atributo = atributo.substring(dot + 1);
                if(utilizados.containsKey(atributo))
                {
                    int i = Integer.parseInt(utilizados.get(atributo).toString());
                    i++;
                    utilizados.put(atributo, Integer.valueOf(i));
                    atributo = (new StringBuilder()).append(atributo).append(i).toString();
                    utilizados.put(atributo, Integer.valueOf(i));
                } else
                {
                    utilizados.put(atributo, Integer.valueOf(0));
                }
                query.setParameter(atributo, valor);
            } else
            {
                int dot = atributo.lastIndexOf(".");
                Class fieldType;
                if(dot == -1)
                {
                    try
                    {
                        fieldType = clazz.getDeclaredField(atributo).getType();
                    }
                    catch(NoSuchFieldException e)
                    {
                        fieldType = clazz.getSuperclass().getDeclaredField(atributo).getType();
                    }
                } else
                {
                    fieldType = getFieldType(clazz, atributo);
                    atributo = atributo.substring(atributo.lastIndexOf(".") + 1);
                }
                if(utilizados.containsKey(atributo))
                {
                    int i = Integer.parseInt(utilizados.get(atributo).toString());
                    i++;
                    utilizados.put(atributo, Integer.valueOf(i));
                    atributo = (new StringBuilder()).append(atributo).append(i).toString();
                    utilizados.put(atributo, Integer.valueOf(i));
                } else
                {
                    utilizados.put(atributo, Integer.valueOf(0));
                }
                if(fieldType.isInstance(new String()))
                    query.setParameter(atributo, (String)valor);
                else
                if(fieldType.isInstance(Character.valueOf(" ".charAt(0))) || fieldType.getName().equals("char"))
                    query.setParameter(atributo, Character.valueOf(valor.toString().charAt(0)));
                else
                if(fieldType.isInstance(Boolean.valueOf("true")))
                    query.setParameter(atributo, (Boolean)valor);
                else
                if(fieldType.isInstance(new Date()))
                    query.setParameter(atributo, (Date)valor, TemporalType.DATE);
                else
                if(fieldType.isInstance(new Integer(0)))
                    query.setParameter(atributo, (Integer)valor);
                else
                if(fieldType.isInstance(new Double(0.0D)))
                    query.setParameter(atributo, (Double)valor);
                else
                if(fieldType.isInstance(new BigDecimal(0)))
                    query.setParameter(atributo, (BigDecimal)valor);
                else
                if(fieldType.isInstance(new Float("0")))
                    query.setParameter(atributo, (Float)valor);
                else
                if(fieldType.isInstance(new Long("0")))
                    query.setParameter(atributo, (Long)valor);
                else
                if(fieldType.isInstance(new Short("0")))
                    query.setParameter(atributo, (Short)valor);
                else
                if(fieldType.isInstance(new BigInteger("0")))
                    query.setParameter(atributo, (BigInteger)valor);
            }
        } while(true);
        utilizados = null;
        return query.getResultList();
    }

    private String getClassName(Class clazz)
    {
        String className = null;
        try
        {
            className = clazz.getSimpleName();
        }
        catch(Exception ex) { }
        return className;
    }

    private static Class getFieldType(Class clase, String cadena)
    {
        Class fieldClass = null;
        try
        {
            if(cadena.contains("."))
            {
                int dot = cadena.indexOf(".");
                String primera = cadena.substring(0, dot);
                String nuevaCadena = cadena.substring(dot + 1);
                String claseCreada = null;
                try
                {
                    claseCreada = clase.getDeclaredField(primera).getType().getName();
                }
                catch(NoSuchFieldException nsfe)
                {
                    claseCreada = clase.getSuperclass().getDeclaredField(primera).getType().getName();
                }
                Class internalClass = Class.forName(claseCreada);
                fieldClass = getFieldType(internalClass, nuevaCadena);
            } else
            {
                fieldClass = clase.getDeclaredField(cadena).getType();
            }
        }
        catch(Exception e) { }
        return fieldClass;
    }

    public String getEntityFromClassName(Class clazz)
    {
        String entityName = null;
        try
        {
            Table table = (Table)clazz.getAnnotation(javax/persistence/Table);
            entityName = table.name();
        }
        catch(Exception ex) { }
        return entityName;
    }

    public static Object getObjectByIdService(String persistenceUnit, Class clazz, Object id)
    {
        return AdministradorEntidades.getEntityManager(persistenceUnit).find(clazz, id);
    }

    public List getListObjectsService(Class clazz)
    {
        query = em.createQuery((new StringBuilder()).append("SELECT e FROM ").append(getClassName(clazz)).append(" e").toString(), clazz);
        return query.getResultList();
    }

    public Object saveObjectService(Object object)
    {
        try
        {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        }
        catch(Exception ex)
        {
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
        }
        return object;
    }

    public void saveAllObjectService()
    {
        try
        {
            em.getTransaction().commit();
            em.getTransaction().begin();
        }
        catch(Exception ex) { }
    }

    public static void guardarListaObjetos(String persistenceUnit, List objects)
    {
        EntityManager entityManager = AdministradorEntidades.getEntityManager(persistenceUnit);
        try
        {
            entityManager.getTransaction().begin();
            Object o;
            for(Iterator iterator = objects.iterator(); iterator.hasNext(); entityManager.persist(o))
                o = iterator.next();

            entityManager.getTransaction().commit();
        }
        catch(PersistenceException ex)
        {
            if(entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
            throw ex;
        }
    }

    public Object updateObjectService(Object object)
    {
        try
        {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        }
        catch(Exception ex)
        {
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
        }
        return object;
    }

    public boolean deleteObjectByIdService(String persistenceUnit, Class clazz, Object id)
    {
        boolean successRemove = false;
        try
        {
            Object object = getObjectByIdService(persistenceUnit, clazz, id);
            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
            successRemove = true;
        }
        catch(Exception ex)
        {
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
        }
        return successRemove;
    }

    public void closeEntityManager()
    {
        try
        {
            em.close();
            if(!em.isOpen());
        }
        catch(Exception ex) { }
    }

    public void closeEntityManagerAndFactory()
    {
        try
        {
            em.close();
            if(!em.isOpen());
        }
        catch(Exception ex) { }
    }



    private EntityManager em;
    private static Query query;*/
}
