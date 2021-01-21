package database;

import java.sql.*;



public class Connection {

    private static java.sql.Connection conn;
    private static Statement statement;
  //  private ResultSet res;

    //Constructor that connects to the msql database online server
    public static void connect(){

        //komma ihåg att använda conn.close, statement.close senare när vi vet hur d ska hanteras?

        String user = "sa";
        String password = "secret";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://localhost;databasename=OnlineStore";
            conn = DriverManager.getConnection(dbURL, user, password);

            if (conn != null) {
                System.out.println("Connected");

            }else System.out.println("Error, connection failed");

             statement = conn.createStatement();

        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    //Method to send querys to the database and get back the ResultSet
    public static ResultSet executeQuery(String query){
        ResultSet res = null;

        try {
            res = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return res;

    }

    //Method for checking if an admins account exist in the database.
    public static void connectAdmin(String username, String password){  //ändra till bool sen
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
            }else System.out.println("Account does not exist");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //Method for checking if a customers account exist in the database.
    public static boolean connectCustomer(String username, String password){

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
                    return true;
                }else {
                    System.out.println(("Account does not exist"));
                    return false;
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public static void main(String[] args) {
        connect();



    }
}



