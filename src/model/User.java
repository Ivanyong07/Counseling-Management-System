package model;


public abstract class User {
    
    // dont create user easily
    protected String firstname;
    protected String lastname;
    protected String username;
    protected String userID;
    protected String password;
    protected String email;
    protected String status;
    
    public User(String userID, String firstname, String lastname,String username, String password, String email, String status){
        if (username==null||username.isEmpty()){
            throw new IllegalArgumentException("Username cannot be empty");
        }
        
        if (!username.matches("[a-zA-Z0-9]+" )){
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
        this.status = status;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getFirstname(){
        return firstname;
    }
    
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    
    public String getLastname(){
        return lastname;
    }
    
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getUserID(){
        return userID;
    }
    
    public void setUserID(String userID){
        this.userID = userID;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    @Override
    public String toString(){
        return "User:" + userID;
    }
}
