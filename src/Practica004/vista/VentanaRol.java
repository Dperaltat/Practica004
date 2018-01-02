/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica004.vista;


import Practica004.controlador.EventoRol;
import Practica004.controlador.GestionDato;
import Practica004.modelo.Actor;
import Practica004.modelo.Pelicula;
import Practica004.modelo.Rol;
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

/**
 *
 * @author Daniel
 */
public class VentanaRol extends JInternalFrame
{
     private GestionDato gestionDato;
    private JComboBox comboActor;
    private JComboBox comboPelicula;
    private List<JLabel> etiList;
    private List<JTextField> txtList;
    private List<JButton> botonList;
    private JPanel panel;
    private JScrollPane scroll;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private Object[] encabezado;
    private Object[][] datos;

    public VentanaRol(GestionDato gestionDato) 
    {
        super("Registro Rol",true,true,true,true);
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
        this.comboActor = new JComboBox(this.cargaComboActor());//Falta agregar el combo
        this.comboPelicula = new JComboBox(this.cargaComboPelicula());
        
        this.etiList.add(new JLabel("Codigo:"));
        this.etiList.add(new JLabel("Actor:"));
        this.etiList.add(new JLabel("Papel:"));
        this.etiList.add(new JLabel("Pelicula:"));
        
        this.txtList.add(new JTextField(15));
        this.txtList.add(new JTextField(15));
        
        this.botonList.add(new JButton("Guardar"));
        this.botonList.add(new JButton("Limpiar"));
        
        this.encabezado = new Object[4];               
        this.encabezado[0] = "Codigo";
        this.encabezado[1] = "Actor ";
        this.encabezado[2] = "Papel";
         this.encabezado[3] = "Pelicula";
        
        
        this.datos = cargaDatosTabla(this.gestionDato.getRolList().size(),4);
        
        this.modeloTabla = new DefaultTableModel(this.datos, this.encabezado);        
        this.tabla = new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);
       
        
        
        panel.add(this.etiList.get(0));
       panel.add(this.txtList.get(0));
       
        panel.add(this.etiList.get(1));
        panel.add(this.comboActor);
        
       panel.add(this.etiList.get(2));
       panel.add(this.txtList.get(1));
       
        panel.add(this.etiList.get(3));
        panel.add(this.comboPelicula);
        
        panel.add(this.botonList.get(0));
        panel.add(this.botonList.get(1));
        panel.add(this.scroll);
        
        this.botonList.get(0).addActionListener(new EventoRol(this));
        this.botonList.get(1).addActionListener(new EventoRol(this));
        
        this.add(panel);
    }
      public String[] cargaComboActor() {       
    
       String[] retorno = new String[this.gestionDato.getActorList().size()];
        int i=0;
        for(Actor a: this.gestionDato.getActorList()) {
            retorno[i] = a.getNombre() ;
            i++;
        }
        return retorno;
    }
        public String[] cargaComboPelicula() {       
        
      String[] retorno = new String[this.gestionDato.getPeliculaList().size()];
        int i=0;
        for(Pelicula a: this.gestionDato.getPeliculaList()) {
            retorno[i] = a.getNombre() ;
            i++;
        }
        return retorno;
    }
       
    public Object[][] cargaDatosTabla(int m, int n) {
        Object[][] retorno = new Object[m][n];
        int i=0;
        for(Rol e:this.gestionDato.getRolList())
        {
            retorno[i][0] = e.getId();
            retorno[i][1] = e.getActor();
            retorno[i][2] = e.getPapel();
            retorno[i][3] = e.getPelicula();
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

    public JComboBox getComboActor() {
        return comboActor;
    }

    public void setComboActor(JComboBox comboActor) {
        this.comboActor = comboActor;
    }

    public JComboBox getComboPelicula() {
        return comboPelicula;
    }

    public void setComboPelicula(JComboBox comboPelicula) {
        this.comboPelicula = comboPelicula;
    }
      
    
    
}
