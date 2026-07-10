package view;

import model.Counselor;
import model.Receptionist;
import model.Student;
import model.User;
import services.UserService;

public class CreateUserDialog extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CreateUserDialog.class.getName());
    private String role;

    public CreateUserDialog(java.awt.Frame parent, boolean modal, String role) {
        super(parent, modal);
        initComponents();
        if (role.equals("Receptionist")){
            
            textFieldUserID.setText(UserService.generateUserID("Receptionist"));
            labelDetails1.setText("Counter Number: ");
            labelDetails2.setText("Contact Number: ");
            
        } else if (role.equals("Counselor")){
            
            textFieldUserID.setText(UserService.generateUserID("Counselor"));
            labelDetails1.setText("Specialist: ");
            labelDetails2.setText("Contact Number: ");
            
        } else if (role.equals("Student")){
            
            textFieldUserID.setText(UserService.generateUserID("Student"));
            labelDetails1.setText("Course: ");
            labelDetails2.setText("Contact Number: ");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textFieldUserID = new javax.swing.JTextField();
        textFieldFirstname = new javax.swing.JTextField();
        textFieldLastname = new javax.swing.JTextField();
        textFieldUsername = new javax.swing.JTextField();
        textFieldEmail = new javax.swing.JTextField();
        textFieldDetails1 = new javax.swing.JTextField();
        textFieldDetails2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        labelUserID = new javax.swing.JLabel();
        labelFirstname = new javax.swing.JLabel();
        labelLastname = new javax.swing.JLabel();
        labelUsername = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        textFieldPassword = new javax.swing.JPasswordField();
        labelEmail = new javax.swing.JLabel();
        labelStatus = new javax.swing.JLabel();
        labelDetails1 = new javax.swing.JLabel();
        labelDetails2 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        textFieldStatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("User Form");

        textFieldUserID.setEditable(false);
        textFieldUserID.setText("jTextField1");
        textFieldUserID.addActionListener(this::textFieldUserIDActionPerformed);

        textFieldEmail.addActionListener(this::textFieldEmailActionPerformed);

        labelUserID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelUserID.setText("User ID:");

        labelFirstname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelFirstname.setText("Firstname:");

        labelLastname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelLastname.setText("Lastname:");

        labelUsername.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelUsername.setText("Username:");

        labelPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPassword.setText("Password:");

        labelEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelEmail.setText("Email:");

        labelStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelStatus.setText("Status:");

        labelDetails1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDetails1.setText("Details1:");

        labelDetails2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDetails2.setText("Details2:");

        btnCancel.setBackground(new java.awt.Color(255, 51, 51));
        btnCancel.setForeground(new java.awt.Color(0, 0, 0));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(this::btnCancelActionPerformed);

        jButton1.setText("Create");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        textFieldStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDetails2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textFieldFirstname, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                .addComponent(textFieldUserID)
                                .addComponent(textFieldLastname, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                .addComponent(textFieldUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                .addComponent(textFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                .addComponent(textFieldDetails1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                .addComponent(textFieldDetails2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                .addComponent(textFieldPassword)))))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(labelUserID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFirstname))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLastname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPassword)
                    .addComponent(textFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStatus)
                    .addComponent(textFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDetails1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldDetails2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDetails2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(jButton1))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String userID = textFieldUserID.getText();
        String firstname = textFieldFirstname.getText();
        String lastname = textFieldLastname.getText();
        String username = textFieldUsername.getText();
        String password = new String(textFieldPassword.getPassword());
        String email = textFieldEmail.getText();
        String status = textFieldStatus.getSelectedItem().toString();
        
        String detail1 = textFieldDetails1.getText();
        String detail2 = textFieldDetails2.getText();
        
        if (firstname.isEmpty() || lastname.isEmpty() || username.isEmpty() || status.isEmpty() || detail1.isEmpty() || detail2.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Please fill in all required fields!!");
            return;
        }
        
        if (!password.isEmpty()){
            if (password.length() < 8){
                javax.swing.JOptionPane.showMessageDialog(this,"Password length must be more than 8!!");
                return;
            }
        } else{
            javax.swing.JOptionPane.showMessageDialog(this, "You must enter password!!");
        }
        
        try {
                boolean isSucces = false;
                
                if(this.role.equals("Receptionist")){
                    Receptionist newRep = new Receptionist(userID, firstname, lastname, username, password, email, status,detail1, detail2);
                    
                    if (UserService.createUser(newRep)!=null){
                        UserService.createReceptionist(newRep);
                        isSucces = true;
                    }
                } else if (this.role.equals("Counselor")){
                    Counselor newCsl = new Counselor(userID, firstname, lastname, username, password, email, status, detail1, detail2);
                    
                    if (UserService.createUser(newCsl)!=null){
                        UserService.createCounselor(newCsl);
                        isSucces = true;
                    }
                } else if (this.role.equals("Student")){
                    Student newStu = new Student(userID, firstname, lastname, username, password, email, status, detail1, detail2);
                    
                    if (UserService.createUser(newStu)!= null){
                        UserService.createStudent(newStu);
                        isSucces = true;
                    }
                }
                
                if (isSucces){
                    javax.swing.JOptionPane.showMessageDialog(this, this.role + " created successfully!");
                    this.dispose();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, 
                            "Failed to create user. The User ID might already exist.", 
                            "Creation Failed", 
                            javax.swing.JOptionPane.ERROR_MESSAGE);
                }
        } catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Error creating " + this.role + ": " + e.getMessage(), 
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textFieldUserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldUserIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldUserIDActionPerformed

    private void textFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldEmailActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CreateUserDialog dialog = new CreateUserDialog(new javax.swing.JFrame(), true, "Student");
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
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JTextField textFieldDetails1;
    private javax.swing.JTextField textFieldDetails2;
    private javax.swing.JTextField textFieldEmail;
    private javax.swing.JTextField textFieldFirstname;
    private javax.swing.JTextField textFieldLastname;
    private javax.swing.JPasswordField textFieldPassword;
    private javax.swing.JComboBox<String> textFieldStatus;
    private javax.swing.JTextField textFieldUserID;
    private javax.swing.JTextField textFieldUsername;
    // End of variables declaration//GEN-END:variables
}
