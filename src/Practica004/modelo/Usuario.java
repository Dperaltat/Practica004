package Practica004.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 *
 * @author Daniel
 */
@Entity
public class Usuario implements Serializable {

    @Id
    private Long id;
    private int codigo;
    private String email;
    private String nombre;
    private String sexo;
    private int edad;
    private String nacionalidad;

    public Usuario() {
        
    }
    
    public Usuario(String nombre, String sexo, int edad, String nacionalidad, Long id, int codigo, String email) {
        
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.codigo = codigo;
        this.id = id;
        this.email = email;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", codigo=" + codigo + ", email=" + email + ", nombre=" + nombre + ", sexo=" + sexo + ", edad=" + edad + ", nacionalidad=" + nacionalidad + '}';
    }
}

