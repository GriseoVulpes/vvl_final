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

    public static Order GetById_Order(ArrayList<Order> as, int id) {
        for (Order a: as)
            if (a.getOrd_id() == id)
                return a;
        return null;
    }

    public static Barista GetById_Barista(ArrayList<Barista> as, int id) {
        for (Barista a: as)
            if (a.getId() == id)
                return a;
        return null;
    }

    public static Client GetById_Client(ArrayList<Client> as, int id) {
        for (Client a: as)
            if (a.getId() == id)
                return a;
        return null;
    }

    public static Coffee_shop GetById_Coffee_Shop(ArrayList<Coffee_shop> as, int id) {
        for (Coffee_shop a: as)
            if (a.getCsId() == id)
                return a;
        return null;
    }

    public static Dishe GetById_Dishe(ArrayList<Dishe> as, int id) {
        for (Dishe a: as)
            if (a.getDishId() == id)
                return a;
        return null;
    }
}
