
package Practica004.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Actor implements Serializable
{
    @Id
    private Long id;
    private String nombre;
    private int nominaciones;
    private  int premios;

    public Actor() {
    }

    public Actor(Long id, String nombre, int nominaciones, int premios) {
        this.id = id;
        this.nombre = nombre;
        this.nominaciones = nominaciones;
        this.premios = premios;
    }
 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return "Actor{" + "id=" + id + ", nombre=" + nombre + ", nominaciones=" + nominaciones + ", premios=" + premios + '}';
    }

 
    
    }


    


    



   

    

