/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica004.controlador;

import Practica004.modelo.Usuario;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class GestionDato {
    
    private List<Usuario> usuarioList;

    public GestionDato(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }
    
    public boolean addUsuario(Usuario usuario) {
        return this.usuarioList.add(usuario);
    }
    
}
