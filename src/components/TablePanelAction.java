package components;

import java.util.ServiceLoader;
import services.FileHandling;
import view.admin.UserAccountPanel;

public class TablePanelAction extends javax.swing.JPanel {

    private String userID;
    public Runnable onRefresh;
    
    public TablePanelAction() {
        initComponents();
    }
    
    public TablePanelAction(String userID, Runnable onRefresh) {
        initComponents();
        this.userID = userID;
        this.onRefresh = onRefresh;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnView = new components.TableActionButton();
        btnDlt = new components.TableActionButton();
        btnEdit = new components.TableActionButton();

        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Public/view.png"))); // NOI18N
        btnView.addActionListener(this::btnViewActionPerformed);
        add(btnView);

        btnDlt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Public/delete.png"))); // NOI18N
        btnDlt.addActionListener(this::btnDltActionPerformed);
        add(btnDlt);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Public/edit.png"))); // NOI18N
        btnEdit.addActionListener(this::btnEditActionPerformed);
        add(btnEdit);
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        System.out.println("View Button Clicked");
        System.out.println("User ID: " + userID);
        FileHandling.LoadInformation(userID);
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnDltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDltActionPerformed
        System.out.println("DELETE CLICKED");
        System.out.println("Delete ID = " + userID);
        FileHandling.deleteUser(userID);
        onRefresh.run();
    }//GEN-LAST:event_btnDltActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.TableActionButton btnDlt;
    private components.TableActionButton btnEdit;
    private components.TableActionButton btnView;
    // End of variables declaration//GEN-END:variables
}
