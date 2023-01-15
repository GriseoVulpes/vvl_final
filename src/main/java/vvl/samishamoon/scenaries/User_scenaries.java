package vvl.samishamoon.scenaries;

import java.util.Date;
import java.util.Scanner;

import vvl.samishamoon.coffe_shop.Dishe;
import vvl.samishamoon.coffe_shop.Order;
import vvl.samishamoon.users.*;
import vvl.samishamoon.util.*;
import vvl.samishamoon.sql.SQL_connection;


public class User_scenaries {

    public static void chooseUser(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите пользователя");
            System.out.println("1. Администрация");
            System.out.println("2. Бариста");
            System.out.println("3. Клиент");
            int user = sc.nextInt();
            switch (user) {
                case 1 -> adminCabinet(sc);
                case 2 -> baristaCabinet(sc);
                case 3 -> clientCabinet(sc);
                default -> System.out.println("Неверно выбран пользователь, попробуйте снова");
            }
        }
    }

    private static void adminCabinet(Scanner sc){
        SQL_connection conn = new SQL_connection();
        System.out.println("Введите логин");
        String log = sc.next();
        Admin a = GetBy.GetBy_Admin(conn.getAdmins(), log);
        System.out.println("Введите пароль");
        String pass = sc.next();

        if (a == null || !a.checkPassword(pass)) {
            System.out.println("Логин или пароль неверны");
            return;
        }
        adminActions(sc);
    }

    private static void baristaCabinet(Scanner sc){
        SQL_connection conn = new SQL_connection();
        System.out.println("Введите логин");
        String log = sc.next();
        Barista a = GetBy.GetBy_Barista(conn.getBaristas(), log);
        System.out.println("Введите пароль");
        String pass = sc.next();

        if (a == null || !a.checkPassword(pass)) {
            System.out.println("Логин или пароль неверны");
            return;
        }
        baristaActions(sc);
    }

    private static void clientCabinet(Scanner sc){
        System.out.println("Введите id");
        String id = sc.next();
        orderEdit(sc);
    }

    private static void adminActions(Scanner sc){
        boolean stay = true;
        while (stay) {
            System.out.println("Выберите действие:");
            System.out.println("1. Редактировать барист");
            System.out.println("2. Редактировать клиентов");
            System.out.println("3. Редактировать меню");
            System.out.println("4. Вернуться к авторизации");
            int sw = sc.nextInt();
            switch (sw) {
                case 1 -> baristaEdit(sc);
                case 2 -> clientEdit(sc);
                case 3 -> dishesEdit(sc);
                case 4 -> stay = false;
                default -> System.out.println("Неверно выбрано действие, попробуйте снова");
            }
        }
    }

    private static void baristaActions(Scanner sc){
        boolean stay = true;
        while (stay) {
            System.out.println("Выберите действие:");
            System.out.println("1. Редактировать клиентов");
            System.out.println("2. Редактировать меню");
            System.out.println("3. Редактировать заказ");
            System.out.println("4. Вернуться к авторизации");
            int sw = sc.nextInt();
            switch (sw) {
                case 1 -> clientEdit(sc);
                case 2 -> dishesEdit(sc);
                case 3 -> orderEdit(sc);
                case 4 -> stay = false;
                default -> System.out.println("Неверно выбрано действие, попробуйте снова");
            }
        }
    }

    private static void baristaEdit(Scanner sc){
        SQL_connection conn = new SQL_connection();
        boolean stay = true;
        while (stay) {
            PrintArray.printBaristas(conn.getBaristas());
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить баристу");
            System.out.println("2. Редактировать баристу");
            System.out.println("3. Удалить баристу");
            System.out.println("4. Вернуться к авторизации");
            int sw = sc.nextInt();
            switch (sw) {
                case 1 -> baristaInsert(sc);
                case 2 -> baristaUpdate(sc);
                case 3 -> baristaDelete(sc);
                case 4 -> stay = false;
                default -> System.out.println("Неверно выбрано действие, попробуйте снова");
            }
        }
    }

    private static void clientEdit(Scanner sc){
        SQL_connection conn = new SQL_connection();
        boolean stay = true;
        while (stay) {
            PrintArray.printClients(conn.getClients());
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить клиента");
            System.out.println("2. Редактировать клиента");
            System.out.println("3. Удалить клиента");
            System.out.println("4. Вернуться к авторизации");
            int sw = sc.nextInt();
            switch (sw) {
                case 1 -> clientInsert(sc);
                case 2 -> clientUpdate(sc);
                case 3 -> clientDelete(sc);
                case 4 -> stay = false;
                default -> System.out.println("Неверно выбрано действие, попробуйте снова");
            }
        }
    }


    private static void dishesEdit(Scanner sc){
        SQL_connection conn = new SQL_connection();
        boolean stay = true;
        while (stay) {
            PrintArray.printBaristas(conn.getBaristas());
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить блюдо");
            System.out.println("2. Редактировать блюдо");
            System.out.println("3. Удалить блюдо");
            System.out.println("4. Вернуться к авторизации");
            int sw = sc.nextInt();
            switch (sw) {
                case 1 -> dishInsert(sc);
                case 2 -> dishUpdate(sc);
                case 3 -> dishDelete(sc);
                case 4 -> stay = false;
                default -> System.out.println("Неверно выбрано действие, попробуйте снова");
            }
        }
    }

    private static void orderEdit(Scanner sc){
        SQL_connection conn = new SQL_connection();
        boolean stay = true;
        while (stay) {
            System.out.println("Меню");
            PrintArray.printDishes(conn.getDishes());
            System.out.println("Выберите действие:");
            System.out.println("1. Новый заказ");
            System.out.println("2. Удалить заказ");
            System.out.println("3. Вернуться к авторизации");
            int sw = sc.nextInt();
            switch (sw) {
                case 1 -> orderInsert(sc);
                case 2 -> orderDelete(sc);
                case 3 -> stay = false;
                default -> System.out.println("Неверно выбрано действие, попробуйте снова");
            }
        }
    }

    public static void baristaInsert(Scanner sc) {
        SQL_connection conn = new SQL_connection();
        System.out.println("Введите имя");
        String name = sc.next();
        System.out.println("Введите логин");
        String log = sc.next();
        System.out.println("Введите пароль");
        String pass = sc.next();
        System.out.println("Введите телефон");
        String phone = sc.next();
        System.out.println("Email");
        String email = sc.next();
        System.out.println("Введите id кафе");
        int csid = sc.nextInt();
        System.out.println("Введите смену: 1(00:00 - 8:00) 2(08:00 - 16:00)  3(16:00 - 00:00)");
        int ts = sc.nextInt();
        Barista b = new Barista(MaxId.maxID_Barista(conn.getBaristas()) + 1, csid, log,  pass, name, ts, phone, email);
        b.setPassword(pass);
        conn.insertBarista(b);
    }

    public static void baristaUpdate(Scanner sc) {
        SQL_connection conn = new SQL_connection();
        System.out.println("Введите id");
        int id = sc.nextInt();

        System.out.println("Введите имя");
        String name = sc.next();
        System.out.println("Введите логин");
        String log = sc.next();
        System.out.println("Введите пароль");
        String pass = sc.next();
        System.out.println("Введите телефон");
        String phone = sc.next();
        System.out.println("Email");
        String email = sc.next();
        System.out.println("Введите id кафе");
        int csid = sc.nextInt();
        System.out.println("Введите смену: 1(00:00 - 8:00) 2(08:00 - 16:00)  3(16:00 - 00:00)");
        int ts = sc.nextInt();
        Barista b = new Barista(id, csid, log,  pass, name, ts, phone, email);
        b.setPassword(pass);
        conn.updateBarista(b);
    }

    public static void baristaDelete(Scanner sc) {
        SQL_connection conn = new SQL_connection();
        System.out.println("Введите id");
        int id = sc.nextInt();

        conn.deleteBarista(id);
    }

    public static void clientInsert(Scanner sc) {
        SQL_connection conn = new SQL_connection();
        System.out.println("Введите имя");
        String name = sc.next();
        System.out.println("Введите адрес");
        String address = sc.next();
        System.out.println("Введите дату рождения");
        Date birthday = new Date();
        System.out.println("Введите телефон");
        String phoneNumber = sc.next();
        System.out.println("Вип-статус:");
        System.out.println("1. Вип");
        System.out.println("2. Обычный");
        boolean vip = false;
        int vipId = sc.nextInt();
        if (vipId == 1) {vip =true;}
        Client c = new Client(MaxId.maxID_Client(conn.getClients()) + 1, "", "", name, address, birthday, vip, phoneNumber);
        conn.insertClient(c);
    }

    public static void clientUpdate(Scanner sc) {
        SQL_connection conn = new SQL_connection();
        System.out.println("Введите id");
        int id = sc.nextInt();

        System.out.println("Введите имя");
        String name = sc.next();
        System.out.println("Введите адрес");
        String address = sc.next();
        System.out.println("Введите дату рождения");
        Date birthday = new Date();
        System.out.println("Введите телефон");
        String phoneNumber = sc.next();
        System.out.println("Вип-статус:");
        System.out.println("1. Вип");
        System.out.println("2. Обычный");
        boolean vip = false;
        int vipId = sc.nextInt();
        if (vipId == 1) {vip =true;}
        Client c = new Client(id, "", "", name, address, birthday, vip, phoneNumber);
        conn.updateClient(c);
    }

    public static void clientDelete(Scanner sc) {
        SQL_connection conn = new SQL_connection();
        System.out.println("Введите id");
        int id = sc.nextInt();

        conn.deleteClient(id);
    }

    public static void dishInsert(Scanner sc) {
        SQL_connection conn = new SQL_connection();
        System.out.println("Введите название:");
        String name = sc.next();
        System.out.println("Введите тип:");
        String type = sc.next();
        System.out.println("Введите добавки:");
        String adds = sc.next();
        System.out.println("Введите цену:");
        Double priceIn = sc.nextDouble();
        System.out.println("Введите цену на вынос:");
        Double priceOut = sc.nextDouble();
        System.out.println("Введите сезон:");
        System.out.println("1. Зима");
        System.out.println("2. Весна");
        System.out.println("3. Лето");
        System.out.println("4. Осень");
        int season = sc.nextInt();
        System.out.println("Введите смену:");
        System.out.println("1. (00:00 - 8:00)");
        System.out.println("2. (08:00 - 16:00)");
        System.out.println("3. (16:00 - 00:00)");
        int ts = sc.nextInt();
        Dishe d = new Dishe(name, type, priceIn, priceOut,MaxId.maxID_Dishe(conn.getDishes()) + 1, season, ts);
        conn.insertDishe(d);
    }

    public static void dishUpdate(Scanner sc) {
        SQL_connection conn = new SQL_connection();
        System.out.println("Введите id:");
        int id = sc.nextInt();

        System.out.println("Введите название:");
        String name = sc.next();
        System.out.println("Введите тип:");
        String type = sc.next();
        System.out.println("Введите добавки:");
        String adds = sc.next();
        System.out.println("Введите цену:");
        Double priceIn = sc.nextDouble();
        System.out.println("Введите цену на вынос:");
        Double priceOut = sc.nextDouble();
        System.out.println("Введите сезон:");
        System.out.println("1. Зима");
        System.out.println("2. Весна");
        System.out.println("3. Лето");
        System.out.println("4. Осень");
        int season = sc.nextInt();
        System.out.println("Введите смену:");
        System.out.println("1. (00:00 - 8:00)");
        System.out.println("2. (08:00 - 16:00)");
        System.out.println("3. (16:00 - 00:00)");
        int ts = sc.nextInt();
        Dishe d = new Dishe(name, type, priceIn, priceOut, id, season, ts);
        conn.updateDishe(d);
    }

    public static void dishDelete(Scanner sc) {
        SQL_connection conn = new SQL_connection();
        System.out.println("Введите id");
        int id = sc.nextInt();
        conn.deleteDish(id);
    }

    public static void orderInsert(Scanner sc) {
        SQL_connection conn = new SQL_connection();

        System.out.println("Введите id баристы");
        int BarId = sc.nextInt();

        System.out.println("Введите id клиента");
        int ClId = sc.nextInt();

        Order o = new Order(MaxId.maxID_Order(conn.getOrders()) + 1, conn.getClient(ClId), GetBy.GetBy_Coffee_Shop(conn.getCoffee_shops(), conn.getBarista(BarId).getCsId()), conn.getBarista(BarId), new Date());
        o.setIs_inside(true);
        boolean stay = true;
        while (stay) {
            System.out.println("Текущий заказ");
            o.print();
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить блюдо");
            System.out.println("2. Удалить блюдо");
            System.out.println("3. Сделать заказ");
            int c = sc.nextInt();
            if (c == 1) {
                System.out.println("Введите id блюда");
                int DishId = sc.nextInt();
                o.addDish(conn.getDishe(DishId));
            } else if (c == 2) {
                System.out.println("Введите id блюда");
                int DishId = sc.nextInt();
                o.deleteDish(conn.getDishe(DishId));
            } else if (c == 3) {
                stay = false;
            }
        }
        conn.insertOrder(o);
    }

    public static void orderDelete(Scanner sc) {
        SQL_connection conn = new SQL_connection();

        System.out.println("Введите id заказа");
        int OrdId = sc.nextInt();
        conn.deleteOrder(OrdId);
    }
}
