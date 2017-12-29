package Practica004.vista;

import Practica004.controlador.GestionDato;
import Practica004.modelo.Actor;
import Practica004.modelo.Reseña;
import Practica004.modelo.Rol;
import Practica004.modelo.Pelicula;
import Practica004.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;


public class Principal 
{

    public static void main(String[] args) 
    {
        
        List<Usuario> usuario = new ArrayList<Usuario>();
        List<Actor> actor = new ArrayList<Actor>();
        List<Rol> rol = new ArrayList<Rol>();
        List<Reseña> reseña = new ArrayList<Reseña>();
        List<Pelicula> pelicula = new ArrayList<Pelicula>();
        
        GestionDato gD = new GestionDato(usuario,actor,rol,reseña, pelicula);
      
        VentanaPrincipal VentPri = new VentanaPrincipal (gD);
        
    }
    
}
