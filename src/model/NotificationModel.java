
package model;

import java.time.LocalTime;
import java.time.LocalDate;


public class NotificationModel {
    
    private String notificationID;
    private String role;
    private String title;
    private String message;
    private LocalDate date;
    private LocalTime time;
    private String status;
    
    public NotificationModel(String notificationID, String role, String title, String message, 
                              LocalDate date, LocalTime time, String status){
        this.notificationID = notificationID;
        this.role = role;
        this.title = title;
        this.message = message;
        this.date = date;
        this.time = time;
        this.status = status;
    }
    
    public String getNotificationID(){ 
        return notificationID; 
    }
    
    public String getRole(){ 
        return role; 
    }
    
    public String getTitle(){ 
        return title; 
    }
    
    public String getMessage(){ 
        return message; 
    }
    
    public String getDate(){ 
        return String.valueOf(date); 
    }
    
    public String getTime(){ 
        return String.valueOf(time); 
    }
    
    public String getStatus(){ 
        return status; 
    }
}
