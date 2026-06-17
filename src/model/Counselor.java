package model;


public class Counselor extends User{
    
    private String course;
    private String year;
    
    public Counselor(String userID,String firstname, String lastname, String username, String password, String email, String status){
        super(userID, firstname, lastname, username,password, email, status);
        
        this.course = course;
        this.year = year;
    }
    
    @Override
    public String toString(){
        return "Counselor: " + userID;
    }
}
