
package view.admin;

import view.Profile;
import Event.EventMenuSelected;
import components.Animation;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.Admin;
import view.Settings;

public class AdminDashboardFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminDashboardFrame.class.getName());
    
    private UserAccount userAccountPanel;
    private AppointmentStatistics appointmentStatistics;
    private GenerateReports generateReports;
    private StaffRosterSchedules staffRosterSchedules;
    private Profile profile;
    private Settings settings;
    private Admin currentAdmin;

    private int delay = 3000;
    
    public AdminDashboardFrame(Admin currentAdmin) {
            setUndecorated(true);
           
            initComponents();
            
            getContentPane().setBackground(new Color(51, 51, 51));
            setLocationRelativeTo(null);
            menu.setCurrentRole("Admin");
            notificationBtn2.setCurrentRole("Admin");
            this.currentAdmin = currentAdmin; 
            menu.setTheme("#3D3D3D", "#4D4C4C");
            
            userAccountPanel = new UserAccount();
            appointmentStatistics = new AppointmentStatistics();
            generateReports = new GenerateReports();
            staffRosterSchedules = new StaffRosterSchedules();
            profile = new Profile(currentAdmin);
            settings = new Settings();

            setPanel(userAccountPanel); // initial panel
            
            // Notification UI
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
                    setPanel(userAccountPanel);
                } else if (index == 1){
                    setPanel(staffRosterSchedules);
                } else if (index == 2){
                    setPanel(appointmentStatistics);
                } else if (index == 4) {
                    setPanel(generateReports);
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

        menu = new components.Menu();
        mainPanel = new javax.swing.JPanel();
        currentTime1 = new components.CurrentTime();
        notificationBtn2 = new components.NotificationBtn();
        notification = new components.Notification();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout notificationLayout = new javax.swing.GroupLayout(notification);
        notification.setLayout(notificationLayout);
        notificationLayout.setHorizontalGroup(
            notificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 236, Short.MAX_VALUE)
        );
        notificationLayout.setVerticalGroup(
            notificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(notification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 335, Short.MAX_VALUE)
                        .addComponent(currentTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(notificationBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(notification, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(currentTime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(notificationBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
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
        java.awt.EventQueue.invokeLater(() -> new AdminDashboardFrame(null).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.CurrentTime currentTime1;
    private javax.swing.JPanel mainPanel;
    private components.Menu menu;
    private components.Notification notification;
    private components.NotificationBtn notificationBtn2;
    // End of variables declaration//GEN-END:variables
}
