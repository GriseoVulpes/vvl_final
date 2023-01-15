package vvl.samishamoon.users;

import vvl.samishamoon.sql.SQL_connection;

public class Barista extends User {
    private String name;
    private int time_shift;
    private String phone_number;
    private String email;
    private int csId;
    private SQL_connection conn = new SQL_connection();

    public Barista(int id, int csId, String login, String password, String name, int time_shift, String phone_number, String email) {
        super(id, login, password);
        this.csId = csId;
        this.name = name;
        this.time_shift = time_shift;
        this.phone_number = phone_number;
        this.email = email;
    }

    public Barista(int id, int csId, String login, String password, int time_shift) {
        this(id, csId, login, password, "NoName", time_shift, "0", "NoEmail");
    }

    public int getTime_shift() {
        return time_shift;
    }

    public void setTime_shift(int time_shift) {
        this.time_shift = time_shift;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCsId() {
        return csId;
    }

    public void setCsId(int csId) {
        this.csId = csId;
    }

    @Override
    public String toString() {
        return String.format("Barista{id: %d, csId: %d name: %s, Login: %s, email: %s, Phone number: %d, Time_shift %s}", this.getId(), this.getCsId(), this.getName(), this.getLogin(), this.getEmail(), this.getPhone_number(), this.getTime_shift());
    }

    public void print() {
        System.out.printf("""
                        Бариста
                        Логин: %s
                        Имя: %s
                        Электронная почта: %s
                        Телефон: %s
                        Смена: %s
                        Кофешоп: %s
                                         
                        """,
                this.getLogin(), this.getName(), this.getEmail(), this.getPhone_number(), this.getTime_shift(), conn.getCoffee_shop(this.getCsId()).getName());
    }

    public void printMin() {
        System.out.printf("""
                        Бариста
                        Логин: %s
                                                
                        """,
                this.getLogin());
    }
}
