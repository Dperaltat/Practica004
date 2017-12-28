
package Practica004.vista;

import Practica004.controlador.EventoReseña;
import Practica004.controlador.GestionDato;
import Practica004.modelo.Pelicula;
import Practica004.modelo.Reseña;
import Practica004.modelo.Usuario;
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

public class VentanaReseña extends JInternalFrame
{
    private GestionDato gestionDato;
    private JComboBox comboUsuario;
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
    
    public VentanaReseña(GestionDato gestionDato) 
    {
        super("Ventana Busqeuda",true,true,true,true);
        this.gestionDato = gestionDato;
        this.iniciaComponente();
        this.setLocation(170, 50);
        this.setSize(625, 550);              
    }

    public GestionDato getGestionDato() {
        return gestionDato;
    }
    public void setGestionDato(GestionDato gestionDato) {
        this.gestionDato = gestionDato;
    }
    public JComboBox getComboUsuario() {
        return comboUsuario;
    }
    public void setComboUsuario(JComboBox comboUsuario) {
        this.comboUsuario = comboUsuario;
    }
    public JComboBox getComboPelicula() {
        return comboPelicula;
    }
    public void setComboPelicula(JComboBox comboPelicula) {
        this.comboPelicula = comboPelicula;
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
    
    public void iniciaComponente()
    {
        this.etiList = new ArrayList<JLabel>();
        this.txtList = new ArrayList<JTextField>();
        this.botonList = new ArrayList<JButton>();
        JPanel panel = new JPanel(new FlowLayout());
        this.comboUsuario = new JComboBox(this.cargaComboUsuario());
        this.comboPelicula = new JComboBox(this.cargaComboPelicula());
          
        this.etiList.add(new JLabel("Usuario"));
        this.etiList.add(new JLabel("Pelicula"));
        this.etiList.add(new JLabel("Calificacion"));
        this.etiList.add(new JLabel("Comentario"));
        
        this.txtList.add(new JTextField(10));
        this.txtList.add(new JTextField(35)); 
        
        this.botonList.add(new JButton("Guardar"));
        this.botonList.add(new JButton("Limpiar"));
        
        this.encabezado = new Object[4];               
        this.encabezado[0] = "Usuario";
        this.encabezado[1] = "Pelicula";
        this.encabezado[2] = "Calificacion";
        this.encabezado[3] = "Comentario";
        
        this.datos = cargaDatosTabla(this.gestionDato.getReseñaList().size(),4);
        
        this.modeloTabla = new DefaultTableModel(this.datos, this.encabezado);        
        this.tabla = new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);
        
        panel.add(this.etiList.get(0));
        panel.add(this.comboUsuario);
        panel.add(this.etiList.get(1));
        panel.add(this.comboPelicula);
        panel.add(this.etiList.get(2));
        panel.add(this.txtList.get(0));
        panel.add(this.etiList.get(3));
        panel.add(this.txtList.get(1));
        panel.add(this.botonList.get(0));
        panel.add(this.botonList.get(1));
        panel.add(this.scroll);
        
        this.botonList.get(0).addActionListener(new EventoReseña(this));
        this.botonList.get(1).addActionListener(new EventoReseña(this));
        
        this.add(panel);
    }
    
    public String[] cargaComboUsuario() 
    {       
        String[] retorno = new String[this.gestionDato.getUsuarioList().size()];
        int i=0;
        for(Usuario u: this.gestionDato.getUsuarioList()) 
        {
            retorno[i] = u.getNombre() + " "  + "Codigo: " + u.getCodigo() + "" + "email: " + u.getEmail();
            i++;
        }
        return retorno;
    }
    
    public String[] cargaComboPelicula() 
    {       
        String[] retorno = new String[this.gestionDato.getPeliculaList().size()];
        int i=0;
        for(Pelicula p: this.gestionDato.getPeliculaList()) 
        {
            retorno[i] = p.getNombre() + "" + "Genero: " + p.getGenero() + "" + "Año: " + p.getAnio();
            i++;
        }
        return retorno;
    }
    
    public Object[][] cargaDatosTabla(int m, int n) 
    {
        Object[][] retorno = new Object[m][n];
        int i=0;
        for(Reseña res: this.gestionDato.getReseñaList()) 
        {
            retorno[i][0] = res.getUsuario().getNombre() + " " + res.getUsuario();
            retorno[i][1] = res.getPelicula().getNombre();
            retorno[i][2] = res.getCalificacion();
            retorno[i][3] = res.getComentario();
            i++;
        }        
        return retorno;
    }
    
}
