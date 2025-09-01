package finalProject.Util;


import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {

    private static final BasicDataSource ds = new BasicDataSource();
    private static Connection connection;

    static {
        ds.setUrl("jdbc:mysql://localhost:3306/test_schema?serverTimeZone=UTC");
        ds.setUsername("lawyer_admin");
        ds.setPassword("Lawyer12345!");
        ds.setInitialSize(8);
        ds.setMinIdle(5);
        ds.setMaxIdle(20);


    }

    private DBUtil() {

    }

    public static Connection getConnection() throws SQLException {
        connection = ds.getConnection();
        System.out.println("Connection ok!");
        return connection;
    }

    public static void closeConnection() throws SQLException{
        if (connection != null) connection.close();
    }
}
