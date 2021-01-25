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
            new CustomerMainMenu(this);
        }
        else {
            JOptionPane.showMessageDialog(null, "Error logging in");
            new StartingMenu(this);
        }

    }

    //Logging in an admin
    public void adminLogin(String user, String pw){

        boolean loggedIn = Connection.connectAdmin(user,pw);

        //logic for if login is successful or not
        if (loggedIn){
            new AdminMenu(this);
        }
        else  {
            JOptionPane.showMessageDialog(null,"Error logging in");
            new StartingMenu(this);
        }


    }

    //Creates new customer row in db
    public void registerCustomer(String fName, String lName, String email, String user, String pw, int nbr,
                                 String country, String city, String address){

        Customer customer = new Customer( fName, lName, email,user,pw, nbr, country, city, address);
        Customer.insertOne(customer);

    }

    public void addProduct(int id, String supplier, String name, int price, int quantity){

        Product.addProduct(id,supplier,name,price,quantity);

    }

    public void editProduct(int id, int quantity){
        Product.editProductQuantity(id,quantity);


    }

    public void deleteProduct(int id){
        Product.deleteProduct(id);
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
