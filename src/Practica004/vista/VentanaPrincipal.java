/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica004.vista;

import Practica004.controlador.GestionDato;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Daniel
 */
public class VentanaPrincipal extends JFrame
{
    private GestionDato gestionDato;
    private JDesktopPane escritorio;
    private JMenuBar barraMenu;
    private java.util.List<JMenu> menuList;
    private ArrayList<JMenuItem> menuItemList; 
    
    public VentanaPrincipal(GestionDato gD) 
    {
        super("Archivos");
        this.gestionDato = gD;
        this.setSize(800, 600);
        this.setLocation(500,250);
        this.iniciaComponente();
        this.setDefaultCloseOperation(3);
        this.setVisible(true);      
    }
    
    public void iniciaComponente()
    {
        
    }
}
