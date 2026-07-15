package view;


import components.Animation;
import components.Notification;
import java.awt.Color;

import java.io.IOException;
import javax.swing.Timer;

import services.AuthService;

import model.User;
import model.Admin;
import model.Counselor;
import model.Receptionist;
import model.Student;

import services.FileHandling;
import view.admin.AdminDashboardFrame;
import view.counselor.CounselorDashboardFrame;
import view.receptionist.ReceptionistDashboardFrame;
import view.student.StudentDashboardFrame;


public class LoginFrame extends javax.swing.JFrame {
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginFrame.class.getName());

    public LoginFrame() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        roundedPanel1 = new components.RoundedPanel();
        notification1 = new components.Notification();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usernameTextBox = new javax.swing.JTextField();
        LoginBtn = new javax.swing.JButton();
        passwordErrorMsg = new javax.swing.JLabel();
        usernameErrorMsg = new javax.swing.JLabel();
        passwordTextBox = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Welcome to our system");

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton1.setText("Quit");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout notification1Layout = new javax.swing.GroupLayout(notification1);
        notification1.setLayout(notification1Layout);
        notification1Layout.setHorizontalGroup(
            notification1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        notification1Layout.setVerticalGroup(
            notification1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Username:");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password:");

        usernameTextBox.addActionListener(this::usernameTextBoxActionPerformed);

        LoginBtn.setText("Login");
        LoginBtn.addActionListener(this::LoginBtnActionPerformed);

        passwordErrorMsg.setForeground(new java.awt.Color(255, 255, 255));
        passwordErrorMsg.setText("Please enter your password");

        usernameErrorMsg.setForeground(new java.awt.Color(255, 255, 255));
        usernameErrorMsg.setText("Please enter your username");

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(notification1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(usernameTextBox, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                                .addComponent(usernameErrorMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordTextBox))
                            .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordErrorMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(notification1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameErrorMsg)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordErrorMsg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(LoginBtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(196, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextBoxActionPerformed

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
        System.out.println(new java.io.File(".data").getAbsolutePath());
                
        String username = usernameTextBox.getText().trim();
        String password = new String(passwordTextBox.getPassword()).trim();

        boolean error = false;

        if (username.isEmpty()){
            usernameErrorMsg.setText("Username cannot be empty");
            usernameTextBox.setText("");
            usernameErrorMsg.setForeground(Color.RED);

//            System.out.println("Hi username"); debug
            error = true;
        } else{
            usernameErrorMsg.setText("");
        }

        if (password.isEmpty()){
            passwordErrorMsg.setText("Password cannot be empty");
            passwordErrorMsg.setForeground(Color.RED);
            passwordTextBox.setText("");

            error = true;
        } else {
            passwordErrorMsg.setText("");
        }

        if (!error){
            try{
                User currentUser = AuthService.login(username, password);
                
                if (currentUser == null){
                    notification1.setTitle("Login Failed");
                    notification1.setMessage("Incorrect username or password");
                    notification1.setStatus("failed");
                    notification1.setVisible(true);


                    Animation.fadeIn(notification1, null);
                    Timer timer = new Timer(2000, null);
                    timer.addActionListener(e -> {
                        Animation.fadeOut(notification1, null);
                        repaint();
                    });
                    timer.setRepeats(false);
                    timer.start();
                    

                    usernameErrorMsg.setText("Username error");
                    usernameTextBox.setText("");
                    usernameErrorMsg.setForeground(Color.RED);
                    
                    passwordErrorMsg.setText("Password error");
                    passwordErrorMsg.setForeground(Color.RED);
                    passwordTextBox.setText("");
                    
                    return; // stop here, don't continue to LoadInformation
                }
                currentUser = FileHandling.LoadInformation(currentUser.getUserID());
                
                if (currentUser instanceof Admin){
                    
                    System.out.println(currentUser.getUserID());
                    AdminDashboardFrame admDashboard = new AdminDashboardFrame((Admin) currentUser);
                    admDashboard.setVisible(true);
                    dispose();
                } else if (currentUser instanceof Receptionist){
                    System.out.println(currentUser.getUserID());
                    ReceptionistDashboardFrame repDashboard = new ReceptionistDashboardFrame((Receptionist) currentUser);
                    repDashboard.setVisible(true);
                    dispose();
                } else if (currentUser instanceof Counselor){
                    System.out.println(currentUser.getUserID());
                    CounselorDashboardFrame counselorDashboardFrame = new CounselorDashboardFrame((Counselor) currentUser);
                    counselorDashboardFrame.setVisible(true);
                    dispose();
                } else if (currentUser instanceof Student){
                    System.out.println(currentUser.getUserID());
                    StudentDashboardFrame studentDashboardFrame = new StudentDashboardFrame((Student) currentUser);
                    studentDashboardFrame.setVisible(true);
                    dispose();
                }

            } catch (IllegalStateException e){
                notification1.setTitle("Account Locked");
                notification1.setMessage("Too many failed attempts. Please try again later.");
                notification1.setStatus("locked");
                notification1.setVisible(true);
                Animation.fadeIn(notification1, null);

                Timer timer2 = new Timer(2000, null);
                timer2.addActionListener(r -> {
                    Animation.fadeOut(notification1, null);
                    repaint();
                });
                timer2.setRepeats(false);
                timer2.start();
                    
            } catch (IOException o){ 
                o.printStackTrace();
            }
        }
    }//GEN-LAST:event_LoginBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
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
        java.awt.EventQueue.invokeLater(() -> new LoginFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private components.Notification notification1;
    private javax.swing.JLabel passwordErrorMsg;
    private javax.swing.JPasswordField passwordTextBox;
    private components.RoundedPanel roundedPanel1;
    private javax.swing.JLabel usernameErrorMsg;
    private javax.swing.JTextField usernameTextBox;
    // End of variables declaration//GEN-END:variables
}
