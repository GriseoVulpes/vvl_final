package vvl.samishamoon.coffe_shop;


import vvl.samishamoon.users.*;

import java.util.*;

public class Order {
    private int ord_id;
    private Date date;
    private Client client;
    private Barista barista;
    private Coffee_shop coffee_shop;
    private ArrayList<Dishe> dishes;
    private boolean is_inside;

    public Order(int ord_id, Client client, Coffee_shop coffee_shop, Barista barista, ArrayList<Dishe> dishes, Date date, boolean is_inside) {
        this.ord_id = ord_id;
        this.client = client;
        this.coffee_shop = coffee_shop;
        this.barista = barista;
        this.dishes = dishes;
        this.date = date;
        this.is_inside = is_inside;
    }

    public Order(int ord_id, Client client, Coffee_shop coffee_shop, Barista barista, Date date) {
        this(ord_id, client, coffee_shop, barista, new ArrayList<Dishe>(), date, true);
    }

    public int getOrd_id() {
        return ord_id;
    }

    public void setOrd_id(int ord_id) {
        this.ord_id = ord_id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Barista getBarista() {
        return barista;
    }

    public void setBarista(Barista barista) {
        this.barista = barista;
    }

    public ArrayList<Dishe> getDishes() {
        return dishes;
    }

    public Coffee_shop getCoffee_shop() {
        return coffee_shop;
    }

    public void setCoffee_shop(Coffee_shop coffee_shop) {
        this.coffee_shop = coffee_shop;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getAmounts() {
        return is_inside;
    }

    public String toString() {
        return String.format("Order{%d, %s, %s, %s, %s, %s}",
                this.getOrd_id(), this.getDate(),
                this.getClient(),
                this.getCoffee_shop(),
                this.getBarista(),
                this.getDishes());
    }

    public void addDish(Dishe dish) {
        this.dishes.add(dish);
    }
}
