package usm;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/usm", "root", "1234567890");

            // Create a statement object
            s = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}