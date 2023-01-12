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
    private ArrayList<Integer> amounts;

    public Order(int ord_id, Client client, Barista barista, ArrayList<Dishe> dishes, ArrayList<Integer> amounts) {
        this.ord_id = ord_id;
        this.client = client;
        this.barista = barista;
        this.dishes = dishes;
        this.amounts = amounts;
    }

    public Order(int ord_id, Client client, Barista barista) {
        this(ord_id, client, barista, new ArrayList<>(), new ArrayList<Integer>());
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

    public ArrayList<Integer> getAmounts() {
        return amounts;
    }

    public String toString() {
        return String.format("Admin{%d, %s, %s, %s, %s, %s}",
                this.getOrd_id(), this.getDate(),
                this.getClient(),
                this.getCoffee_shop(),
                this.getBarista(),
                this.getDishes());
    }

    public void addDish(Dishe dish, int amount) {
        for (int i = 0; i < this.getDishes().size(); i++)
            if (this.getDishes().get(i) == dish) {
                this.amounts.set(i, this.getAmounts().get(i) + amount);
                return;
            }
        this.dishes.add(dish);
        this.amounts.add(amount);
    }
}
