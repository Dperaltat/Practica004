/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica004.controlador;

import Practica004.modelo.Usuario;
import Practica004.vista.VentanaUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author Daniel
 */
public class EventoUsuario implements ActionListener {

    private VentanaUsuario ventanaUsuario;
    

    public EventoUsuario(VentanaUsuario ventanaUsuario) {
        this.ventanaUsuario = ventanaUsuario;
    }

    public VentanaUsuario getVentanaUsuario() {
        return ventanaUsuario;
    }

    public void setVentanaUsuario(VentanaUsuario ventanaUsuario) {
        this.ventanaUsuario = ventanaUsuario;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource().equals(this.ventanaUsuario.getBotonList().get(0))) {
                String nombre = this.ventanaUsuario.getTxtList().get(0).getText();
                String sexo = this.ventanaUsuario.getTxtList().get(1).getText();
                int edad = Integer.parseInt(this.ventanaUsuario.getTxtList().get(2).getText());
                String nacionalidad = this.ventanaUsuario.getTxtList().get(3).getText();
                String cedula = this.ventanaUsuario.getTxtList().get(4).getText();
                int codigo = Integer.parseInt(this.ventanaUsuario.getTxtList().get(5).getText());
                String email = this.ventanaUsuario.getTxtList().get(6).getText();
                
                Usuario u = new Usuario(nombre, sexo, edad, nacionalidad, cedula, codigo, email);
                
                BaseDatos bD = new BaseDatos();
                
                bD.insertarUsuario(u);
      
                int i = 0;
                boolean ban = true;

                for (Usuario us : this.ventanaUsuario.getGestionDato().getUsuarioList()) {
                    if (u.getId().equals(this.ventanaUsuario.getGestionDato().getUsuarioList().get(i).getId())) {

                        ban = false;
                        JDialog d = new JDialog();
                        d.setTitle("Error");
                        d.getContentPane().add(new JLabel("Datos ya existentes"));
                        d.setSize(120, 100);
                        d.setLocation(830, 400);
                        d.setVisible(true);
                        this.ventanaUsuario.getTxtList().get(0).setText("");
                        this.ventanaUsuario.getTxtList().get(1).setText("");
                        this.ventanaUsuario.getTxtList().get(2).setText("");
                        this.ventanaUsuario.getTxtList().get(3).setText("");
                        this.ventanaUsuario.getTxtList().get(4).setText("");
                        this.ventanaUsuario.getTxtList().get(5).setText("");
                        this.ventanaUsuario.getTxtList().get(6).setText("");
                        break;

                    }
                    i++;
                }

                if (ban == true) {
                    this.ventanaUsuario.getGestionDato().addUsuario(u);
                }

                Object[][] datoUsuario = this.ventanaUsuario.cargarDatosTabla(this.ventanaUsuario.getGestionDato().getUsuarioList().size(), 7);
                this.ventanaUsuario.setDatos(datoUsuario);
                this.ventanaUsuario.getModeloTabla().setDataVector(this.ventanaUsuario.getDatos(), this.ventanaUsuario.getEncabezado());

            } else {
                this.ventanaUsuario.getTxtList().get(0).setText("");
                this.ventanaUsuario.getTxtList().get(1).setText("");
                this.ventanaUsuario.getTxtList().get(2).setText("");
                this.ventanaUsuario.getTxtList().get(3).setText("");
                this.ventanaUsuario.getTxtList().get(4).setText("");
                this.ventanaUsuario.getTxtList().get(5).setText("");
                this.ventanaUsuario.getTxtList().get(6).setText("");

            }

        } catch (Exception ae) {

            JDialog d = new JDialog();
            d.setTitle("Error");
            d.getContentPane().add(new JLabel("Ingrese correctamente la información el los casilleros"));
            d.setSize(120, 100);
            d.setLocation(830, 400);
            d.setVisible(true);

        }

    }

}
