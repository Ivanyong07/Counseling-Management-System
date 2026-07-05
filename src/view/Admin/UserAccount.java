
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
import view.CreateUserDialog;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.Font;

public class UserAccount extends javax.swing.JPanel {
    
    private static String fileUser = System.getProperty("user.dir") + "/src/data/users.txt";
    java.awt.Frame frame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);

    public UserAccount() {
        initComponents();
        refreshTable();
        
        JTableHeader header = tblUser.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer(){ // header
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setBackground(new Color(130, 129, 129));
                setForeground(Color.WHITE);
                setFont(new Font("Segoe UI", Font.BOLD, 14));
                setBorder(javax.swing.BorderFactory.createEmptyBorder(10,5,10,0));
                return this;
            }
        });
        
        tblUser.setBackground(new Color(36, 36, 36));
        tblUser.setForeground(Color.WHITE);
        tblUser.setGridColor(new Color(80, 80, 80));
        tblUser.setSelectionBackground(new Color(255, 87, 87)); // Modern red highlight
        tblUser.setSelectionForeground(Color.WHITE);       // Text stays white when clicked
        tblUser.setShowVerticalLines(false);
        
        jScrollPane1.getViewport().setBackground(new Color(36, 36, 36)); 
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Remove ugly borders
        
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

                if (value.equals("ACTIVE")){
                    label.setBackground(new Color(205,231,202));
                    label.setForeground(Color.BLACK);
                } else {
                    label.setBackground(new Color(153,3,3));
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

        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(new java.awt.Color(51, 51, 51));

        tblUser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblUser.setForeground(new java.awt.Color(51, 51, 51));
        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(btnAddReceptionist, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddCounselor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 143, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCounselor)
                    .addComponent(btnAddReceptionist))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddReceptionistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddReceptionistActionPerformed

        CreateUserDialog dialog = new CreateUserDialog(frame, true, "Receptionist");
        dialog.setVisible(true);
    }//GEN-LAST:event_btnAddReceptionistActionPerformed

    private void btnAddCounselorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCounselorActionPerformed
        
        CreateUserDialog dialog = new CreateUserDialog(frame, true, "Counselor");
        dialog.setVisible(true);
    }//GEN-LAST:event_btnAddCounselorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCounselor;
    private javax.swing.JButton btnAddReceptionist;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUser;
    // End of variables declaration//GEN-END:variables
}
