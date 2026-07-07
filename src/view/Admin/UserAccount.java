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
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import model.CardModel;

public class UserAccount extends javax.swing.JPanel {
    
    private static String fileUser = System.getProperty("user.dir") + "/src/data/users.txt";
    private static String fileReceptionist = System.getProperty("user.dir") + "/src/data/receptionist.txt";
    private static String fileCounselor = System.getProperty("user.dir") + "/src/data/counselor.txt";
    private ImageIcon userIcon = new ImageIcon(getClass().getResource("/Public/user.png"));
//    java.net.URL testUrl = getClass().getResource("/Public/user.png"); debug
   
    
    java.awt.Frame frame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);
    private int hoverIndex = -1;
    private int cornerRadius = 30;

    public UserAccount() {
        initComponents();  
        setOpaque(false);
        
        tblUser.setRowHeight(40);
        refreshTable();
        jScrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jScrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(80, 80, 80), 1));
        jScrollPane.getViewport().setBackground(new Color(36, 36, 36));

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
        
        tblUser.setOpaque(false);
        tblUser.setBackground(Color.GRAY);
        tblUser.setForeground(Color.WHITE);
        tblUser.setGridColor(new Color(80, 80, 80));
        tblUser.setSelectionBackground(new Color(148, 148, 148)); 
        tblUser.setSelectionForeground(Color.WHITE);  
        tblUser.setShowVerticalLines(false);
        tblUser.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        tblUser.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e){
                int row = tblUser.rowAtPoint(e.getPoint());
                if (row != hoverIndex){
                    hoverIndex = row;
                    tblUser.repaint();
                }
            }
        });
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hoverIndex = -1;
                tblUser.repaint();
            }
        });

        // 3. Paint the hover color on the standard columns
        tblUser.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (row == hoverIndex) {
                    com.setBackground(new Color(160, 148, 148)); // Hover color
                } else {
                    com.setBackground(new Color(36, 36, 36));   // Normal color
                }
                com.setForeground(Color.WHITE);
                return com;
            }
        });
//        System.out.println(testUrl); debug
        roundedPanel.setBackgroundColor(new Color(28, 28, 30));
        loadDataCard();
    }
    
    public void loadDataCard(){
        try{
            String countRep = getDataReceptionist();
            String countCsl = getDataCounselor();
            
            CardModel modelCard1  = new CardModel(userIcon, "Currently Active", "Receptionist", countRep);
            card1.setData(modelCard1);
            
            CardModel modelCard2 = new CardModel(userIcon, "Currently Active", "Counselor", countCsl);
            card2.setData(modelCard2);
            
            
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
    }
    
    public String getDataReceptionist() throws IOException{
        int value = 0;
        try (BufferedReader  userReader = new BufferedReader(new FileReader(fileReceptionist))){
            String userLine;
            
            
            while ((userLine = userReader.readLine()) != null){
                String[] userData = userLine.split("\\|");
                
                for (int i = 0; i < userData.length; i++){
                    userData[i] = userData[i].trim();
                }
                
                if (userData[0].startsWith("REP")){
                    value += 1;
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        return String.valueOf(value);
    }
    
        public String getDataCounselor() throws IOException{
        int value = 0;
        try (BufferedReader  userReader = new BufferedReader(new FileReader(fileCounselor))){
            String userLine;
            
            
            while ((userLine = userReader.readLine()) != null){
                String[] userData = userLine.split("\\|");
                
                for (int i = 0; i < userData.length; i++){
                    userData[i] = userData[i].trim();
                }
                
                if (userData[0].startsWith("CSL")){
                    value += 1;
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        return String.valueOf(value);
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
                
                if (row == hoverIndex){
                    label.setBackground(new Color(60, 148, 148));
                    label.setForeground(Color.WHITE);
                } else {
                    if (value.equals("ACTIVE")){
                    label.setBackground(new Color(205,231,202));
                    label.setForeground(Color.BLACK);
                    } else {
                        label.setBackground(new Color(191,90,90));
                        label.setForeground(Color.WHITE);
                    }
                }
                return label;
            }
        });
    }
    
    public void setImageIcon(){
        
        tblUser.getColumnModel().getColumn(3).setCellEditor(new TableEditorAction()); // set it to clickable
        
        tblUser.getColumnModel().getColumn(3).setCellRenderer(new TableCellRenderer () { // show image
            public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focus, int row, int column){
                Component com;
                if (value instanceof TablePanelAction){
                    com = (TablePanelAction) value;
                } else {
                    com = new JLabel("");
                }
                if (row == hoverIndex) {
                    com.setBackground(new Color(160, 148, 148)); // Hover color
                } else {
                    com.setBackground(new Color(36, 36, 36));   // Normal color
                }
                return com;
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        // This is not needed for the panel itself, but keeps the background clean
        super.paintComponent(g);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddReceptionist = new javax.swing.JButton();
        btnAddCounselor = new javax.swing.JButton();
        roundedPanel = new components.RoundedPanel();
        jScrollPane = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        card1 = new components.Card();
        card2 = new components.Card();

        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(new java.awt.Color(51, 51, 51));

        btnAddReceptionist.setText("Add Receptionist");
        btnAddReceptionist.addActionListener(this::btnAddReceptionistActionPerformed);

        btnAddCounselor.setText("Add Counselor");
        btnAddCounselor.addActionListener(this::btnAddCounselorActionPerformed);

        roundedPanel.setBackground(new java.awt.Color(255, 255, 255));

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane.setViewportView(tblUser);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Public/profile.png"))); // NOI18N
        jLabel1.setText("USER ACCOUNT:");

        javax.swing.GroupLayout roundedPanelLayout = new javax.swing.GroupLayout(roundedPanel);
        roundedPanel.setLayout(roundedPanelLayout);
        roundedPanelLayout.setHorizontalGroup(
            roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        roundedPanelLayout.setVerticalGroup(
            roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roundedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddReceptionist, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddCounselor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddReceptionist)
                    .addComponent(btnAddCounselor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
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
    private components.Card card1;
    private components.Card card2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane;
    private components.RoundedPanel roundedPanel;
    private javax.swing.JTable tblUser;
    // End of variables declaration//GEN-END:variables
}
