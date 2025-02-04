package UserInterface.CustomerControl;

import UserInterface.Style;
import java.awt.*;
import javax.swing.*;

public class G3LabelText extends JPanel{
    private G3Label    lblEtiqueta = new G3Label();
    private G3TextBox  txtContenido= new G3TextBox();

    public G3LabelText(String etiqueta) {
        setLayout(new BorderLayout());

        lblEtiqueta.setCustomizeComponent(  etiqueta, 
                                            Style.FONT_SMALL, 
                                            Style.COLOR_FONT_LIGHT); 
        //txtContenido.setBorder(txtContenido.createBorderLine());
        txtContenido.setBorderLine();
        add(lblEtiqueta, BorderLayout.NORTH);
        add(txtContenido, BorderLayout.CENTER);
    }
}
