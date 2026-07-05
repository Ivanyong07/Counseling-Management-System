package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import services.AuthService;

import model.User;
import model.Admin;
import services.FileHandling;
import view.admin.AdminDashboardFrame;


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
        usernameTextBox = new javax.swing.JTextField();
        LoginBtn = new javax.swing.JButton();
        passwordErrorMsg = new javax.swing.JLabel();
        usernameErrorMsg = new javax.swing.JLabel();
        passwordTextBox = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        usernameTextBox.addActionListener(this::usernameTextBoxActionPerformed);

        LoginBtn.setText("Login");
        LoginBtn.addActionListener(this::LoginBtnActionPerformed);

        passwordErrorMsg.setText("Please enter your password");

        usernameErrorMsg.setText("Please enter your username");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Welcome to our system");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(usernameErrorMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(usernameTextBox)
                        .addComponent(passwordErrorMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(322, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(292, 292, 292))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(usernameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameErrorMsg)
                .addGap(18, 18, 18)
                .addComponent(passwordTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordErrorMsg)
                .addGap(27, 27, 27)
                .addComponent(LoginBtn)
                .addGap(117, 117, 117))
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

            System.out.println("Hi username");
            error = true;
        } else{
            usernameErrorMsg.setText("");
        }

        if (password.isEmpty()){
            passwordErrorMsg.setText("Password cannot be empty");
            passwordErrorMsg.setForeground(Color.RED);
            passwordTextBox.setText("");

            System.out.println("hi passowrd");
            error = true;
        } else {
            passwordErrorMsg.setText("");
        }

        if (!error){
            try{
                User currentUser = AuthService.login(username, password);
                currentUser = FileHandling.LoadInformation(currentUser.getUserID());

                if (currentUser instanceof Admin){
                    
                    System.out.println(currentUser.getUserID());
                    AdminDashboardFrame admDashboard = new AdminDashboardFrame((Admin) currentUser);
                    admDashboard.setVisible(true);
                    dispose();
                }

            } catch (IOException o){
                o.printStackTrace();
            }
        }
    }//GEN-LAST:event_LoginBtnActionPerformed

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel passwordErrorMsg;
    private javax.swing.JPasswordField passwordTextBox;
    private javax.swing.JLabel usernameErrorMsg;
    private javax.swing.JTextField usernameTextBox;
    // End of variables declaration//GEN-END:variables
}
