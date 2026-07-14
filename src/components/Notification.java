package components;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.ImageIcon;

public class Notification extends javax.swing.JPanel {
    
    private ImageIcon successIcon = new ImageIcon(getClass().getResource("/Public/success.png"));
    private ImageIcon newIcon = new ImageIcon(getClass().getResource("/Public/new-account.png"));
    private ImageIcon failedIcon = new ImageIcon(getClass().getResource("/Public/failed.png"));
    private ImageIcon lockedIcon = new ImageIcon(getClass().getResource("/Public/lock.png"));
    private static final String fileRosters = System.getProperty("user.dir") + "/src/data/notification.txt";
    private String file;
    private LocalDate date;
    private LocalTime time;
    
    float alpha = 0f;
    private String title, message, status;
    
    public Notification() {
        initComponents();
        setOpaque(false);
    }
    
    public Notification(String title, String message, String status, boolean saveMssg, String file) {
        initComponents();
        setOpaque(false);
        this.title = title;
        this.message = message;
        this.status = status;
        this.file = file;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        
        if (saveMssg){
            generateNotificationID();
            saveMeesage();
        }
    }
    
    public void setTitle(String title){
        this.title = title;
        repaint();
    }
    
    public void setMessage(String message){
        this.message = message;
        repaint();
    }
    
    public void setStatus(String status){
        this.status = status;
        repaint();
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getMessage(){
        return message;
    }
    
    public String getStatus(){
        return status;
    }
    
    public static String generateNotificationID(){
        String prefix = "NOTI";
        
        int random = 1000 + (int)(Math.random() * 9000);
        
        return prefix + random;
    }
    
    public void saveMeesage(){
        String id = generateNotificationID();
    
        try (BufferedReader dataRead = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = dataRead.readLine()) != null){
                String[] data = line.split("\\|");
                for (int i = 0; i < data.length; i++){
                    data[i] = data[i].trim();
                }
                if (data[0].equals(id)){
                    id = generateNotificationID(); // regenerate if collision
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
            writer.write(id + " | " + "Admin" + " | "+ title + " | " + message + " | " + date + " | " + time + " | " + status);
            writer.newLine();
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha)); // transparent
        if (status == null) return;
        Color color;
        ImageIcon icon;
        
        switch (status) {
            case "success" -> {color = new Color(46, 204, 113); icon = successIcon;}
            case "failed" -> {color = new Color(231, 76, 60); icon = failedIcon;}
            case "locked" -> { color = new Color(149, 165, 166); icon = lockedIcon; }
            case "new" -> {color = new Color(128, 128, 128); icon = newIcon;}
            default -> {return;}
        }
        
        // whole box
        g2.setColor(new Color(28,28,28));
        g2.fillRoundRect(0, 0, getWidth() + 5, getHeight(), 14, 14);
        
        // side
        g2.setColor(color);
        g2.fillRoundRect(0, 0, 6, getHeight(), 16, 16);
        g2.fillRect(2, 0, 3, getHeight());
        
        // icon circle
        int iconSize = 40;
        int iconX = 16, iconY = (getHeight() - iconSize)/2;
        g2.setColor(new Color(28, 28, 28));
        g2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        g2.drawImage(icon.getImage(), iconX + 5, iconY + 5, 32, 32, this);
        
        // title
        int textX = iconX + iconSize + 14;
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        g2.drawString(title != null ? title : "", textX, getHeight() / 2 - 4);

        // message
        g2.setColor(new Color(190, 190, 190));
        g2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        g2.drawString(message != null ? message : "", textX, getHeight() / 2 + 14);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
