package vvl.samishamoon;

import vvl.samishamoon.coffe_shop.Coffee_shop;
import vvl.samishamoon.coffe_shop.Dishe;
import vvl.samishamoon.coffe_shop.Order;
import vvl.samishamoon.sql.SQL_functions;
import vvl.samishamoon.users.*;
import vvl.samishamoon.util.*;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SQL_functions g = new SQL_functions();
        g.testDB();

        Admin a1 =  g.getAdmin(1);
        a1.setPassword("admin1");
        g.updateAdmin(a1);

        Admin a2 =  g.getAdmin(2);
        a2.setPassword("admin2");
        g.updateAdmin(a2);



//        PrintArray.printAdmins(g.getAdmins());
//        PrintArray.printClients(g.getClients());
//        PrintArray.printDishes(g.getDishes());
//        PrintArray.printOrders(g.getOrders());
//        PrintArray.printCoffeeShops(g.getCoffee_shops());
//        PrintArray.printBaristas(g.getBaristas());

//        a.setId(3);
//        g.insertAdmin(a);
//        System.out.println(g.getAdmins());
//        g.deleteAdmin(3);
//        System.out.println(g.getAdmins());

//
//        Barista b = g.getBarista(1);
//        System.out.println(b);
//        ArrayList<Barista> bs = g.getBaristas();
//        System.out.println(bs);
//
//        Client c = g.getClient(1);
//        System.out.println(c);
//        ArrayList<Client> cs = g.getClients();
//        System.out.println(cs);
//
//        Coffee_shop c_s = g.getCoffee_shop(1);
//        System.out.println(c_s);
//        ArrayList<Coffee_shop> css = g.getCoffee_shops();
//        System.out.println(css);
//

//        Dishe d = g.getDishe(20);
//        g.deleteDish(20);
//        System.out.println(d);
//        g.insertDishe(d);

//        ArrayList<Dishe> ds = g.getDishes();
//        System.out.println(ds);
//        g.deleteClient(17);

//        Order o = new Order(11, g.getClient(2), g.getCoffee_shop(2), g.getBarista(5), new Date());
//        o.addDish(g.getDishe(11));
//        g.insertOrder(o);
//        System.out.println(g.getOrders());

    }
}
