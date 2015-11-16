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
        
Movimiento movimiento=new Movimiento();
movimiento.setIdMovimiento(BigDecimal.ZERO);
movimiento.setCantidad(199);
Cuenta c= SICService.getServCuenta().getCuentaById("110102");

movimiento.setCuenta(c);
movimiento.setTipo("D");
movimiento.setFecha(new Date());


if(SICService.getServMovimiento().guardar(movimiento))
                System.out.println("ok");
else
                System.out.println("MT");
        
    }
}
