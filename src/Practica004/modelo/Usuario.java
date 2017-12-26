package Practica004.modelo;

/**
 *
 * @author Daniel
 */
public class Usuario extends Persona {

    private int codigo;
    private String id;
    private String email;

    public Usuario(String nombre, String sexo, int edad, String nacionalidad, String id, int codigo, String email) {
        super(nombre, sexo, edad, nacionalidad);
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
