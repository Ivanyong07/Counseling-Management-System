package model;

// menu structure for menu

import javax.swing.ImageIcon;
import javax.swing.Icon;

public class MenuModel {
    
    private String name;
    private String icon;
    private MenuType type;
    
    public MenuModel(String name, String icon, MenuType type){
        this.name = name;
        this.icon = icon;
        this.type = type;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(){
        this.name = name;
    }
    
    public void setIcon(){
        this.icon = icon;
    }
    
    public String getIcon(){
        return icon;
    }
    
    public MenuType getType(){
        return type;
    }
    
    public void setType(){
        this.type = type;
    }
    
    
    public Icon toIcon() {
        return new ImageIcon(getClass().getResource("C:\\NetBeansProjects\\Counseling-Management-System\\src\\Public\\" + icon + ".png"));
    }

    
    public static enum MenuType{
        TITLE, MENU, EMPTY
    }
    
}
