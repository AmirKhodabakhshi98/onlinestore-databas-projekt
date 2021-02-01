package view;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class MyTableModel extends AbstractTableModel {

    private String[][] infoStrings = {{"1", "2"}, {"3", "4"}};
    private DefaultTableModel tableModel = new DefaultTableModel();
    private int rows;

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return infoStrings[rowIndex][0]; //ändra till orderID raden
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }


    public void setTableInfo(String[][]infoStrings){
        this.infoStrings =infoStrings;
    //    rows=infoStrings.length;
    }


}
