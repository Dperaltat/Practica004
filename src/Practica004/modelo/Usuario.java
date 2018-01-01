package Practica004.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Daniel
 */
@Entity
public class Usuario extends Persona implements Serializable {

    @Id
    private long id;
    private int codigo;
    private String cedula;
    private String email;

    public Usuario(String nombre, String sexo, int edad, String nacionalidad, String cedula, int codigo, String email) {
        super(nombre, sexo, edad, nacionalidad);
        this.codigo = codigo;
        this.cedula = cedula;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

}

