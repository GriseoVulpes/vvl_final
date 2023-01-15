package vvl.samishamoon.users;

import vvl.samishamoon.sql.SQL_connection;

public class Admin extends User {
    private int CsId;

    private SQL_connection conn = new SQL_connection();

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


    public void print() {
        System.out.printf("""
                        Админ
                        Логин: %s
                        Кофешоп: %s
                        
                        """,
                this.getLogin(), conn.getCoffee_shop(this.getCsId()).getName());
    }

    public void printMin() {
        System.out.printf("""
                        Админ
                        Логин: %s
                        
                        """,
                this.getLogin());
    }
}
