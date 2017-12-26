/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica004.controlador;

import Practica004.vista.VentanaPrincipal;
import Practica004.vista.VentanaUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Daniel
 */
public class EventoVentana implements ActionListener{
    
    private VentanaPrincipal VentPri;
    
    public EventoVentana (VentanaPrincipal VentPri){
        this.VentPri = VentPri;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource().equals(this.VentPri.getMenuItemList().get(0))) 
        {
            System.err.println("Ventana Usuario");
            VentanaUsuario VenUs = new VentanaUsuario(this.VentPri.getGestionDato());
            VenUs.setVisible(true);
            this.VentPri.getEscritorio().add(VenUs);
          
        }
        
    }
    
}
