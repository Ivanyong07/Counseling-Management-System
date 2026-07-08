
package model;


public class NotificationModel {
    
    private String message;
    private String time;
    
    public NotificationModel(String message, String time){
        this.message = message;
        this.time = time;
    }
    
    public String getMessage(){
        return message;
    }
    public String getTime(){
        return time;
    }
}
