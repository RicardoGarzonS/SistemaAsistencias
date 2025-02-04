package UserInterface.Form;

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
    final int ESCALA = 70;
    final int ALTO   = ESCALA * 9;
    final int ANCHO  = ESCALA * 16;

    private JLabel  fondo;
    private JLabel  logo;
    private G3Panel ttlPanel;
    private G3Label ttlLabel        = new G3Label("SISTEMA DE ASISTENCIA");
    private JPanel  loginPanel      = new JPanel();
    private G3Panel loginTtlPanel;
    private G3Label loginTtlLabel   = new G3Label("Inicio de sesion");
    private JPanel  logoPanel       = new JPanel();
    private G3Panel rolPanel;
    private G3Label rolLabel        = new G3Label("ROL");
    private G3Panel usuarioPanel;
    private G3Label usuarioLabel    = new G3Label("ROL");
    private G3Panel clavePanel;
    private G3Label claveLabel      = new G3Label("ROL");

    public LogInForm(String titulo) {
        customizeComponent(titulo);
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
        Rectangle bordes = new Rectangle((ESCALA * 9) / 10, ESCALA / 2, (ANCHO / 16) * 14, ESCALA * 2);
        
        ttlPanel = new G3Panel(Style.COLOR_ACCENT, bordes);
        ttlPanel.agregarTexto(ttlLabel);

        loginPanel.setBackground(new Color(255, 255, 255, 166));
        loginPanel.setBounds(bordes.x, bordes.y + bordes.height + (ALTO / 14), (ANCHO / 5) * 2, ALTO / 2);
        loginPanel.setLayout(null);

        loginTtlPanel = new G3Panel(Style.COLOR_ACCENT_SOLID, new Rectangle(0, 0, (ANCHO / 5) * 2, ALTO / 10));
        loginTtlPanel.agregarTexto(loginTtlLabel);
        loginPanel.add(loginTtlPanel);

        rolPanel = new G3Panel(Style.COLOR_ACCENT_SOLID, new Rectangle(ALTO / 25, loginTtlPanel.getHeight() + ALTO / 25, (ANCHO / 5) * 2, ALTO / 10));
        rolPanel.agregarTexto(rolLabel);
        loginPanel.add(rolPanel);
        
        logoPanel.setBackground(new Color(255, 255, 255, 0));
        logoPanel.setBounds(bordes.x + ttlPanel.getWidth() - loginPanel.getWidth(), loginPanel.getY(), loginPanel.getWidth(), loginPanel.getHeight());
        try {
            ImageIcon imgFnd = new ImageIcon(Style.URL_LOGO);

            Image img = imgFnd.getImage();
            Image imgResize = img.getScaledInstance((logoPanel.getWidth() / 10) * 9, logoPanel.getHeight(), Image.SCALE_SMOOTH);
            imgFnd = new ImageIcon(imgResize);
            
            logo = new JLabel(imgFnd);
            logoPanel.add(logo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        fondo.add(ttlPanel);
        fondo.add(loginPanel);
        fondo.add(logoPanel);
        add(fondo);
        
    }   
}