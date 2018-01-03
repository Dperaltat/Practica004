
package Practica004.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reseña implements Serializable
{
    @Id
    private Long id;
    private Usuario usuario;
    private Pelicula pelicula;
    private int calificacion;
    private String comentario;

    public Reseña() {
    }
   
    public Reseña(Long id, Usuario usuario, Pelicula pelicula, int calificacion, String comentario) {
        this.id = id;
        this.usuario = usuario;
        this.pelicula = pelicula;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Rese\u00f1a{" + "id=" + id + ", usuario=" + usuario + ", pelicula=" + pelicula + ", calificacion=" + calificacion + ", comentario=" + comentario + '}';
    }
    
    
    
}
