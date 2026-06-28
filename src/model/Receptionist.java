package model;

public class Receptionist extends User{
    
    private String contactNumber;
    private String counter;
    
    public Receptionist(String userID, String firstname, String lastname, 
            String username,String password, String email, String status, String contactNumber, String counter){
        super(userID,firstname, lastname, username, password, email, status);
        
        this.contactNumber = contactNumber;
        this.counter = counter;
    }
    
    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }
    
    public String getContactNumber(){
        return contactNumber;
    }
    
    public void setCounter(String counter){
        this.counter = counter;
    }
    
    public String getCounter(){
        return counter;
    }
    
    @Override
    public String toString(){
        return "Receptionist: " + userID;
    }
}
