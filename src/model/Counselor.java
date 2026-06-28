package model;


public class Counselor extends User{
    
    private String specialist;
    private String contactNumber;
    
    public Counselor(String userID,String firstname, String lastname, 
            String username, String password, String email, String status, String specialist, String contactNumber){
        super(userID, firstname, lastname, username,password, email, status);
        
        this.contactNumber = contactNumber;
        this.specialist = specialist;
    }
    
    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }
    
    public String getContactNumber(){
        return contactNumber;
    }
    
    public void setSpecialist(String specialist){
        this.specialist = specialist;
    }
    
    public String getSpecialist(){
        return specialist;
    }
    
    @Override
    public String toString(){
        return "Counselor: " + userID;
    }
}
