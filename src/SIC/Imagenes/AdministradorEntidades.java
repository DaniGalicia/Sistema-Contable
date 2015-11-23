// Decompiled by DJ v3.12.12.100 Copyright 2015 Atanas Neshkov  Date: 22/11/2015 23:59:09
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   AdministradorEntidades.java

package sv.gob.mined.accesodatos;

import javax.persistence.*;

public class AdministradorEntidades
{

    public AdministradorEntidades()
    {
    }

    public static EntityManager getEntityManager(String pu)
    {
        if(pu.equalsIgnoreCase("ISEPU"))
        {
            if(iseEntityManager == null)
            {
                iseEntityManager = Persistence.createEntityManagerFactory("isepu").createEntityManager();
                iseEntityManager.setFlushMode(FlushModeType.AUTO);
            }
            return iseEntityManager;
        }
        if(pu.equalsIgnoreCase("seguridadpu"))
        {
            if(seguridadEntityManager == null)
                seguridadEntityManager = Persistence.createEntityManagerFactory("seguridadpu").createEntityManager();
            return seguridadEntityManager;
        }
        if(pu.equalsIgnoreCase("catalogospu"))
        {
            if(catalogosEntityManager == null)
                catalogosEntityManager = Persistence.createEntityManagerFactory("catalogospu").createEntityManager();
            return catalogosEntityManager;
        }
        if(pu.equalsIgnoreCase("WSSAEPU-BODEGAS"))
        {
            if(bodegasEntityManager == null)
                bodegasEntityManager = Persistence.createEntityManagerFactory("WSSAEPU-BODEGAS").createEntityManager();
            return bodegasEntityManager;
        }
        if(pu.equalsIgnoreCase("entidades-sae-testPU"))
        {
            if(saeTestEntityManager == null)
                saeTestEntityManager = Persistence.createEntityManagerFactory("entidades-sae-testPU").createEntityManager();
            return saeTestEntityManager;
        }
        if(pu.equalsIgnoreCase("finanzaspu"))
        {
            if(finanzasEntityManager == null)
                finanzasEntityManager = Persistence.createEntityManagerFactory("finanzaspu").createEntityManager();
            return finanzasEntityManager;
        }
        if(pu.equalsIgnoreCase("comunespu"))
        {
            if(comunesEntityManager == null)
                comunesEntityManager = Persistence.createEntityManagerFactory("comunespu").createEntityManager();
            return comunesEntityManager;
        }
        if(pu.equalsIgnoreCase("bodegaspu"))
        {
            if(bodegasv2EntityManager == null)
                bodegasv2EntityManager = Persistence.createEntityManagerFactory("bodegaspu").createEntityManager();
            return bodegasv2EntityManager;
        } else
        {
            return null;
        }
    }

    private static EntityManager iseEntityManager;
    private static EntityManager seguridadEntityManager;
    private static EntityManager catalogosEntityManager;
    private static EntityManager bodegasEntityManager;
    private static EntityManager finanzasEntityManager;
    private static EntityManager saeTestEntityManager;
    private static EntityManager comunesEntityManager;
    private static EntityManager bodegasv2EntityManager;
}
