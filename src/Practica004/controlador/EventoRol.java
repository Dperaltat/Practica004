/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica004.controlador;

import Practica004.modelo.Actor;
import Practica004.modelo.Pelicula;
import Practica004.modelo.Rol;
import Practica004.vista.VentanaRol;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.geometry.Side;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class EventoRol implements ActionListener
{
    private VentanaRol VentRol;
    private Actor actor;
    private Pelicula pelicula;

    public EventoRol(VentanaRol VentRol) {
        this.VentRol = VentRol;
    }

    public VentanaRol getVentRol() {
        return VentRol;
    }

    public void setVentRol(VentanaRol VentRol) {
        this.VentRol = VentRol;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource().equals(this.VentRol.getBotonList().get(0))) 
            {
                try{
             
                Long id = Long.parseLong(this.VentRol.getTxtList().get(0).getText()); 
                
                int numActor = this.VentRol.getComboActor().getSelectedIndex();
                this.actor = this.VentRol.getGestionDato().getActorList().get(numActor);
              
                int numRol = this.VentRol.getComboPelicula().getSelectedIndex();
                this.pelicula = this.VentRol.getGestionDato().getPeliculaList().get(numRol);
                
                String papel = this.VentRol.getTxtList().get(1).getText();
                Rol r = new Rol(id,this.actor, papel, this.pelicula);
                
                System.err.println(id +"+"+this.actor +"+"+papel +"+"+this.pelicula);
                BaseDatos BD = new BaseDatos ();
                int i = 0;
                boolean ban = true;
                for (Rol ca : this.VentRol.getGestionDato().getRolList()) 
                {
                    if(r.getActor().equals(this.VentRol.getGestionDato().getRolList().get(i).getActor()) && r.getPapel().equals(this.VentRol.getGestionDato().getRolList().get(i).getPapel()) ) 
                    {
                        ban = false;
                        JDialog d = new JDialog();
                        d.setTitle("Error");
                        d.getContentPane().add(new JLabel("Ya existe."));
                        d.setSize(120, 100);
                        d.setLocation(830, 400);
                        d.setVisible(true);
                        break;
                    }
                    i++;
                }
                if (ban == true) 
                {
                    this.VentRol.getGestionDato().addRol(r);
                    
                    BD.insertarRol(r);//cosas
                    
                    System.err.println("Rol Guardado.");
                       System.err.println("Rol Guardado.");

                    
                }
                Object[][] dato = this.VentRol.cargaDatosTabla(this.VentRol.getGestionDato().getRolList().size(), 4);
                this.VentRol.setDatos(dato);
                this.VentRol.getModeloTabla().setDataVector(this.VentRol.getDatos(), this.VentRol.getEncabezado());
              
              
                } catch(NullPointerException | NumberFormatException | ArrayIndexOutOfBoundsException ae)
            {
                 JOptionPane.showMessageDialog(null, "Datos Incorrectos");
            }
            }
          if (e.getSource().equals(this.VentRol.getBotonList().get(1))) 
            {
                this.VentRol.getTxtList().get(0).setText("");
            }
    }
}
