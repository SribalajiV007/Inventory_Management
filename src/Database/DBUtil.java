package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String url = "jdbc:mysql://localhost:3306/smart_warehouse";
    private static final String user = "root";
    private static final String password = "Malliga2003#";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }

}