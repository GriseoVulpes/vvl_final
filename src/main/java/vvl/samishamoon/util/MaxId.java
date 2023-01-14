package vvl.samishamoon.util;

import java.util.ArrayList;
import java.util.Arrays;

import vvl.samishamoon.coffe_shop.*;
import vvl.samishamoon.users.*;

public class Utility {
    // get_max_ids
    public static int maxID_Admin(ArrayList<Admin> as) {
        int ans = 0;
        for (Admin a: as)
            if (a.getId() > ans)
                ans = a.getId();
        return ans;
    }
    public static int maxID_Barista(ArrayList<Barista> as) {
        int ans = 0;
        for (Barista a: as)
            if (a.getId() > ans)
                ans = a.getId();
        return ans;
    }
    public static int maxID_Client(ArrayList<Client> as) {
        int ans = 0;
        for (Client a : as)
            if (a.getId() > ans)
                ans = a.getId();
        return ans;
    }
    public static int maxID_Coffee_shop(ArrayList<Coffee_shop> as) {
        int ans = 0;
        for (Coffee_shop a : as)
            if (a.getCsId() > ans)
                ans = a.getCsId();
        return ans;
    }
    public static int maxID_Dishe(ArrayList<Dishe> as) {
        int ans = 0;
        for (Dishe a : as)
            if (a.getDishId() > ans)
                ans = a.getDishId();
        return ans;
    }
    public static int maxID_Order(ArrayList<Order> as) {
        int ans = 0;
        for (Order a : as)
            if (a.getOrd_id() > ans)
                ans = a.getOrd_id();
        return ans;
    }
}
