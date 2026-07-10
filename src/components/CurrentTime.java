package components;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class CurrentTime extends javax.swing.JPanel {
    
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    String time;
    String day;
    
    
    public CurrentTime() {
        initComponents();
        timeFormat = new SimpleDateFormat("hh:mm:ss");
        dayFormat = new SimpleDateFormat("EEEE");
        setTime();
        javax.swing.Timer timer = new javax.swing.Timer(1000, e -> setTime());
        timer.start(); // repeats every second, non-blocking
        
    }
    
    public void setTime(){
        java.util.Calendar cal = java.util.Calendar.getInstance();
        labelTime.setText(timeFormat.format(cal.getTime()));
        labelDay.setText(dayFormat.format(cal.getTime()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTime = new javax.swing.JLabel();
        labelDay = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        labelTime.setText("jLabel1");

        labelDay.setText("jLabel2");

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(labelTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelDay;
    private javax.swing.JLabel labelTime;
    // End of variables declaration//GEN-END:variables
}
