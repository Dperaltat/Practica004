package Practica004.vista;

import Practica004.controlador.GestionDato;
import Practica004.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;


public class Principal 
{

    public static void main(String[] args) 
    {
        
        List<Usuario> usuario = new ArrayList<Usuario>();
        GestionDato gD = new GestionDato(usuario);
        VentanaPrincipal VentPri = new VentanaPrincipal (gD);
        
    }
    
}
