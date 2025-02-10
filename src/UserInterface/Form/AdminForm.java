package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BusinessLogic.Entities.Administrador;
import DataAccess.DTO.UsuarioDTO;
import UserInterface.Style;
import UserInterface.CustomerControl.G3Button;

public class AdminForm extends JFrame{
    private UsuarioDTO usuario;
    private Administrador administrador;
    private MainForm padre;
    final   int         ESCALA              = 70;
    final   int         ALTO                = ESCALA * 9;
    final   int         ANCHO               = ESCALA * 16;
    final   int         SEPARACION          = ALTO / 25;

    private JPanel      cabecera        = new JPanel();
    private JLabel      bienvenida      = new JLabel();
    private JPanel      navegacion      = new JPanel();
    private G3Button    logoutBtn       = new G3Button("CERRAR SESION");
    private G3Button    backBtn         = new G3Button("INICIO");

    private JPanel      panelActual;
    private JPanel      menu              = new JPanel();
    private G3Button    agregarBtn        = new G3Button("USUARIOS");
    private G3Button    modificarBtn      = new G3Button("ASISTENCIAS");

    private JPanel      pantalla            = new JPanel();

    public AdminForm(UsuarioDTO us, MainForm p) {
        usuario = us;
        administrador = new Administrador();
        padre = p;
        panelActual = menu;
        customizeComponent();

        // agregarBtn.addActionListener( e -> verAgregarMenu());
        logoutBtn.addActionListener     ( e -> logout());
        backBtn.addActionListener       (e -> verInicio());

        setVisible(true);
    }

    public void customizeComponent(){
        setTitle("Menu " + usuario.getIdRol());
        setSize(ANCHO, ALTO);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        cabecera.setLayout(new BorderLayout());
        cabecera.setBackground(Style.COLOR_ACCENT_SOLID);
        cabecera.setBorder(new EmptyBorder(ANCHO / 28, ANCHO / 28, ANCHO / 28, ANCHO / 28));
        bienvenida.setForeground(Style.COLOR_FONT_LIGHT);
        bienvenida.setFont(new Font("Century Gothic", Font.BOLD, (ESCALA * 2) / 3));
        bienvenida.setText("Bienvenido, " + usuario.getNombreUsuario());
        
        logoutBtn.setForeground(Style.COLOR_ACCENT_SOLID);
        logoutBtn.setBackground(Style.COLOR_FONT_LIGHT);

        backBtn.setForeground(Style.COLOR_ACCENT_SOLID);
        backBtn.setBackground(Style.COLOR_FONT_LIGHT);

        navegacion.setLayout(new BorderLayout());
        navegacion.add(backBtn, BorderLayout.WEST);
        navegacion.add(logoutBtn, BorderLayout.EAST);

        cabecera.add(navegacion, BorderLayout.EAST);
        cabecera.add(bienvenida, BorderLayout.WEST);

        menu.setLayout(new BorderLayout());
        menu.setBorder(new EmptyBorder(ANCHO / 20, ANCHO / 7, ANCHO / 20, ANCHO / 7));
        

        add(cabecera, BorderLayout.NORTH);
        add(panelActual);
    }

    private void logout(){
        setVisible(false);
        padre.mostrarLogin();
    }
    private void verInicio(){
        remove(panelActual);
        panelActual = menu;
        customizeComponent();
    }
    // private void verAgregarMenu(){
    //     pantalla.removeAll();
    //     remove(panelActual);
    //     panelActual = pantallaAgregar;
    //     customizeComponent();
    // }
}
