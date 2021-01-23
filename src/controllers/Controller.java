package controllers;

import database.Connection;
import model.Customer;
import model.Product;
import model.Suppliers;
import view.*;

import javax.swing.*;

public class Controller {




    //Logging in a customer
    public void customerLogin(String user, String pw){

        boolean loggedIn = Connection.connectCustomer(user,pw);

        //logic for if login is successful or not
        if (loggedIn){
            new customerMainMenu(this);
        }
        else {
            JOptionPane.showMessageDialog(null, "Error logging in");
            new startingMenu(this);
        }

    }

    //Logging in an admin
    public void adminLogin(String user, String pw){

        boolean loggedIn = Connection.connectAdmin(user,pw);

        //logic for if login is successful or not
        if (loggedIn){
            new adminMainMenu(this);
        }
        else  {
            JOptionPane.showMessageDialog(null,"Error logging in");
            new startingMenu(this);
        }


    }

    //Creates new customer row in db
    public void registerCustomer(String fName, String lName, String email, String user, String pw, int nbr,
                                 String country, String city, String address){

        Customer customer = new Customer( fName, lName, email,user,pw, nbr, country, city, address);
        Customer.insertOne(customer);

    }

    public void editProduct(int id, int quantity){
        Product.editProductQuantity(id,quantity);


    }

    //Adds new supplier to db
    public void newSupplier(String name, int nbr, String address){

        Suppliers.addSupplier(name, nbr, address);

    }

    //retrieves and returns arraylist of all products in db
    public String[][] getProducts(){
        return Product.getAllProducts();
    }




}
