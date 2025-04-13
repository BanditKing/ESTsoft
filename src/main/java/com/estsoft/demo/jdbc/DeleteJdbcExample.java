package com.estsoft.demo.jdbc;

import java.sql.*;

/**
 * 1. DB연결
 * 2. SQL 실행 -> DELETE 쿼리 (모든 행 삭제)
 * 3. 결과 출력 -> 삭제된 갯수
 */
public class DeleteJdbcExample {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/test_db";
    private static final String username = "root";
    private static final String password = "1234";

    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(url, username, password);
                Statement statement = conn.createStatement()
        ) {
            // 2. SQL 실행 -> 모든 행 삭제
            String deletequery = "DELETE FROM students";

            // 3. 결과 출력
            int count = statement.executeUpdate(deletequery);
            System.out.println(count + "명 삭제");
        } catch (SQLException e) {
            System.out.println("SQL Exception : " + e.getMessage());
        }
    }
}