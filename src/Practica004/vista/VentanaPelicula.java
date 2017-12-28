/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica004.vista;

import Practica004.controlador.EventoPelicula;
import Practica004.controlador.GestionDato;
import Practica004.modelo.Pelicula;
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
public class VentanaPelicula extends JInternalFrame {

    private GestionDato gestionDato;
    private List<JLabel> etiList;
    private List<JTextField> txtList;
    private List<JButton> botonList;
    private JPanel panel;
    private JScrollPane scroll;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private Object[] encabezado;
    private Object[][] datos;

    public VentanaPelicula(GestionDato gestionDato) {
        super("Registro - Pelicula", true, true, true, true);
        this.gestionDato = gestionDato;
        this.iniciaComponente();
        this.setSize(700, 500);
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

    public void iniciaComponente() {

        this.etiList = new ArrayList<JLabel>();
        this.txtList = new ArrayList<JTextField>();
        this.botonList = new ArrayList<JButton>();
        JPanel panel = new JPanel(new FlowLayout());
        
        this.etiList.add(new JLabel("Nombre:"));
        this.etiList.add(new JLabel("Genero:"));
        this.etiList.add(new JLabel("Año:"));
        this.etiList.add(new JLabel("Numero de Entregas:"));
        
        this.txtList.add(new JTextField(20));
        this.txtList.add(new JTextField(15));
        this.txtList.add(new JTextField(10));
        this.txtList.add(new JTextField(10));
        
        this.botonList.add(new JButton("Guardar"));
        this.botonList.add(new JButton("Limpiar"));
        
        this.encabezado = new Object[4];               
        this.encabezado[0] = "Nombre";
        this.encabezado[1] = "Genero";
        this.encabezado[2] = "Año";
        this.encabezado[3] = "Entregas";
        
        this.datos = cargaDatosTabla(this.gestionDato.getPeliculaList().size(),4);
        
        this.modeloTabla = new DefaultTableModel(this.datos, this.encabezado);        
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
        panel.add(this.botonList.get(0));
        panel.add(this.botonList.get(1));
        panel.add(this.scroll);
        
        this.botonList.get(0).addActionListener(new EventoPelicula(this));
        this.botonList.get(1).addActionListener(new EventoPelicula(this));
        
        this.add(panel);

    }
    
    public Object[][] cargaDatosTabla(int m, int n) {
        Object[][] retorno = new Object[m][n];
        int i=0;
        for(Pelicula p:this.gestionDato.getPeliculaList()) {
            retorno[i][0] = p.getNombre();
            retorno[i][1] = p.getGenero();
            retorno[i][2] = p.getAnio();
            retorno[i][3] = p.getNumEntregas();
            i++;
        }        
        return retorno;
    }

}
