package com.gmail.violentoleg.droid.battles.game.model.user;

public class User {

    private String login;
    private String pass;
    private UserRole role = UserRole.USER;

    public User() {
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
        return "User{-----}";
    }
}
