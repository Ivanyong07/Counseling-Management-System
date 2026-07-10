package model;

public class Appointment {
    
private String appointmentID;
    private String counselorID;
    private String studentID;
    private String startTime;
    private String endTime;
    private String date;
    private StatusType status;
    private String consultationsNote;
    private String bookMethod;

    public Appointment(String appointmentID,String counselorID, String studentID,
            String startTime,String endTime,String date,StatusType status,String consultationsNote, String bookMethod){
        this.appointmentID = appointmentID;
        this.counselorID= counselorID;
        this.studentID= studentID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.status = status;
        this.consultationsNote = consultationsNote;
    }
    
    public void setAppointmentID(String appointmentID){
        this.counselorID= appointmentID;
    }
    
    public String getAppointmentID(){
        return appointmentID;
    }
    
    public void setCounselorID(String counselorID){
        this.counselorID=counselorID;
    }
    
    public String getCounselorID(){
        return counselorID;
    }
    
    public void setstudentID(String studentID){
        this.studentID=studentID;
    }
    
    public String getStudentID(){
        return studentID;
    }
    
    public void setStartTime(String StartTime){
        this.startTime = StartTime;
    }
    
    public String getStartTime(){
        return startTime;
    }
    
    public void setEndTime(String endTime){
        this.endTime = endTime;
    }
    
    public String getEndTime(){
        return endTime;
    }
    
    public String getSendTime(){
        return endTime;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setStatus(StatusType status){
        this.status = status;
    }
    
    public StatusType getStatus(){
        return status;
    }
    
    public void setConsultationsNote(String consultationsNote){
        this.consultationsNote = consultationsNote;
    }
    
    public String getConsultationsNote(){
        return consultationsNote;
    }
    
    public void setBookMethod(String bookMethod){
        this.bookMethod = bookMethod;
    }
    
    public String getBookMethod(){
        return bookMethod;
    }
}
