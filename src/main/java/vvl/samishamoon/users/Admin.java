package vvl.samishamoon.users;

public class Admin extends User {
    public Admin(int id, String login, String password) {
        super(id, login, password);
    }

    @Override
    public String toString() {
        return String.format("Admin{%d, %s, %d}", this.getId(), this.getLogin(), this.getCsId());
    }

    public int getCsId() {
        return CsId;
    }

    public void setCsId(int csId) {
        CsId = csId;
    }
}
