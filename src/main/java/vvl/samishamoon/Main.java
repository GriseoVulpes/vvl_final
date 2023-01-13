package vvl.samishamoon;

import vvl.samishamoon.sql.SQL_functions;
import vvl.samishamoon.users.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SQL_functions g = new SQL_functions();

        g.testDB();
        ArrayList<Admin> as = g.getAdmins();
        System.out.println(as);

        Admin a1 = g.getAdmin(2);
        System.out.println(a1);
    }
}
