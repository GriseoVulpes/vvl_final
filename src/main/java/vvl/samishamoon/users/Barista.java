package vvl.samishamoon.users;

public class Barista extends User {
    private String name;
    private int time_shift;
    private int phone_number;
    private String email;


    public Barista(int id, String login, String password, String name, int time_shift, int phone_number, String email) {
        super(id, login, password);
        this.name = name;
        this.time_shift = time_shift;
        this.phone_number = phone_number;
        this.email = email;
    }

    public Barista(int id, String login, String password) {
        this(id, login, password, "NoName", 0, 0, "NoEmail");
    }

    public int getTime_shift() {
        return time_shift;
    }

    public void setTime_shift(int time_shift) {
        this.time_shift = time_shift;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
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

    @Override
    public String toString() {
        return String.format("Barista{%d, %s, %s, %s, %d, %s}", this.getId(), this.getName(), this.getLogin(), this.getEmail(), this.getPhone_number(), this.getTime_shift());
    }
}
