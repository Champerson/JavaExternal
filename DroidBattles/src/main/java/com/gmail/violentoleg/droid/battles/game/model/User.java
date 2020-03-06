package main.java.com.gmail.violentoleg.droid.battles.game.model;


import static main.java.com.gmail.violentoleg.droid.battles.game.model.UserRole.GUEST;

public class User {

    private String login;
    private String pass;
    private UserRole role;

    public User() {
        role = GUEST;
    }

    public User(String login, String pass, UserRole userRole) {
        this.login = login;
        this.pass = pass;
        this.role = userRole;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User: " + login;
    }
}
