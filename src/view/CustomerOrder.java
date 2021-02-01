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




    private JTable tableProducts;
    private JTable tableOrders;

    private JButton btnMenu = new JButton("Main Menu");
    private JButton btnDelete = new JButton("Delete Product");
    private JButton btnGetProds = new JButton("Delete Product");

    private String[] tableOrderColumns = {"OrderId", "Confirmed"};
    String[][] arr = {{"1", "2"}, {"3", "4"}};


    private JLabel lblId = new JLabel("OrderId to delete");
    private JTextField tfId = new JTextField();

    private JPanel pnlRight = new JPanel();
    private JPanel pnlLeft = new JPanel();
    private JPanel pnlButtons = new JPanel();

    private Controller controller;


    public CustomerOrder(Controller controller){
        this.controller=controller;
        setLayout(new GridLayout(1,2));

        pnlLeft.setLayout(new BorderLayout());
        pnlRight.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(tableOrders);
        pnlLeft.add(scrollPane,BorderLayout.CENTER);




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

    public static void main(String[] args) {
        Connection.connect();
        new CustomerOrder(new Controller());
    }
 


    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
