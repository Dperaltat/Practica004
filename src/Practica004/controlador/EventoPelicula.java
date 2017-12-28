/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica004.controlador;

import Practica004.modelo.Pelicula;
import Practica004.vista.VentanaPelicula;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.annotation.Resource;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author Daniel
 */
public class EventoPelicula implements ActionListener {

    private VentanaPelicula ventanaPelicula;

    public EventoPelicula(VentanaPelicula ventanaPelicula) {
        this.ventanaPelicula = ventanaPelicula;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        try {

            if (ae.getSource().equals(this.ventanaPelicula.getBotonList().get(0))) {

                String nombre = this.ventanaPelicula.getTxtList().get(0).getText();
                String genero = this.ventanaPelicula.getTxtList().get(1).getText();
                int anio = Integer.parseInt(this.ventanaPelicula.getTxtList().get(2).getText());
                int entregas = Integer.parseInt(this.ventanaPelicula.getTxtList().get(3).getText());

                Pelicula p = new Pelicula(nombre, genero, anio, entregas);

            //Control Dato Repetido:
                int i = 0;
                boolean ban = true;
                for (Pelicula ps : this.ventanaPelicula.getGestionDato().getPeliculaList()) {
                    if (ps.getNombre().equals(p.getNombre()) == true && ps.getGenero().equals(p.getGenero()) == true && ps.getAnio() == p.getAnio()) {
                        ban = false;
                        JDialog d = new JDialog();
                        d.setTitle("Error");
                        d.getContentPane().add(new JLabel("       Esta Pelicula ya existe."));
                        d.setSize(320, 100);
                        d.setLocation(700, 500);
                        d.setVisible(true);
                        break;
                    }
                    i++;
                }
                if (ban == true) {
                    this.ventanaPelicula.getGestionDato().addPelicula(p);
                }

                Object[][] datoPelicula = this.ventanaPelicula.cargaDatosTabla(this.ventanaPelicula.getGestionDato().getPeliculaList().size(), 4);
                this.ventanaPelicula.setDatos(datoPelicula);
                this.ventanaPelicula.getModeloTabla().setDataVector(this.ventanaPelicula.getDatos(), this.ventanaPelicula.getEncabezado());

            } else if (ae.getSource().equals(this.ventanaPelicula.getBotonList().get(1))) {

                this.ventanaPelicula.getTxtList().get(0).setText("");
                this.ventanaPelicula.getTxtList().get(1).setText("");
                this.ventanaPelicula.getTxtList().get(2).setText("");
                this.ventanaPelicula.getTxtList().get(3).setText("");

            }

        } catch (NumberFormatException e) {
            JDialog d = new JDialog();
            d.setTitle("Error");
            d.getContentPane().add(new JLabel("   Los casilleros NO se han llenado correctamente."));
            d.setSize(320, 100);
            d.setLocation(700, 500);
            d.setBackground(Color.RED);
            d.setVisible(true);
        }

    }

}
