
package Practica004.controlador;

import Practica004.modelo.Pelicula;
import Practica004.modelo.Reseña;
import Practica004.modelo.Usuario;
import Practica004.vista.VentanaReseña;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class EventoReseña implements ActionListener
{
    private VentanaReseña ventanaReseña;
    private Usuario usuario;
    private Pelicula pelicula;
    private GestionDato gd;
    
    public EventoReseña(VentanaReseña ventanaReseña) {
        this.ventanaReseña = ventanaReseña;
    }

    public VentanaReseña getVentanaReseña() {
        return ventanaReseña;
    }
    public void setVentanaReseña(VentanaReseña ventanaReseña) {
        this.ventanaReseña = ventanaReseña;
    }
    public GestionDato getGd() {
        return gd;
    }
    public void setGd(GestionDato gd) {
        this.gd = gd;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        try
        {
            
            if (e.getSource().equals(this.ventanaReseña.getBotonList().get(0))) 
            {               
                int numu = this.ventanaReseña.getComboUsuario().getSelectedIndex();
                this.usuario = this.ventanaReseña.getGestionDato().getUsuarioList().get(numu);
                int nump = this.ventanaReseña.getComboPelicula().getSelectedIndex();
                this.pelicula = this.ventanaReseña.getGestionDato().getPeliculaList().get(nump);
                int calificacion = Integer.parseInt(this.ventanaReseña.getTxtList().get(0).getText());
                String comentario = this.ventanaReseña.getTxtList().get(1).getText();
                
                Long id = Long.parseLong(this.ventanaReseña.getTxtList().get(2).getText());
                
                Reseña r = new Reseña(id,this.usuario, this.pelicula, calificacion,comentario);
                
                BaseDatos Bd = new BaseDatos();
                
                int i = 0;
                boolean ban = true;
                for (Reseña re : this.ventanaReseña.getGestionDato().getReseñaList()) 
                {
                    if(r.getUsuario().equals(this.ventanaReseña.getGestionDato().getReseñaList().get(i).getUsuario()) == true && r.getPelicula().equals(this.ventanaReseña.getGestionDato().getReseñaList().get(i).getPelicula()) == true) 
                    {
                        ban = false;
                        JDialog d = new JDialog();
                        d.setTitle("Error");
                        d.getContentPane().add(new JLabel("Ya exsiste"));
                        d.setSize(120, 100);
                        d.setLocation(830, 400);
                        d.setVisible(true);
                        break;
                    }
                    i++;                 
                }
                if (ban == true) 
                {
                    this.ventanaReseña.getGestionDato().addReseña(r);
                    Bd.insertarReseña(r);
                    System.err.println("Reseña Guardada");
                }
                
                Object[][] datoReseña = this.ventanaReseña.cargaDatosTabla(this.ventanaReseña.getGestionDato().getReseñaList().size(), 5);
                this.ventanaReseña.setDatos(datoReseña);
                this.ventanaReseña.getModeloTabla().setDataVector(this.ventanaReseña.getDatos(), this.ventanaReseña.getEncabezado());
                
            }
            else  if (e.getSource().equals(this.ventanaReseña.getBotonList().get(1))) 
            {
                this.ventanaReseña.getTxtList().get(0).setText("");
                this.ventanaReseña.getTxtList().get(1).setText("");
                this.ventanaReseña.getTxtList().get(2).setText("");
                this.ventanaReseña.getTxtList().get(3).setText("");
            }
        }    
        catch (NumberFormatException ae1) 
        {
            JDialog d = new JDialog();
            d.setTitle("Error");
            d.getContentPane().add(new JLabel("Casilleros incorrectos"));
            d.setSize(120, 100);
            d.setLocation(830, 400);
            d.setVisible(true);
        } 
        catch (ArrayIndexOutOfBoundsException ae2) 
        {
            JDialog d = new JDialog();
            d.setTitle("Error");
            d.getContentPane().add(new JLabel("NO se han encontrado USUARIOS o PELICULAS"));
            d.setSize(320, 100);
            d.setLocation(830, 400);
            d.setVisible(true);
        }
            
    }
       
 }
        
    
