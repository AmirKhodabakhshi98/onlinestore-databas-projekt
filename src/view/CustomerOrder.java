package view;

import controllers.Controller;
import database.Connection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerOrder extends JFrame implements ActionListener {



    private MyTableModel tm = new MyTableModel();
    private DefaultTableModel tableModel = new DefaultTableModel();

    private JTable tableProducts;

    private JButton btnMenu = new JButton("Main Menu");
    private JButton btnDelete = new JButton("Delete Product");

    private String[] tableOrderColumns = {"OrderId", "Confirmed", "Date", "Time"};
    private String[] tableProductsColumns = {"", "1", "2"};
    String[][] arr = {{"1", "2"}, {"3", "4"}};

    private JTable tableOrders = new JTable(tm);

    private JLabel lblId = new JLabel("OrderId to delete");
    private JTextField tfId = new JTextField();

    private JPanel pnlRight = new JPanel();
    private JPanel pnlLeft = new JPanel();
    private JPanel pnlButtons = new JPanel();

    private Controller controller;

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    

    public CustomerOrder(Controller controller){
        this.controller=controller;
        setLayout(new GridLayout(1,2));

        pnlLeft.setLayout(new BorderLayout());
        pnlRight.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(tableOrders);
        pnlLeft.add(scrollPane,BorderLayout.CENTER);
        setTableOrders(arr);




        add(pnlLeft);
        add(pnlRight);
        setSize(900,500);
        setVisible(true);
                /*

        tableOrders = new JTable(null,tableOrderColumns); //lägga till rader
        tableOrders.setEnabled(false);



                table= new JTable(controller.getProducts(), columnNames);
        table.setEnabled(false);    //Makes table not editable
        panelLeft.setLayout(new BorderLayout());
        panelLeft.add(new JScrollPane(table), BorderLayout.CENTER);

         */


    }

    public void setTableOrders(String[][] array){
        tm.setTableInfo(array);
        tableOrders.setModel(tm);
        tableOrders.repaint();
    }

    public static void main(String[] args) {
        Connection.connect();
        new CustomerOrder(new Controller());
    }
 


    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
