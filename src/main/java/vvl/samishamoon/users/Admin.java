package vvl.samishamoon.users;

public class Admin extends User {
    public Admin(int id, String login, String password) {
        super(id, login, password);
    }

    @Override
    public String toString() {
        return String.format("Admin{%d, %s}", this.getId(), this.getLogin());
    }
}
