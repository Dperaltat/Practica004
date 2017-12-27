/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica004.vista;

import Practica004.controlador.EventoActor;
import Practica004.controlador.GestionDato;
import Practica004.modelo.Actor;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class VentanaActor extends JInternalFrame
{
    private GestionDato gestionDato;
    private JComboBox comboPersona;
    private List<JLabel> etiList;
    private List<JTextField> txtList;
    private List<JButton> botonList;
    private JPanel panel;
    private JScrollPane scroll;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private Object[] encabezado;
    private Object[][] datos;

    public VentanaActor(GestionDato gestionDato)
    {
        super("Registro Actor",true,true,true,true);
        this.gestionDato = gestionDato;
        this.iniciaComponente();
        this.setLocation(170, 50);
        this.setSize(600, 450);
    }
    public void iniciaComponente() 
    {
       this.etiList= new ArrayList<JLabel>();
        this.txtList= new ArrayList<JTextField>();
        this.botonList= new ArrayList<JButton>();
        JPanel panel = new JPanel(new FlowLayout());
        this.comboPersona = new JComboBox();
        
        this.etiList.add(new JLabel("Persona:"));
        this.etiList.add(new JLabel("Nominacion:"));
        this.etiList.add(new JLabel("# Premios"));
        
        this.txtList.add(new JTextField(15));
        this.txtList.add(new JTextField(15));
        
        this.botonList.add(new JButton("Guardar"));
        this.botonList.add(new JButton("Limpiar"));
        
        this.encabezado = new Object[3];               
        this.encabezado[0] = "Persona";
        this.encabezado[1] = "Nominacion";
        this.encabezado[2] = " # Premios";
        
        this.datos = cargaDatosTabla(this.gestionDato.getActorList().size(),3);
        
        this.modeloTabla = new DefaultTableModel(this.datos, this.encabezado);        
        this.tabla = new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);
        
        panel.add(this.etiList.get(0));
       panel.add(this.comboPersona);
        panel.add(this.etiList.get(1));
        panel.add(this.txtList.get(0));
        panel.add(this.etiList.get(2));
        panel.add(this.txtList.get(1));
        panel.add(this.botonList.get(0));
        panel.add(this.botonList.get(1));
        panel.add(this.scroll);
        
        this.botonList.get(0).addActionListener(new EventoActor(this));
        this.botonList.get(1).addActionListener(new EventoActor(this));
        
        this.add(panel);
    }
    
    public String[] cargaComboPersona() {       
        return null;
    /*    String[] retorno = new String[this.gestionDato.getAspiranteList().size()];
        int i=0;
        for(Aspirante a: this.gestionDato.getAspiranteList()) {
            retorno[i] = a.getNombre() + " " + a.getApellido() + " - CI: " + a.getCedula();
            i++;
        }
        return retorno;*/
    }
    public Object[][] cargaDatosTabla(int m, int n) {
        Object[][] retorno = new Object[m][n];
        int i=0;
        for(Actor e:this.gestionDato.getActorList())
        {
            retorno[i][0] = e.getNominaciones();
            retorno[i][1] = e.getPersona();
            retorno[i][2] = e.getPremios();
            i++;
        }        
        return retorno;
    }

    public GestionDato getGestionDato() {
        return gestionDato;
    }

    public void setGestionDato(GestionDato gestionDato) {
        this.gestionDato = gestionDato;
    }

    public JComboBox getComboPersona() {
        return comboPersona;
    }

    public void setComboPersona(JComboBox comboPersona) {
        this.comboPersona = comboPersona;
    }

    public List<JLabel> getEtiList() {
        return etiList;
    }

    public void setEtiList(List<JLabel> etiList) {
        this.etiList = etiList;
    }

    public List<JTextField> getTxtList() {
        return txtList;
    }

    public void setTxtList(List<JTextField> txtList) {
        this.txtList = txtList;
    }

    public List<JButton> getBotonList() {
        return botonList;
    }

    public void setBotonList(List<JButton> botonList) {
        this.botonList = botonList;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }
    
    
    
    
    
    
    
    
    
}
