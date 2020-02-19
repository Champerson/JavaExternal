package com.gmail.violentoleg.droid.battles.game.controller;


import com.gmail.violentoleg.droid.battles.game.dao.InMemoryUserDao;
import com.gmail.violentoleg.droid.battles.game.model.user.User;
import com.gmail.violentoleg.droid.battles.game.viewer.View;

import static com.gmail.violentoleg.droid.battles.game.controller.ConsoleMenuController.Command;

public class AuthorizationController {

    private InMemoryUserDao inMemoryUserDao;
    private View view;

    public AuthorizationController(InMemoryUserDao inMemoryUserDao, View view) {
        this.inMemoryUserDao = inMemoryUserDao;
        this.view = view;
    }

    public Command logIn(String login, String pass) {
        if (!validate(login, pass)) {
            view.printLoginFailed();
            return Command.A;
        }
        User user = inMemoryUserDao.getAllUsers().get(login);
        if (user == null) {
            view.printLoginFailed();
            return Command.A;
        }
        if (!user.getPass().equals(pass)) {
            view.printLoginFailed();
            return Command.A;
        }
        inMemoryUserDao.saveCurrentUser(user);
        return Command.M;
    }

    private boolean validate(String login, String pass) {
        return login != null && !login.isEmpty() && pass != null && !pass.isEmpty();
    }

    public void logOut() {
        inMemoryUserDao.saveCurrentUser(new User());
    }
}
