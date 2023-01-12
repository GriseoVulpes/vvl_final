package vvl.samishamoon.users;


public abstract class User {
    private int id;
    private String login;
    private int password;


    public User(int id, String login, String password) {
        this(id, login, password.hashCode());
    }

    public User(int id, String login, int password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.hashCode();
    }

    public boolean checkPassword(String password) {
        return (this.password == password.hashCode());
    }

    @Override
    abstract public String toString();
}
