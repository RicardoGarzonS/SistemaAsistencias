package UserInterface.Form;

import BusinessLogic.Entities.Login;
import BusinessLogic.UsuarioBL;
import DataAccess.DTO.UsuarioDTO;
import Framework.ExceptionLogger;
import UserInterface.CustomerControl.*;
import UserInterface.Style;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LogInForm extends JFrame{
    private MainForm    padre;
    private Login       lg;
    private UsuarioBL   ubl;
    final   int         ESCALA          = 70;
    final   int         ALTO            = ESCALA * 9;
    final   int         ANCHO           = ESCALA * 16;

    private JLabel      fondo;
    private JLabel      logo;
    private G3Label     ttlLabel;

    private JPanel      loginPanel      = new JPanel();
    private G3Label     loginTtlLabel;

    // private G3Panel     rolPanel;
    // final   G3Label     rolLabel     = new G3Label("ROL");
    // private JComboBox   rolSelect;

    private G3Label     usuarioLabel;
    private G3TextBox   usuarioTxt;

    private G3Label     claveLabel;
    private G3TextBox   claveTxt;

    private G3Button    loginBtn;

    //final   JPanel  logoPanel           = new JPanel();

    public LogInForm(String titulo, MainForm p) {
        padre = p;
        customizeComponent(titulo);
        lg = new Login();
        ubl = new UsuarioBL();
        loginBtn.addActionListener ( e -> login()); 
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
        
        ttlLabel = new G3Label("SISTEMA DE ASISTENCIA", new Rectangle(xTtlP, yTtlP, anchoTtlP, altoTtlP));

        loginPanel.setBackground(new Color(255, 255, 255, 166));
        loginPanel.setBounds(xTtlP, yPnl, anchoPnl, altoPnl);
        loginPanel.setLayout(null);

        loginTtlLabel = new G3Label("INICIO DE SESION", new Rectangle(0, 0, anchoPnl, altoTtl));
        loginPanel.add(loginTtlLabel);

        // rolPanel = new G3Panel(Style.COLOR_ACCENT_SOLID, new Rectangle(tabulacion, altoTtl + separacion, anchoLbl, altoLbl));
        // rolPanel.agregarTexto(rolLabel);
        // loginPanel.add(rolPanel);

        // String[] opciones = {"Administrador", "Profesor", "Estudiante"};
        // rolSelect = new JComboBox(opciones);
        // rolSelect.setFont(new Font("Century Gothic", Font.PLAIN, (altoLbl / 7) * 4));
        // rolSelect.setBounds(new Rectangle(rolPanel.getX() + anchoLbl, rolPanel.getY(), anchoTxt, altoLbl));
        // loginPanel.add(rolSelect);

        usuarioLabel = new G3Label("CORREO", new Rectangle(tabulacion, altoTtl + separacion, anchoLbl, altoLbl));
        loginPanel.add(usuarioLabel);

        usuarioTxt = new G3TextBox(new Rectangle(usuarioLabel.getX() + anchoLbl, usuarioLabel.getY(), anchoTxt, altoLbl));
        loginPanel.add(usuarioTxt);

        claveLabel = new G3Label("CLAVE", new Rectangle(tabulacion, usuarioLabel.getY() + altoLbl + separacion, anchoLbl, altoLbl));
        loginPanel.add(claveLabel);

        claveTxt = new G3TextBox(new Rectangle(claveLabel.getX() + anchoLbl, claveLabel.getY(), anchoTxt, altoLbl));
        loginPanel.add(claveTxt);

        loginBtn = new G3Button("INGRESAR", new Rectangle((anchoPnl - anchoLbl) / 2, claveLabel.getY() + altoLbl + separacion, anchoLbl, altoLbl));
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
        
        fondo.add(ttlLabel);
        fondo.add(loginPanel);
        fondo.add(logo);
        add(fondo);
    }   

    private void login(){
        setVisible(false);
        int idUsuario = -1;
        try {
            idUsuario = lg.loginCuenta(usuarioTxt.getText(), claveTxt.getText());
        } catch (Exception e) {
            Style.showMsgError("Credenciales no validas");
            new ExceptionLogger(e.getMessage(), this.getClass().getName(), "InicioSesion");
        }
        if(idUsuario != - 1 ){
            try {
                UsuarioDTO us = ubl.getByIdUsuario(idUsuario);
                switch (Integer.valueOf(us.getIdRol())) {
                    case 1:
                        padre.mostrarEstudiante(us);
                        break;
                    case 2:
                        padre.mostrarProfesor(us);
                    default:
                        padre.mostrarLogin();
                        break;
                }
            } catch (Exception e) {
                Style.showMsgError("Credenciales no validas");
                new ExceptionLogger(e.getMessage(), this.getClass().getName(), "InicioSesion");
            }
        }else{
            Style.showMsgError("Credenciales no validas");
            padre.mostrarLogin();
        }
    }
}