package controllers;

import database.Connection;
import model.Customer;
import model.Orders;
import model.Product;
import model.Suppliers;
import view.*;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Controller {


    public String username;


    //Logging in a customer
    public void customerLogin(String user, String pw){

        this.username=user; //saves username to retreieve customer specific information later like their orders

        boolean loggedIn = Connection.connectCustomer(user,pw);

        //logic for if login is successful or not
        if (loggedIn){
            new CustomerMainMenu(this);
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid username and/or password");
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
            JOptionPane.showMessageDialog(null,"Invalid username and/or password");
            new StartingMenu(this);
        }
    }


    //Converts a Resultset object into a 2d array that can be used in JTables
    public static String[][] resultSetToArray(ResultSet res){

        try {

            ResultSetMetaData metaData = res.getMetaData(); //Metadata is to get information about resultset columns
            int columnCount = metaData.getColumnCount(); //gets the number of columns

            res.last(); //moves cursor to last row
            int rows = res.getRow(); //gets number of the last row, i.e row count

            String[][] prodArray = new String[rows][columnCount]; //intializes array based on resultset rows/cols

            res.first(); //moves cursor to first row

            for (int i=0; i<rows; i++){

                for (int j= 0 ; j<columnCount; j++){
                    prodArray[i][j] = res.getString(j+1);
                }

                res.next(); //moves pointer to next row
            }

            return prodArray;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }


    //Returns columnnames of a result set as an array so it can be used in JTAble
    public static String[] getColumnNames(ResultSet res){

        try {

            ResultSetMetaData metaData = null;

            metaData = res.getMetaData();

            int columns = metaData.getColumnCount();

            String[] colunmArray = new String[columns];

            for (int i=0; i<columns; i++){

                colunmArray[i] = metaData.getColumnName(i+1); //+1 else it would start by pointing at 0th col whilst table starts at col 1, etc

            }

            return colunmArray;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    //relays customers orders based on the stored username
    public String[][] getUserOrders(){

        return Orders.findOrdersByUsername(username);

    }

}
