package view;

import controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMainMenu extends JFrame implements ActionListener {


    private Controller controller;
    private JButton btnProd = new JButton("Products page");
    private JButton btnOrder = new JButton("Order page");


    public CustomerMainMenu(Controller controller){
        this.controller=controller;
        setLayout(new GridLayout(2,1));
        setSize(400,500);
        add(btnProd);
        add(btnOrder);
        btnProd.addActionListener(this);
        btnOrder.addActionListener(this);

        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnProd){
            this.dispose();
            new CustomerProduct(controller);
        }
        if (e.getSource()==btnOrder){
            this.dispose();
            new CustomerOrder(controller);
        }
    }
}
