package view;

import controllers.Controller;
import model.Suppliers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminMainMenu extends JFrame {

    private Controller controller;
    private JButton btnAddSupplier = new JButton("New Supplier");
    private JButton btnProductPage = new JButton("Product Page");

    public adminMainMenu(Controller controller){

        this.controller=controller;
        actionListener al = new actionListener();
        setLayout(new GridLayout(6,2));
        setSize(400,500);


        add(btnAddSupplier);
        add(btnProductPage);

        btnAddSupplier.addActionListener(al);
        btnProductPage.addActionListener(al);

        setVisible(true);
    }

    //Takes you to add suplier page
    private void addSupplier(){
        this.dispose();
        new addSupplier(controller);
    }

    //Opens admin product page
    private void openProductPage(){
        this.dispose();
        new adminProductPage(controller);
    }

    private class actionListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {


            if (e.getSource() == btnAddSupplier){
                addSupplier();
            }

            if (e.getSource() == btnProductPage){
                openProductPage();


            }


        }
    }

}
