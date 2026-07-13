package view.admin;

import javax.swing.JOptionPane;
import model.Roster;
import services.FileHandling;
import services.RosterService;

public class StaffRosterSchedules extends javax.swing.JPanel {
    
    private static String fileRoster = System.getProperty("user.dir") + "/src/data/rosters.txt";
    private int row = -1;



    public StaffRosterSchedules() {
        initComponents();
        refreshTable();
    }
    
    public void refreshTable(){
        tblRoster.setModel(FileHandling.loadTableInformation(
                () -> refreshTable(),
                new String[]{"Username", "Date", "Start Time", "End Time", "Shift Time"}, 
                new int[]{2, 3, 4 ,5 ,6},
                fileRoster, 
                null,
                false,
                false));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundedPanel1 = new components.RoundedPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRoster = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        tblRoster.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblRoster);

        btnAdd.setText("Add Counselor");
        btnAdd.addActionListener(this::btnAddActionPerformed);

        btnEdit.setText("Edit");
        btnEdit.addActionListener(this::btnEditActionPerformed);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        jButton1.setText("Add Receptionist");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)))
                .addGap(18, 18, 18))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnEdit)
                    .addComponent(btnAdd)
                    .addComponent(jButton1))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(219, Short.MAX_VALUE)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        java.awt.Frame frame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);
        CreateRosterDialog dialog = new CreateRosterDialog(frame, true, "Counselor", this::refreshTable);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        java.awt.Frame frame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);
        CreateRosterDialog dialog = new CreateRosterDialog(frame, true, "Receptionist", this::refreshTable);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        java.awt.Frame frame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);
        int row = tblRoster.getSelectedRow();

        if (row == -1){
            JOptionPane.showMessageDialog(this, "You must click on the table first");
            return;
        }
        
        String rosterID = (String) tblRoster.getModel().getValueAt(row, 0);
        Roster roster = RosterService.getRosterById(rosterID);
        
        if (roster != null){
            CreateRosterDialog dialog = new CreateRosterDialog(frame, true, null, this::refreshTable, roster);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = tblRoster.getSelectedRow();
        
        if (row == -1){
            JOptionPane.showMessageDialog(this, "You must click on the table first");
            return;
        }
        
        String rosterID = (String) tblRoster.getModel().getValueAt(row, 0);
        Roster roster = RosterService.getRosterById(rosterID);
        
        if (roster == null){
            JOptionPane.showMessageDialog(this, "Error: Rotser data could not found.");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(
                this, 
                "Are you sure you want to delete the roster entry for " + roster.getUsername() + "?",
                "Confirm Deleteion",
                JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_NO_OPTION){
            boolean success = RosterService.deleteRoster(rosterID);
            
            if (success){
                javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblRoster.getModel();
                model.removeRow(row);
                
                JOptionPane.showMessageDialog(this, "Roster deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete the roster from the file system.");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private components.RoundedPanel roundedPanel1;
    private javax.swing.JTable tblRoster;
    // End of variables declaration//GEN-END:variables
}
