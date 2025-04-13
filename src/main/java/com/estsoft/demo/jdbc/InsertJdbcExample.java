package com.estsoft.demo.jdbc;

import java.sql.*;

/**
 * 1. DB연결
 * 2. SQL 실행 -> INSERT INTO 쿼리
 * 3. 결과 출력 -> insert 갯수
 */
public class InsertJdbcExample {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/test_db";
    private static final String username = "root";
    private static final String password = "1234";

    public static void main(String[] args) {
        try (
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement()
        ) {
            // 2. sql 실행 -> insert로 변경
            String addquery = "INSERT INTO students (name, age, address) VALUES " +
                    "('바보', 444, '서울'), " +
                    "('최고', 1557, '부산'), " +
                    "('최악', 888484, '충주')";


            // 3. 결과 출력
            int count = statement.executeUpdate(addquery);
            System.out.println(count + " 추가.");
        } catch (SQLException e) {
            System.out.println("SQL Exception : " + e.getMessage());
        }
    }
}
