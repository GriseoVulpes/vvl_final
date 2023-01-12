package vvl.samishamoon.coffe_shop;


import vvl.samishamoon.users.*;

import java.util.*;

public class Order {
    private int ord_id;
    private Client client;
    private Barista barista;
    private ArrayList<Dishe> dishes;

    public Order(int ord_id, Client client, Barista barista, ArrayList<Dishe> dishes) {
        this.ord_id = ord_id;
        this.client = client;
        this.barista = barista;
        this.dishes = dishes;
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
}
