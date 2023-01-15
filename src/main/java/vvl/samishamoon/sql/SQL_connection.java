package vvl.samishamoon.sql;

import vvl.samishamoon.users.*;
import vvl.samishamoon.coffe_shop.*;

import java.sql.*;
import java.util.*;
import java.util.Date;

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
                        rs.getInt("CsId"),
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
                    rs.getInt("CsId"),
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

    public ArrayList<Order> getOrders() {
        ArrayList<Order> ans = new ArrayList<Order>();

        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT \"Order\".\"OrdId\", \"Order\".\"CSId\", \"Order\".\"ClId\", \"Order\".\"BarId\", \"Order\".\"InOut\", \"DishOrd\".\"TimeStamp\", \"DishOrd\".\"DishId\"\n" +
                     "FROM \"Order\", \"DishOrd\"\n" +
                     "WHERE \"Order\".\"OrdId\" = \"DishOrd\".\"OrdId\"\n" +
                     "ORDER BY \"Order\".\"OrdId\";");) {
            ArrayList<Dishe> ds = new ArrayList<>();
            int ordid = -1;
            Coffee_shop cs = null;
            Client cl = null;
            Barista b = null;
            boolean is_inside = true;
            Date d = null;
            while (rs.next()) {
                int old_ordid = ordid;
                ordid = rs.getInt("OrdId");

                if (ordid != old_ordid && old_ordid != -1) {
                    ans.add(new Order(old_ordid, cl, cs, b, ds, d, is_inside));
                    ds = new ArrayList<Dishe>();
                }

                cs = this.getCoffee_shop(rs.getInt("CSId"));
                cl = this.getClient(rs.getInt("ClId"));
                b = this.getBarista(rs.getInt("BarId"));
                is_inside = rs.getBoolean("InOut");
                d = rs.getDate("TimeStamp");
                ds.add(this.getDishe(rs.getInt("DishId")));
            }

            if (ordid != -1 && ds.size() != 0) {
                ans.add(new Order(ordid, cl, cs, b, ds, d, is_inside));
                ds = new ArrayList<Dishe>();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }

    public Order getOrder(int ind) {
        Order ans = null;
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(String.format("SELECT \"Order\".\"OrdId\", \"Order\".\"CSId\", \"Order\".\"ClId\", \"Order\".\"BarId\", \"Order\".\"InOut\", \"DishOrd\".\"TimeStamp\", \"DishOrd\".\"DishId\"\n" +
                     "FROM \"Order\", \"DishOrd\"\n" +
                     "WHERE \"Order\".\"OrdId\" = \"DishOrd\".\"OrdId\" AND \"Order\".\"OrdId\" = %d;",
                     ind));) {
            int ordid = -1;
            Coffee_shop cs = null;
            Client cl = null;
            Barista b = null;
            boolean is_inside = false;
            Date d = null;
            ArrayList<Dishe> ds = new ArrayList<Dishe>();
            while (rs.next()) {
                ordid = rs.getInt("OrdId");
                cs = this.getCoffee_shop(rs.getInt("CSId"));
                cl = this.getClient(rs.getInt("ClId"));
                b = this.getBarista(rs.getInt("BarId"));
                is_inside = rs.getBoolean("InOut");
                d = rs.getDate("TimeStamp");
                ds.add(this.getDishe(rs.getInt("DishId")));
            }
            if (ordid == -1)
                return null;
            return new Order(ordid, cl, cs, b, ds, d, is_inside);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    //                      -------
    // --------------------------------------------------- UPDATE/INSERT Admin
    //                      -------
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

    //                      -------
    // --------------------------------------------------- UPDATE/INSERT COFFEE_SHOP
    //                      -------
    public void updateCoffee_shop (Coffee_shop cs) {
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();)
        {
            st.executeUpdate(String.format("UPDATE \"CoffeeShop\"\n" +
                                    "SET \"CSID\" = %d, \"Name\" = '%s', \"Adress\" = '%s', \"PhoneNumber\" = '%s'\n" +
                                    "WHERE \"CSID\" = %d;",
                            cs.getCsId(), cs.getName(), cs.getAddress(), cs.getPhoneNumber(),
                            cs.getCsId()
                    )
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertCoffee_shop(Coffee_shop cs) {
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();)
        {
            st.executeUpdate(String.format("INSERT INTO \"CoffeeShop\" " +
                                    "(\"CSID\", \"Name\", \"Adress\", \"PhoneNumber\")\n" +
                                    "VALUES (%d, '%s', '%s', '%s');",
                            cs.getCsId(), cs.getName(), cs.getAddress(), cs.getPhoneNumber()
                    )
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //                      -------
    // --------------------------------------------------- UPDATE/INSERT DISHES
    //                      -------
    public void updateDishe (Dishe d) {
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();)
        {
            st.executeUpdate(String.format(Locale.US, "UPDATE \"Dishes\"\n" +
                                    "SET \"DishId\" = %d, \"Name\" = '%s', \"Type\" = '%s', \"Adds\" = NULL, \"PriceIn\" = %f, \"PriceOut\" = %f, \"Season\" = %d, \"TimeShift\" = %d\n" +
                                    "WHERE \"DishId\" = %d;",
                            d.getDishId(), d.getName(), d.getType(), d.getPriceIn(), d.getPriceOut(), d.getSeason(),d.getTimeShift(),
                            d.getDishId()
                    )
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertDishe(Dishe d) {
        String exp;
        if (d.getAdds() != null)
            exp =  String.format(Locale.US, "INSERT INTO \"Dishes\" " +
                            "(\"DishId\", \"Name\", \"Type\", \"Adds\", \"PriceIn\", \"PriceOut\", \"Season\", \"TimeShift\")\n" +
                            "VALUES (%d, '%s', '%s', '%s', %f, %f, %d, %d);",
                    d.getDishId(), d.getName(), d.getType(), d.getAdds(), d.getPriceIn(), d.getPriceOut(), d.getSeason(),d.getTimeShift());
        else
            exp =  String.format(Locale.US, "INSERT INTO \"Dishes\" " +
                            "(\"DishId\", \"Name\", \"Type\", \"Adds\", \"PriceIn\", \"PriceOut\", \"Season\", \"TimeShift\")\n" +
                            "VALUES (%d, '%s', '%s', NULL, %f, %f, %d, %d);",
                    d.getDishId(), d.getName(), d.getType(), d.getPriceIn(), d.getPriceOut(), d.getSeason(),d.getTimeShift());

        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();
             )
        {
            st.executeUpdate(exp);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //                      -------
    // --------------------------------------------------- UPDATE/INSERT BARISTA
    //                      -------
    public void updateBarista (Barista b) {
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();)
        {
            st.executeUpdate(String.format("UPDATE \"Barista\"\n" +
                                    "SET \"BarId\" = %d, \"Login\" = '%s', \"Password\" = '%s', \"Mail\" = '%s', \"Phone number\" = '%s', \"Name\" = '%s', \"TimeShift\" = %d, \"CSID\" = %d\n" +
                                    "WHERE \"BarId\" = %d;",
                            b.getId(), b.getLogin(), b.getPassword(), b.getEmail(), b.getPhone_number(), b.getName(), b.getTime_shift(), b.getCsId(),
                            b.getId()
                    )
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertBarista (Barista b) {
        System.out.println(String.format("INSERT INTO \"Barista\" " +
                        "(\"BarId\", \"Login\", \"Password\", \"Mail\", \"Phone number\", \"Name\", \"TimeShift\", \"CSID\")\n" +
                        "VALUES (%d, '%s', '%s', '%s', '%s', '%s', %d, %d);",
                b.getId(), b.getLogin(), b.getPassword(), b.getEmail(), b.getPhone_number(), b.getName(), b.getTime_shift(), b.getCsId()
        ));
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();)
        {
            st.executeUpdate(String.format("INSERT INTO \"Barista\" " +
                                    "(\"BarId\", \"Login\", \"Password\", \"Mail\", \"Phone number\", \"Name\", \"TimeShift\", \"CSID\")\n" +
                                    "VALUES (%d, '%s', '%s', '%s', '%s', '%s', %d, %d);",
                            b.getId(), b.getLogin(), b.getPassword(), b.getEmail(), b.getPhone_number(), b.getName(), b.getTime_shift(), b.getCsId()
                    )
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //                      -------
    // --------------------------------------------------- UPDATE/INSERT CLIENT
    //                      -------
    public void updateClient (Client c) {
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();)
        {
            st.executeUpdate(String.format("UPDATE \"Client\"\n" +
                                    "SET \"ClId\" = %d, \"Name\" = '%s', \"Adress\" = '%s', \"Birthday\" = Date '%s', \"VipStatus\" = %b, \"PhoneNumber\" = '%s'\n" +
                                    "WHERE \"ClId\" = %d;",
                            c.getId(), c.getName(), c.getAddress(), c.getBirthday(), c.isIs_vip(), c.getPhone_number(),
                            c.getId()
                    )
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertClient (Client c) {
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();)
        {
            st.executeUpdate(String.format("INSERT INTO \"Client\" " +
                                    "(\"ClId\", \"Name\", \"Adress\", \"Birthday\", \"VipStatus\", \"PhoneNumber\")\n" +
                                    "VALUES (%d, '%s', '%s', DATE '%s', %b, '%s');",
                            c.getId(), c.getName(), c.getAddress(), c.getBirthday(), c.isIs_vip(), c.getPhone_number()
                    )
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //                      -------
    // --------------------------------------------------- INSERT ORDER
    //                      -------
    public void insertOrder (Order o) {
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();)
        {
            st.executeUpdate(String.format("INSERT INTO \"Order\" " +
                                    "(\"OrdId\", \"CSId\", \"BarId\", \"ClId\", \"InOut\")\n" +
                                    "VALUES (%d, %d, %d, %d, %b);",
                            o.getOrd_id(), o.getCoffee_shop().getCsId(), o.getBarista().getId(), o.getClient().getId(), o.getIs_inside()
                    )
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();)
        {
            for (Dishe d: o.getDishes()) {
                System.out.println(String.format("INSERT INTO \"DishOrd\" " +
                                "(\"DishOrdId\", \"TimeStamp\",\"DishId\", \"CSId\", \"OrdId\")\n" +
                                "VALUES (%d, Date '%s', %d, %d, %d);",
                        0, o.getDate(), d.getDishId(), o.getCoffee_shop().getCsId(), o.getOrd_id()
                ));
                st.executeUpdate(String.format("INSERT INTO \"DishOrd\" " +
                                        "(\"DishOrdId\", \"TimeStamp\", \"DishId\", \"CSId\", \"OrdId\")\n" +
                                        "VALUES (%d, Date '%s', %d, %d, %d);",
                                0, o.getDate(), d.getDishId(), o.getCoffee_shop().getCsId(), o.getOrd_id()
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //                      -------
    // --------------------------------------------------- DELETE ADMIN
    //                      -------
    public void deleteAdmin(int a) {
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();
             ) {
            st.executeUpdate(String.format("DELETE FROM \"Admin\"\nWHERE \"AdminId\" = %d;", a));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteBarista(int a) {
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();) {
            st.executeUpdate(String.format("DELETE FROM \"Barista\"\nWHERE \"BarId\" = %d;", a));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteClient(int a) {
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();) {
            st.executeUpdate(String.format("DELETE FROM \"Client\"\nWHERE \"ClId\" = %d;", a));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteCoffeeShop(int a) {
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();) {
            st.executeUpdate(String.format("DELETE FROM \"CoffeeShop\"\nWHERE \"CSID\" = %d;", a));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteDish(int a) {
        try (Connection conn = DriverManager.getConnection(url, props);
             Statement st = conn.createStatement();) {
            st.executeUpdate(String.format("DELETE FROM \"Dishes\"\nWHERE \"DishId\" = %d;", a));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}