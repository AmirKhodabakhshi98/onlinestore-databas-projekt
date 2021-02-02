package view;

import controllers.Controller;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProduct extends JPanel implements ActionListener{

    private JLabel lblId = new JLabel("ID");
    private JLabel lblSupplier = new JLabel("Supplier");
    private JLabel lblName = new JLabel("Name");
    private JLabel lblPrice = new JLabel("Price");
    private JLabel lblQuantity = new JLabel("Quantity");

    private JTextField tfId = new JTextField();
    private JTextField tfSupplier = new JTextField();
    private JTextField tfName = new JTextField();
    private JTextField tfPrice = new JTextField();
    private JTextField tfQuantity = new JTextField();

    private JButton btnAdd = new JButton("Add");

    Controller controller;
    AdminProductMenu apm;


    //gui class that handles admin adding a new product to db
    public AddProduct(Controller controller, AdminProductMenu apm){
        this.controller=controller;
        this.apm=apm;
        setLayout(new GridLayout(6,2));
      //  add(lblId);
     //   add(tfId);
        add(lblSupplier);
        add(tfSupplier);
        add(lblName);
        add(tfName);
        add(lblPrice);
        add(tfPrice);
        add(lblQuantity);
        add(tfQuantity);
        add(btnAdd);
        btnAdd.addActionListener(this);
        setSize(400,500);
        setVisible(true);


    }

    private void addProduct(){
        Product.addProduct(
                tfSupplier.getText(),
                tfName.getText(),
                Integer.parseInt(tfPrice.getText()),
                Integer.parseInt(tfQuantity.getText()));
    }



        public void actionPerformed(ActionEvent e) {


          if (e.getSource()==btnAdd){
              addProduct();
              tfId.setText(null);
              tfSupplier.setText(null);
              tfName.setText(null);
              tfPrice.setText(null);
              tfQuantity.setText(null);
              tfQuantity.setText(null);
              apm.updateTable();

          }

        }

}
