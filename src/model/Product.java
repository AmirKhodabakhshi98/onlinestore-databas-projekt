package model;

import controllers.Controller;
import database.Connection;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class Product {

    private int id;
    private String supplier;
    private String name;
    private int price;
    private int quantity;

    public Product(int id, String supplier, String name, int price, int quantity){

        this.id= id;
        this.supplier=supplier;
        this.name=name;
        this.price=price;
        this.quantity=quantity;

    }



    public static void addProduct( String supplier, String name, int price, int quantity){

        String  query = "EXEC addProduct @Supplier_name = '" + supplier + "', @Name = '" + name + "', @Base_price = " +
                price + ", @Quantity = " + quantity;

        Connection.executeQueryNoResult(query);

    }


    //Alter quantity of a product in db based on input id
    public static void editProductQuantity(int id, int quantity){



        String  query = "EXEC setProductQuantity @Product_id = '" + id + "', @Quantity = '" + quantity + "'";

            Connection.executeQueryNoResult(query);


    }

    //Delete a product in db based on input id
    public static void deleteProduct(int id){

        String query = "EXEC deleteProduct @Product_id = " + id;

        Connection.executeQueryNoResult(query);
    }



    //Returns an array of representing all products stored in the database
    public static String[][] getAllProducts(){


        String  query = "EXEC getProducts";

            ResultSet res = Connection.executeQueryWithResult(query);   // returns all products

            return Controller.resultSetToArray(res);

    }

    //Returns all products including their current discount status
    public static String[][] getAllProductsAndDiscount(){
        String query = "EXEC getProductsAndDiscount";
        ResultSet res = Connection.executeQueryWithResult(query);

        return Controller.resultSetToArray(res);
    }


    public static String[][] searchProductOnSupplier(String keyword){

        String  query = "EXEC searchSupplier @Supplier_name = '" + keyword + "'";

        ResultSet res = Connection.executeQueryWithResult(query);

        return Controller.resultSetToArray(res);

    }

    public static String[][] searchProductOnPrice(int keyword){

        String query = "EXEC searchProductPrice @Price = " + keyword;

        ResultSet res = Connection.executeQueryWithResult(query);

        return Controller.resultSetToArray(res);

    }

    public static String[][] searchProductOnName(String keyword){

        String query = "EXEC searchNameProduct @Name = '" + keyword + "'";

        ResultSet res = Connection.executeQueryWithResult(query);

        return Controller.resultSetToArray(res);

    }


    public static String[][] searchProductOnId (int price){
        String query = "EXEC searchProductId @Id = " + price + "";

        ResultSet res = Connection.executeQueryWithResult(query);

        return Controller.resultSetToArray(res);
    }

    public static String[][] customerSearchID(int id){
        String query = "EXEC customerSearchID @id = " + id;

        ResultSet res = Connection.executeQueryWithResult(query);

        return Controller.resultSetToArray(res);
    }


    public static String[][] customerSearchName(String name){
        String query = "EXEC customerSearchName @name = '" + name +"'";

        ResultSet res = Connection.executeQueryWithResult(query);

        return Controller.resultSetToArray(res);
    }
    public static String[][] customerSearchSupplier(String supplier){
        String query = "EXEC customerSearchSupplier @supplier = '" + supplier + "'";

        ResultSet res = Connection.executeQueryWithResult(query);

        return Controller.resultSetToArray(res);
    }
    public static String[][] customerSearchPrice(int price){
        String query = "EXEC customerSearchPrice @price = " + price;

        ResultSet res = Connection.executeQueryWithResult(query);

        return Controller.resultSetToArray(res);
    }

}


            /*
            for (int i=0; i<prodArray.length; i++){
                res.next();
                prodArray[i][0] = String.valueOf(res.getInt("Product_id"));
                prodArray[i][1] = res.getNString("Supplier_name");
                prodArray[i][2] = res.getNString("Name");
                prodArray[i][3] = String.valueOf(res.getInt("Base_price"));
                prodArray[i][4] = String.valueOf(res.getInt("Quantity"));
            }

             */

