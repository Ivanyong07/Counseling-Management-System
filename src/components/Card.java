
package components;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import model.CardModel;


public class Card extends javax.swing.JPanel {
    
    private Color color1;
    private Color color2;
    
    public Card(Color color1, Color color2, JLabel labelDescription, JLabel labelIcon, JLabel labelTitle, JLabel labelValue){
        this.color1= color1;
        this.color2=color2;
        this.labelDescription=labelDescription;
        this.labelIcon=labelIcon;
        this.labelTitle=labelTitle;
        this.labelValue=labelValue;
    }
 
    public Card() {
        initComponents();
        setOpaque(false);
        color1=Color.BLACK;
        color2=Color.WHITE;
    }
    public void setColor(Color color1, Color color2){
        this.color1 = color1;
        this.color2 = color2;
    }

    
    public void setColors(Color color1, Color color2){
        this.color1 = color1;
        this.color2 = color2;
        repaint();
    }
    
    public void setData(CardModel data){
        labelIcon.setIcon(data.getICcon());
        labelTitle.setText(data.getTitle());
        labelValue.setText(data.getValue());
        labelDescription.setText(data.getDescription());
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(g);
    }
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelIcon = new javax.swing.JLabel();
        labelTitle = new javax.swing.JLabel();
        labelValue = new javax.swing.JLabel();
        labelDescription = new javax.swing.JLabel();

        labelTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTitle.setText("jLabel2");

        labelValue.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelValue.setText("jLabel3");

        labelDescription.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDescription.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelValue)
                    .addComponent(labelDescription)
                    .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(labelTitle)
                .addGap(18, 18, 18)
                .addComponent(labelValue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDescription)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelDescription;
    private javax.swing.JLabel labelIcon;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JLabel labelValue;
    // End of variables declaration//GEN-END:variables
}
