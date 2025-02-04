package UserInterface.CustomerControl;

import UserInterface.Style;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class G3TextBox extends JTextField {

    public G3TextBox() {
        customizeComponent();
    }

    private void customizeComponent() {
        setBorderRect();
        setFont(Style.FONT);  
        setForeground(Style.COLOR_FONT_LIGHT);  
        setCaretColor(Style.COLOR_CURSOR);
        setMargin(new Insets(5, 5, 5, 5));
        setOpaque(false);
    }

    public void setBorderRect() {
        Border lineBorder = BorderFactory.createLineBorder(Style.COLOR_BORDER);
        Border emptyBorder = new EmptyBorder(5, 5, 5, 5);
        setBorder( new CompoundBorder(lineBorder, emptyBorder));
    }

    public void setBorderLine(){
        int thickness = 1;
        setBorder(  BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(0, 0, thickness, 0),
                    BorderFactory.createMatteBorder(0, 0, thickness, 0, Style.COLOR_BORDER) 
        ));
    }
}
