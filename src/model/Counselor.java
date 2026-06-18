package model;


public class Counselor extends User{
    
    private String specialist;
    private String counterNumber;
    
    public Counselor(String userID,String firstname, String lastname, 
            String username, String password, String email, String status, String specialist, String counterNumber){
        super(userID, firstname, lastname, username,password, email, status);
        
        this.counterNumber = counterNumber;
        this.specialist = specialist;
    }
    
    @Override
    public String toString(){
        return "Counselor: " + userID;
    }
}
