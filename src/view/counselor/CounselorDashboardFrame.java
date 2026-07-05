
package view.counselor;

import model.Counselor;
import view.Profile;
import Event.EventMenuSelected;
import components.Animation;
import javax.swing.JPanel;
import javax.swing.Timer;
import view.Settings;

public class CounselorDashboardFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CounselorDashboardFrame.class.getName());
    
    private AssignedAppointments assignedAppointments;
    private ConsultationNotesRecommendations consultationNotesRecommendations;
    private PersonalRoster personalRoster;
    private StudentConsultationRecords studentConsultationRecords;
    private Profile profile;
    private Settings settings;
    
    private Counselor currentCounselor;
    
    private int delay= 3000;

    public CounselorDashboardFrame(Counselor currentCounselor) {
        initComponents();
        menu.setCurrentRole("Counselor");
        this.currentCounselor = currentCounselor;
        menu.setTheme("#FD99FF", "#FD99FF");
        
        assignedAppointments = new AssignedAppointments();
        consultationNotesRecommendations = new ConsultationNotesRecommendations();
        personalRoster = new PersonalRoster();
        studentConsultationRecords = new StudentConsultationRecords();
        profile = new Profile(currentCounselor);
        settings = new Settings();
        
        setPanel(personalRoster);
        
        notification.setStatus("success");
        notification.setTitle("Success");
        notification.setMessage("Login Successful");
        notification.setVisible(true);
        Animation.fadeIn(notification, null);
        Timer timer = new Timer(delay, null);
        timer.addActionListener(e -> {
            Animation.fadeOut(notification, null);
        });
        timer.setRepeats(false);
        timer.start();
        
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index){
                if (index == 0){
                    setPanel(assignedAppointments);
                } else if (index == 1){
                    setPanel(consultationNotesRecommendations);
                } else if (index == 2){
                    setPanel(personalRoster);
                } else if (index ==4){
                    setPanel(studentConsultationRecords);
                } else if (index == 5){
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
            .addGap(0, 570, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout notificationLayout = new javax.swing.GroupLayout(notification);
        notification.setLayout(notificationLayout);
        notificationLayout.setHorizontalGroup(
            notificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 249, Short.MAX_VALUE)
        );
        notificationLayout.setVerticalGroup(
            notificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(notification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(notification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
        java.awt.EventQueue.invokeLater(() -> new CounselorDashboardFrame(null).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private components.Menu menu;
    private components.Notification notification;
    // End of variables declaration//GEN-END:variables
}
