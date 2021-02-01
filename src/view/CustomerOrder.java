package view;

import controllers.Controller;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerOrder extends JFrame implements ActionListener {



    private MyTableModel tm = new MyTableModel();
    private JTable tableOrders = new JTable(tm);
    private JTable tableProducts = new JTable(tm);

    private JButton btnMenu = new JButton("Main Menu");
    private JButton btnDelete = new JButton("Delete Product");

    private String[] tableOrderColumns = {"OrderId", "Confirmed", "Date", "Time"};
    private String[] tableProductsColumns = {};

    private JLabel lblId = new JLabel("OrderId to delete");
    private JTextField tfId = new JTextField();

    private JPanel pnlRight = new JPanel();
    private JPanel pnlLeft = new JPanel();
    private JPanel pnlButtons = new JPanel();

    private Controller controller;

    public CustomerOrder(Controller controller){
        this.controller=controller;
        setLayout(new GridLayout(1,2));
        add(pnlLeft);
        add(pnlRight);
        pnlLeft.setLayout(new BorderLayout());
        pnlRight.setLayout(new BorderLayout());
        tableOrders = new JTable(null,tableOrderColumns); //lägga till rader
        tableOrders.setEnabled(false);


        /*
                table= new JTable(controller.getProducts(), columnNames);
        table.setEnabled(false);    //Makes table not editable
        panelLeft.setLayout(new BorderLayout());
        panelLeft.add(new JScrollPane(table), BorderLayout.CENTER);

         */


    }


 


    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
