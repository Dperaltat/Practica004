
package Practica004.modelo;

/**
 *
 * @author Daniel
 */
public class Rol implements java.io.Serializable
{
    
    private Actor actor;
    private String papel;
    private Pelicula pelicula; 

    public Rol(Actor actor, String papel, Pelicula pelicula) {
        this.actor = actor;
        this.papel = papel;
        this.pelicula = pelicula;
    }
    
    

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "Rol{" + "actor=" + actor + ", papel=" + papel + ", pelicula=" + pelicula + '}';
    }
    
}
