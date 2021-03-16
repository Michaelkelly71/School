import java.sql.*;

public class dbConnection {

    private Connection Database;

    public dbConnection() {
        
    }
    
    public Connection getDatabase() {
        String url="jdbc:mariadb://localhost:3306/FeePaymentSystem";
        String dbUsername = "root";
        String dbPassword = "mack1234";

        try {
            Database = DriverManager.getConnection(url, dbUsername, dbPassword);
            
        } catch (Exception e) {
            e.getStackTrace();
        }
        return Database;
    }

}