/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIC.Entidades;

import SIC.Service.SICService;
import SIC.Service.ServUsuario;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author dannier
 */
public class PruebaServicio {

    public static void main(String[] args) {
        // TODO code application logic here
        
        Usuario usuario=new Usuario();
        usuario.setCarnet("gc19384");
        usuario.setClave("algo");
        
        SICService.getServUsuario().guardar(usuario);
    }
}
