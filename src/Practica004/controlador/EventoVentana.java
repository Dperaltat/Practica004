/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica004.controlador;

import Practica004.vista.VentanaActor;
import Practica004.vista.VentanaPelicula;
import Practica004.vista.VentanaPrincipal;
import Practica004.vista.VentanaReseña;
import Practica004.vista.VentanaRol;
import Practica004.vista.VentanaUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Daniel
 */
public class EventoVentana implements ActionListener {

    private VentanaPrincipal VentPri;

    public EventoVentana(VentanaPrincipal VentPri) {
        this.VentPri = VentPri;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource().equals(this.VentPri.getMenuItemList().get(0))) {
            System.err.println("Ventana Usuario");
            VentanaUsuario VenUs = new VentanaUsuario(this.VentPri.getGestionDato());
            VenUs.setVisible(true);
            this.VentPri.getEscritorio().add(VenUs);
        } else if (e.getSource().equals(this.VentPri.getMenuItemList().get(1))) {
            System.err.println("Ventana Pelicula");
            VentanaPelicula vP = new VentanaPelicula(this.VentPri.getGestionDato());
            vP.setVisible(true);
            this.VentPri.getEscritorio().add(vP);
        } else if (e.getSource().equals(this.VentPri.getMenuItemList().get(2))) {
            System.err.println("Ventana Actor");
            VentanaActor VenAc = new VentanaActor(this.VentPri.getGestionDato());
            VenAc.setVisible(true);
            this.VentPri.getEscritorio().add(VenAc);

        } else if (e.getSource().equals(this.VentPri.getMenuItemList().get(3))) {
            System.err.println("Ventana Rol");
            VentanaRol VenRol = new VentanaRol(this.VentPri.getGestionDato());
            VenRol.setVisible(true);
            this.VentPri.getEscritorio().add(VenRol);
        } else if (e.getSource().equals(this.VentPri.getMenuItemList().get(4))) {
            System.err.println("Ventana Reseña");
            VentanaReseña ventanaReseña = new VentanaReseña(this.VentPri.getGestionDato());
            ventanaReseña.setVisible(true);
            this.VentPri.getEscritorio().add(ventanaReseña);
        }

    }

}
