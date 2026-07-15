
package model;


public class Consultants {
    
    private String consultationID;
    private String appointmentID;
    private String counselorID;
    private String studentID;
    private String startTime;
    private String endTime;
    private String date;
    private String consultationsNote;
    private ConsultationStatusType statusType;
    private String bookMethod;

    public Consultants(String consultationID ,String appointmentID, String counselorID,String studentID, String startTime, String endTime, String date, 
        String consultationsNote,ConsultationStatusType statusType, String bookMethod){
        this.consultationID=consultationID;
        this.appointmentID= appointmentID;
        this.counselorID= counselorID;
        this.studentID=studentID;
        this.startTime=startTime;
        this.endTime=endTime;
        this.date=date;
        this.consultationsNote=consultationsNote;
        this.statusType=statusType;
        this.bookMethod=bookMethod;
    }
    
    public String getConsultationID(){
        return consultationID;
    }

    public void setConsultationID(String consultationID){
        this.consultationID=consultationID;
    }
    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getCounselorID() {
        return counselorID;
    }

    public void setCounselorID(String counselorID) {
        this.counselorID = counselorID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getConsultationsNote() {
        return consultationsNote;
    }

    public void setConsultationsNote(String consultationsNote) {
        this.consultationsNote = consultationsNote;
    }

    public ConsultationStatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(ConsultationStatusType statusType) {
        this.statusType = statusType;
    }

    public String getBookMethod() {
        return bookMethod;
    }

    public void setBookMethod(String bookMethod) {
        this.bookMethod = bookMethod;
    }

}
