package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;


public class DialogShow {
    
    private static void applyCustomTheme() {
        
        try {
            // FIX: Force Swing to use the cross-platform look and feel 
            // so your custom colors are not overridden by Windows/Mac defaults!
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            // Fallback silently if it encounters an issue
        }
        // Change the background colors
        UIManager.put("OptionPane.background", new Color(245, 247, 250));
        UIManager.put("Panel.background", new Color(245, 247, 250));
        
        // Custom fonts and message colors
        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.PLAIN, 14));
        UIManager.put("OptionPane.messageForeground", new Color(33, 37, 41));
        
        // Custom Button Styling
        UIManager.put("Button.background", new Color(13, 110, 253)); // Corporate Blue
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.font", new Font("Segoe UI", Font.BOLD, 12));
    }


    public static boolean showConfirm(JFrame frame, String title, String message) {
        // We use an array wrapper so we can mutate the boolean inside the lambda action listener
        final boolean[] result = {false};

        // 1. Create the translucent backdrop overlay
        JPanel glassPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // Dark translucent tint (RGBA)
                g2.setColor(new Color(0, 0, 0, 100)); 
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.dispose();
            }
        };
        glassPane.setLayout(new GridBagLayout());
        glassPane.setOpaque(false);

        // Block all mouse events from leaking down to the background UI fields
        glassPane.addMouseListener(new MouseAdapter() {});

        // 2. Create the floating message container card
        JPanel card = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // Solid crisp white card background
                g2.setColor(Color.WHITE); 
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 16, 16);
                g2.dispose();
            }
        };
        card.setOpaque(false);
        card.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setPreferredSize(new Dimension(380, 180));

        // 3. Add text typography elements
        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitle.setForeground(new Color(33, 37, 41));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblMessage = new JLabel("<html><center>" + message + "</center></html>");
        lblMessage.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblMessage.setForeground(new Color(108, 117, 125));
        lblMessage.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 4. Custom Buttons
        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnCancel.setBackground(new Color(233, 236, 239));
        btnCancel.setForeground(new Color(73, 80, 87));
        btnCancel.setFocusPainted(false);
        btnCancel.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));

        JButton btnConfirm = new JButton("Delete");
        btnConfirm.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnConfirm.setBackground(new Color(220, 53, 69)); // Crimson warning color
        btnConfirm.setForeground(Color.WHITE);
        btnConfirm.setFocusPainted(false);
        btnConfirm.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(btnCancel);
        buttonPanel.add(btnConfirm);

        // Assemble the card layout
        card.add(lblTitle);
        card.add(Box.createVerticalStrut(12));
        card.add(lblMessage);
        card.add(Box.createVerticalGlue());
        card.add(buttonPanel);

        // Mount card to center of GlassPane
        glassPane.add(card);

        // 5. Create a blocking modal helper loop
        final JDialog modalBlocker = new JDialog(frame, true);
        modalBlocker.setUndecorated(true);
        modalBlocker.setSize(1, 1);
        modalBlocker.setLocationRelativeTo(frame);

        // Button Actions
        btnCancel.addActionListener(e -> {
            frame.getGlassPane().setVisible(false);
            modalBlocker.dispose();
        });

        btnConfirm.addActionListener(e -> {
            result[0] = true;
            frame.getGlassPane().setVisible(false);
            modalBlocker.dispose();
        });

        // Push glasspane onto view layout and show
        frame.setGlassPane(glassPane);
        glassPane.setVisible(true);
        modalBlocker.setVisible(true); // Thread pauses right here until a button executes .dispose()

        return result[0];
    }

    
    public static void showMessage(Component parent, String message, String title){
        applyCustomTheme();
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showWarning(Component parent, String message, String title){
        applyCustomTheme();
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.WARNING_MESSAGE);
    }
    
    public static boolean showConfirm(Component parent, String message, String title) {
        applyCustomTheme();
        int choice = JOptionPane.showConfirmDialog(parent, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return choice == JOptionPane.YES_OPTION;
    }
    
}
