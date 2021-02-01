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






    private JButton btnMenu = new JButton("Main Menu");
    private JButton btnDelete = new JButton("Delete Product");

    private String[] tableOrderColumns = {"OrderId", "Confirmed"};
    private String[] tableProductsColumns = {"", "1", "2"};

    private JTable tableOrders;
    private JTable tableProducts;

    private String[][] test = {{"1","2"},{"3","4"}};

    private JLabel lblId = new JLabel("OrderId to delete");
    private JTextField tfId = new JTextField();

    private JPanel pnlRight = new JPanel();
    private JPanel pnlLeft = new JPanel();
    private JPanel pnlButtons = new JPanel();

    private Controller controller;


    private DefaultTableModel defaultTm = new DefaultTableModel();



    public CustomerOrder(Controller controller){
        this.controller=controller;
        setLayout(new GridLayout(1,2));


        tableOrders = new JTable(test,tableOrderColumns); //ändra sen
        tableOrders.setEnabled(false);

        pnlLeft.setLayout(new BorderLayout());
        pnlLeft.add(new JScrollPane(tableOrders), BorderLayout.CENTER);


        pnlRight.setLayout(new BorderLayout());

        pnlButtons.add(btnMenu);
        pnlButtons.add(btnDelete);
        pnlLeft.add(pnlButtons,BorderLayout.SOUTH);



        add(pnlLeft);
        add(pnlRight);
        setSize(900,500);
        setVisible(true);



    }


    public static void main(String[] args) {
        Connection.connect();
        new CustomerOrder(new Controller());
    }
 


    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
