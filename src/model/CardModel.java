
package model;

import javax.swing.Icon;

public class CardModel {
    
    private Icon icon;
    private String description, title, value;
    
    public CardModel(Icon icon, String description, String title, String value){
        this.icon = icon;
        this.description = description;
        this.title = title;
        this.value = value;
    }
    
    public Icon getICcon(){
        return icon;
    }
    
    public void setIcon(Icon icon){
        this.icon = icon;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getValue(){
        return value;
    }
    
    public void setValue(String value){
        this.value = value;
    }
}
