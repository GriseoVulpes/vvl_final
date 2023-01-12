package vvl.samishamoon;

import java.sql.*;
import java.util.Arrays;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String url = "jdbc:postgresql://localhost:5432/COFFEESHOP";
        Properties props = new Properties();
        props.setProperty("user", "ADMIN");
        props.setProperty("password", "123456789");


        try (Connection conn = DriverManager.getConnection(url, props)) {
            System.out.println(conn.getMetaData().getDatabaseProductVersion());
        } catch(SQLException e) {
            System.out.println("Error connecting to database " + Arrays.toString(e.getStackTrace()));
        }
    }
}
