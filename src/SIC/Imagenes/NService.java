// Decompiled by DJ v3.12.12.100 Copyright 2015 Atanas Neshkov  Date: 23/11/2015 0:02:14
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   NService.java

package sv.gob.mined.accesodatos.service;

import java.util.List;

public interface NService
{

    public abstract List getExportacion(Object obj);

    public abstract List getListado();

    public abstract boolean guardar(Object obj);

    public abstract Object getObjeto(Class class1, Object obj);

    public abstract boolean eliminar(Object obj);
}
