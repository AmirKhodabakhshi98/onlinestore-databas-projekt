package model;

public class Suppliers {
<<<<<<< Updated upstream
=======
    String query;

    //Add a supplier
    public void addSupplier(String name, int phonenbr, String address){
        query = "Insert into Supplier (Name, Phone_number, Address) " +
                "values (" + name + ", " + phonenbr + ", " + address + ");" ;

        Connection.executeQuery(query);

    }





>>>>>>> Stashed changes
}
