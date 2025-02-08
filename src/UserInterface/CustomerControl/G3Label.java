package UserInterface.CustomerControl;

import UserInterface.Style;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class G3Label extends JLabel{
    public G3Label(Rectangle b){
        customizeComponent(b);
    }
    public G3Label(String text, Rectangle b){
        setBounds(b);
        setText(text);
        customizeComponent(b);
    }
    private void customizeComponent(Rectangle b){
        setBounds(b);
        Font fuente = new Font("Century Gothic", Font.BOLD, (b.height / 7) * 4);
        setCustomizeComponent(getText(), fuente, Style.COLOR_ACCENT_SOLID, Style.COLOR_FONT_LIGHT, b);
    }
    public void setCustomizeComponent(String text, Font  font, Color color, Color colorText, Rectangle b) {
        setText(text);
        setFont(font);
        setOpaque(true);
        setBackground(color);
        setForeground(colorText);
        setHorizontalAlignment(Style.ALIGNMENT_CENTER);
        ponerBorde();
        //setIcon(new ImageIcon(iconPath));
    }
    public void ponerBorde() {
        Border lineBorder = BorderFactory.createLineBorder(Style.COLOR_BORDER);
        Border emptyBorder = new EmptyBorder(5, 5, 5, 5);
        setBorder( new CompoundBorder(lineBorder, emptyBorder));
    }
}