/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica004.controlador;

import Practica004.modelo.Actor;
import Practica004.vista.VentanaActor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class EventoActor implements ActionListener
{
private VentanaActor VentActor;

    public EventoActor(VentanaActor VentActor) {
        this.VentActor = VentActor;
    }

    public VentanaActor getVentActor() {
        return VentActor;
    }

    public void setVentActor(VentanaActor VentActor) {
        this.VentActor = VentActor;
    }
    

    
    @Override
    public void actionPerformed (ActionEvent e) 
    {
        if (e.getSource().equals(this.VentActor.getBotonList().get(0))) 
            {
            
            try{
               
            
                String nombre = this.VentActor.getTxtList().get(0).getText();
                String cedula = this.VentActor.getTxtList().get(1).getText();
                int nominacion = Integer.parseInt(this.VentActor.getTxtList().get(2).getText());
                int premios  = Integer.parseInt(this.VentActor.getTxtList().get(3).getText());
                Actor a = new Actor(nombre,cedula, nominacion, premios);
                int i = 0;
                boolean ban = true;
                for (Actor ca : this.VentActor.getGestionDato().getActorList()) 
                {
                    if(a.getCedula().equals(this.VentActor.getGestionDato().getActorList().get(i).getCedula()) ) 
                    {
                        ban = false;
                        JDialog d = new JDialog();
                        d.setTitle("Error");
                        d.getContentPane().add(new JLabel("Ya existe"));
                        d.setSize(120, 100);
                        d.setLocation(830, 400);
                        d.setVisible(true);
                        break;
                    }
                    i++;
                }
                if (ban == true) 
                {
                    this.VentActor.getGestionDato().addActor(a);
                }
                Object[][] dato = this.VentActor.cargaDatosTabla(this.VentActor.getGestionDato().getActorList().size(), 4);
                this.VentActor.setDatos(dato);
                this.VentActor.getModeloTabla().setDataVector(this.VentActor.getDatos(), this.VentActor.getEncabezado());
    
            }
            catch(NullPointerException | NumberFormatException ae)
            {
                 JOptionPane.showMessageDialog(null, "Datos Incorrectos.");
            }
                     
            }
        if (e.getSource().equals(this.VentActor.getBotonList().get(1))) 
            {
                this.VentActor.getTxtList().get(0).setText("");
                this.VentActor.getTxtList().get(1).setText("");
                
                 this.VentActor.getTxtList().get(2).setText("");
                this.VentActor.getTxtList().get(3).setText("");
            }
    }
    
}
 
