
package components;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import model.NotificationModel;



public class NotificationBtn extends JLabel{
    
    private static final String fileNotificationAdmin = System.getProperty("user.dir") + "/src/data/notificationAdmin.txt";
    private boolean hover = false;
    private String currentRole;

    
    public NotificationBtn(){
        this.currentRole = currentRole;
        this.setIcon(new ImageIcon(getClass().getResource(("/Public/notification.png"))));
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
    
    public void setCurrentRole(String currentRole){
        this.currentRole = currentRole;
    }
    
    private void showNotificationPanel(){
        JPopupMenu popup = new JPopupMenu();
        popup.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
        // add jpanel cause got conflict with the nimbus
        JPanel panel = new JPanel();panel.setPreferredSize(new java.awt.Dimension(330, 200));
        panel.setBackground(new Color(28, 28, 30));
        panel.setLayout(new javax.swing.BoxLayout(panel, javax.swing.BoxLayout.Y_AXIS));
        panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        
        
        // label
        JLabel label = new JLabel();
        label.setForeground(Color.WHITE);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(label);
        
        
        // space
        panel.add(javax.swing.Box.createVerticalStrut(16));
        
        ArrayList<NotificationModel> notification = loadData();
        
        if (notification.isEmpty()){
            JLabel empty = new JLabel("No new notifications");
            empty.setForeground(new Color(142, 142, 147)); // Soft gray text
            empty.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            empty.setAlignmentX(Component.CENTER_ALIGNMENT);

            panel.add(javax.swing.Box.createVerticalGlue());
            panel.add(empty);
            panel.add(javax.swing.Box.createVerticalGlue());
        } else {
            
            JPanel listPanel = new JPanel();
            listPanel.setOpaque(false);
            listPanel.setLayout(new javax.swing.BoxLayout(listPanel, javax.swing.BoxLayout.Y_AXIS));
            listPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            
            for (NotificationModel data: notification){
                NotificationPanel item = new NotificationPanel();
                item.setData(data);
                
                item.setAlignmentX(Component.LEFT_ALIGNMENT);
            
                
            
                listPanel.add(item);
                listPanel.setLayout(new javax.swing.BoxLayout(listPanel, javax.swing.BoxLayout.Y_AXIS));
                listPanel.add(javax.swing.Box.createVerticalStrut(8)); // Space between notifications
            }
            
            javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(listPanel);
            scroll.setBorder(null);
            scroll.setOpaque(false);
            scroll.getViewport().setOpaque(false);
            
            scroll.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scroll.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scroll.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            scroll.getVerticalScrollBar().setPreferredSize((new java.awt.Dimension(6,0)));
            scroll.setOpaque(false);
            scroll.getViewport().setOpaque(false);

            panel.add(scroll);
        }
        
        popup.add(panel);
        popup.show(this, -200, this.getHeight() + 4);
    }
    
    public ArrayList<NotificationModel> loadData(){
        ArrayList<NotificationModel> notifications = new ArrayList<>();
        
        try (BufferedReader notifiReader = new BufferedReader(new FileReader(fileNotificationAdmin))){
            String notifiData;
            while ((notifiData = notifiReader.readLine())!=null){
                String[] data = notifiData.split("\\|");
                
                for (int i =0; i < data.length; i++){
                    data[i] = data[i].trim();
                }
                
                notifications.add(new NotificationModel(data[0], data[1], data[2], data[3],
                        LocalDate.parse(data[4]), LocalTime.parse(data[5]), data[6]));
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
