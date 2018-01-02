
package Practica004.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Daniel
 */
@Entity
public class Rol implements Serializable
{
     @Id
    private Long id;
    private Actor actor;
    private String papel;
    private Pelicula pelicula; 

    public Rol() {
    }

    public Rol(Long id, Actor actor, String papel, Pelicula pelicula) {
        this.id = id;
        this.actor = actor;
        this.papel = papel;
        this.pelicula = pelicula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "Rol{" + "id=" + id + ", actor=" + actor + ", papel=" + papel + ", pelicula=" + pelicula + '}';
    }
   
    
  
    
    

    
    
}
