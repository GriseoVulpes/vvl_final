package vvl.samishamoon;

import vvl.samishamoon.coffe_shop.Dishe;

import java.sql.*;
import java.util.Arrays;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Dishe d = new Dishe("s","s", 5.55, 5.543,32,2,1);
        System.out.println(d);
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
