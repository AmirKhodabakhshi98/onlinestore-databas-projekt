package view;

import controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartingMenu extends JFrame {


    private Controller controller;
    private JButton btnLogin = new JButton("Login");
    private JButton btnRegister = new JButton("Register");
    private JButton btnBrowse = new JButton("Browse");



    public StartingMenu(Controller controller){

        this.controller=controller;
        setSize(300,300);

        GridLayout layout = new GridLayout(3,1);
        layout.setVgap(55);
        setLayout(layout);
        add(btnLogin);
        add(btnRegister);
        add(btnBrowse);
        actionListener al = new actionListener();
        btnLogin.addActionListener(al);
        btnRegister.addActionListener(al);
        btnBrowse.addActionListener(al);

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
        new Register(controller);
    }
    private void browse(){
        this.dispose();
        new browseNoLogin(controller);
    }


    private class actionListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {


            if (e.getSource() == btnLogin){
                login();
            }
            if (e.getSource() == btnRegister) {
                register();
            }
            if (e.getSource()==btnBrowse){
                browse();
            }
        }

    }


}
