
package Practica004.modelo;

/**
 *
 * @author Daniel
 */
public class Actor implements java.io.Serializable
{
    
    private String Nombre;
    private String Cedula;
    private int nominaciones;
    private int premios;

    public Actor(String Nombre, String Cedula, int nominaciones, int premios) {
        this.Nombre = Nombre;
        this.Cedula = Cedula;
        this.nominaciones = nominaciones;
        this.premios = premios;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
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
        return  Nombre ;
    }

   

    
}
