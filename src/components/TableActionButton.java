package components;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;


public class TableActionButton extends JButton{

    public TableActionButton(){
        setContentAreaFilled(false); // remove border
        setBorder(new EmptyBorder(3,3,3,3));
        
    }
}
