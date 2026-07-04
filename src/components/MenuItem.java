package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import model.MenuModel;


// this file is for ui, hover, name icon or selected
// one row of data
public class MenuItem extends javax.swing.JPanel {
    
    private boolean selected;
    private boolean hover;

    public MenuItem(MenuModel data) {
        initComponents();
        if (data.getType() == MenuModel.MenuType.MENU){
            menuName.setText(data.getName());
            menuIcon.setText("");
            menuIcon.setIcon(data.toIcon());
        } else if (data.getType()==MenuModel.MenuType.TITLE){
            menuName.setText(data.getName());
        } else {
            menuName.setText("");
            menuIcon.setText("");
        }
    }
    
    public void setSelected(boolean selected){
        this.selected = selected;
        repaint();
    }
    
    public void setOver(boolean hover){
        this.hover = hover;
        repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuIcon = new javax.swing.JLabel();
        menuName = new javax.swing.JLabel();

        setOpaque(false);

        menuIcon.setForeground(new java.awt.Color(255, 255, 255));
        menuIcon.setText("JIcon");

        menuName.setForeground(new java.awt.Color(255, 255, 255));
        menuName.setText("jName");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(menuIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuName, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menuIcon)
                    .addComponent(menuName))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (selected || hover){
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (selected){
                g2.setColor(new Color(255,255,255,80));
            } else{
                g2.setColor(new Color(255,255,255,20));
            }
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        }
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel menuIcon;
    private javax.swing.JLabel menuName;
    // End of variables declaration//GEN-END:variables

}
