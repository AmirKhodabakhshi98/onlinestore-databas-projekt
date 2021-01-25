package view;

import controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu extends JFrame {

    private Controller controller;
    private JButton btnAddSupplier = new JButton("New Supplier");
    private JButton btnProductPage = new JButton("Product Page");
    private JButton btnOrderPage = new JButton("Orders Page");

    public AdminMenu(Controller controller){

        this.controller=controller;
        actionListener al = new actionListener();
        setLayout(new GridLayout(6,1));
        setSize(400,500);


        add(btnAddSupplier);
        add(btnProductPage);
        add(btnOrderPage);

        btnAddSupplier.addActionListener(al);
        btnProductPage.addActionListener(al);
        btnOrderPage.addActionListener(al);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    //Takes you to add suplier page
    private void addSupplier(){
        this.dispose();
        new AddSupplier(controller);
    }

    //Opens admin product page
    private void openProductPage(){
        this.dispose();
        new AdminProductMenu(controller);
    }

    private void openOrderPage(){
        this.dispose();
        new AdminOrder(controller);
    }
    private class actionListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {


            if (e.getSource() == btnAddSupplier){
                addSupplier();
            }

            if (e.getSource() == btnProductPage){
                openProductPage();
            }
            if (e.getSource()==btnOrderPage){
                openOrderPage();
            }


        }
    }

}
