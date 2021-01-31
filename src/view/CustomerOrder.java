package view;

import controllers.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerOrder extends JFrame implements ActionListener {




    private JTable tableOrders;
    private JTable tableProducts;
    private JButton btnMenu = new JButton("Main Menu");
    private JButton btnDelete = new JButton("Delete Product");

    private String[] tableOrderColumns = {"OrderId", "Confirmed", "Date", "Time"};
    private String[] tableProductsColumns = {};

    private JLabel lblId = new JLabel("OrderId to delete");
    private JTextField tfId = new JTextField();

    private Controller controller;

    public CustomerOrder(Controller controller){
        this.controller=controller;

    }


 


    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
