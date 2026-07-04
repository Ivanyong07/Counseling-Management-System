package components;

// main menu sidebar

import Event.EventMenuSelected;
import model.MenuModel;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;

public class Menu extends javax.swing.JPanel {
    
    private EventMenuSelected event;
    private String color1 = "#000000";
    private String color2 = "#000000";
    private String currentRole;
    
    String userIcon = "src/Public/user.png";
    
    public void addEventMenuSelected(EventMenuSelected event){
        this.event = event;
        listMenu.addEventMenuSelected(event);
    }
    
    public Menu() {
        initComponents();
        setOpaque(false);
        
        jScrollPane.setOpaque(false);
        jScrollPane.getViewport().setOpaque(false);
        jScrollPane.setViewportBorder(null);
    }
    
    public Menu(String currentRole) {
        initComponents();
        setOpaque(false);
        
        jScrollPane.setOpaque(false);
        jScrollPane.getViewport().setOpaque(false);
        jScrollPane.setViewportBorder(null);
        this.currentRole = currentRole;
        init();
    }
    
    private void init(){
        
        if (this.currentRole == null){
            this.currentRole = "Admin";
        }
        
        if (this.currentRole.equals("Admin")){
            
            listMenu.addItem(new MenuModel("User Accounts", "user", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Staff Roster and Schedules", "UI Elements", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Appointment Statistics", "Appointment Statistics", MenuModel.MenuType.MENU));

            listMenu.addItem(new MenuModel("", " ", MenuModel.MenuType.EMPTY));

            listMenu.addItem(new MenuModel("Generate Reports", "Date Table", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Profile", "Date Table", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Settings", "setting", MenuModel.MenuType.MENU));
            
        } else if (this.currentRole.equals("Counselor")){
            
            listMenu.addItem(new MenuModel("Personal Roster", "user", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Assigned Appointments", "UI Elements", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Student Consultation Records", "Appointment Statistics", MenuModel.MenuType.MENU));
            
            listMenu.addItem(new MenuModel("", " ", MenuModel.MenuType.EMPTY));
            
            listMenu.addItem(new MenuModel("Consultation Notes and Recommendations", "user", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Profile", "Date Table", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Settings", "setting", MenuModel.MenuType.MENU));
            
        } else if (this.currentRole.equals("Receptionist")){
            
            listMenu.addItem(new MenuModel("Manage Student Accounts", "user", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Manage Appointments", "UI Elements", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Assign Appointments", "Appointment Statistics", MenuModel.MenuType.MENU));
            
            listMenu.addItem(new MenuModel("", " ", MenuModel.MenuType.EMPTY));
            
            listMenu.addItem(new MenuModel("Profile", "Date Table", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Settings", "setting", MenuModel.MenuType.MENU));
            
        } else if (this.currentRole.equals("Student")){
            
            listMenu.addItem(new MenuModel("Queue Number", "user", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Counseling Appointments", "UI Elements", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Appointment History", "Appointment Statistics", MenuModel.MenuType.MENU));
            
            listMenu.addItem(new MenuModel("", " ", MenuModel.MenuType.EMPTY));
            
            listMenu.addItem(new MenuModel("Counselor Profiles", "Appointment Statistics", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Profile", "Date Table", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Settings", "setting", MenuModel.MenuType.MENU));
            
        }
    }
    
    public void setTheme(String color1, String color2){
        this.color1 = color1;
        this.color2 = color2;
    }
    
    public void setCurrentRole(String currentRole){
        this.currentRole = currentRole;
        listMenu.clearItem();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        listMenu = new components.ListMenu<>();

        panelMoving.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dashboard");

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jScrollPane.setBorder(null);
        jScrollPane.setViewportView(listMenu);

        listMenu.setBorder(null);
        jScrollPane.setViewportView(listMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private static final System.Logger LOG = System.getLogger(Menu.class.getName());
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0,0, Color.decode(color1), 0, getHeight(), Color.decode(color2));
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.setColor(getBackground());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane;
    private components.ListMenu<String> listMenu;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}
