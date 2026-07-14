package components;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class CurrentTime extends javax.swing.JPanel {
    
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dateFormat;
    String time;
    String date;
    
    
    public CurrentTime() {
        initComponents();
        setOpaque(false);
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        setTime();
        javax.swing.Timer timer = new javax.swing.Timer(1000, e -> setTime());
        timer.start(); // repeats every second, non-blocking
        
    }
    
    public void setTime(){
        java.util.Calendar cal = java.util.Calendar.getInstance();
        labelTime.setText(timeFormat.format(cal.getTime()));
        labelDate.setText(dateFormat.format(cal.getTime()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTime = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();

        labelTime.setForeground(new java.awt.Color(255, 255, 255));
        labelTime.setText("jLabel1");

        labelDate.setForeground(new java.awt.Color(255, 255, 255));
        labelDate.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTime, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
            .addComponent(labelDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDate))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelTime;
    // End of variables declaration//GEN-END:variables
}
