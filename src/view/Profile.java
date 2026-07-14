package view;

import javax.swing.JOptionPane;
import model.Admin;
import model.Counselor;
import model.Receptionist;
import model.User;
import model.Student;
import view.EditProfileDialog;


public class Profile extends javax.swing.JPanel {
    
    private User currentUser;
    

    public Profile(User currentUser) {
        initComponents();
        this.currentUser = currentUser;
        
        // load information
        refresh();
    }
    
    private void loadRoleInfo(){
        
        textFieldUserID.setText(currentUser.getUserID());
        textFieldUserID.setEditable(false);
        
        textFieldFirstname.setText(currentUser.getFirstname());
        textFieldLastname.setText(currentUser.getLastname());
        textFieldUsername.setText(currentUser.getUsername());
        textFieldPassword.setText(currentUser.getPassword());
        textFieldEmail.setText(currentUser.getEmail());
        textFieldStatus.setText(currentUser.getStatus());
    }
    
    private void loadRoleDetails(){
        
        if (currentUser instanceof Admin){
            
            Admin admin = (Admin) currentUser;
            textDetails1.setText(admin.getOffice());
            labelDetails1.setText("Office Number:");
            
            textDetails2.setText(admin.getContactNumber());
            labelDetails2.setText("Contact Number:");
            
        } else if (currentUser instanceof Receptionist){
            
            Receptionist receptionist = (Receptionist) currentUser;
            
            textDetails1.setText(receptionist.getCounter());
            labelDetails1.setText("Counter Number:");
            
            textDetails2.setText(receptionist.getContactNumber());
            labelDetails2.setText(receptionist.getContactNumber());
            
        } else if (currentUser instanceof Counselor){
            
            Counselor counselor = (Counselor) currentUser;
            
            textDetails1.setText(counselor.getSpecialist());
            labelDetails1.setText("Specialist:");
            
            textDetails2.setText(counselor.getContactNumber());
            labelDetails2.setText("Contact Number:");
            
        } else if (currentUser instanceof Student) {
            
            Student student = (Student) currentUser;
            
            textDetails1.setText(student.getCourse());
            labelDetails1.setText("Course:");
            
            textDetails2.setText(student.getContactNumber());
            labelDetails2.setText("Contact Number:");
        }
    }
    
    public void refresh(){
        loadRoleInfo();
        loadRoleDetails();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        textFieldLastname = new javax.swing.JTextField();
        textFieldUserID = new javax.swing.JTextField();
        textFieldFirstname = new javax.swing.JTextField();
        textFieldPassword = new javax.swing.JTextField();
        textFieldEmail = new javax.swing.JTextField();
        textDetails1 = new javax.swing.JTextField();
        textFieldUsername = new javax.swing.JTextField();
        textFieldStatus = new javax.swing.JTextField();
        textDetails2 = new javax.swing.JTextField();
        labelFirstname = new javax.swing.JLabel();
        labelUserID = new javax.swing.JLabel();
        labelLastname = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        labelUsername = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelDetails1 = new javax.swing.JLabel();
        labelStatus = new javax.swing.JLabel();
        labelDetails2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnChangePassword = new javax.swing.JButton();
        btnChangeProfile = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel2.setText("User Details:");

        textFieldLastname.setText("jTextField1");
        textFieldLastname.addActionListener(this::textFieldLastnameActionPerformed);

        textFieldUserID.setText("jTextField1");

        textFieldFirstname.setText("jTextField1");
        textFieldFirstname.addActionListener(this::textFieldFirstnameActionPerformed);

        textFieldPassword.setText("jTextField1");
        textFieldPassword.addActionListener(this::textFieldPasswordActionPerformed);

        textFieldEmail.setText("jTextField1");
        textFieldEmail.addActionListener(this::textFieldEmailActionPerformed);

        textDetails1.setText("jTextField1");
        textDetails1.addActionListener(this::textDetails1ActionPerformed);

        textFieldUsername.setText("jTextField1");
        textFieldUsername.addActionListener(this::textFieldUsernameActionPerformed);

        textFieldStatus.setText("jTextField1");
        textFieldStatus.addActionListener(this::textFieldStatusActionPerformed);

        textDetails2.setText("jTextField1");
        textDetails2.addActionListener(this::textDetails2ActionPerformed);

        labelFirstname.setText("Firstname:");

        labelUserID.setText("User ID: ");

        labelLastname.setText("Lastname: ");

        labelPassword.setText("Password");

        labelUsername.setText("Username:");

        labelEmail.setText("Email:");

        labelDetails1.setText("Details 1:");

        labelStatus.setText("Status:");

        labelDetails2.setText("Details 2:");

        jLabel1.setText("(Read Only)");

        btnChangePassword.setText("Edit Password");
        btnChangePassword.addActionListener(this::btnChangePasswordActionPerformed);

        btnChangeProfile.setText("Edit Profile");
        btnChangeProfile.addActionListener(this::btnChangeProfileActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textFieldUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textFieldFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnChangePassword)))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelDetails2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textDetails2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnChangeProfile)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelUserID)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelFirstname)
                            .addComponent(btnChangePassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelLastname)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelStatus))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDetails1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textDetails2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDetails2))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsername))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPassword))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChangeProfile)
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldLastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldLastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldLastnameActionPerformed

    private void textFieldFirstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldFirstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldFirstnameActionPerformed

    private void textFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPasswordActionPerformed

    private void textFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldEmailActionPerformed

    private void textDetails1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDetails1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDetails1ActionPerformed

    private void textFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldUsernameActionPerformed

    private void textFieldStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldStatusActionPerformed

    private void textDetails2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDetails2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDetails2ActionPerformed

    private void btnChangeProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeProfileActionPerformed
        
        java.awt.Window window = javax.swing.SwingUtilities.getWindowAncestor(this);
        EditProfileDialog dialog = new EditProfileDialog((java.awt.Frame) window, true, currentUser);
        
        dialog.setLocationRelativeTo(window);
        
        dialog.setEditable(true);
        dialog.setVerification(true);
        dialog.setEditButton(true);
        dialog.setCancelButton("Cancel");
        
        dialog.setVisible(true);
    }//GEN-LAST:event_btnChangeProfileActionPerformed

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        java.awt.Window window = javax.swing.SwingUtilities.getWindowAncestor(this);
        ChangePasswordDialog dialog = new ChangePasswordDialog((java.awt.Frame) window, true, currentUser);
        
        dialog.setLocationRelativeTo(window);
        
        dialog.setVisible(true);
    }//GEN-LAST:event_btnChangePasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnChangeProfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelDetails1;
    private javax.swing.JLabel labelDetails2;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelFirstname;
    private javax.swing.JLabel labelLastname;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelUserID;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JTextField textDetails1;
    private javax.swing.JTextField textDetails2;
    private javax.swing.JTextField textFieldEmail;
    private javax.swing.JTextField textFieldFirstname;
    private javax.swing.JTextField textFieldLastname;
    private javax.swing.JTextField textFieldPassword;
    private javax.swing.JTextField textFieldStatus;
    private javax.swing.JTextField textFieldUserID;
    private javax.swing.JTextField textFieldUsername;
    // End of variables declaration//GEN-END:variables
}
