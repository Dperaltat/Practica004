/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica004.controlador;

import Practica004.modelo.Actor;
import Practica004.modelo.Rol;
import Practica004.modelo.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class GestionDato {
    
    private List<Usuario> usuarioList;
    private List<Actor> actorList;
    private List<Rol> rolList;

    public GestionDato(List<Usuario> usuarioList, List<Actor> actorList, List<Rol> rolList) {
        this.usuarioList = usuarioList;
        this.actorList = actorList;
        this.rolList = rolList;
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

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }

    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }
       public boolean addActor(Actor ac) {
        return this.actorList.add(ac);
    }
          public boolean addRol(Rol rol) {
        return this.rolList.add(rol);
    }
    
     
          

}
