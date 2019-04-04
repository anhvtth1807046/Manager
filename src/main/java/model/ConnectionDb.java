package model;

import java.sql.*;

public class ConnectionDb {
    public Connection ConnectionMysql () throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ManagerSchool?user=root&password=");
        return connection;
    }
}
