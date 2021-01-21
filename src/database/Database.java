package database;


import java.sql.*;

public class Database {

    private DatabaseSettings settings;

    private Connection connection;

    public Database(DatabaseSettings settings) {

        this.settings = settings;

        this.connect();
    }

    private void connect() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection connection = DriverManager.getConnection(settings.getUrl(), settings.getUser(), settings.getPassword());

            this.connection = connection;

            if (connection != null) {

                System.out.println("Database connected");
            }
        }
        catch(ClassNotFoundException | SQLException error) {

            System.err.println("Error occured when connecting to database!"+ "\n"+ error);
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {

        Statement statement = this.connection.createStatement();

        ResultSet result = statement.executeQuery(query);

        statement.close();

        return result;
    }

    public void close() throws SQLException {

        this.connection.close();
    }
}
