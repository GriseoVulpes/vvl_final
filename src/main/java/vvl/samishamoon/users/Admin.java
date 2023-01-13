package vvl.samishamoon.users;

public class Admin extends User {
    private int CsId;

    public Admin(int id, String login, String password, int CsId) {
        super(id, login, password);
        this.CsId = CsId;
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
