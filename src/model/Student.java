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
    
    @Override
    public String toString(){
        return "Student: " + userID;
    }
}
