import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // Change these if needed
    private static final String URL = "jdbc:mysql://localhost:3306/srms";
    private static final String USER = "root";
    private static final String PASSWORD = "fooders2000";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        } catch (Exception e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
            return null;
        }
    }
}