
package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class LogoutBtn extends JButton{
    
    private final Color defaultColor = new Color(255, 87, 87);
    private final Color hoverColor = new Color(200, 50, 50);
    
    public LogoutBtn() {
        setOpaque(false);
        setText("Logout");
        setFont(new Font("Segoe UI", Font.BOLD, 14));
        setForeground(Color.WHITE);
        setBackground(defaultColor);
        
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(true);
        
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                setBackground(hoverColor);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                setBackground(defaultColor);
            }
        });
        
        addActionListener(e -> {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            
            if(parentFrame != null){
                parentFrame.dispose();
                new LoginFrame().setVisible(true);
            }
        });
    }
    @Override
        public void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight()); // Draws a flat rectangle
            super.paintComponent(g); // Draws the text on top
        }
    
    
}
