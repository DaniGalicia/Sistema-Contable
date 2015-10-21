/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GALICIA
 */
public class EstadoFinanciero {

    /*private String nombre;
    private List<Cuenta> cuentas = new ArrayList<>();

    public EstadoFinanciero(String nombre, List<Cuenta> cuentas) {
        this.nombre = nombre;
        this.cuentas = cuentas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public double saldar() {
        double res = 0;
        for (Cuenta cuenta : cuentas) {
            res += cuenta.saldar();
        }
        return res;
    }

    public String toString() {
        String cadena = "";
        for (Cuenta cuenta : cuentas) {
            if (cuenta.saldar() > 0 || cuenta.saldar() < 0) {
                cadena += cuenta.getNombre() + "\t";

                if (cuenta.saldar() < 0)
                    cadena += "\t";

                cadena += Math.abs(cuenta.saldar()) +"\n";
                

            }
        }
        return cadena;
    }*/
}
