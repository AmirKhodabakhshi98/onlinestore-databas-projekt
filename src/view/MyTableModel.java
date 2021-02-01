package view;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

    private int[][] data;

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
        return data[rowIndex][0]; //ändra till orderID raden
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
