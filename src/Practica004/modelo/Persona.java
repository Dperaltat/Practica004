
package Practica004.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Daniel
 */

public class Persona implements Serializable {
  
    private String nombre;
    private String sexo;
    private int edad;
    private String nacionalidad;

    public Persona(String nombre, String sexo, int edad, String nacionalidad) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    
    
}
