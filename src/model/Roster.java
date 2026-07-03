package model;


public class Roster {
    
    private String rosterID, userID, firstname, lastname,startTime, endTime;
    
    public Roster(String rosterID, String userID, String firstname, String lastname, String startTime, String endTime){
        this.rosterID = rosterID;
        this.userID = userID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public String getRosterID(){
        return rosterID;
    }
    
    public void setRosterID(String rosterID){
        this.rosterID = rosterID;
    }
    
    public String getUserID(){
        return userID;
    }
    
    public void setUserID(){
        this.userID = userID;
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
    
    public String getStartTime(){
        return startTime;
    }
    
    public void setStartTime(String startTime){
        this.startTime = startTime;
    }
    
    public String getEndTime(){
        return endTime;
    }
    
    public void setEndTime(String endTime){
        this.endTime = endTime;
    }
}
