package vvl.samishamoon.users;

import java.util.Date;

public class
Client extends User {
    private String name;
    private String email;
    private Date birthday;
    private boolean is_vip;
    private String phone_number;


    public Client(int id, String login, String password, String name, String email, Date birthday, boolean is_vip, String phone_number) {
        super(id, login, password);
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.is_vip = is_vip;
        this.phone_number = phone_number;
    }

    public Client(int id, String login, String password) {
        this(id, login, password, "NoName", "NoEmail", new Date(), false, "");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isIs_vip() {
        return is_vip;
    }

    public void setIs_vip(boolean is_vip) {
        this.is_vip = is_vip;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return String.format("Client{%d, %s, %s, %s, %s, %s, vip:%b}", this.getId(), this.getName(), this.getLogin(), this.getEmail(), this.getPhone_number(), this.getBirthday(), this.isIs_vip());
    }
}
