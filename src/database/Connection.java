package database;

import controllers.Controller;
import view.*;

import java.sql.*;



public class Connection {

    private static java.sql.Connection conn;
    private static Statement statement;
  //  private ResultSet res;

    //Constructor that connects to the msql database online server
    public static void connect(){

        //komma ihåg att använda conn.close, statement.close senare när vi vet hur d ska hanteras?
        //uppdatera logic för failed/connected lite

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

             statement = conn.createStatement();

            res = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

            return res;

    }

    //Method for executing querys that expect no resultset, eg INSERT or DELETE
    public static void executeQueryNoResult(String query){

        try {


            statement = conn.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    //Method for checking if an admins account exist in the database.
    public static boolean connectAdmin(String username, String password) {
        try {

            String getAdmins =
                    "Select Username, Password " +
                            " FROM Admin"; //

            ResultSet res = executeQueryWithResult(getAdmins);


            while (res.next()) {

                String user = res.getNString("Username"); //ändra eventuellt kolumnnamn...
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

        String getUsers =
                "Select Username, Password " +
                        " FROM Customer";

                 ResultSet res = executeQueryWithResult(getUsers);


                while (res.next()){

                    String user = res.getNString("Username");
                    String pw = res.getNString("Password");

                    if (user.equals(username) && pw.equals(password)){
                        System.out.println("Costumer logged in");
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



