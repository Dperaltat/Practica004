/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica004.vista;

import Practica004.controlador.EventoVentana;
import Practica004.controlador.GestionDato;
import java.util.ArrayList;
import java.util.List;
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
        
        this.escritorio= new JDesktopPane();
        this.barraMenu= new JMenuBar();
        this.menuList=new ArrayList<JMenu>();
        
        this.menuList.add(new JMenu("Usuario"));
        
        this.menuItemList = new  ArrayList<JMenuItem>();
        this.menuItemList.add(new JMenuItem("Agregar Usuario"));
        
        this.setContentPane(this.escritorio);
        this.setJMenuBar(barraMenu);
        
        this.barraMenu.add(this.menuList.get(0));
        this.menuList.get(0).add(this.menuItemList.get(0));
        
        this.menuItemList.get(0).addActionListener(new EventoVentana(this));
        
        
    }

    public GestionDato getGestionDato() {
        return gestionDato;
    }

    public void setGestionDato(GestionDato gestionDato) {
        this.gestionDato = gestionDato;
    }

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public JMenuBar getBarraMenu() {
        return barraMenu;
    }

    public void setBarraMenu(JMenuBar barraMenu) {
        this.barraMenu = barraMenu;
    }

    public List<JMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<JMenu> menuList) {
        this.menuList = menuList;
    }

    public ArrayList<JMenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(ArrayList<JMenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }
    
    
}
