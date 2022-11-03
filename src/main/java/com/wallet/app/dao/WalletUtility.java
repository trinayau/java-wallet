package com.wallet.app.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class WalletUtility {
    public static Connection getConnectionToMySQL() {
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1:3306/ford_schema?" + "user=root&password=Elyonn2022!");
            System.out.println("Connection to MYSQL successful!");
            Statement stmt = connection.createStatement();

            stmt.executeUpdate("DROP TABLE IF EXISTS wallet");
            System.out.println("Drop wallet table if exists");
            String sql = "CREATE TABLE wallet " +
                    "(id INTEGER not NULL, " +
                    " name VARCHAR(50), " +
                    " password VARCHAR(50), " +
                    " balance FLOAT, " +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);
            System.out.println("Created wallet table");

        } catch (SQLException e) {
            System.out.println("Error connecting to MySQL DB, please try again: " + e);
        }

        return connection;
    }

}
