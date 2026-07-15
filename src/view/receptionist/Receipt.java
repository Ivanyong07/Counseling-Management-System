
package view.receptionist;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import model.Consultants;
import model.ConsultationStatusType;
import services.AppointmentService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.File;



public class Receipt extends javax.swing.JPanel {
    
    private String receiptID;
    private LocalDate currentDate;
    private LocalTime currentTime;
    private String consultationID;

    private static final String fileReceipt = System.getProperty("user.dir") + "/src/data/receipt.txt";

    
    public Receipt(String receiptID, LocalDate currentDate, LocalTime currentTime, String consultationID){
        this.receiptID= receiptID;
        this.currentDate=currentDate;
        this.currentTime=currentTime;
        initComponents();

    }

    public String getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public LocalTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
    }

    public void createReceipt(Consultants consultant) {
        // 1. Create a File object using your file path
        File file = new File(fileReceipt);

        // 2. CRITICAL FIX: Automatically create the 'src/data' folders if they are missing
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs(); 
        }

        // 3. Write to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(
                this.getReceiptID() + " | " +
                consultant.getAppointmentID() + " | " +
                consultant.getCounselorID() + " | " +
                consultant.getStudentID() + " | " +
                consultant.getDate() + " | " +
                consultant.getStartTime() + " | " +
                consultant.getEndTime() + " | " +                 
                consultant.getStatusType() + " | " + // Ensure this matches your Consultant model getter
                consultant.getConsultationsNote() + " | " +
                consultant.getBookMethod() + " | " +
                this.getCurrentDate() + " | " +
                this.getCurrentTime()                
            ); 
            writer.newLine();

            // Helpful debugging print so you know exactly where it saved
            System.out.println("Receipt saved successfully to: " + file.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Failed to write receipt: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public Receipt(Consultants consultant) {
        initComponents();
        jLabel1.setText(AppointmentService.generateReceiptID());
        jLabel2.setText(consultant.getAppointmentID());
        jLabel3.setText(consultant.getCounselorID());
        jLabel4.setText(consultant.getStudentID());
        jLabel5.setText(consultant.getStartTime());
        jLabel6.setText(consultant.getEndTime());
        jLabel7.setText(consultant.getDate());
        jLabel8.setText(consultant.getConsultationsNote());
        if (consultant.getStatusType() == ConsultationStatusType.FINISH){
            jLabel9.setText("Finish");
        } else{
            jLabel9.setText("");
        }
        jLabel10.setText(consultant.getBookMethod());
        jLabel11.setText(currentDate.toString());
        jLabel12.setText(currentTime.toString());
        jLabel29.setText(consultant.getConsultationID());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        line1 = new javax.swing.JLabel();
        receiptid = new javax.swing.JLabel();
        appointmentid = new javax.swing.JLabel();
        consulid = new javax.swing.JLabel();
        stuid = new javax.swing.JLabel();
        cslid = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        starttime = new javax.swing.JLabel();
        endtime = new javax.swing.JLabel();
        note = new javax.swing.JLabel();
        statustype = new javax.swing.JLabel();
        bookmethod = new javax.swing.JLabel();
        currentdate = new javax.swing.JLabel();
        currenttime = new javax.swing.JLabel();
        line2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title.setText("Counseling Management System");

        line1.setText("********************************************************************************");

        receiptid.setText("Receipt ID:");

        appointmentid.setText("Appointment ID:");

        consulid.setText("Consultation ID:");

        stuid.setText("Student ID:");

        cslid.setText("Counselor ID:");

        date.setText("Date:");

        starttime.setText("Start Time:");

        endtime.setText("End Time:");

        note.setText("Note:");

        statustype.setText("Status Type:");

        bookmethod.setText("Book Method:");

        currentdate.setText("Current Date:");

        currenttime.setText("Current Time:");

        line2.setText("********************************************************************************");

        jLabel1.setText("jLabel17");

        jLabel2.setText("jLabel17");

        jLabel29.setText("jLabel17");

        jLabel3.setText("jLabel17");

        jLabel4.setText("jLabel17");

        jLabel7.setText("jLabel17");

        jLabel5.setText("jLabel17");

        jLabel6.setText("jLabel17");

        jLabel8.setText("jLabel17");

        jLabel9.setText("jLabel17");

        jLabel10.setText("jLabel17");

        jLabel11.setText("jLabel17");

        jLabel12.setText("jLabel17");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(title))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(line2)
                            .addComponent(bookmethod, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(appointmentid, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stuid, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cslid, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(consulid))
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(starttime, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endtime, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(note, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statustype, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(224, 224, 224)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel29)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10))))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(currentdate, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(currenttime, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(89, 89, 89))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(line1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(receiptid, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(87, 87, 87))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(receiptid)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appointmentid)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consulid)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cslid)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stuid)
                    .addComponent(jLabel4))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(starttime)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endtime)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(note)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statustype)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookmethod)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(line2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentdate)
                    .addComponent(jLabel11))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currenttime)
                    .addComponent(jLabel12))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appointmentid;
    private javax.swing.JLabel bookmethod;
    private javax.swing.JLabel consulid;
    private javax.swing.JLabel cslid;
    private javax.swing.JLabel currentdate;
    private javax.swing.JLabel currenttime;
    private javax.swing.JLabel date;
    private javax.swing.JLabel endtime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel line1;
    private javax.swing.JLabel line2;
    private javax.swing.JLabel note;
    private javax.swing.JLabel receiptid;
    private javax.swing.JLabel starttime;
    private javax.swing.JLabel statustype;
    private javax.swing.JLabel stuid;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
