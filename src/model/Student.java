package model;


public class Student extends User{
    
    private String course;
    private String contactNumber;
        
    public Student(String userID,String firstname, String lastname, 
            String username, String password, String email, String status, String contactNumber, String course){
        
        super(userID,firstname, lastname, username, password, email, status);
        
        this.course = course;
        this.contactNumber = contactNumber;
    }
    
    public void setCourse(String course){
        this.course = course;
    }
    
    public String getCourse(){
        return course;
    }
    
    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }
    
    public String getContactNumber(){
        return contactNumber;
    }
    
    @Override
    public String toString(){
        return "Student: " + userID;
    }
}
