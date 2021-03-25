package model;

import controllers.Controller;
import database.Connection;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Orders {


    public static void addToCart(String username, int productId, int quantity){

        int FinalPrice = calculateDiscountedPriceBasedOnDate(productId,quantity,null);


        String query = "EXEC addToCart @Username = '" + username + "', @Product_ID = " + productId
        + ", @Quantity = " + quantity + ", @FinalPrice = " + FinalPrice;

        Connection.executeQueryNoResult(query);


    }


    public static void purchase(String username){

        if (Orders.fetchCartItems(username).length != 0) {

            String query = "EXEC PURCHASE @username = '" + username + "'";

            Connection.executeQueryNoResult(query);
        }
        else JOptionPane.showMessageDialog(null,"Empty order");
    }


    public static String[][] fetchCartItems(String username){
        String query = "exec fetchCartItems @username = '" + username + "'";
        ResultSet res = Connection.executeQueryWithResult(query);
        String[][] arr = Controller.resultSetToArray(res);

        for (int i = 0; i<arr.length; i++){
            for (int j=0; j<arr[i].length; j++){
                System.out.println(arr[i][j]);
            }
        }
        System.out.println(arr);
        return arr;
    }

    public static void deleteFromCart(String username, int productId){
        String query = "EXEC deleteFromCart @Product_ID = " + productId + ", @username = '" + username + "'";
        Connection.executeQueryNoResult(query);
    }




    public static int totalPrice(String username){
        String query = "EXEC totalPrice @username = '" + username + "'";
        ResultSet res = Connection.executeQueryWithResult(query);

        try {

            res.next();
            return res.getInt("price"); // fixa sen

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return -1;

    }



    //Method for getting the total price of an order
    public static int getOrderPrice(int orderID, String username){

        int orderPrice = 0;

        try {

            String q = "Select Username from [Order] where [Order].Order_id = " + orderID;
            ResultSet r = Connection.executeQueryWithResult(q);
            r.next();
            if (username.equals(r.getNString("Username"))) {

                //gets date for the order
                String query = "Select FORMAT([date] , 'yyyy-MM-dd hh:mm:ss') AS [Date] from [Order] where Order_id = " + orderID;
                ResultSet res = Connection.executeQueryWithResult(query);
                res.next();
                String date = res.getNString("Date");

                //gets a list of products and their quantities for the order.
                query = "Select Product_id, QuantitySold from Order_Product where Order_product.Order_id = " + orderID;
                res = Connection.executeQueryWithResult(query);

                //goes through all products in order and fetches their price, then combines them.
                while (res.next()) {
                    int productID = res.getInt("Product_id");
                    int quantity = res.getInt("QuantitySold");

                    orderPrice += calculateDiscountedPriceBasedOnDate(productID, quantity, date);    //calculates total order price

                }
            }else JOptionPane.showMessageDialog(null, "Error fetching order");


        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error fetching order");
            e.printStackTrace();
        }

        return orderPrice;
    }


    public static void deleteOrder(int id, String username){

        String query = "EXEC deleteOrder @Order_id = " + id + ", @Username = '" + username + "'";

        Connection.executeQueryNoResult(query);

    }


    public static String[][] findOrderProductsByOrderId(int id, String username){

        String query = "EXEC findOrderProductsByOrderId @Order_id = " + id + ", @Username = '" + username + "'";

        ResultSet res = Connection.executeQueryWithResult(query);

        return Controller.resultSetToArray(res);

    }

    public static String[][] findOrdersByUsername(String username){

        String query = "EXEC findOrdersByUsername @Username = '" + username + "'";

        ResultSet res = Connection.executeQueryWithResult(query);

        return Controller.resultSetToArray(res);

    }

    public static String[][] UnconfirmedOrders(){
        String query = "EXEC UnconfirmedOrders";

        ResultSet res = Connection.executeQueryWithResult(query);

        return Controller.resultSetToArray(res);
    }


    public static void confirmOrder(int orderID){
        String query = "EXEC confirmOrder @Order_id = " + orderID;
        Connection.executeQueryNoResult(query);
    }


    public static Object[] maxMonthlyOrder(){
        Object[] returnData = new Object[2];

        String query = "EXEC maxMonthlyOrder";

        ResultSet res = Connection.executeQueryWithResult(query);

        returnData[0] = Controller.resultSetToArray(res);
        returnData[1] = Controller.getColumnNames(res);

        return returnData;

    }


    //Method to calculate product price at a given date taking in account quantity and discount
    public static int calculateDiscountedPriceBasedOnDate(int productID, int quantity, String dateStamp){

        //if datestamp is empty or null it gets the current datetime
        if (dateStamp == null || dateStamp.equals("")){
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //create current date in same format as SQL
            dateStamp = formatter.format(date);

        }

        //Gets the base price of a product
        String query = "SELECT Base_price FROM Product where Product_id = " + productID;
        ResultSet res = Connection.executeQueryWithResult(query);
        try {
            res.next();
            int basePrice = res.getInt("Base_price");


            //gets the discount percentage applied to the product at the given date
            query = "Select Percentage \n" +
                    "FROM Discount\n" +
                    "JOIN Product_discount on Discount.Discount_id = Product_discount.Discount_id\n" +
                    "WHERE '" + dateStamp + "' >= Start_date AND '" + dateStamp + "' <= End_date AND Product_discount.Product_id = " + productID; //checks if date is during a discount period for product
            res = Connection.executeQueryWithResult(query);

            int percentage;

            //check if there is discount. checks if null or if it isnt on first row which would mean its empty
            if (res == null || !res.first()) {

                percentage=0;

            }else {

                percentage = res.getInt("Percentage"); //gets discount percentage

            }

            //calculates total price for given quantity and applied discount
            double finalPrice = basePrice * quantity * (1 - percentage/100.0);

            return (int)finalPrice;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return -1;

    }

}
