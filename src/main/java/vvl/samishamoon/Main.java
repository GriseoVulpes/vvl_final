package vvl.samishamoon;

import vvl.samishamoon.coffe_shop.Coffee_shop;
import vvl.samishamoon.coffe_shop.Dishe;
import vvl.samishamoon.sql.SQL_functions;
import vvl.samishamoon.users.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SQL_functions g = new SQL_functions();

        g.testDB();

        Admin a = g.getAdmin(1);
        System.out.println(a);
        ArrayList<Admin> as = g.getAdmins();
        System.out.println(as);

        Barista b = g.getBarista(1);
        System.out.println(b);
        ArrayList<Barista> bs = g.getBaristas();
        System.out.println(bs);

        Client c = g.getClient(1);
        System.out.println(c);
        ArrayList<Client> cs = g.getClients();
        System.out.println(cs);

        Coffee_shop c_s = g.getCoffee_shop(1);
        System.out.println(c_s);
        ArrayList<Coffee_shop> css = g.getCoffee_shops();
        System.out.println(css);

        Dishe d = g.getDishe(1);
        System.out.println(d);
        ArrayList<Dishe> ds = g.getDishes();
        System.out.println(ds);
    }
}
