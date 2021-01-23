package view;

import controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startingMenu extends JFrame {


    private Controller controller;
    private JButton btnLogin = new JButton("login");
    private JButton btnRegister = new JButton("register");



    public startingMenu(Controller controller){

        this.controller=controller;
        setSize(300,300);

        GridLayout layout = new GridLayout(2,1);
        layout.setVgap(55);
        setLayout(layout);
        add(btnLogin);
        add(btnRegister);
        actionListener al = new actionListener();
        btnLogin.addActionListener(al);
        btnRegister.addActionListener(al);

        setLocationRelativeTo(null);

        setVisible(true);

    }


    //If login button is pressed this window closes and login window opens
    private void login(){

        this.dispose();
        new LogIn(controller);

    }

    //If register button is pressed this window closes and register window opens
    private void register(){

        this.dispose();
        new register(controller);
    }


    private class actionListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {


            if (e.getSource() == btnLogin){
                login();
            }
            if (e.getSource() == btnRegister)
                register();

        }
    }


}
