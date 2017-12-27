
package Practica004.modelo;

/**
 *
 * @author Daniel
 */
public class Actor implements java.io.Serializable
{
    
    private Persona persona;
    private int nominaciones;
    private int premios;

    public Actor(Persona persona, int nominaciones, int premios) {
        this.persona = persona;
        this.nominaciones = nominaciones;
        this.premios = premios;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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
        return "Actor{" + "persona=" + persona + ", nominaciones=" + nominaciones + ", premios=" + premios + '}';
    }
    
}
