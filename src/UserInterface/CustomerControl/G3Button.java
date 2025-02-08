package UserInterface.CustomerControl;

import UserInterface.Style;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class G3Button  extends JButton implements MouseListener {

    public G3Button(String text){
        customizeComponent(text);
    }

    public G3Button(String text, Rectangle area){
        customizeComponent(text, area);
    }

    public G3Button(String text, String iconPath){
        customizeComponent(text, iconPath);
    }

    public void customizeComponent(String text, String iconPath){ 
        
        setSize(20, 70);
        addMouseListener(this);
        customizeComponent(text);
        setBounds(50, 30, 90, 20); 
        
        setIcon(new ImageIcon(iconPath));
        setFont(Style.FONT);
    }
    public void customizeComponent(String text) {
        setText(text);
        // setFocusPainted(false);
        // setBorderPainted(false);
        // setContentAreaFilled(false);
        setForeground(Style.COLOR_FONT);
        setHorizontalAlignment(Style.ALIGNMENT_CENTER);
        setFont(Style.FONT);
        
        setCursor(new Cursor(Cursor.HAND_CURSOR)); 
    }
    public void customizeComponent(String text, Rectangle area) {
        setBounds(area);
        setText(text);
        // setFocusPainted(false);
        // setBorderPainted(false);
        // setContentAreaFilled(false);
        setForeground(Style.COLOR_FONT);
        setHorizontalAlignment(Style.ALIGNMENT_CENTER);
        setFont(new Font("Century Gothic", Font.PLAIN, (getHeight() / 7) * 4));
        
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setForeground(Color.BLACK);
        setCursor(Style.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(Color.GRAY);
        setCursor(Style.CURSOR_DEFAULT);
    }
}
