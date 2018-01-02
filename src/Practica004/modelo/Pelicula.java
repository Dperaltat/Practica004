
package Practica004.modelo;

import java.io.Serializable;


/**
 *
 * @author Daniel
 */
public class Pelicula implements Serializable{
    
    private String nombre;
    private String genero;
    private int anio;
    private int numEntregas;

    public Pelicula() {
    }

    public Pelicula(String nombre, String genero, int anio, int numEntregas) {
        
        this.nombre = nombre;
        this.genero = genero;
        this.anio = anio;
        this.numEntregas = numEntregas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getNumEntregas() {
        return numEntregas;
    }

    public void setNumEntregas(int numEntregas) {
        this.numEntregas = numEntregas;
    }

    @Override
    public String toString() {
        return nombre ;
    }
    
}
