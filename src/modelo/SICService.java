/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author GALICIA
 */
public class SICService {
   private static ServCuenta servCuenta;
   

    public static ServCuenta getServCuenta() {
       if(servCuenta==null)
           SICService.servCuenta=new ServCuenta();
       return servCuenta;
    }   
    
}
