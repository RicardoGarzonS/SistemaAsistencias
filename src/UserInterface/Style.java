package UserInterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public abstract class Style {
    public static final Color COLOR_FONT = new Color(0, 0, 0);
    public static final Color COLOR_ACCENT = new Color(31, 78, 121, 166);
    public static final Color COLOR_ACCENT_SOLID = new Color(31, 78, 121);
    public static final Color COLOR_FONT_LIGHT = new Color(255, 255, 255);
    public static final Color COLOR_CURSOR = Color.black;
    public static final Color COLOR_BORDER = Color.black;
    public static final Font  FONT         = new Font("Century Gothic", Font.PLAIN, 20);
    public static final Font  FONT_TTL     = new Font("Century Gothic", Font.BOLD, 85);
    public static final Font  FONT_BOLD    = new Font("JetBrains Mono", Font.BOLD | Font.PLAIN, 14);
    public static final Font  FONT_SMALL   = new Font("JetBrains Mono", Font.PLAIN| Font.PLAIN, 10);

    public static final int ALIGNMENT_LEFT  = SwingConstants.LEFT;
    public static final int ALIGNMENT_RIGHT = SwingConstants.RIGHT;
    public static final int ALIGNMENT_CENTER= SwingConstants.CENTER;

    public static final Cursor CURSOR_HAND    = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    public static final URL URL_MAIN  = Style.class.getResource("/UserInterface/Resource/Img/Main.png");
    public static final URL URL_LOGO  = Style.class.getResource("/UserInterface/Resource/Img/Logo.png");
    public static final URL URL_SPLASH= Style.class.getResource("/UserInterface/Resource/Img/");

    public static final CompoundBorder createBorderRect(){
        return BorderFactory.createCompoundBorder(  new LineBorder(Color.lightGray),
                                                    new EmptyBorder(5, 5, 5, 5));
    }

    public static final void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg, "Sistema de Asistencias", JOptionPane.INFORMATION_MESSAGE);
    }
    public static final void showMsgError(String msg){
        JOptionPane.showMessageDialog(null, msg, "💀 Sistema de Asistencias", JOptionPane.OK_OPTION);
    }

    public static final boolean showConfirmYesNo(String msg){
        return (JOptionPane.showConfirmDialog(null, msg, "Sistema de Asistencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
}
