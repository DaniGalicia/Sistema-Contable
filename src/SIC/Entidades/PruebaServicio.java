/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Entidades;

import SIC.Service.SICService;
/**
 *
 * @author dannier
 */
public class PruebaServicio {

    public static void main(String[] args) {
        
        Empleado e=SICService.getServEmpleado().getEmpleadoByCodigo("34341");
        
        Usuario u=new Usuario(e.getCodigoEmpleado());
        u.setClave("admin");
        u.setUsuario("Hola");
        SICService.getServUsuario().guardar(u);
        
    }
}
