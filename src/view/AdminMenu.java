package view;

import controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu extends JFrame implements ActionListener{

    private Controller controller;
    private JButton btnAddSupplier = new JButton("New Supplier");
    private JButton btnProductPage = new JButton("Product Menu");
    private JButton btnOrderPage = new JButton("Orders Menu");
    private JButton btnDiscountPage = new JButton("Discount Menu");
    private JButton btnLogOut = new JButton("Log out");

    //Main menu for admin
    public AdminMenu(Controller controller){

        this.controller=controller;
        setLayout(new GridLayout(6,1));
        setSize(400,500);


        add(btnAddSupplier);
        add(btnProductPage);
        add(btnOrderPage);
        add(btnDiscountPage);
        add(btnLogOut);

        btnAddSupplier.addActionListener(this);
        btnProductPage.addActionListener(this);
        btnOrderPage.addActionListener(this);
        btnDiscountPage.addActionListener(this);
        btnLogOut.addActionListener(this);

        this.setTitle("Admin Main Menu");

        setLocationRelativeTo(null);
        setVisible(true);
    }

        public void actionPerformed(ActionEvent e) {


            if (e.getSource() == btnAddSupplier){
                this.dispose();
                new AddSupplier(controller);
            }

            if (e.getSource() == btnProductPage){
                this.dispose();
                new AdminProductMenu(controller);
            }
            if (e.getSource()==btnOrderPage){
                this.dispose();
                new AdminOrder(controller);
            }
            if (e.getSource()==btnDiscountPage){
                this.dispose();
                new AdminDiscount(controller);
            }
            if (e.getSource()==btnLogOut){
                this.dispose();
                new StartingMenu(controller);
            }

        }


}
