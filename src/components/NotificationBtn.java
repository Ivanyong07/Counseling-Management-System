
package components;

import java.awt.Cursor;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;



public class NotificationBtn extends JLabel{
    
    private static final String fileNotification = System.getProperty("user.dir") + "/src/data/notificationAdmin.txt";
    

    
    public NotificationBtn(){
        this.setIcon(new ImageIcon(getClass().getResource(("/Public/"))));
        this.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        
        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                showNotificationPanel();
            }
        });
        
    }
    
    private void showNotificationPanel(){
        JPopupMenu popup = new JPopupMenu();
        ArrayList<String> messages = loadData();
        
        if (messages.isEmpty()){
            popup.add(new javax.swing.JLabel("No new notifications"));
        } else {
            for (String msg: messages){
                popup.add(new javax.swing.JLabel(msg));
            }
        }
        
        popup.show(this, 0, this.getHeight());
    }
    
    public ArrayList<String> loadData(){
        ArrayList<String> messages = new ArrayList<>();
        
        try (BufferedReader notifiReader = new BufferedReader(new FileReader(fileNotification))){
            String notifiData;
            while ((notifiData = notifiReader.readLine())!=null){
                String[] data = notifiData.split("\\|");
                
                for (int i =0; i < data.length; i++){
                    data[i] = data[i].trim();
                }
                
                messages.add(data[2]);            
            }
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: "+ e);
        }
        
        return messages;
    }
    
}
