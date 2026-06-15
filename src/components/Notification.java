package components;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Notification extends javax.swing.JPanel {
    
    private String status;
    
    
    public void setStatus(String status){
        this.status = status;
        repaint();
    }
    
    public Notification() {
        initComponents();
        setOpaque(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.85f)); // transparent
        
        if ("success".equals(status)){
            
            g2.setColor(new Color(32, 232, 80)); // green
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            
            
            g2.setColor(Color.WHITE);
            g2.drawString("Login Successful", 0,30);
            
        } else if ("failed".equals(status)){
            
            g2.setColor(new Color (200,0,0,200)); // red 
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            
            
            g2.setColor(Color.WHITE);
            g2.drawString("Failed", 0, 30);
            
        } else if ("locked".equals(status)) {
            
            g2.setColor(new Color (128, 124, 124)); // grey
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            
            
            g2.setColor(Color.WHITE);
            g2.drawString("Locked", getWidth(), getHeight());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
