/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica004.vista;

import Practica004.controlador.EventoUsuario;
import Practica004.controlador.GestionDato;
import Practica004.modelo.Usuario;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class VentanaUsuario extends JInternalFrame {
    
    private GestionDato gestionDato;
    private List<JLabel> etiList;
    private List<JTextField> txtList;
    private List<JButton> botonList;
    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;
    private JPanel panel;
    
    public VentanaUsuario(GestionDato gestionDato){
        
        super("Registrar Usuario",true,true,true,true);
        this.gestionDato = gestionDato;
        this.iniciaComponente();
        this.setSize(700, 500);    
        
    }
    
    public void iniciaComponente(){
        
        this.etiList= new ArrayList<JLabel>();
        this.txtList= new ArrayList<JTextField>();
        this.botonList= new ArrayList<JButton>();
        JPanel panel = new JPanel(new FlowLayout());
        
        this.etiList.add(new JLabel("Nombre"));
        this.etiList.add(new JLabel("Sexo"));
        this.etiList.add(new JLabel("Edad"));
        this.etiList.add(new JLabel("Nacionalidad"));
        this.etiList.add(new JLabel("Cedula"));
        this.etiList.add(new JLabel("Codigo"));
        this.etiList.add(new JLabel("E-mail"));
        
        this.txtList.add(new JTextField(15));
        this.txtList.add(new JTextField(15));
        this.txtList.add(new JTextField(15));
        this.txtList.add(new JTextField(15));
        this.txtList.add(new JTextField(15));
        this.txtList.add(new JTextField(15));
        this.txtList.add(new JTextField(15));
        
        this.botonList.add(new JButton("Guardar"));
        this.botonList.add(new JButton("Limpiar"));
        
        this.encabezado = new Object[7];               
        this.encabezado[0] = "Nombre";
        this.encabezado[1] = "Sexo";
        this.encabezado[2] = "Edad";
        this.encabezado[3] = "Nacionalidad";
        this.encabezado[4] = "Cedula";
        this.encabezado[5] = "Codigo";
        this.encabezado[6] = "E-mail";
        
        this.datos = cargarDatosTabla(this.gestionDato.getUsuarioList().size(),7);//inicializando tabla. Esta linea puede o no ponerse.
        this.modeloTabla = new DefaultTableModel(this.datos,this.encabezado);
        this.tabla = new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);
        
        panel.add(this.etiList.get(0));
        panel.add(this.txtList.get(0));
        panel.add(this.etiList.get(1));
        panel.add(this.txtList.get(1));
        panel.add(this.etiList.get(2));
        panel.add(this.txtList.get(2));
        panel.add(this.etiList.get(3));
        panel.add(this.txtList.get(3));
        panel.add(this.etiList.get(4));
        panel.add(this.txtList.get(4));
        panel.add(this.etiList.get(5));
        panel.add(this.txtList.get(5));
        panel.add(this.etiList.get(6));
        panel.add(this.txtList.get(6));
        panel.add(this.botonList.get(0));
        panel.add(this.botonList.get(1));
        panel.add(this.scroll);
        
        this.botonList.get(0).addActionListener(new EventoUsuario(this));
        this.botonList.get(1).addActionListener(new EventoUsuario(this));
        
        this.add(panel);
        
        
    }
    
    public Object[][] cargarDatosTabla(int m, int n) 
    {
        Object[][] retorno = new Object[m][n];
        int i=0;
        for(Usuario u:this.gestionDato.getUsuarioList()) 
        {
            retorno[i][0] = u.getNombre();
            retorno[i][1] = u.getSexo();
            retorno[i][2] = u.getEdad();
            retorno[i][3] = u.getNacionalidad();
            retorno[i][4] = u.getId();
            retorno[i][5] = u.getCodigo();
            retorno[i][6] = u.getEmail();
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

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
    
    
    
    
}
