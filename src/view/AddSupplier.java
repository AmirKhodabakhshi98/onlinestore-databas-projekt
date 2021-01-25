package view;

import javax.swing.*;
import controllers.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSupplier extends JFrame {

    private JLabel lblName = new JLabel("Name");
    private JLabel lblNbr = new JLabel("Phone number (with no space)");
    private JLabel lblAddress = new JLabel("Address");
    private JTextField tfName = new JTextField();
    private JTextField tfNbr = new JTextField();
    private  JTextField tfAddress = new JTextField();
    private Controller controller;
    private JButton addButton = new JButton("Add");
    private  JButton menuButton = new JButton("Main Menu");

    public AddSupplier(Controller controller){
        this.controller=controller;
        this.setTitle("New Supplier");
        setLayout(new GridLayout(4,2));
        add(lblName);
        add(tfName);
        add(lblNbr);
        add(tfNbr);
        add(lblAddress);
        add(tfAddress);
        add(addButton);
        add(menuButton);
        actionListener al = new actionListener();
        addButton.addActionListener(al);
        menuButton.addActionListener(al);
        setSize(400,500);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    //Takes you back to admin main menu
    private void goToMainMenu(){
        this.dispose();
        new AdminMenu(controller);
    }

    //Sends input data to controller in order to add new supplier to db
    private void addSupplier(){

        controller.newSupplier(tfName.getText(), Integer.parseInt(tfNbr.getText()), tfAddress.getText());
        clearFields();

    }

    //Clears input fields
    private void clearFields(){
        tfName.setText(null);
        tfAddress.setText(null);
        tfNbr.setText(null);
    }


    private class actionListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {


                if (e.getSource() == addButton){
                    addSupplier();
                }
                if (e.getSource() == menuButton){
                    goToMainMenu();
                }

        }
    }



}