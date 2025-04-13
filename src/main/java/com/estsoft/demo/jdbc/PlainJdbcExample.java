package com.estsoft.demo.jdbc;

import java.sql.*;

public class PlainJdbcExample {
    private static final String url ="jdbc:mysql://127.0.0.1:3306/test_db";
    private static final String username ="root";
    private static final String password ="1234";

    public static void main(String[] args) {

        try (
        Connection conn = DriverManager.getConnection(url,username,password);
        Statement statement = conn.createStatement();
        ResultSet resultSet =  statement.executeQuery("select * from students"); ){

            while(resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("name: " + resultSet.getString("name"));
                System.out.println("age: " + resultSet.getInt("age"));
                System.out.println("address: " + resultSet.getString("address"));
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception : " + e.getMessage());
        }

    }
}
