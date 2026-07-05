
package view.student;

import view.Profile;
import Event.EventMenuSelected;
import components.Animation;
import javax.swing.JPanel;
import javax.swing.Timer;
import view.Settings;

import model.Student;


public class StudentDashboardFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(StudentDashboardFrame.class.getName());
    
    private AppoinementHistory appoinementHistory;
    private CounselingAppointments counselingAppointments;
    private CounselorProfiles counselorProfiles;
    private QueueNumber queueNumber;
    private Profile profile;
    private Settings settings;
    private Student currentStduent;
    private int delay = 3000;


    public StudentDashboardFrame(Student currentStudent) {
        initComponents();
        menu.setCurrentRole("Student");
        this.currentStduent = currentStudent;
        menu.setTheme("#FD99FF", "#FD99FF");
        
        appoinementHistory = new AppoinementHistory();
        counselingAppointments = new CounselingAppointments();
        counselorProfiles = new CounselorProfiles();
        queueNumber = new QueueNumber();
        profile = new Profile(currentStudent);
        settings = new Settings();
        
        setPanel(queueNumber);
        notification.setStatus("success");
            notification.setTitle("Success");
            notification.setMessage("Login Successful");
            notification.setVisible(true);
            Animation.fadeIn(notification, null);
            Timer timer = new Timer(delay, null); // set after 3 seconds the notification box fadeout
            // 3000 -> 3s
            timer.addActionListener(e -> {
                Animation.fadeOut(notification, null);
            });
                timer.setRepeats(false); // run only one time
                timer.start();
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index){
                if (index == 0){
                    setPanel(queueNumber);
                } else if (index == 1){
                    setPanel(counselingAppointments);
                } else if (index == 2){
                    setPanel(appoinementHistory);
                } else if (index == 4) {
                    setPanel(counselorProfiles);
                } else if (index ==5){
                    setPanel(profile);
                } else if (index == 6){
                    setPanel(settings);
                }
            }
        });
    }
    
    public void setPanel(JPanel panel){
        mainPanel.removeAll();
        panel.setPreferredSize(new java.awt.Dimension(mainPanel.getWidth(), mainPanel.getHeight()));
        mainPanel.setLayout(new java.awt.BorderLayout());
        mainPanel.add(panel, java.awt.BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        menu = new components.Menu();
        notification = new components.Notification();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout notificationLayout = new javax.swing.GroupLayout(notification);
        notification.setLayout(notificationLayout);
        notificationLayout.setHorizontalGroup(
            notificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 227, Short.MAX_VALUE)
        );
        notificationLayout.setVerticalGroup(
            notificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(notification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(notification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new StudentDashboardFrame(null).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private components.Menu menu;
    private components.Notification notification;
    // End of variables declaration//GEN-END:variables
}
