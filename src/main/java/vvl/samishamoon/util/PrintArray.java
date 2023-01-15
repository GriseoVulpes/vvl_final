package vvl.samishamoon.util;

import vvl.samishamoon.coffe_shop.Coffee_shop;
import vvl.samishamoon.coffe_shop.Dishe;
import vvl.samishamoon.coffe_shop.Order;
import vvl.samishamoon.users.*;

import java.util.ArrayList;

public class PrintArray {

    public static void printAdmins(ArrayList<Admin> as) {
        System.out.println("Админы:");
        for (int i = 0; i < as.size(); i++){
            System.out.println(i + 1);
            as.get(i).print();
        }
    }

    public static void printBaristas(ArrayList<Barista> as) {
        System.out.println("Баристы:");
        for (int i = 0; i < as.size(); i++){
            System.out.println(i + 1);
            as.get(i).print();
        }
    }

    public static void printClients(ArrayList<Client> as) {
        System.out.println("Клиенты:");
        for (int i = 0; i < as.size(); i++){
            System.out.println(i + 1);
            as.get(i).print();
        }
    }

    public static void printOrders(ArrayList<Order> as) {
        System.out.println("Заказы:");
        for (int i = 0; i < as.size(); i++){
            System.out.println(i + 1);
            as.get(i).print();
        }
    }

    public static void printDishes(ArrayList<Dishe> as) {
        System.out.println("Блюда:");
        for (int i = 0; i < as.size(); i++){
            System.out.println(i + 1);
            as.get(i).print();
        }
    }

    public static void printCoffeeShops(ArrayList<Coffee_shop> as) {
        System.out.println("Кофейни:");
        for (int i = 0; i < as.size(); i++){
            System.out.println(i + 1);
            as.get(i).print();
        }
    }
}
