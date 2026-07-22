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
            
            labelWelcomeRole.setText("Welcome back, Admin");
            listMenu.addItem(new MenuModel("User Accounts", "user", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Staff Roster and Schedules", "schedule", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Appointment Statistics", "statistics", MenuModel.MenuType.MENU));

            listMenu.addItem(new MenuModel("", " ", MenuModel.MenuType.EMPTY));

            listMenu.addItem(new MenuModel("Generate Reports", "report", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Profile", "profile", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Settings", "setting", MenuModel.MenuType.MENU));
            
        } else if (this.currentRole.equals("Counselor")){
            
            labelWelcomeRole.setText("Welcome back, Counselor");
            listMenu.addItem(new MenuModel("Personal Roster", "user", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Assigned Appointments", "UI Elements", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Student Consultation Records", "Appointment Statistics", MenuModel.MenuType.MENU));
            
            listMenu.addItem(new MenuModel("", " ", MenuModel.MenuType.EMPTY));
            
            listMenu.addItem(new MenuModel("Consultation Notes and Recommendations", "user", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Profile", "Date Table", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Settings", "setting", MenuModel.MenuType.MENU));
            
        } else if (this.currentRole.equals("Receptionist")){
            
            labelWelcomeRole.setText("Welcome back, Receptionist");
            listMenu.addItem(new MenuModel("Manage Student Accounts", "user", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Manage Appointments", "statistics", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Assign Appointments", "report", MenuModel.MenuType.MENU));
            
            listMenu.addItem(new MenuModel("", " ", MenuModel.MenuType.EMPTY));
            
            listMenu.addItem(new MenuModel("Profile", "profile", MenuModel.MenuType.MENU));
            listMenu.addItem(new MenuModel("Settings", "setting", MenuModel.MenuType.MENU));
            
        } else if (this.currentRole.equals("Student")){
            
            labelWelcomeRole.setText("Welcome back, Student");
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
        labelWelcomeRole = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        listMenu = new components.ListMenu<>();
        logoutBtn1 = new view.LogoutBtn();

        panelMoving.setOpaque(false);

        labelWelcomeRole.setBackground(new java.awt.Color(255, 255, 255));
        labelWelcomeRole.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelWelcomeRole.setForeground(new java.awt.Color(255, 255, 255));
        labelWelcomeRole.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelWelcomeRole.setText("Welcome back, username");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Public/account_circle_150dp_E3E3E3_FILL0_wght400_GRAD0_opsz48.png"))); // NOI18N

        jScrollPane.setBorder(null);
        jScrollPane.setViewportView(listMenu);

        listMenu.setBorder(null);
        jScrollPane.setViewportView(listMenu);

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGroup(panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addGroup(panelMovingLayout.createSequentialGroup()
                        .addGroup(panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(panelMovingLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel3))
                            .addGroup(panelMovingLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(labelWelcomeRole, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(logoutBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelWelcomeRole, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(logoutBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel labelWelcomeRole;
    private components.ListMenu<String> listMenu;
    private view.LogoutBtn logoutBtn1;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}
