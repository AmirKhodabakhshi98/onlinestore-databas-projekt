package view;

import controllers.Controller;

import javax.swing.*;

public class AdminDiscount extends JFrame {
    private Controller controller;

    public AdminDiscount(Controller controller){
        this.controller=controller;
        setSize(400,500);
        setLocationRelativeTo(null);
        setTitle("Admin Discount Menu");
        setVisible(true);

    }
}
