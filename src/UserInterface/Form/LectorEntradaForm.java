    package UserInterface.Form;

    import BusinessLogic.Entities.Lector;
    import DataAccess.DTO.AsistenciaDTO;
    import UserInterface.CustomerControl.G3Button;
    import UserInterface.CustomerControl.G3TextBox;
    import UserInterface.Style;
    import java.awt.BorderLayout;
    import java.awt.Container;
    import java.awt.Font;
    import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
    import javax.swing.JTextField;
    import javax.swing.border.EmptyBorder;

    public class LectorEntradaForm extends JFrame{
        AsistenciaDTO asistencia;
        private MainForm    padre;
        private Lector      lector;
        final   int         ESCALA              = 70;
        final   int         ALTO                = ESCALA * 9;
        final   int         ANCHO               = ESCALA * 9;
        final   int         SEPARACION          = ALTO / 25;


        private JPanel      cabecera            = new JPanel();
        private JLabel      bienvenida          = new JLabel();
        private G3Button    salirBtn       = new G3Button("CERRAR PROGRAMA");
        
        private JPanel      panelActual;
        private JPanel      menu                = new JPanel();
        private G3TextBox   lecturaTxt          = new G3TextBox();

        private JPanel      pantalla            = new JPanel();
        

        public LectorEntradaForm(String titulo, MainForm p) {
            padre = p;
            panelActual = menu;
            customizeComponent(titulo);

            salirBtn.addActionListener( e -> salir());

            lector = new Lector();
            
            if(!lecturaTxt.getText().equals("")){
                lecturaTxt.addKeyListener(lector.obtenerKeyListenerEntrada(lecturaTxt, asistencia));
                lecturaTxt.setText("");
            }
            
            setVisible(true);
            
        }

        public void customizeComponent(String titulo){
            setTitle(titulo);
            setSize(ANCHO, ALTO);
            setResizable(false);
            setLocation(0, 0);
            //setLocationRelativeTo(null);

            Container container = getContentPane();
            container.setLayout(new BorderLayout());


            cabecera.setLayout(new BorderLayout());
            cabecera.setBackground(Style.COLOR_ACCENT_SOLID);
            cabecera.setBorder(new EmptyBorder(ANCHO / 28, ANCHO / 28, ANCHO / 28, ANCHO / 28));
            bienvenida.setForeground(Style.COLOR_FONT_LIGHT);
            bienvenida.setFont(new Font("Century Gothic", Font.BOLD, (ESCALA * 2) / 7));
            bienvenida.setText("REGISTRO HORA DE ENTRADA");

            salirBtn.setForeground(Style.COLOR_ACCENT_SOLID);
            salirBtn.setBackground(Style.COLOR_FONT_LIGHT);

            cabecera.add(bienvenida, BorderLayout.WEST);
            cabecera.add(salirBtn, BorderLayout.EAST);

            menu.setLayout(new BorderLayout());
            menu.setBackground(Style.COLOR_ACCENT_SOLID);
            menu.setBorder(new EmptyBorder(ANCHO / 20, ANCHO / 7, ANCHO / 20, ANCHO / 7));
            
            lecturaTxt.setForeground(Style.COLOR_ACCENT_SOLID);
            lecturaTxt.setFont(new Font("Century Gothic", Font.BOLD, (ESCALA * 2) / 3));
            lecturaTxt.setText("ACERCE SU TARJETA AL LECTOR");
            lecturaTxt.setHorizontalAlignment(JTextField.CENTER);
            //lecturaTxt.setEditable(false);

            menu.add(lecturaTxt, BorderLayout.CENTER);

            pantalla.setLayout(null);

            add(menu, BorderLayout.CENTER);
            add(cabecera, BorderLayout.NORTH); // Agregar fondo después del menu
            add(panelActual);
            
        }

        public void salir(){
            setVisible(false);
            padre.mostrarLogin();
        }


    }
