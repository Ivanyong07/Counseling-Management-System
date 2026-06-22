
package components;
// this file is allow the table button activate
import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

// AbstractCellEditor - JTable editor
// TableCellEditor - method to edit Jtable

public class TableEditorAction extends AbstractCellEditor implements TableCellEditor{
    
    private TablePanelAction panel; // store exsiting button in table panel action
    
    public TableEditorAction(){
        
    }
    
    
    @Override // runs when click jtable cell
    public Component getTableCellEditorComponent(JTable table,Object value,boolean isSelected,int row,int column){
        panel = (TablePanelAction) value; // casting 
        return panel; // return the real button so that the button can work
    }
    
    @Override
    public Object getCellEditorValue() {
        return panel;
    }
    
}
