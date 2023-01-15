package vvl.samishamoon.users;


public abstract class User {
    private int id;
    private String login;
    private String password;


    public User(int id, String login, String password) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Integer.toString(password.hashCode());
    }

    public boolean checkPassword(String password) {
        return (this.password.compareTo(Integer.toString(password.hashCode())) == 0);
    }

    @Override
    abstract public String toString();
}
