package view;

import controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMainMenu extends JFrame implements ActionListener {


    private Controller controller;
    private JButton prodBtn = new JButton("Products");
    private JButton shopCartBtn = new JButton("Shopping cart");
    private JButton orderBtn = new JButton("Orders");
    private JButton backBtn = new JButton("Back");
    private JPanel mainPnl = new JPanel();



    public CustomerMainMenu(Controller controller) {
        this.controller = controller;
        //setLayout(new GridLayout(4,1));
        setSize(250, 240);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        mainPnl.setLayout(null);
        add(mainPnl);
        mainPnl.setBackground(Color.white);
        mainPnl.setPreferredSize(new Dimension(250, 240));
        mainPnl.add(prodBtn);
        prodBtn.setBounds(60, 20, 125, 25);
        mainPnl.add(shopCartBtn);
        shopCartBtn.setBounds(60, 60, 125, 25);
        mainPnl.add(orderBtn);
        orderBtn.setBounds(60, 100, 125, 25);
        mainPnl.add(backBtn);
        backBtn.setBounds(60, 140, 125, 25);
        mainPnl.validate();

        prodBtn.addActionListener(this);
        shopCartBtn.addActionListener(this);
        orderBtn.addActionListener(this);
        backBtn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==prodBtn){
            this.dispose();
            new CustomerProduct(controller);
        }
        if (e.getSource()==shopCartBtn){
            this.dispose();
            new ShoppingList(controller);
        }
        if (e.getSource()==orderBtn){
            this.dispose();
            new CustomerOrder(controller);
        }
        if (e.getSource()==backBtn){
            this.dispose();
            new LogIn(controller);
        }
    }
}
