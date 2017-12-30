
package Practica004.modelo;

import java.io.Serializable;



/**
 *
 * @author Daniel
 */

public class Actor implements Serializable
{
     
    
     
    private String nombre;
    private String Cedula;
    private int nominaciones;
    private  int premios;

    public Actor(String nombre, String Cedula, int nominaciones, int premios) {
        this.nombre = nombre;
        this.Cedula = Cedula;
        this.nominaciones = nominaciones;
        this.premios = premios;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public int getNominaciones() {
        return nominaciones;
    }

    public void setNominaciones(int nominaciones) {
        this.nominaciones = nominaciones;
    }

    public int getPremios() {
        return premios;
    }

    public void setPremios(int premios) {
        this.premios = premios;
    }

    @Override
    public String toString() {
        return  nombre ;
    }


    


    



   

    
}
