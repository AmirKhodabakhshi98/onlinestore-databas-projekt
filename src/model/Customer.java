package model;


import database.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {


    public String firstName;
    public String lastName;
    public String email;
    public String username;
    public String password;
    public int phoneNumber;
    public String country;
    public String  city;
    public String streetAddress;

    public Customer(
        String firstName,
        String lastName,
        String email,
        String username,
        String password,
        int phoneNumber,
        String country,
        String  city,
        String streetAddress
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.city = city;
        this.streetAddress = streetAddress;
    }

    public static void insertOne(Customer customer) {

        Connection.executeQueryNoResult(
            "INSERT INTO Customer (" +
                "Firstname, " +
                "Lastname, " +
                "Email, " +
                "Username, " +
                "Password, " +
                "Phone_number, " +
                "Country, " +
                "City, " +
                "Street_address " +
            ") " +
            "VALUES('" +
                customer.firstName + "', '" +
                customer.lastName + "', '" +
                customer.email + "', '" +
                customer.username + "', '" +
                customer.password + "', " +
                customer.phoneNumber + ", '" +
                customer.country + "', '" +
                customer.city + "', '" +
                customer.streetAddress +
            "')"
        );
    }


    public static Customer findByUsername(String username) throws SQLException {

        ResultSet resultSet = Connection.executeQueryWithResult(
            "SELECT *" +
            "FROM Customer" +
            "WHERE Username = " + "'" +username + "'"
        );

        String firstName = "";

        String lastName = "";

        String email = "";

        String password = "";

        String country = "";

        String city = "";

        String streetAddress = "";

        int phoneNumber = 0;

        while (resultSet.next()) {

            firstName = resultSet.getNString("Firstname");

            lastName = resultSet.getNString("Lastname");

            email = resultSet.getNString("Email");

            password = resultSet.getNString("Password");

            country = resultSet.getNString("country");

            city = resultSet.getNString("city");

            streetAddress = resultSet.getNString("Street_address");

            phoneNumber = resultSet.getInt("Phone_number");
        }

        return new Customer(
            firstName,
            lastName,
            email,
            username,
            password,
            phoneNumber,
            country,
            city,
            streetAddress
        );
    }
}
