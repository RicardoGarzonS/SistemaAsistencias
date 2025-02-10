package UserInterface.Form;

import BusinessLogic.BLFactory;
import BusinessLogic.ClaseBL;
import BusinessLogic.DiaBL;
import BusinessLogic.Entities.Administrador;
import BusinessLogic.InscripcionBL;
import BusinessLogic.MateriaBl;
import BusinessLogic.UsuarioBL;
import DataAccess.DAO.LectorDAO;
import DataAccess.DAO.RolDAO;
import DataAccess.DTO.ClaseDTO;
import DataAccess.DTO.InscripcionDTO;
import DataAccess.DTO.LectorDTO;
import DataAccess.DTO.MateriaDTO;
import DataAccess.DTO.RolDTO;
import DataAccess.DTO.UsuarioDTO;
import UserInterface.CustomerControl.G3Button;
import UserInterface.Style;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class AdminForm extends JFrame{
    private BLFactory<RolDTO>       rBl;
    private BLFactory<LectorDTO>    lBl;
    private UsuarioBL               uBl;
    private MateriaBl               mBl;
    private DiaBL                   dBl;
    private ClaseBL                 cBl;
    private InscripcionBL           iBl;

    private UsuarioDTO      admin;
    private Administrador   administrador;
    private MainForm        padre;
    final   int             ESCALA          = 70;
    final   int             ALTO            = ESCALA * 9;
    final   int             ANCHO           = ESCALA * 16;
    final   int             SEPARACION      = ALTO / 25;

    private JPanel          cabecera        = new JPanel();
    private JLabel          bienvenida      = new JLabel();
    private JPanel          navegacion      = new JPanel();
    private G3Button        logoutBtn       = new G3Button("CERRAR SESION");

    private JPanel          menu            = new JPanel();
    private G3Button        agregarBtn      = new G3Button("USUARIOS");
    private G3Button        modificarBtn    = new G3Button("ASISTENCIAS");

    private JPanel          pantalla        = new JPanel();

    public AdminForm(UsuarioDTO us, MainForm p) {
        admin = us;
        administrador = new Administrador();
        padre = p;

        rBl = new BLFactory<RolDTO>(RolDAO :: new);
        lBl = new BLFactory<LectorDTO>(LectorDAO :: new);
        uBl = new UsuarioBL();
        mBl = new MateriaBl();
        dBl = new DiaBL();
        cBl = new ClaseBL();
        iBl = new InscripcionBL();

        String[] opciones = {"Estudiante", "Profesor", "Admin"};
        rolComb = new JComboBox(opciones);

        String[] opciones2 = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
        diaComb = new JComboBox(opciones2);

        String[] opciones3 = {"1"};
        lectorComb = new JComboBox(opciones3);

        customizeComponent();

        // agregarBtn.addActionListener( e -> verAgregarMenu());
        logoutBtn.addActionListener     ( e -> logout());

        setVisible(true);
    }

    public void customizeComponent(){
        setTitle("Menu " + admin.getIdRol());
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
        bienvenida.setText("Bienvenido, " + admin.getNombreUsuario());
        
        logoutBtn.setForeground(Style.COLOR_ACCENT_SOLID);
        logoutBtn.setBackground(Style.COLOR_FONT_LIGHT);

        navegacion.setLayout(new BorderLayout());
        navegacion.add(logoutBtn, BorderLayout.EAST);

        cabecera.add(navegacion, BorderLayout.EAST);
        cabecera.add(bienvenida, BorderLayout.WEST);

        usuarioPnl.setLayout(new GridBagLayout());
        usuarioPnl.setBorder(new EmptyBorder(5, 5, 5, 5));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        usuarioPnl.add(usuarioTtl, gbc);
        gbc.gridy++;
        gbc.ipadx = ANCHO / 5;
        gbc.ipady = ANCHO / 10;
        cargarUsuarios();
        usuarioPnl.add(usuarioTblPnl, gbc);
        gbc.gridy++;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.gridx = 0;
        usuarioPnl.add(idUsuarioLbl, gbc);
        gbc.gridx = 1;
        usuarioPnl.add(idUsuarioTxt, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        usuarioPnl.add(idRolLbl, gbc);
        gbc.gridx = 1;
        usuarioPnl.add(rolComb, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        usuarioPnl.add(nombreUsuarioLbl, gbc);
        gbc.gridx = 1;
        usuarioPnl.add(nombreUsuarioTxt, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        usuarioPnl.add(claveUsuarioLbl, gbc);
        gbc.gridx = 1;
        usuarioPnl.add(claveUsuarioTxt, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        usuarioPnl.add(cedulaUsuarioLbl, gbc);
        gbc.gridx = 1;
        usuarioPnl.add(cedulaUsuarioTxt, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        usuarioPnl.add(correoUsuarioLbl, gbc);
        gbc.gridx = 1;
        usuarioPnl.add(correoUsuarioTxt, gbc);

        materiaPnl.setLayout(new GridBagLayout());
        materiaPnl.setBorder(new EmptyBorder(5, 5, 5, 5));
        gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        materiaPnl.add(materiaTtl, gbc);
        gbc.gridy++;
        gbc.ipadx = ANCHO / 5;
        gbc.ipady = ANCHO / 10;
        cargarMaterias();
        materiaPnl.add(materiaTblPnl, gbc);
        gbc.gridy++;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.gridx = 0;
        materiaPnl.add(idMateriaLbl, gbc);
        gbc.gridx = 1;
        materiaPnl.add(idMateriaTxt, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        materiaPnl.add(nombreMateriaLbl, gbc);
        gbc.gridx = 1;
        materiaPnl.add(nombreMateriaTxt, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        materiaPnl.add(new JLabel(" "), gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        materiaPnl.add(new JLabel(" "), gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        materiaPnl.add(new JLabel(" "), gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        materiaPnl.add(new JLabel(" "), gbc);

        clasePnl.setLayout(new GridBagLayout());
        clasePnl.setBorder(new EmptyBorder(5, 5, 5, 5));
        gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        clasePnl.add(claseTtl, gbc);
        gbc.gridy++;
        gbc.ipadx = ANCHO / 5;
        gbc.ipady = ANCHO / 10;
        cargarClases();
        clasePnl.add(claseTblPnl, gbc);
        gbc.gridy++;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.gridx = 0;
        clasePnl.add(idClaseLbl, gbc);
        gbc.gridx = 1;
        clasePnl.add(idClaseTxt, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        clasePnl.add(idDiaLbl, gbc);
        gbc.gridx = 1;
        clasePnl.add(diaComb, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        clasePnl.add(inicioClaseLbl, gbc);
        gbc.gridx = 1;
        clasePnl.add(inicioClaseTxt, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        clasePnl.add(finClaseLbl, gbc);
        gbc.gridx = 1;
        clasePnl.add(finClaseTxt, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        clasePnl.add(new JLabel(" "), gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        clasePnl.add(new JLabel(" "), gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        clasePnl.add(new JLabel(" "), gbc);

        inscripcionPnl.setLayout(new GridBagLayout());
        inscripcionPnl.setBorder(new EmptyBorder(5, 5, 5, 5));
        gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inscripcionPnl.add(inscripcionTtl, gbc);
        gbc.gridy++;
        gbc.ipadx = ANCHO / 5;
        gbc.ipady = ANCHO / 10;
        cargarInscripciones();
        inscripcionPnl.add(inscripcionTblPnl, gbc);
        gbc.gridy++;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.gridx = 0;
        inscripcionPnl.add(idInscripcionLbl, gbc);
        gbc.gridx = 1;
        inscripcionPnl.add(idInscripcionTxt, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        inscripcionPnl.add(idDiaLbl, gbc);
        gbc.gridx = 1;
        inscripcionPnl.add(diaComb, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        inscripcionPnl.add(yearInscripcionLbl, gbc);
        gbc.gridx = 1;
        inscripcionPnl.add(yearInscripcionTxt, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        inscripcionPnl.add(idLectorLbl, gbc);
        gbc.gridx = 1;
        inscripcionPnl.add(lectorComb, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        inscripcionPnl.add(new JLabel(" "), gbc);

        menu.setLayout(new BoxLayout(menu, BoxLayout.X_AXIS));
        menu.add(usuarioPnl);
        menu.add(materiaPnl);
        menu.add(clasePnl);
        menu.add(inscripcionPnl);

        add(cabecera, BorderLayout.NORTH);
        add(menu);
    }

    private void logout(){
        setVisible(false);
        padre.mostrarLogin();
    }

    private UsuarioDTO              usuario;
    private MateriaDTO              materia;
    private ClaseDTO                clase;
    private InscripcionDTO          inscripcion;

    private JPanel                  usuarioPnl = new JPanel(),
                                    materiaPnl = new JPanel(),
                                    clasePnl = new JPanel(),
                                    inscripcionPnl = new JPanel(),
                                    usuarioTblPnl = new JPanel(),
                                    materiaTblPnl = new JPanel(),
                                    claseTblPnl = new JPanel(),
                                    inscripcionTblPnl = new JPanel();

    private JTable                  usuarioTbl;
    private JTable                  materiaTbl;
    private JTable                  claseTbl;
    private JTable                  inscripcionTbl;
    
    private JLabel                  idUsuarioLbl = new JLabel("Id: "),
                                    idRolLbl = new JLabel("Rol: "),
                                    nombreUsuarioLbl = new JLabel("Username: "),
                                    claveUsuarioLbl = new JLabel("Clave: "),
                                    cedulaUsuarioLbl = new JLabel("Cedula: "),
                                    correoUsuarioLbl = new JLabel("Correo: "),
                                    idMateriaLbl = new JLabel("Id: "),
                                    nombreMateriaLbl = new JLabel("Materia: "),
                                    idClaseLbl = new JLabel("Id: "),
                                    idDiaLbl = new JLabel("Dia: "),
                                    inicioClaseLbl = new JLabel("Desde: "),
                                    finClaseLbl = new JLabel("Hasta: "),
                                    idInscripcionLbl = new JLabel("Id:"),
                                    yearInscripcionLbl = new JLabel("Año:"),
                                    idLectorLbl = new JLabel("Lector: "),

                                    usuarioTtl = new JLabel("USUARIO"),
                                    materiaTtl = new JLabel("MATERIA"),
                                    claseTtl = new JLabel("CLASE"),
                                    inscripcionTtl = new JLabel("INSCRIPCION");

    private JTextArea               idUsuarioTxt = new JTextArea(),
                                    nombreUsuarioTxt = new JTextArea(),
                                    claveUsuarioTxt = new JTextArea(),
                                    cedulaUsuarioTxt = new JTextArea(),
                                    correoUsuarioTxt = new JTextArea(),
                                    idMateriaTxt = new JTextArea(),
                                    nombreMateriaTxt = new JTextArea(),
                                    idClaseTxt = new JTextArea(),
                                    inicioClaseTxt = new JTextArea(),
                                    finClaseTxt = new JTextArea(),
                                    idInscripcionTxt = new JTextArea(),
                                    yearInscripcionTxt = new JTextArea();

    private JComboBox               rolComb,
                                    diaComb,
                                    lectorComb;

        private void cargarUsuarios(){
        try {
            List<UsuarioDTO> usuarios = uBl.getAll();
            usuarioTblPnl.removeAll();
            String[] header = {"Id", "Rol", "Cedula", "Correo", "Usuario", "Clave"};
            Object[][] data = new Object[usuarios.size()][6];
            int index = 0;
            for(UsuarioDTO us : usuarios){
                data[index][0] = us.getIdUsuario();
                data[index][1] = rBl.getBy(Integer.valueOf(us.getIdRol())).getNombre();
                data[index][2] = us.getCedula();
                data[index][3] = us.getCorreoInstitucional();
                data[index][4] = us.getNombreUsuario();
                data[index][5] = "***";
                index++;
            }
            usuarioTbl = new JTable(data, header);
            usuarioTbl.setShowHorizontalLines(true);
            usuarioTbl.setGridColor(Style.COLOR_FONT);
            usuarioTbl.setBackground(Style.COLOR_FONT_LIGHT);
            usuarioTbl.setForeground(Style.COLOR_ACCENT_SOLID);
            usuarioTbl.setRowSelectionAllowed(false);
            usuarioTbl.setColumnSelectionAllowed(false);

            usuarioTbl.setPreferredScrollableViewportSize(new Dimension(ANCHO / 5, ANCHO / 10));
            usuarioTbl.setFillsViewportHeight(true);

            usuarioTblPnl.add(new JScrollPane(usuarioTbl));

            usuarioTbl.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = usuarioTbl.rowAtPoint(e.getPoint());
                    int col = usuarioTbl.columnAtPoint(e.getPoint());
                    if (row >= 0 && col >= 0) {
                        String strId = usuarioTbl.getModel().getValueAt(row, 0).toString();
                        try {
                            usuario     = uBl.getByIdUsuario(Integer.parseInt(strId));
                            inscripcion = null;
                            actualizarTextAreas();
                        } catch (Exception ignored) {
                            Style.showMsgError("Error de carga, reinicie el programa");
                        }
                    }
                }
            });
        } catch (Exception e) {
            Style.showMsgError("Error al cargar datos de usuario");
        }
    }
    private void cargarMaterias(){
        try {
            List<MateriaDTO> materias = mBl.getAll();
            materiaTblPnl.removeAll();
            String[] header = {"Id", "Materia"};
            Object[][] data = new Object[materias.size()][2];
            int index = 0;
            for(MateriaDTO mt : materias){
                data[index][0] = mt.getIdMateria();
                data[index][1] = mt.getNombre();
                index++;
            }
            materiaTbl = new JTable(data, header);
            materiaTbl.setShowHorizontalLines(true);
            materiaTbl.setGridColor(Style.COLOR_FONT);
            materiaTbl.setBackground(Style.COLOR_FONT_LIGHT);
            materiaTbl.setForeground(Style.COLOR_ACCENT_SOLID);
            materiaTbl.setRowSelectionAllowed(false);
            materiaTbl.setColumnSelectionAllowed(false);

            usuarioTbl.setPreferredScrollableViewportSize(new Dimension(ANCHO / 5, ANCHO / 10));
            materiaTbl.setFillsViewportHeight(true);

            materiaTblPnl.add(new JScrollPane(materiaTbl));

            materiaTbl.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = materiaTbl.rowAtPoint(e.getPoint());
                    int col = materiaTbl.columnAtPoint(e.getPoint());
                    if (row >= 0 && col >= 0) {
                        String strId = materiaTbl.getModel().getValueAt(row, 0).toString();
                        try {
                            materia     = mBl.getById(Integer.parseInt(strId));
                            clase       = null;
                            inscripcion = null;
                            actualizarTextAreas();
                        } catch (Exception ignored) {
                            Style.showMsgError("Error de carga, reinicie el programa");
                        }
                    }
                }
            });
        } catch (Exception e) {
            Style.showMsgError("Error al cargar datos de materia");
        }
    }
    private void cargarClases(){
        try {
            List<ClaseDTO> clases = cBl.getAll();
            claseTblPnl.removeAll();
            String[] header = {"Id", "Dia", "HoraInicio", "HoraFin"};
            Object[][] data = new Object[clases.size()][4];
            int index = 0;
            for(ClaseDTO cl : clases){
                data[index][0] = cl.getIdClase();
                data[index][1] = dBl.getByIdCliente(Integer.valueOf(cl.getIdDia())).getNombre();
                data[index][2] = cl.getHoraInicio();
                data[index][3] = cl.getHoraFin();
                index++;
            }
            claseTbl = new JTable(data, header);
            claseTbl.setShowHorizontalLines(true);
            claseTbl.setGridColor(Style.COLOR_FONT);
            claseTbl.setBackground(Style.COLOR_FONT_LIGHT);
            claseTbl.setForeground(Style.COLOR_ACCENT_SOLID);
            claseTbl.setRowSelectionAllowed(false);
            claseTbl.setColumnSelectionAllowed(false);

            usuarioTbl.setPreferredScrollableViewportSize(new Dimension(ANCHO / 5, ANCHO / 10));
            claseTbl.setFillsViewportHeight(true);

            claseTblPnl.add(new JScrollPane(claseTbl));

            claseTbl.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = claseTbl.rowAtPoint(e.getPoint());
                    int col = claseTbl.columnAtPoint(e.getPoint());
                    if (row >= 0 && col >= 0) {
                        String strId = claseTbl.getModel().getValueAt(row, 0).toString();
                        try {
                            clase       = cBl.getByIdCliente(Integer.parseInt(strId));
                            materia     = mBl.getById(Integer.parseInt(clase.getIdMateria())); 
                            inscripcion = null;
                            actualizarTextAreas();
                        } catch (Exception ignored) {
                            Style.showMsgError("Error de carga, reinicie el programa");
                        }
                    }
                }
            });
        } catch (Exception e) {
            Style.showMsgError("Error al cargar datos de clase");
        }
    }
    private void cargarInscripciones(){
        try {
            List<InscripcionDTO> inscripciones = iBl.getAll();
            inscripcionTblPnl.removeAll();
            String[] header = {"Id", "Lector", "Aula"};
            Object[][] data = new Object[inscripciones.size()][3];
            int index = 0;
            for(InscripcionDTO in : inscripciones){
                data[index][0] = in.getIdInscripcion();
                data[index][1] = in.getIdLector();
                data[index][2] = lBl.getBy(Integer.valueOf(in.getIdLector())).getCodigoAula();
                index++;
            }
            inscripcionTbl = new JTable(data, header);
            inscripcionTbl.setShowHorizontalLines(true);
            inscripcionTbl.setGridColor(Style.COLOR_FONT);
            inscripcionTbl.setBackground(Style.COLOR_FONT_LIGHT);
            inscripcionTbl.setForeground(Style.COLOR_ACCENT_SOLID);
            inscripcionTbl.setRowSelectionAllowed(false);
            inscripcionTbl.setColumnSelectionAllowed(false);

            usuarioTbl.setPreferredScrollableViewportSize(new Dimension(ANCHO / 5, ANCHO / 10));
            inscripcionTbl.setFillsViewportHeight(true);

            inscripcionTblPnl.add(new JScrollPane(inscripcionTbl));

            inscripcionTbl.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = inscripcionTbl.rowAtPoint(e.getPoint());
                    int col = inscripcionTbl.columnAtPoint(e.getPoint());
                    if (row >= 0 && col >= 0) {
                        String strId = inscripcionTbl.getModel().getValueAt(row, 0).toString();
                        try {
                            inscripcion = iBl.getById(Integer.parseInt(strId));
                            usuario     = uBl.getByIdUsuario(Integer.parseInt(inscripcion.getIdUsuario()));
                            clase       = cBl.getByIdCliente(Integer.parseInt(inscripcion.getIdClase()));
                            materia     = mBl.getById(Integer.parseInt(clase.getIdMateria()));
                            actualizarTextAreas();
                        } catch (Exception ignored) {
                            Style.showMsgError("Error de carga, reinicie el programa");
                        }
                    }
                }
            });
        } catch (Exception e) {
            Style.showMsgError("Error al cargar datos de inscripciones");
        }
    }
    private void actualizarTextAreas(){
        boolean userNull = (usuario == null);
        idUsuarioTxt.setText(userNull ? "" : usuario.getIdUsuario());
        nombreUsuarioTxt.setText(userNull ? "" : usuario.getNombreUsuario());
        claveUsuarioTxt.setText(userNull ? "" : usuario.getClave());
        cedulaUsuarioTxt.setText(userNull ? "" : usuario.getCedula());
        correoUsuarioTxt.setText(userNull ? "" : usuario.getCorreoInstitucional());

        boolean materiaNull = (materia == null);
        idMateriaTxt.setText(materiaNull ? "" : materia.getIdMateria());
        nombreMateriaTxt.setText(materiaNull ? "" : materia.getNombre());

        boolean claseNull = (clase == null);
        idClaseTxt.setText(claseNull ? "" : clase.getIdClase());
        inicioClaseTxt.setText(claseNull ? "" : clase.getHoraInicio());
        finClaseTxt.setText(claseNull ? "" : clase.getHoraFin());

        boolean inscripcionNull = (inscripcion == null);
        idInscripcionTxt.setText(inscripcionNull ? "" : inscripcion.getIdInscripcion());
        yearInscripcionTxt.setText(inscripcionNull ? "" : inscripcion.getAño());
    }
}
