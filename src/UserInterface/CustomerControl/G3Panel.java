package UserInterface.CustomerControl;

import UserInterface.Style;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class G3Panel extends JPanel {
    private JLabel texto = new JLabel();
    private Color color;
    private Rectangle bordes;
    
    public G3Panel(Color c, Rectangle b){
        setLayout(null);
        color = c;
        bordes = b;
    }
    
    public void customizeComponent() {
        if (bordes != null){
            setBounds(bordes);
            texto.setBounds(0, 0, getWidth(), getHeight());
        }
        texto.setHorizontalAlignment(Style.ALIGNMENT_CENTER);
        ponerBorde();
        texto.setFont(new Font("Century Gothic", Font.BOLD, (getHeight() / 7) * 4));
        setBackground(color);
    }
    public void agregarTexto(JLabel txt){
        texto = txt;
        add(txt);
        customizeComponent();
    }
    public void ponerBorde() {
        Border lineBorder = BorderFactory.createLineBorder(Style.COLOR_BORDER);
        Border emptyBorder = new EmptyBorder(5, 5, 5, 5);
        setBorder( new CompoundBorder(lineBorder, emptyBorder));
    }
}