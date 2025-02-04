package UserInterface.CustomerControl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class G3Panel extends JPanel {
    private JLabel texto = new JLabel();
    private Color color;
    private Rectangle bordes;

    public G3Panel(Color c, Rectangle b){
        color = c;
        bordes = b;
        setBounds(bordes);
        customizeComponent();
    }
    
    public void customizeComponent() {
        texto.setBounds(bordes);
        Font  FONT_TTL = new Font("Century Gothic", Font.BOLD, (bordes.height / 7) * 4);
        texto.setFont(FONT_TTL);
        setBackground(color);
    }
    public void agregarTexto(JLabel txt){
        texto = txt;
        add(txt);
        customizeComponent();
    }
}