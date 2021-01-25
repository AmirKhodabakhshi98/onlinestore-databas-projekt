package view;

import controllers.Controller;

import javax.swing.*;

public class AdminOrder extends JFrame{

    private Controller controller;

    public AdminOrder(Controller controller){
        this.controller=controller;
        setSize(400,500);
        setLocationRelativeTo(null);
        setTitle("Admin Order Menu");
        setVisible(true);

    }


}
