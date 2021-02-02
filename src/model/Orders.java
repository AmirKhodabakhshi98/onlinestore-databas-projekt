package model;

import controllers.Controller;
import database.Connection;

import java.sql.ResultSet;

public class Orders {





    public static void deleteOrder(int id){

        String query = "EXEC deleteOrder @Order_id = " + id;

        Connection.executeQueryNoResult(query);

    }


    public static String[][] findOrderProductsByOrderId(int id){

        String query = "EXEC findOrderProductsByOrderId @Order_id = " + id;

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

}
