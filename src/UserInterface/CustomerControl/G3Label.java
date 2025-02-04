package UserInterface.CustomerControl;

import UserInterface.Style;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class G3Label extends JLabel{
    public G3Label(){
        customizeComponent();
    }
    public G3Label(String text){
        setText(text);
        customizeComponent();
    }
    private void customizeComponent(){
        setCustomizeComponent(getText(), Style.FONT, Style.COLOR_FONT_LIGHT);
    }
    public void setCustomizeComponent(String text, Font  font, Color color) {
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(color);
        //setIcon(new ImageIcon(iconPath));
    }
}