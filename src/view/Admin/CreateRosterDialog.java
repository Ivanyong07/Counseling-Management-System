package view.admin;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import model.Roster;
import services.FileHandling;
import services.RosterService;
import com.toedter.calendar.JDateChooser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class CreateRosterDialog extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CreateRosterDialog.class.getName());
    
    private static String fileCounselor = System.getProperty("user.dir") + "/src/data/counselor.txt";
    private static String fileReceptionist = System.getProperty("user.dir") + "/src/data/receptionist.txt";
    private String role;
    private ArrayList<String[]> data = new ArrayList<>();
    private Runnable onRun;
    private Roster rosterEdit = null;
    
    public CreateRosterDialog(java.awt.Frame parent, boolean modal, String role, Runnable onRun, Roster rosterEdit){
        this(parent, modal, determienRole(rosterEdit), onRun);
        this.rosterEdit = rosterEdit;
        formForEdit();
    }

    public CreateRosterDialog(java.awt.Frame parent, boolean modal, String role, Runnable onRun) {
        super(parent, modal);
        this.role = role;
        this.onRun = onRun;
        initComponents();
        textFieldEndTime.setText("");
        
        selectedBox.addActionListener( e -> {
            String selectedID = (String) selectedBox.getSelectedItem();
            for (String[] row: data){
                if (row[0].equals(selectedID)){
                    textFieldUsername.setText(row[3]);
                    break;
                }
            }
        });
        
        
        java.awt.event.ActionListener updateEndTime = e -> {
            String startTimeStr = (String) setSelectedBoxStartTime.getSelectedItem();
            String hoursStr = (String) setSelectedBoxHours.getSelectedItem();
            
            if (startTimeStr != null && hoursStr != null && !hoursStr.isBlank()){
                LocalTime start = LocalTime.parse(startTimeStr);
                int hour = Integer.parseInt(hoursStr);
                LocalTime end = start.plusHours(hour);
                textFieldEndTime.setText(end.toString());
            } else {
                JOptionPane.showMessageDialog(this, "You must choose a time");
            }
        };
        setSelectedBoxStartTime.addActionListener(updateEndTime);
        setSelectedBoxHours.addActionListener(updateEndTime);
        showTable();
        showRoleSelectedBox();
        
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        dateChoose.setMinSelectableDate(today.getTime());
    }
    
    private static String determienRole(Roster roster){
        if (roster.getUserID().startsWith("CSL")){
            return "Counselor";
        } else if (roster.getUserID().startsWith("REP")){
            return "Receptionist";
        }
        return null;
    }
    
    public void formForEdit(){
        textFieldRosterID.setText(rosterEdit.getRosterID());
        textFieldUsername.setText(rosterEdit.getUsername());
        selectedBox.setSelectedItem(rosterEdit.getUserID());
        setSelectedBoxStartTime.setSelectedItem(rosterEdit.getStartTime());
        boxSelectedShiftTime.setSelectedItem(rosterEdit.getShiftTime());
        
        LocalDate existingDate = LocalDate.parse(rosterEdit.getDate());
        Date dateAsUtilDate = Date.from(existingDate.atStartOfDay(java.time.ZoneId.systemDefault()).toInstant());
        dateChoose.setDate(dateAsUtilDate);
        
        btnAdd.setText("Update");
    }
    
    public void showRoleSelectedBox(){
        
        if (role.equals("Receptionist")){
            loadInformation(fileReceptionist, "REP");
        } else if (role.equals("Counselor")){
            loadInformation(fileCounselor, "CSL");
        }
        
        showSelectedBox();
    }
    
    public void loadInformation(String filePath, String prefix){

        try (BufferedReader readerLine = new BufferedReader(new FileReader(filePath))){
                String line;

                while ((line = readerLine.readLine()) != null){
                    String[] userData = line.split("\\|");
                    for (int i = 0; i < userData.length; i++){
                        userData[i] = userData[i].trim();
                    }
                    
                    if (userData[0].startsWith(prefix) && userData[6].equals("ACTIVE")){
                        data.add(userData);
                    }
                    
                }
            } catch (FileNotFoundException e){
                System.out.println("File Not Found");
            } catch (IOException e){
                System.out.println("Error: " + e);
            }
    }
    
    public void showSelectedBox(){
        selectedBox.removeAllItems();
        for (String[] row: data){
            selectedBox.addItem(row[0]);
        }
    }
    
    public void showTable(){
        
        if (role.equals("Counselor")){
            refreshTableCounselor();
        } else if (role.equals("Receptionist")){
            refreshTableReceptionist();
        }
    }

    public void refreshTableCounselor(){
        tbl.setModel(FileHandling.loadTableInformation(
                () -> refreshTableCounselor(),
                new String[]{"Counselor ID", "Username", "Email", "Status"}, 
                new int[]{0, 3, 5 ,6},
                fileCounselor, 
                null,
                false,
                true,
                null));
        labelWorkerID.setText("Counselor ID:");
        labelWorkerName.setText("Counselor:");
    }
    
    public void refreshTableReceptionist(){
        tbl.setModel(FileHandling.loadTableInformation(
                () -> refreshTableReceptionist(),
                new String[]{"Counselor ID", "Username", "Email", "Status"}, 
                new int[]{0, 3, 5 ,6},
                fileReceptionist, 
                null,
                false,
                true,
                null));
        labelWorkerID.setText("Receptionist ID:");
        labelWorkerName.setText("Receptionist:");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        roundedPanel1 = new components.RoundedPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        roundedPanel2 = new components.RoundedPanel();
        boxSelectedShiftTime = new javax.swing.JComboBox<>();
        labelRosterID = new javax.swing.JLabel();
        labelHours = new javax.swing.JLabel();
        dateChoose = new com.toedter.calendar.JDateChooser();
        labelWorkerName = new javax.swing.JLabel();
        setSelectedBoxHours = new javax.swing.JComboBox<>();
        setSelectedBoxStartTime = new javax.swing.JComboBox<>();
        labelWorkerID = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        textFieldEndTime = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        selectedBox = new javax.swing.JComboBox<>();
        textFieldRosterID = new javax.swing.JTextField();
        textFieldUsername = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Create Roster Form:");

        tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Counselor Table:");

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        boxSelectedShiftTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Morning", "Night" }));
        boxSelectedShiftTime.addActionListener(this::boxSelectedShiftTimeActionPerformed);

        labelRosterID.setText("Roster ID:");

        labelHours.setText("Hours:");

        labelWorkerName.setText("Counselor Name:");

        setSelectedBoxHours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "6", "7", "8", " " }));
        setSelectedBoxHours.addActionListener(this::setSelectedBoxHoursActionPerformed);

        setSelectedBoxStartTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00" }));

        labelWorkerID.setText("Counselor ID:");

        label.setText("Date:");

        textFieldEndTime.setEditable(false);
        textFieldEndTime.setText("jTextField2");

        jLabel6.setText("End Time:");

        jLabel7.setText("Start Time:");

        jLabel8.setText("Shift Time:");

        selectedBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        textFieldRosterID.setEditable(false);
        textFieldRosterID.setText("jTextField1");

        textFieldUsername.setEditable(false);
        textFieldUsername.setText("jTextField2");
        textFieldUsername.addActionListener(this::textFieldUsernameActionPerformed);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Cancel");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        btnAdd.setText("Add");
        btnAdd.addActionListener(this::btnAddActionPerformed);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Form:");

        javax.swing.GroupLayout roundedPanel2Layout = new javax.swing.GroupLayout(roundedPanel2);
        roundedPanel2.setLayout(roundedPanel2Layout);
        roundedPanel2Layout.setHorizontalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel2Layout.createSequentialGroup()
                .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelWorkerName, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelWorkerID, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelRosterID, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectedBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldRosterID, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roundedPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(dateChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHours, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(setSelectedBoxHours, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setSelectedBoxStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxSelectedShiftTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89))
            .addGroup(roundedPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260))
        );
        roundedPanel2Layout.setVerticalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelRosterID)
                            .addComponent(textFieldRosterID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelHours)
                            .addComponent(setSelectedBoxHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelWorkerID)
                            .addComponent(selectedBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(setSelectedBoxStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelWorkerName)
                            .addComponent(textFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(textFieldEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label)
                            .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(boxSelectedShiftTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(60, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(btnAdd))
                        .addGap(16, 16, 16))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roundedPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roundedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(roundedPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void setSelectedBoxHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setSelectedBoxHoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setSelectedBoxHoursActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
        
        String rosterID = textFieldRosterID.getText().trim();
        String username = textFieldUsername.getText().trim();
        String selectedID = (String) selectedBox.getSelectedItem();
        String hourStr = (String) setSelectedBoxHours.getSelectedItem();
        String startTimeStr = (String) setSelectedBoxStartTime.getSelectedItem();
        String endTimeStr = textFieldEndTime.getText();
        String shiftTime  = (String) boxSelectedShiftTime.getSelectedItem();
        
        if (rosterID.isEmpty()){
            textFieldRosterID.setText(RosterService.generateRosterID());
            rosterID = textFieldRosterID.getText().trim();
        }
        
        if(selectedID == null || username.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please select a" + role + ".");
            return;
        }
        
        if (dateChoose.getDate() == null){
            JOptionPane.showMessageDialog(this, "Please select a date.");
            return;
        }
        

        LocalDate selectedDate = dateChoose.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        
        if (selectedDate.isBefore(LocalDate.now())){
            JOptionPane.showMessageDialog(this, "Date cannot be in the past. Please select today or a future date.");
            return;
        }
        
        if (startTimeStr == null){
            JOptionPane.showMessageDialog(this, "Please select a start time.");
            return;
        }
        
        if (hourStr == null || hourStr.isBlank()){
            JOptionPane.showMessageDialog(this, "Please select hours (5-8)");
            return;
        }
        
        if (endTimeStr.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please select a end time.");
            return;
        }
        
        if (shiftTime == null){
            JOptionPane.showMessageDialog(this, "Please select a shift time.");
            return;
        }
        
        ArrayList<Roster> existingShifts  = RosterService.readRoster(selectedID);
        LocalTime startTime = LocalTime.parse(startTimeStr);
        LocalTime endTime = LocalTime.parse(endTimeStr);
        int hours = Integer.parseInt(hourStr);
        
        for (Roster existing: existingShifts){
            LocalDate existDate = LocalDate.parse(existing.getDate());
            LocalTime existStartTime = LocalTime.parse(existing.getStartTime());
            LocalTime existEndTime = LocalTime.parse(existing.getEndTime());
            
            if (!existDate.equals(selectedDate)){
                continue;
            }
            
            if (existEndTime.isBefore(endTime) && existStartTime.isBefore(startTime)){
                JOptionPane.showMessageDialog(this, "Time conflict: " + username + " already has a shift from " + existStartTime + " to " + existEndTime + " on this date.");
                return;
            }
        }
        
        if (rosterEdit == null){
            Roster roster = new Roster(rosterID, selectedID, username, selectedDate, startTime, endTime, hours, shiftTime);
            Roster save = RosterService.createRoster(roster);

            if (save != null){
                JOptionPane.showMessageDialog(this, "Roster saved successfuly!");

                if (onRun != null){
                    onRun.run();
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Saved failed");
            }
        } else {
            Roster newRoster = new Roster(rosterID, selectedID, username, selectedDate, startTime, endTime, hours, shiftTime);
            RosterService.updateRoster(newRoster);
            JOptionPane.showMessageDialog(this, "Roster updated successfully!");
            if (onRun != null){
                onRun.run();
            };
            dispose();
        }
        
        
        
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void textFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldUsernameActionPerformed

    private void boxSelectedShiftTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSelectedShiftTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxSelectedShiftTimeActionPerformed

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
                CreateRosterDialog dialog = new CreateRosterDialog(new javax.swing.JFrame(), true, null, null);
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
    private javax.swing.JComboBox<String> boxSelectedShiftTime;
    private javax.swing.JButton btnAdd;
    private com.toedter.calendar.JDateChooser dateChoose;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel labelHours;
    private javax.swing.JLabel labelRosterID;
    private javax.swing.JLabel labelWorkerID;
    private javax.swing.JLabel labelWorkerName;
    private components.RoundedPanel roundedPanel1;
    private components.RoundedPanel roundedPanel2;
    private javax.swing.JComboBox<String> selectedBox;
    private javax.swing.JComboBox<String> setSelectedBoxHours;
    private javax.swing.JComboBox<String> setSelectedBoxStartTime;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField textFieldEndTime;
    private javax.swing.JTextField textFieldRosterID;
    private javax.swing.JTextField textFieldUsername;
    // End of variables declaration//GEN-END:variables
}
