import java.sql.*;

public class exempel {



    public exempel() {

        try {


            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //   String dbURL="jdbc:sqlserver://localhost\\sqlexpress;user=DESKTOP-RPVA9PI\\Amir;password=";
            //  String dbURL="jd-bc:sqlserver://localhost:1433;databaseName=School;user=DESKTOP-RPVA9PI\\Amir;";
            String dbURL = "jdbc:sqlserver://localhost;databasename=school";
            String user = "DESKTOP-RPVA9PI/Amir";

            Connection conn = DriverManager.getConnection(dbURL, "sa", "secret");
            if (conn != null) {
                System.out.println("Connected");
            }

            assert conn != null : "CONNECTION IS NULL, BAKA!";
            Statement statement = conn.createStatement();
            String selectSql =
                    "Select department.name DepartmentName" +
                            " from student join department" +
                            " on student.dep_code=department.code" +
                            " where f_name ='Carlos' and l_name='Manuel' ";
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                System.out.println(resultSet.getMetaData().getColumnName(1));
                System.out.println(resultSet.getString(1));
            }

            statement.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
       // exempel ex = new exempel();
    }

}
