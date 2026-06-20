package components;

import Event.EventMenuSelected;
import components.MenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import model.MenuModel;
import javax.swing.DefaultListCellRenderer;
import java.awt.Component;
import javax.swing.DefaultListModel;

// whole list UI
public class ListMenu<E extends Object> extends JList<E>{
    
    private final DefaultListModel model;
    private int selectedIndex = -1;
    private int hoverIndex = -1;
    private EventMenuSelected event;
    
    public void addEventMenuSelected(EventMenuSelected event){
        this.event = event;
    }
    
    // Click
    public ListMenu(){
        model = new DefaultListModel();
        setModel(model);
        setOpaque(false);
        addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent e){
                if(SwingUtilities.isLeftMouseButton(e)) {
                    int index = locationToIndex(e.getPoint());
                    
                    Object o = model.getElementAt(index);
                    
                    if (o instanceof MenuModel){
                        MenuModel menu = (MenuModel)o; // casting
                        
                        if (menu.getType()==MenuModel.MenuType.MENU){
                            selectedIndex = index;
                            if (event != null){
                                event.selected(index);
                            }
                        }
                    } else {
                        selectedIndex = index;
                    }
                    repaint();
                }
            }
        });
        
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int index = locationToIndex(e.getPoint());
                if (index!=hoverIndex){ // get update if the index not same
                    Object o = model.getElementAt(index);
                    
                    if (o instanceof MenuModel){
                        MenuModel menu = (MenuModel)o;
                        if (menu.getType()==MenuModel.MenuType.MENU){
                            hoverIndex = index;
                        } else {
                            hoverIndex = -1;
                        }
                        repaint();
                    }
                }
            }
            
        });
    }
    
    // display
    @Override
    public ListCellRenderer<? super E> getCellRenderer(){
        return new DefaultListCellRenderer(){
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean selected, boolean focus){
                MenuModel data;
                if (value instanceof MenuModel){
                    data = (MenuModel) value;
                } else {
                    data = new MenuModel("", value + "", MenuModel.MenuType.EMPTY);
                }
                MenuItem item = new MenuItem(data);
                item.setSelected(selectedIndex==index);
                item.setOver(hoverIndex==index);
                return item;
            }
        };
    }
    
    // Add item to model list
    public void addItem(MenuModel data){
        model.addElement(data);
    }
}
