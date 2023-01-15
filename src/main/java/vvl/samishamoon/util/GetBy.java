package vvl.samishamoon.util;

import java.util.ArrayList;

import vvl.samishamoon.coffe_shop.*;
import vvl.samishamoon.users.*;


public class GetBy {
    public static Admin GetBy_Admin(ArrayList<Admin> as, int id) {
        for (Admin a: as)
            if (a.getId() == id)
                return a;
        return null;
    }

    public static Order GetBy_Order(ArrayList<Order> as, int id) {
        for (Order a: as)
            if (a.getOrd_id() == id)
                return a;
        return null;
    }

    public static ArrayList<Order> GetByDish_Orders(ArrayList<Order> as, int id) {
        ArrayList<Order> ans = new ArrayList<Order>();
        for (Order a: as)
            for (Dishe d: a.getDishes())
                if (d.getDishId() == id){
                    ans.add(a);
                    break;
                }
        return ans;
    }

    public static ArrayList<Order> GetByCl_Orders(ArrayList<Order> as, int id) {
        ArrayList<Order> ans = new ArrayList<Order>();
        for (Order a: as)
            if (a.getClient().getId() == id)
                ans.add(a);
        return ans;
    }

    public static ArrayList<Order> GetByBar_Orders(ArrayList<Order> as, int id) {
        ArrayList<Order> ans = new ArrayList<Order>();
        for (Order a: as)
            if (a.getBarista().getId() == id)
                ans.add(a);
        return ans;
    }

    public static Barista GetBy_Barista(ArrayList<Barista> as, int id) {
        for (Barista a: as)
            if (a.getId() == id)
                return a;
        return null;
    }

    public static Client GetBy_Client(ArrayList<Client> as, int id) {
        for (Client a: as)
            if (a.getId() == id)
                return a;
        return null;
    }

    public static Coffee_shop GetBy_Coffee_Shop(ArrayList<Coffee_shop> as, int id) {
        for (Coffee_shop a: as)
            if (a.getCsId() == id)
                return a;
        return null;
    }

    public static Dishe GetBy_Dishe(ArrayList<Dishe> as, int id) {
        for (Dishe a: as)
            if (a.getDishId() == id)
                return a;
        return null;
    }

    public static Admin GetBy_Admin(ArrayList<Admin> as, String log) {
        for (Admin a: as)
            if (a.getLogin().compareTo(log) == 0)
                return a;
        return null;
    }

    public static Barista GetBy_Barista(ArrayList<Barista> as, String log) {
        for (Barista a: as)
            if (a.getLogin().compareTo(log) == 0)
                return a;
        return null;
    }
}
