package database;

import controllers.Controller;
import view.*;

import javax.swing.*;
import java.sql.*;


public class Connection {

    public static String globalUsername; //so users username can be accessed from rest of program

    private static java.sql.Connection conn;
    private static Statement statement;
  //  private ResultSet res;

    //Constructor that connects to the msql database online server
    public static void connect(){

        String user = "sa";
        String password = "secret";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://localhost;databasename=OnlineStore";
            conn = DriverManager.getConnection(dbURL, user, password);

            if (conn != null) {
                System.out.println("Connected");

            }else System.out.println("Error, connection failed");

         //    statement = conn.createStatement();

        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    //Method to send querys to the database and get back the ResultSet
    public static ResultSet executeQueryWithResult(String query){
        ResultSet res = null;

        try {

             statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            res = statement.executeQuery(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

            return res;

    }

    //Method for executing querys that expect no resultset, eg INSERT or DELETE
    public static void executeQueryNoResult(String query){

        try {


            statement = conn.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }


    //Method for checking if an admins account exist in the database.
    public static boolean connectAdmin(String username, String password) {
        try {

            String getAdmins = "EXEC getAdmins";

            ResultSet res = executeQueryWithResult(getAdmins);


            while (res.next()) {

                String user = res.getNString("Email");
                String pw = res.getNString("Password");

                if (user.equals(username) && pw.equals(password)) {
                    System.out.println("Admin logged in");
                    return true;

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        System.out.println("admin login failed");
        return false;
    }



    //Method for checking if a customers account exist in the database.
    public static boolean connectCustomer(String username, String password){

        try {

        String getUsers = "EXEC getCustomerLogin";

                 ResultSet res = executeQueryWithResult(getUsers);

                while (res.next()){

                    String user = res.getNString("Username");
                    String pw = res.getNString("Password");

                    //checks if username and password match database records
                    if (user.equals(username) && pw.equals(password)){
                        System.out.println("Costumer logged in");
                        globalUsername = username;
                        return true;
                    }
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(("Account does not exist"));
        return false;

    }

    public static void main(String[] args) {
        connect();
        Controller controller = new Controller();

     //   new StartingMenu(controller);
        new AdminProductMenu(controller);
     //     new CustomerMainMenu(controller);



    }
}



