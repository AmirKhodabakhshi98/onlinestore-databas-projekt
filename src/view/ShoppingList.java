package view;

import controllers.Controller;

import javax.swing.*;

public class ShoppingList {

    private Controller controller;

    private JLabel lblEmpty = new JLabel("");
    private JLabel lblEmpty2 = new JLabel("");
    private JLabel lblID = new JLabel("ProductID");
    private JLabel lblQuantity = new JLabel("Quantity");


    public ShoppingList(Controller controller){

        this.controller = controller;

    }




}
