package UserInterface.Form;

import UserInterface.CustomerControl.*;
import UserInterface.Style;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LogInForm extends JFrame{
    final int ESCALA = 70;
    final int ALTO   = ESCALA * 9;
    final int ANCHO  = ESCALA * 16;

    private JLabel      fondo;
    private JLabel      logo;
    private G3Panel     ttlPanel;
    final   G3Label     ttlLabel        = new G3Label("SISTEMA DE ASISTENCIA");

    private JPanel      loginPanel      = new JPanel();
    private G3Panel     loginTtlPanel;
    final   G3Label     loginTtlLabel   = new G3Label("Inicio de sesion");

    private G3Panel     rolPanel;
    final   G3Label     rolLabel        = new G3Label("ROL");
    private JComboBox   rolSelect;

    private G3Panel     usuarioPanel;
    final   G3Label     usuarioLabel    = new G3Label("USUARIO");
    private G3TextBox   usuarioTxt;

    private G3Panel     clavePanel;
    final   G3Label     claveLabel      = new G3Label("CLAVE");
    private G3TextBox   claveTxt;

    private G3Button    loginBtn;

    //final   JPanel  logoPanel           = new JPanel();

    public LogInForm(String titulo) {
        customizeComponent(titulo);
        loginBtn.addActionListener ( e -> System.out.println("Aqui va el metodo de login")); 
        setVisible(true);
    }

    private void customizeComponent(String titulo) {

        setTitle(titulo);
        setSize(ANCHO, ALTO);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(null);

        try {
            ImageIcon imgFnd = new ImageIcon(Style.URL_MAIN);
            fondo = new JLabel(imgFnd);
            fondo.setBounds(0, 0, ANCHO, ALTO);
            fondo.setLayout(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int tabulacion = ALTO / 25;
        int separacion = ALTO / 40;
        int xTtlP      = (ESCALA * 9) / 10;
        int yTtlP      = ESCALA / 2;
        int anchoTtlP  = (ANCHO / 16) * 14;
        int altoTtlP   = ESCALA * 2;
        int yPnl       = yTtlP + altoTtlP + (ALTO / 14);
        int altoPnl    = ALTO / 2;
        int anchoPnl   = (ANCHO / 5) * 2;
        int altoTtl    = ALTO / 10;
        int altoLbl    = ALTO / 15;
        int anchoLbl   = ANCHO / 7;
        int anchoTxt   = (anchoLbl * 3) / 2;
        
        ttlPanel = new G3Panel(Style.COLOR_ACCENT, new Rectangle(xTtlP, yTtlP, anchoTtlP, altoTtlP));
        ttlPanel.agregarTexto(ttlLabel);

        loginPanel.setBackground(new Color(255, 255, 255, 166));
        loginPanel.setBounds(xTtlP, yPnl, anchoPnl, altoPnl);
        loginPanel.setLayout(null);

        loginTtlPanel = new G3Panel(Style.COLOR_ACCENT_SOLID, new Rectangle(0, 0, anchoPnl, altoTtl));
        loginTtlPanel.agregarTexto(loginTtlLabel);
        loginPanel.add(loginTtlPanel);

        rolPanel = new G3Panel(Style.COLOR_ACCENT_SOLID, new Rectangle(tabulacion, altoTtl + separacion, anchoLbl, altoLbl));
        rolPanel.agregarTexto(rolLabel);
        loginPanel.add(rolPanel);

        String[] opciones = {"Administrador", "Profesor", "Estudiante"};
        rolSelect = new JComboBox(opciones);
        rolSelect.setFont(new Font("Century Gothic", Font.PLAIN, (altoLbl / 7) * 4));
        rolSelect.setBounds(new Rectangle(rolPanel.getX() + anchoLbl, rolPanel.getY(), anchoTxt, altoLbl));
        loginPanel.add(rolSelect);

        usuarioPanel = new G3Panel(Style.COLOR_ACCENT_SOLID, new Rectangle(tabulacion, rolPanel.getY() + altoLbl + separacion, anchoLbl, altoLbl));
        usuarioPanel.agregarTexto(usuarioLabel);
        loginPanel.add(usuarioPanel);

        usuarioTxt = new G3TextBox(new Rectangle(usuarioPanel.getX() + anchoLbl, usuarioPanel.getY(), anchoTxt, altoLbl));
        loginPanel.add(usuarioTxt);

        clavePanel = new G3Panel(Style.COLOR_ACCENT_SOLID, new Rectangle(tabulacion, usuarioPanel.getY() + altoLbl + separacion, anchoLbl, altoLbl));
        clavePanel.agregarTexto(claveLabel);
        loginPanel.add(clavePanel);

        claveTxt = new G3TextBox(new Rectangle(clavePanel.getX() + anchoLbl, clavePanel.getY(), anchoTxt, altoLbl));
        loginPanel.add(claveTxt);

        loginBtn = new G3Button("INGRESAR", new Rectangle((anchoPnl - anchoLbl) / 2, clavePanel.getY() + altoLbl + separacion, anchoLbl, altoLbl));
        loginBtn.setBackground(Style.COLOR_ACCENT_SOLID);
        loginBtn.setForeground(Style.COLOR_FONT_LIGHT);
        loginPanel.add(loginBtn);

        try {
            ImageIcon imgFnd = new ImageIcon(Style.URL_LOGO);

            Image img = imgFnd.getImage();
            Image imgResize = img.getScaledInstance(anchoPnl, altoPnl, Image.SCALE_SMOOTH);
            imgFnd = new ImageIcon(imgResize);
            
            logo = new JLabel(imgFnd);
            logo.setBounds(xTtlP + anchoTtlP - anchoPnl, yPnl, anchoPnl, altoPnl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        fondo.add(ttlPanel);
        fondo.add(loginPanel);
        fondo.add(logo);
        add(fondo);
        
    }   
}