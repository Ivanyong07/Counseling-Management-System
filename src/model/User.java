package model;


public class User {
    
    private String firstname;
    private String lastname;
    private String username;
    private String userID;
    private String password;
    private String email;
    
    public User(String userID,String firstname, String lastname,String username, String password, String email){
        if (username==null||username.isEmpty()){
            throw new IllegalArgumentException("Username cannot be empty");
        }
        
        if (!username.matches("^[A-Za-z]+$" )){
            throw new IllegalArgumentException("Username must in alphabet only");
        }
        
        if (password.length() != 8){
            throw new IllegalArgumentException("Password length must be 8 character");
        }
        
        
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.userID = userID;
        this.password = password;
        this.email = email;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getFirstname(){
        return firstname;
    }
    
    public String getLastname(){
        return lastname;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getUserID(){
        return userID;
    }
}
