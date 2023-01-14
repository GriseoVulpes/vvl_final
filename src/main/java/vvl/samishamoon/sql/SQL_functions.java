package vvl.samishamoon.sql;

import vvl.samishamoon.users.*;
import vvl.samishamoon.coffe_shop.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class SQL_functions {
    public String url;
    public Properties props;

    public SQL_functions() {
        this.url = "jdbc:postgresql://localhost:5432/COFFEESHOP";
        this.props = new Properties();
        this.props.setProperty("user", "ADMIN");
        this.props.setProperty("password", "123456789");
    }

    public void testDB() {
        try (Connection conn = DriverManager.getConnection(url, props)) {
            System.out.println(conn.getMetaData().getDatabaseProductVersion());
        } catch(SQLException e) {
            System.out.println("Error connecting to database " + Arrays.toString(e.getStackTrace()));
        }
    }
    //                      -------
    // ---------------------------------------------------ADMIN
    //                      -------
    public ArrayList<Admin> getAdmins() {
        ArrayList<Admin> ans = new ArrayList<Admin>();
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM \"Admin\";");) {
            while (rs.next()) {
                ans.add(new Admin(
                        rs.getInt("AdminId"),
                        rs.getString("Login"),
                        rs.getString("Password"),
                        rs.getInt("CsId")
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }

    public Admin getAdmin(int ind) {
        Admin ans = null;
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(String.format("SELECT * FROM \"Admin\" x WHERE x.\"AdminId\" = %d;", ind));) {
            rs.next();
            ans = new Admin(
                    rs.getInt("AdminId"),
                    rs.getString("Login"),
                    rs.getString("Password"),
                    rs.getInt("CsId")
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }
    //                      -------
    // --------------------------------------------------- COFFEE_SHOP
    //                      -------
    public ArrayList<Coffee_shop> getCoffee_shops() {
        ArrayList<Coffee_shop> ans = new ArrayList<Coffee_shop>();
        try (Connection conn = DriverManager.getConnection(url,props);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM \"CoffeeShop\";");) {
            while (rs.next()) {
                ans.add(new Coffee_shop(
                        rs.getInt("CSID"),
                        rs.getString("Name"),
                        rs.getString("Adress"),
                        rs.getString("PhoneNumber")
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }

    public Coffee_shop getCoffee_shop (int ind) {
        Coffee_shop ans = null;
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(String.format("SELECT * FROM \"CoffeeShop\" x WHERE x.\"CSID\" = %d;", ind));) {
            rs.next();
            ans = new Coffee_shop(
                    rs.getInt("CSID"),
                    rs.getString("Name"),
                    rs.getString("Adress"),
                    rs.getString("PhoneNumber")
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }
    //                      -------
    // --------------------------------------------------- DISHES
    //                      -------
    public ArrayList<Dishe> getDishes() {
        ArrayList<Dishe> ans = new ArrayList<Dishe>();
        try (Connection conn = DriverManager.getConnection(url,props);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM \"Dishes\";");) {
            while (rs.next()) {
                ans.add(new Dishe(
                                rs.getString("Name"),
                                rs.getString("Type"),
                                rs.getDouble("PriceIn"),
                                rs.getDouble("PriceOut"),
                                rs.getInt("DishId"),
                                rs.getString("Adds"),
                                rs.getInt("Season"),
                                rs.getInt("TimeShift")
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }

    public Dishe getDishe(int ind) {
        Dishe ans = null;
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(String.format("SELECT * FROM \"Dishes\" x WHERE x.\"DishId\" = %d;", ind));) {
            rs.next();
            ans = new Dishe(
                    rs.getString("Name"),
                    rs.getString("Type"),
                    rs.getDouble("PriceIn"),
                    rs.getDouble("PriceOut"),
                    rs.getInt("DishId"),
                    rs.getString("Adds"),
                    rs.getInt("Season"),
                    rs.getInt("TimeShift")
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }
    //                      -------
    // --------------------------------------------------- BARISTA
    //                      -------
    public ArrayList<Barista> getBaristas() {
        ArrayList<Barista> ans = new ArrayList<Barista>();
        try (Connection conn = DriverManager.getConnection(url,props);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM \"Barista\";");) {
            while (rs.next()) {
                ans.add(new Barista(
                                rs.getInt("Barid"),
                                rs.getString("Login"),
                                rs.getString("Password"),
                                rs.getString("Name"),
                                rs.getInt("TimeShift"),
                                rs.getInt("Phone number"),
                                rs.getString("Mail")
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }

    public Barista getBarista (int ind) {
        Barista ans = null;
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(String.format("SELECT * FROM \"Barista\" x WHERE x.\"BarId\" = %d;", ind));) {
            rs.next();
            ans = new Barista(
                    rs.getInt("Barid"),
                    rs.getString("Login"),
                    rs.getString("Password"),
                    rs.getString("Name"),
                    rs.getInt("TimeShift"),
                    rs.getInt("Phone number"),
                    rs.getString("Mail")
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }
    //                      -------
    // --------------------------------------------------- CLIENT
    //                      -------
    public ArrayList<Client> getClients() {
        ArrayList<Client> ans = new ArrayList<Client>();
        try (Connection conn = DriverManager.getConnection(url,props);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM \"Client\";");) {
            while (rs.next()) {
                ans.add(new Client(
                                rs.getInt("Clid"),
                                null,
                                null,
                                rs.getString("Name"),
                                rs.getString("Adress"),
                                rs.getDate("Birthday"),
                                rs.getBoolean("VipStatus"),
                                rs.getString("PhoneNumber")
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }

    public Client getClient (int ind) {
        Client ans = null;
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(String.format("SELECT * FROM \"Client\" x WHERE x.\"ClId\" = %d;", ind));) {
            rs.next();
            ans = new Client(
                    rs.getInt("Clid"),
                    null,
                    null,
                    rs.getString("Name"),
                    rs.getString("Adress"),
                    rs.getDate("Birthday"),
                    rs.getBoolean("VipStatus"),
                    rs.getString("PhoneNumber")
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }


    public void updateAdmin(Admin a) {
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();)
        {
            st.executeUpdate(String.format("UPDATE \"Admin\"\n" +
                                    "SET \"AdminId\" = %d, \"Login\" = '%s', \"Password\" = '%s', \"CSID\" = %d\n" +
                                    "WHERE \"AdminId\" = %d;",
                    a.getId(), a.getLogin(), a.getPassword(), a.getCsId(), a.getId()
            )
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertAdmin(Admin a) {
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();)
        {
            st.executeUpdate(String.format("INSERT INTO \"Admin\" " +
                            "(\"AdminId\", \"Login\", \"Password\", \"CSID\")\n" +
                            "VALUES (%d, '%s', '%s', %d);",
                            a.getId(), a.getLogin(), a.getPassword(), a.getCsId()
                    )
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}