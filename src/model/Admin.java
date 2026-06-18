package model;


public class Admin extends User{ // inherit
    
        private String office;
        private String contactNumber;
        
        public Admin(String userID,String firstname, String lastname, 
                String username,String password, String email, String status, String office, String contactNumber){
            
            super(userID, firstname, lastname, username, password, email, status);
            
            this.office = office;
            this.contactNumber = contactNumber;
    }
        @Override
        public String toString(){
            return "Admin: " + userID + username;
        }
    
}
