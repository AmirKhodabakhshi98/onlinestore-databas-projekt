package view;

import controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {

    private JLabel lblUser = new JLabel("Username");
    private JLabel lblFirstN = new JLabel("Firstname");
    private JLabel lblLastN = new JLabel("Lastname");
    private JLabel lblEmail = new JLabel("Email");
    private JLabel lblNbr = new JLabel("Phone nbr (no spaces)");
    private JLabel lblCountry = new JLabel("Country");
    private JLabel lblCity = new JLabel("City");
    private JLabel lblAddress = new JLabel("Address");
    private JLabel lblPw = new JLabel("Password");

    private JTextField tfUser = new JTextField();
    private JTextField tfFirstN = new JTextField();
    private JTextField tfLastN = new JTextField();
    private JTextField tfEmail = new JTextField();
    private JTextField tfNbr = new JTextField();
    private JTextField tfCountry = new JTextField();
    private JTextField tfCity = new JTextField();
    private JTextField tfAddress = new JTextField();
    private JTextField tfPw = new JTextField();

    private JButton buttonRegister = new JButton("Register");

    private Controller controller;

    public Register(Controller controller){
        this.controller=controller;

        setLayout(new GridLayout(10,2));
        setSize(400,500);
        setLocationRelativeTo(null);

        add(lblFirstN);
        add(tfFirstN);
        add(lblLastN);
        add(tfLastN);
        add(lblEmail);
        add(tfEmail);
        add(lblUser);
        add(tfUser);
        add(lblPw);
        add(tfPw);
        add(lblNbr);
        add(tfNbr);
        add(lblCountry);
        add(tfCountry);
        add(lblCity);
        add(tfCity);
        add(lblAddress);
        add(tfAddress);
        add(buttonRegister);

        actionListener al = new actionListener();
        buttonRegister.addActionListener(al);

        setVisible(true);

    }

    //Takes input values and sends to controller for registering user
    private void register(){
        controller.registerCustomer(
            tfFirstN.getText(),
            tfLastN.getText(),
            tfEmail.getText(),
            tfUser.getText(),
            tfPw.getText(),
            Integer.parseInt(tfNbr.getText()),
            tfCountry.getText(),
            tfCity.getText(),
            tfAddress.getText()
        );

        this.dispose();
        new LogIn(controller);

    }

/*
    private void clearTextfield(){

        tfUser.setText(null);
        tfFirstN.setText(null);
        tfLastN.setText(null);
        tfEmail.setText(null);
        tfNbr.setText(null);
        tfCity.setText(null);
        tfCountry.setText(null);
        tfAddress.setText(null);
        tfPw.setText(null);

    }

 */


    private class actionListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == buttonRegister){
                register();
            }



        }
    }


}
