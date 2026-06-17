package model;

public class Receptionist extends User{
    
    private String contactNumber;
    private String counterNumber;
    
    public Receptionist(String userID, String firstname, String lastname, 
            String username,String password, String email, String status, String contactNumber){
        super(userID,firstname, lastname, username, password, email, status);
        
        this.contactNumber = contactNumber;
        this.counterNumber = counterNumber;
    }
    
    @Override
    public String toString(){
        return "Receptionist: " + userID;
    }
}
