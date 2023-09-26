package com.baharmand;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    public static void main(String[] args) {
        try {

            //String url = System.getenv("DB_URL");
            //String user = System.getenv("DB_USER");
            //String password = System.getenv("DB_PASSWORD");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoit",  "root",  "negar");
        } catch (SQLException e) {
            System.out.println("SQL Exception: ");
            e.printStackTrace();
        }
    }
}
