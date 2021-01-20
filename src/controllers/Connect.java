package controllers;

import java.sql.*;



public class Connect {

    private static Connection conn;
    private static Statement statement;
  //  private ResultSet res;

    public Connect(){

        //komma ihåg att använda conn.close, statemnet.close senare när vi vet hur d ska hanteras

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://localhost;databasename=OnlineStore";
            conn = DriverManager.getConnection(dbURL, "sa", "secret");

            if (conn != null) {
                System.out.println("Connected");

            }else System.out.println("Error, connection failed");

             statement = conn.createStatement();

        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public static ResultSet executeQuery(String query){
        ResultSet res = null;

        try {
            res = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return res;

    }

    public static void connectAdmin(String username, String password){
        try {

            String getAdmins =
                    "Select Username, Password " +
                            " FROM BLANK"; //replace blank later....

            ResultSet res = executeQuery(getAdmins);

            boolean userExists = false;

            while (res.next()){

                String user = res.getNString("Username"); //ändra eventuellt kolumnnamn...
                String pw = res.getNString("Password");

                if (user.equals(username) && pw.equals(password)){
                    userExists = true;
                    break;
                }
            }



            System.out.println(userExists);
            if (userExists){
                System.out.println("Admin logged in");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void connectCustomer(String username, String password){

        try {

        String getUsers =
                "Select Username, Password " +
                        " FROM Customer";

                 ResultSet res = executeQuery(getUsers);

                boolean userExists = false;

                while (res.next()){

                    String user = res.getNString("Username");
                    String pw = res.getNString("Password");

                    if (user.equals(username) && pw.equals(password)){
                        userExists = true;
                        break;
                    }
                }



                System.out.println(userExists);
                if (userExists){
                    System.out.println("Costumer logged in");
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Connect con = new Connect();
        connectCustomer("user1", "pw1");

    }
}



