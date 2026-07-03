
package view.admin;

import components.TableEditorAction;
import components.TablePanelAction;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import services.FileHandling;
import view.EditProfileDialog;

public class UserAccountPanel extends javax.swing.JPanel {
    
    private static String fileUser = System.getProperty("user.dir") + "/src/data/users.txt";

    public UserAccountPanel() {
        initComponents();
        refreshTable();
    }
    
    public void refreshTable(){
        tblUser.setModel(FileHandling.loadTableInformation(
                () -> refreshTable(),  
                new String[]{"ID", "Email", "Status", "Action"},
                new int[]{0, 5, 6},
                fileUser,
                "ADM"));
        setStatusColor();
        setImageIcon();
    }
    
    public void setStatusColor(){
        tblUser.getColumnModel().getColumn(2).setCellRenderer(new TableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focus, int row, int column){
                if (value == null) return new JLabel("");
                JLabel label = new JLabel(value.toString());

                label.setOpaque(true);

                if (value.equals("active")){
                    label.setBackground(new Color(55, 255, 96));
                    label.setForeground(Color.BLACK);
                } else {
                    label.setBackground(new Color(255, 55, 55));
                    label.setForeground(Color.WHITE);
                }
                return label;
            }
        });
    }
    
    public void setImageIcon(){
        
        tblUser.getColumnModel().getColumn(3).setCellEditor(new TableEditorAction()); // set it to clickable
        
        tblUser.getColumnModel().getColumn(3).setCellRenderer(new TableCellRenderer () { // show image
            public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focus, int row, int column){
                
                if (value instanceof TablePanelAction){
                    return (TablePanelAction) value;
                }
                return new JLabel("");
            }
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        btnAddReceptionist = new javax.swing.JButton();
        btnAddCounselor = new javax.swing.JButton();

        tblUser.setRowHeight(40);
        jScrollPane1.setViewportView(tblUser);

        btnAddReceptionist.setText("Add Receptionist");
        btnAddReceptionist.addActionListener(this::btnAddReceptionistActionPerformed);

        btnAddCounselor.setText("Add Counselor");
        btnAddCounselor.addActionListener(this::btnAddCounselorActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddReceptionist, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddCounselor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 475, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 199, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddReceptionist)
                    .addComponent(btnAddCounselor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddReceptionistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddReceptionistActionPerformed
        java.awt.Frame frame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);
        EditProfileDialog dialog = new EditProfileDialog(new javax.swing.JFrame(), true, null);
    }//GEN-LAST:event_btnAddReceptionistActionPerformed

    private void btnAddCounselorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCounselorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddCounselorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCounselor;
    private javax.swing.JButton btnAddReceptionist;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUser;
    // End of variables declaration//GEN-END:variables
}
