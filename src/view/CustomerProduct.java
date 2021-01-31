package view;

import controllers.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerProduct extends JFrame implements ActionListener {



    private Controller controller;

    public CustomerProduct(Controller controller){
        this.controller=controller;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
