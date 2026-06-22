
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

        tblUser.setRowHeight(40);
        jScrollPane1.setViewportView(tblUser);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUser;
    // End of variables declaration//GEN-END:variables
}
