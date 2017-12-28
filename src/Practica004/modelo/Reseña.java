
package Practica004.modelo;

/**
 *
 * @author Daniel
 */
public class Reseña implements java.io.Serializable
{
    
    private Usuario usuario;
    private Pelicula pelicula;
    private int calificacion;
    private String comentario;

    public Reseña(Usuario usuario, Pelicula pelicula, int calificacion, String comentario) {
        this.usuario = usuario;
        this.pelicula = pelicula;
        this.calificacion = calificacion;
        this.comentario = comentario;
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
    public double getCalificacion() {
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
    public String toString() 
    {
        return "Rese\u00f1a{" + "usuario=" + usuario + ", pelicula=" + pelicula + ", calificacion=" + calificacion + ", comentario=" + comentario + '}';
    }
    
    
    
}
