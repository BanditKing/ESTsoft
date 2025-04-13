package com.estsoft.demo.jdbc;

import java.sql.*;

/**
 * 1. DB연결
 * 2. SQL 실행 -> UPDATE 쿼리 (전체 age = 30)
 * 3. 결과 출력 -> update 갯수
 */
public class UpdateJdbcExample {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/test_db";
    private static final String username = "root";
    private static final String password = "1234";

    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(url, username, password);
                Statement statement = conn.createStatement()
        ) {
            // 2. SQL 실행 -> 나이 30으로 수정
            String updatequery = "UPDATE students SET age = 30";

            // 3. 결과 출력
            int count = statement.executeUpdate(updatequery);
            System.out.println(count + "명 나이 수정");
        } catch (SQLException e) {
            System.out.println("SQL Exception : " + e.getMessage());
        }
    }
}