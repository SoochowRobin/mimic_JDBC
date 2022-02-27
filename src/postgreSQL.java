import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class postgreSQL {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/robinchen",
                    "postgres", "12345");

            statement = connection.createStatement();
//            String sql = "CREATE DATABASE connection_test";
//            statement.executeUpdate(sql);
//            System.out.println("Create a database!");  // drop a database
//            String sql_del = "DROP DATABASE connection_test";
//            statement.executeUpdate(sql_del);
            String sql_table = "CREATE TABLE connection_test(Name varchar(20)," +
                    "Age int)";
            statement.executeUpdate(sql_table);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }finally {
            try{
                if (statement !=null){
                    statement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try{
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        System.out.println("Opened database successfully");

    }



}
