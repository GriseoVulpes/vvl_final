package vvl.samishamoon.sql;

import vvl.samishamoon.users.*;
import vvl.samishamoon.coffe_shop.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class SQL_functions {
    private String url;
    private Properties props;

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

//    public void updateAdmin(Admin a) {
//        try (Connection conn = DriverManager.getConnection(url, props);
//             Statement st = conn.createStatement();
//             st.executeUpdate(String.format("UPDATE \"Admin\"\nSET \"AdminId\" = %d, \"Login\" = %s, \"Password\" = %s, \"CSID\" = %d\nWHERE \"AdminId\" = %d;",
//                     a.getId(), a.getLogin(), a.getPassword(), a.getCsId(), a.getId()
//                     )
//             );
//             ) {
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
