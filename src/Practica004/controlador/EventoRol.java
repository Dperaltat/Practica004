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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JLabel;

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
                FileOutputStream ae = null;
            try {
                int numActor = this.VentRol.getComboActor().getSelectedIndex();
                this.actor = this.VentRol.getGestionDato().getActorList().get(numActor);
              
                int numRol = this.VentRol.getComboPelicula().getSelectedIndex();
                this.pelicula = this.VentRol.getGestionDato().getPeliculaList().get(numRol);
                
                String papel = this.VentRol.getTxtList().get(0).getText();
                Rol r = new Rol(this.actor, papel, this.pelicula);
                int i = 0;
                boolean ban = true;
                for (Rol ca : this.VentRol.getGestionDato().getRolList()) 
                {
                    if(r.getActor().equals(this.VentRol.getGestionDato().getRolList().get(i).getActor()) && r.getPapel().equals(this.VentRol.getGestionDato().getRolList().get(i).getPapel()) ) 
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
                    this.VentRol.getGestionDato().addRol(r);
                }
                Object[][] dato = this.VentRol.cargaDatosTabla(this.VentRol.getGestionDato().getRolList().size(), 3);
                this.VentRol.setDatos(dato);
                this.VentRol.getModeloTabla().setDataVector(this.VentRol.getDatos(), this.VentRol.getEncabezado());
                ae = new FileOutputStream("C:/carpetaPractica04/DatosRol.txt",true);
                ObjectOutputStream escritura= new ObjectOutputStream(ae);
                escritura.writeObject(r);
                escritura.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(EventoRol.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(EventoRol.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    ae.close();
                } catch (IOException ex) {
                    Logger.getLogger(EventoRol.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
         
            }
    }
}
