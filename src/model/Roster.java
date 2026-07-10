package model;

import java.time.LocalDate;
import java.time.LocalTime;


public class Roster {
    
    private String rosterID, userID, username;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String shiftTime;
    
    public Roster(String rosterID, String userID, String username, LocalDate date, LocalTime startTime, LocalTime endTime, String shiftTime){
        this.rosterID = rosterID;
        this.userID = userID;
        this.username = username;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.shiftTime = shiftTime;
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
    
    public void setUserID(String userID){
        this.userID = userID;
    }
    
    public String getStartTime(){
        return String.valueOf(startTime);
    }
    
    public void setStartTime(LocalTime startTime){
        this.startTime = startTime;
    }
    
    public String getEndTime(){
        return String.valueOf(endTime);
    }
    
    public void setEndTime(LocalTime endTime){
        this.endTime = endTime;
    }
    
    public void setDate(LocalDate date){
        this.date = date;
    }
    
    public String getDate(){
        return String.valueOf(date);
    }
    
    public void setShiftTime(String shiftTime){
        this.shiftTime = shiftTime;
    }
    
    public String getShiftTime(){
        return shiftTime;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
}
