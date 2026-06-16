package components;
//1. what changes?        → make it a variable (alpha, x, y)
//2. how much per step?   → += or -= value
//3. when to stop?        → if condition → timer.stop()
//4. what updates visual? → repaint() or setLocation()
//5. anything after done? → onFinish.run()

//Fade → alpha changes → repaint()
//Slide → x or y changes → setLocation()
//Grow → width/height changes → setSize()
import javax.swing.JPanel;
import javax.swing.Timer;

public class Animation {
    
    public static void fadeIn(JPanel component, Runnable onFinish){
        // Animation.fadeIn(...)
        
        Timer timer = new Timer(30,null);
        timer.addActionListener(e -> {
            
            if (component instanceof Notification n){
                n.alpha += 0.05f; // + 0.05 every 30ms
                n.repaint(); // when value change repaint everytime
                
                if (n.alpha >= 1f){
                    n.alpha = 1f;
                    timer.stop();
                    if(onFinish!=null) onFinish.run();
                }
            }
        });
        timer.start();
    }
    
    public static void fadeOut(JPanel component, Runnable onFinish){
        // Animation.fadeIn(...)
        
        Timer timer = new Timer(30,null);
        timer.addActionListener(e -> {
            
            if (component instanceof Notification n){
                
                n.alpha -= 0.05f; // + 0.05 every 30ms
                n.repaint();
            
                if (n.alpha <= 0f){
                    n.alpha = 0f;
                    timer.stop();
                    if(onFinish!=null) onFinish.run();
                }
            }
        });
        timer.start();
    }
    
    
    public static void slideIn(JPanel component, float x, float y, Runnable onFinish){
        // Animation.slideIn(...)
        float[] width = {component.getX()};
        
        Timer timer = new Timer(30,null);
        timer.addActionListener(e -> {
            width[0] += 10f;
            component.setLocation((int)width[0], (int)y); // setLocation only use int
            
            if (width[0] >= x){
                component.setLocation((int)x, (int)y);
                timer.stop();
                if(onFinish!=null) onFinish.run();
            }
        });
        timer.start();
    }
    
    public static void slideOut(JPanel component, float x, float y, Runnable onFinish){
        // Animation.slideOut(...)
        float[] width = {component.getX()};
        
        Timer timer = new Timer(30,null);
        timer.addActionListener(e -> {
            width[0] -= 10f;
            component.setLocation((int)width[0], (int)y); // setLocation only use int
            
            if (width[0] <= x){
                component.setLocation((int)x, (int)y);
                timer.stop();
                if(onFinish!=null) onFinish.run();
            }
        });
        timer.start();
    }
}
