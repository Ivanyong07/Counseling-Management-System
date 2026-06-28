package view;

import components.Animation;
import components.Notification;
import javax.swing.Timer;
import model.Admin;
import model.Receptionist;
import model.Student;
import model.Counselor;
import model.User;
import services.FileHandling;

public class EditProfileDialog extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EditProfileDialog.class.getName());
    
    private User currentUser;
    private Notification notification;
    private int delay = 2000;
    
    public EditProfileDialog(java.awt.Frame parent, boolean modal, User currentUser) {
        super(parent, modal);
        initComponents();
        this.currentUser = currentUser;
        loadInfo();
    }
    
    private void loadInfo(){
        
        labelUserID.setText(currentUser.getUserID());
        
        textFieldFirstname.setText(currentUser.getUsername());
        textFieldLastname.setText(currentUser.getLastname());
        textFieldUsername.setText(currentUser.getUsername());
        textFieldEmail.setText(currentUser.getEmail());
        textFieldStatus.setText(currentUser.getStatus());
        
        if (currentUser instanceof Admin){
            Admin admin = (Admin) currentUser;
            
            textFieldDetails1.setText(admin.getOffice());
            labelDetails1.setText("Office Number:");
            
            textFieldDetails2.setText(admin.getContactNumber());
            labelDetails2.setText("Contact Number");
        } else if (currentUser instanceof Receptionist){
            Receptionist receptionist = (Receptionist) currentUser;
            
            textFieldDetails1.setText(receptionist.getCounter());
            labelDetails1.setText("Counter Number:");
            
            textFieldDetails2.setText(receptionist.getContactNumber());
            labelDetails2.setText("Contact Number");
        } else if (currentUser instanceof Counselor){
            Counselor counselor = (Counselor) currentUser;
            
            textFieldDetails1.setText(counselor.getSpecialist());
            labelDetails1.setText("Specialist:");
            
            textFieldDetails2.setText(counselor.getContactNumber());
            labelDetails2.setText("Contact Number");
            
        } else if (currentUser instanceof Student){
            Student student = (Student) currentUser;
            
            textFieldDetails1.setText(student.getCourse());
            labelDetails1.setText("Specialist:");
            
            textFieldDetails2.setText(student.getContactNumber());
            labelDetails2.setText("Contact Number");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textFieldFirstname = new javax.swing.JTextField();
        textFieldLastname = new javax.swing.JTextField();
        textFieldUsername = new javax.swing.JTextField();
        textFieldEmail = new javax.swing.JTextField();
        textFieldStatus = new javax.swing.JTextField();
        textFieldDetails1 = new javax.swing.JTextField();
        textFieldDetails2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelUserID = new javax.swing.JLabel();
        labelDetails1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textFieldPasswordCheck = new javax.swing.JPasswordField();
        labelDetails2 = new javax.swing.JLabel();
        textFieldOTP = new javax.swing.JTextField();
        btnSendOTP = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("User Profile");

        textFieldFirstname.setText("jTextField1");
        textFieldFirstname.addActionListener(this::textFieldFirstnameActionPerformed);

        textFieldLastname.setText("jTextField1");
        textFieldLastname.addActionListener(this::textFieldLastnameActionPerformed);

        textFieldUsername.setText("jTextField1");
        textFieldUsername.addActionListener(this::textFieldUsernameActionPerformed);

        textFieldEmail.setText("jTextField1");
        textFieldEmail.addActionListener(this::textFieldEmailActionPerformed);

        textFieldStatus.setText("jTextField1");
        textFieldStatus.addActionListener(this::textFieldStatusActionPerformed);

        textFieldDetails1.setText("jTextField1");
        textFieldDetails1.addActionListener(this::textFieldDetails1ActionPerformed);

        textFieldDetails2.setText("jTextField1");
        textFieldDetails2.addActionListener(this::textFieldDetails2ActionPerformed);

        jButton1.setText("Edit");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Cancel");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Firstname");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Email");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Lastname");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Username");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("User ID:");

        labelUserID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelUserID.setText("UserID");

        labelDetails1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDetails1.setText("Details1");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Status");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("Please enter password to save");

        textFieldPasswordCheck.setText("jPasswordField1");

        labelDetails2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDetails2.setText("Details2");

        textFieldOTP.setText("OTP");
        textFieldOTP.addActionListener(this::textFieldOTPActionPerformed);

        btnSendOTP.setText("Send OTP");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("Please enter OTP number to save");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("Please make sure your email is valid for receive OTP number");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textFieldOTP, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSendOTP))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(textFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldDetails2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldPasswordCheck, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDetails2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(12, 12, 12)
                .addComponent(labelUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(labelUserID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(textFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDetails1)
                    .addComponent(textFieldDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textFieldDetails2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldPasswordCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldOTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSendOTP)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelDetails2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldFirstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldFirstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldFirstnameActionPerformed

    private void textFieldLastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldLastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldLastnameActionPerformed

    private void textFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldUsernameActionPerformed

    private void textFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldEmailActionPerformed

    private void textFieldStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldStatusActionPerformed

    private void textFieldDetails1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldDetails1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldDetails1ActionPerformed

    private void textFieldDetails2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldDetails2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldDetails2ActionPerformed

    private void textFieldOTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldOTPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldOTPActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String password = new String(textFieldPasswordCheck.getPassword());
        
        if (!password.equals(currentUser.getPassword())){
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
            return;
        }
        
        // Update user info
        currentUser.setFirstname(textFieldFirstname.getText().trim());
    }//GEN-LAST:event_jButton1ActionPerformed

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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                EditProfileDialog dialog = new EditProfileDialog(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendOTP;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelDetails1;
    private javax.swing.JLabel labelDetails2;
    private javax.swing.JLabel labelUserID;
    private javax.swing.JTextField textFieldDetails1;
    private javax.swing.JTextField textFieldDetails2;
    private javax.swing.JTextField textFieldEmail;
    private javax.swing.JTextField textFieldFirstname;
    private javax.swing.JTextField textFieldLastname;
    private javax.swing.JTextField textFieldOTP;
    private javax.swing.JPasswordField textFieldPasswordCheck;
    private javax.swing.JTextField textFieldStatus;
    private javax.swing.JTextField textFieldUsername;
    // End of variables declaration//GEN-END:variables
}
