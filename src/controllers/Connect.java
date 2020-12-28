package controllers;

import java.sql.*;

public class Connect {

    public Connect(){

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://localhost;databasename=OnlineStore";
            Connection conn = DriverManager.getConnection(dbURL, "sa", "secret");
            if (conn != null) {

                System.out.println("Connected");

            }



        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Connect con = new Connect();
    }
}
