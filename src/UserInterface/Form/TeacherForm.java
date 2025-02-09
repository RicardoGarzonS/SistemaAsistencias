package UserInterface.Form;

import BusinessLogic.Entities.Docente;
import DataAccess.DTO.UsuarioDTO;
import UserInterface.CustomerControl.*;
import UserInterface.Style;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class TeacherForm extends JFrame{
    private UsuarioDTO  usuario;
    private Docente     docente;
    private MainForm    padre;
    final   int         ESCALA              = 70;
    final   int         ALTO                = ESCALA * 9;
    final   int         ANCHO               = ESCALA * 16;
    final   int         SEPARACION          = ALTO / 25;

    private JPanel      cabecera            = new JPanel();
    private JLabel      bienvenida          = new JLabel();
    private JPanel      navegacion          = new JPanel();
    private G3Button    logoutBtn           = new G3Button("CERRAR SESION");
    private G3Button    backBtn             = new G3Button("INICIO");

    private JPanel      panelActual;
    private JPanel      menu                = new JPanel();
    private G3Button    asistenciasBtn      = new G3Button("<html>&emsp;&emsp;MIS<br>ASISTENCIAS</html>");
    private G3Button    estudiantesBtn      = new G3Button("<html>ASISTENCIAS<br>ESTUDIANTES</html>");

    private JPanel      pantalla            = new JPanel();

    private G3Label     horarioLbl;
    private JPanel      horarioPnl          = new JPanel();
    private JTable      horario;

    private G3Label     historicoLbl;
    private JPanel      historicoPnl        = new JPanel();
    private JTable      historico;

    private G3Button    resumenBtn          = new G3Button("RESUMEN");
    private JPanel      pantallaResumen     = new JPanel();
    private G3Label     resumenLbl;
    private JPanel      resumenPnl          = new JPanel();
    private JTable      resumen;
    
    private JPanel      pantallaEstudiantes = new JPanel();
    private G3Label     estudiantesLbl;
    private JPanel      estudiantesPnl      = new JPanel();
    private JTable      estudiantes;
    
    private G3Button    resumenBtnEst       = new G3Button("RESUMEN");
    private JPanel      pantallaResumenEst  = new JPanel();
    private G3Label     resumenEstLbl;
    private JPanel      resumenEstPnl          = new JPanel();
    private JTable      resumenEst;

    private G3Button    regresarBtn         = new G3Button("REGRESAR");
    private G3Button    regresarBtnEst      = new G3Button("REGRESAR");

    public TeacherForm(UsuarioDTO us, MainForm p) {
        usuario     = us;
        docente     = new Docente();
        padre       = p;
        panelActual = menu;
        customizeComponent();

        logoutBtn.addActionListener     ( e -> logout());
        backBtn.addActionListener       (e -> verInicio());
        asistenciasBtn.addActionListener(e -> verAsistencias());
        resumenBtn.addActionListener    (e -> verResumen());
        regresarBtn.addActionListener   (e -> verAsistencias());
        estudiantesBtn.addActionListener(e -> verEstudiantes());
        resumenBtnEst.addActionListener (e -> verEstResumen());
        regresarBtnEst.addActionListener(e -> verEstudiantes());
        
        setVisible(true);
    }

    private void customizeComponent() {

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

        asistenciasBtn.setForeground(Style.COLOR_FONT_LIGHT);
        asistenciasBtn.setBackground(Style.COLOR_ACCENT_SOLID);
        asistenciasBtn.setFont(new Font("Century Gothic", Font.BOLD, (ESCALA * 2) / 3));

        estudiantesBtn.setForeground(Style.COLOR_FONT_LIGHT);
        estudiantesBtn.setBackground(Style.COLOR_ACCENT_SOLID);
        estudiantesBtn.setFont(new Font("Century Gothic", Font.BOLD, (ESCALA * 2) / 3));

        menu.add(asistenciasBtn, BorderLayout.WEST);
        menu.add(estudiantesBtn, BorderLayout.EAST);

        pantalla.setLayout(null);
        
        horarioLbl = new G3Label("ESTA SEMANA", new Rectangle(SEPARACION, SEPARACION, ANCHO / 2 - 2 * SEPARACION, ALTO / 10));
        horarioPnl.setBounds(SEPARACION, ALTO / 10 + 2 * SEPARACION, ANCHO / 2 - 2 * SEPARACION, ESCALA * 2);
        crearHorario();

        historicoLbl = new G3Label("HISTORICO", new Rectangle(ANCHO / 2, SEPARACION, ANCHO / 2 - 2 * SEPARACION, ALTO / 10));

        resumenBtn.setBounds(ANCHO / 2 - 2 * SEPARACION - ANCHO / 10 - (SEPARACION * 2) / 3, (SEPARACION * 2) / 3, ANCHO / 10, ALTO / 10 - (SEPARACION * 4) /3);
        resumenBtn.setFont(new Font("Century Gothic", Font.BOLD, (ESCALA) / 4));
        resumenBtn.setBackground(Style.COLOR_FONT_LIGHT);
        resumenBtn.setForeground(Style.COLOR_ACCENT_SOLID);
        historicoLbl.add(resumenBtn);

        historicoPnl.setBounds(ANCHO / 2, ALTO / 10 + 2 * SEPARACION, ANCHO / 2 - 2 * SEPARACION, ESCALA * 2);
        crearHistorico();

        pantalla.add(horarioLbl);
        pantalla.add(horarioPnl);
        pantalla.add(historicoLbl);
        pantalla.add(historicoPnl);

        pantallaResumen.setLayout(null);

        resumenLbl = new G3Label("RESUMEN", new Rectangle(SEPARACION, SEPARACION, ANCHO - 3 * SEPARACION, ALTO / 10));

        regresarBtn.setBounds(ANCHO - 3 * SEPARACION - ANCHO / 7 - (SEPARACION * 2) / 3, (SEPARACION * 2) / 3, ANCHO / 7, ALTO / 10 - (SEPARACION * 4) /3);
        regresarBtn.setFont(new Font("Century Gothic", Font.BOLD, (ESCALA) / 4));
        regresarBtn.setBackground(Style.COLOR_FONT_LIGHT);
        regresarBtn.setForeground(Style.COLOR_ACCENT_SOLID);
        regresarBtn.setOpaque(true);
        resumenLbl.add(regresarBtn);

        resumenPnl.setBounds(SEPARACION, ALTO / 10 + 2 * SEPARACION, ANCHO - (3 * SEPARACION), ESCALA * 2);
        crearEstudiantes();

        pantallaResumen.add(resumenLbl);
        pantallaResumen.add(resumenPnl);

        pantallaEstudiantes.setLayout(null);

        estudiantesLbl = new G3Label("ASISTENCIAS ESTUDIANTES", new Rectangle(SEPARACION, SEPARACION, ANCHO - 3 * SEPARACION, ALTO / 10));

        resumenBtnEst.setBounds(ANCHO - 3 * SEPARACION - ANCHO / 7 - (SEPARACION * 2) / 3, (SEPARACION * 2) / 3, ANCHO / 7, ALTO / 10 - (SEPARACION * 4) /3);
        resumenBtnEst.setFont(new Font("Century Gothic", Font.BOLD, (ESCALA) / 4));
        resumenBtnEst.setBackground(Style.COLOR_FONT_LIGHT);
        resumenBtnEst.setForeground(Style.COLOR_ACCENT_SOLID);
        resumenBtnEst.setOpaque(true);
        estudiantesLbl.add(resumenBtnEst);

        estudiantesPnl.setBounds(SEPARACION, ALTO / 10 + 2 * SEPARACION, ANCHO - (3 * SEPARACION), ESCALA * 2);
        crearResumen();

        pantallaEstudiantes.add(estudiantesLbl);
        pantallaEstudiantes.add(estudiantesPnl);

        pantallaResumenEst.setLayout(null);

        resumenEstLbl = new G3Label("RESUMEN", new Rectangle(SEPARACION, SEPARACION, ANCHO - 3 * SEPARACION, ALTO / 10));

        regresarBtnEst.setBounds(ANCHO - 3 * SEPARACION - ANCHO / 7 - (SEPARACION * 2) / 3, (SEPARACION * 2) / 3, ANCHO / 7, ALTO / 10 - (SEPARACION * 4) /3);
        regresarBtnEst.setFont(new Font("Century Gothic", Font.BOLD, (ESCALA) / 4));
        regresarBtnEst.setBackground(Style.COLOR_FONT_LIGHT);
        regresarBtnEst.setForeground(Style.COLOR_ACCENT_SOLID);
        regresarBtnEst.setOpaque(true);
        resumenEstLbl.add(regresarBtnEst);

        resumenEstPnl.setBounds(SEPARACION, ALTO / 10 + 2 * SEPARACION, ANCHO - (3 * SEPARACION), ESCALA * 2);
        crearResumenEst();

        pantallaResumenEst.add(resumenEstLbl);
        pantallaResumenEst.add(resumenEstPnl);

        add(cabecera, BorderLayout.NORTH);
        add(panelActual);
    }
    private void crearHorario(){
        horarioPnl.removeAll();
        String[] header = {"Hora", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
        Object[][] data = new Object[6][6];
        /*
         * Aqui va el metodo para poner el horario en Object [][] data
         */
        horario = new JTable(data, header);
        horario.setShowHorizontalLines(true);
        horario.setGridColor(Style.COLOR_FONT);
        horario.setBackground(Style.COLOR_FONT_LIGHT);
        horario.setForeground(Style.COLOR_ACCENT_SOLID);
        horario.setRowSelectionAllowed(false);
        horario.setColumnSelectionAllowed(false);

        horario.setPreferredScrollableViewportSize(new Dimension(ANCHO / 2 - 2 * SEPARACION - ESCALA / 4, ESCALA * 2));
        horario.setFillsViewportHeight(true);

        horarioPnl.add(new JScrollPane(horario));
    }
    private void crearHistorico(){
        historicoPnl.removeAll();
        String[] header = {"Fecha", "Hora", "Materia", "Asistencia"};
        Object[][] data = new Object[12][4];
        /*
         * Aqui va el metodo para poner todas las asistencias (Ausente 0, Atrasado 1, Presente 2) del usuario en Object [][] data
         */
        historico = new JTable(data, header);
        historico.setShowHorizontalLines(true);
        historico.setGridColor(Style.COLOR_FONT);
        historico.setRowSelectionAllowed(true);
        historico.setColumnSelectionAllowed(false);

        historico.setPreferredScrollableViewportSize(new Dimension(ANCHO / 2 - 2 * SEPARACION - ESCALA / 4, ESCALA * 2));
        historico.setFillsViewportHeight(true);

        historicoPnl.add(new JScrollPane(historico));
    }
    private void crearResumen(){
        resumenPnl.removeAll();
        String[] header = {"Materia", "Asistencias", "Atrasos", "Inasistencias"};
        Object[][] data = new Object[6][4];
        /*
         * Aqui va el metodo para poner el total de asistencias, atrasos e inasistencias del usuario en Object [][] data
         */
        resumen = new JTable(data, header);
        resumen.setShowHorizontalLines(true);
        resumen.setGridColor(Style.COLOR_FONT);
        resumen.setRowSelectionAllowed(true);
        resumen.setColumnSelectionAllowed(false);

        resumen.setPreferredScrollableViewportSize(new Dimension(ANCHO - 3 * SEPARACION, ESCALA * 2));
        resumen.setFillsViewportHeight(true);

        resumenPnl.add(new JScrollPane(resumen));
    }
    private void crearEstudiantes(){
        estudiantesPnl.removeAll();
        String[] header = {"Fecha", "Hora", "Materia", "Estudiante", "Asistencia"};
        Object[][] data = new Object[12][5];
        /*
         * Aqui va el metodo para poner todas las asistencias (Ausente 0, Atrasado 1, Presente 2) de los estudiantes en Object [][] data
         */
        estudiantes = new JTable(data, header);
        estudiantes.setShowHorizontalLines(true);
        estudiantes.setGridColor(Style.COLOR_FONT);
        estudiantes.setRowSelectionAllowed(true);
        estudiantes.setColumnSelectionAllowed(false);

        estudiantes.setPreferredScrollableViewportSize(new Dimension(ANCHO - 3 * SEPARACION, ESCALA * 2));
        estudiantes.setFillsViewportHeight(true);

        estudiantesPnl.add(new JScrollPane(estudiantes));
    }
    private void crearResumenEst(){
        resumenPnl.removeAll();
        String[] header = {"Estudiante", "Materia", "Asistencias", "Atrasos", "Inasistencias"};
        Object[][] data = new Object[12][5];
        /*
         * Aqui va el metodo para poner el total de asistencias, atrasos e inasistencias de los estudiantes en Object [][] data
         */
        resumenEst = new JTable(data, header);
        resumenEst.setShowHorizontalLines(true);
        resumenEst.setGridColor(Style.COLOR_FONT);
        resumenEst.setRowSelectionAllowed(true);
        resumenEst.setColumnSelectionAllowed(false);

        resumenEst.setPreferredScrollableViewportSize(new Dimension(ANCHO - 3 * SEPARACION, ESCALA * 2));
        resumenEst.setFillsViewportHeight(true);

        resumenEstPnl.add(new JScrollPane(resumenEst));
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
    private void verAsistencias(){
        pantalla.removeAll();
        remove(panelActual);
        panelActual = pantalla;
        customizeComponent();
    }
    private void verResumen(){
        pantallaResumen.removeAll();
        remove(panelActual);
        panelActual = pantallaResumen;
        customizeComponent();
    }
    private void verEstudiantes(){
        pantallaEstudiantes.removeAll();
        remove(panelActual);
        panelActual = pantallaEstudiantes;
        customizeComponent();
    }
    private void verEstResumen(){
        pantallaResumenEst.removeAll();
        remove(panelActual);
        panelActual = pantallaResumenEst;
        customizeComponent();
    }
}
