package com.ignite.ee.Database;

import com.ignite.ee.util.PropertyLoader;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDatabase{
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public void ConnectDatabase(String sql){
        //String jdbcUrl = "jdbc:mysql://localhost:3306/bank?useSSL=false";
        String jdbcUrl = PropertyLoader.loadProperty("jdbc.url");
        String username =  PropertyLoader.loadProperty("jdbc.username");
        String password = null;
        try (java.sql.Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             java.sql.Statement stmt = conn.createStatement();) {

            stmt.executeUpdate(sql);
            System.out.println("Database updated successfully ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
