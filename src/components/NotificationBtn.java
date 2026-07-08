
package components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import model.NotificationModel;



public class NotificationBtn extends JLabel{
    
    private static final String fileNotification = System.getProperty("user.dir") + "/src/data/notificationAdmin.txt";
    private boolean hover = false;
    

    
    public NotificationBtn(){
        this.setIcon(new ImageIcon(getClass().getResource(("/Public/"))));
        this.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 11, 5, 0));
        
        
        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                showNotificationPanel();
            }
        });
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                hover = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                hover = false;
                repaint();
            }
            
            
            
        });
        
        
        
    }
    
    private void showNotificationPanel(){
        JPopupMenu popup = new JPopupMenu();
        
        // add jpanel cause got conflict with the nimbus
        JPanel panel = new JPanel();


        panel.setPreferredSize(new java.awt.Dimension(350, 200));
        panel.setBackground(Color.BLUE);
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(80, 80, 80), 3));
        
        JLabel label = new JLabel();
        
        label.setText("Notification");
        
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        
        label.setFont(new Font("Arial", Font.BOLD, 14));

        panel.add(label);
        
        ArrayList<NotificationModel> notification = loadData();
        
        if (notification.isEmpty()){
            JLabel empty = new JLabel("No new notifications");
            empty.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(empty);
        } else {
            for (NotificationModel data: notification){
                NotificationPanel item = new NotificationPanel();
                item.setData(data);
                panel.add(item);
            }
        }
        
        popup.add(panel);
        popup.show(this, -200, this.getHeight());
    }
    
    public ArrayList<NotificationModel> loadData(){
        ArrayList<NotificationModel> notifications = new ArrayList<>();
        
        try (BufferedReader notifiReader = new BufferedReader(new FileReader(fileNotification))){
            String notifiData;
            while ((notifiData = notifiReader.readLine())!=null){
                String[] data = notifiData.split("\\|");
                
                for (int i =0; i < data.length; i++){
                    data[i] = data[i].trim();
                }
                
                notifications.add(new NotificationModel(data[2], data[3]));
            }
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: "+ e);
        }
        return notifications;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (hover){
            g2.setColor(new Color(60, 60, 60));
        } else {
            g2.setColor(new Color(36, 36, 36));
        }
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(g);
    }
    
    
    
}
