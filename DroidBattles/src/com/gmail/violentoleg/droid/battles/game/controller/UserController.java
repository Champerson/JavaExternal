package com.gmail.violentoleg.droid.battles.game.controller;

import com.gmail.violentoleg.droid.battles.game.dao.InMemoryUserDao;
import com.gmail.violentoleg.droid.battles.game.model.user.User;
import com.gmail.violentoleg.droid.battles.game.viewer.View;

import java.util.Locale;
import java.util.ResourceBundle;

import static com.gmail.violentoleg.droid.battles.game.controller.ConsoleMenuController.Command;


public class UserController {

    private InMemoryUserDao inMemoryUserDao;
    private View view;

    public UserController(InMemoryUserDao inMemoryUserDao, View view) {
        this.inMemoryUserDao = inMemoryUserDao;
        this.view = view;
    }

    public Command changeLanguage(String newLanguage) {
        switch (newLanguage) {
            case "ru":
                view.setResourceBundle(ResourceBundle.getBundle("messages", new Locale("ru", "RU")));
                return Command.M;
            case "en":
                view.setResourceBundle(ResourceBundle.getBundle("messages", new Locale("en", "US")));
                return Command.M;
            default: {
                view.printInvalidCommand();
                return Command.L;
            }
        }
    }

    public Command registerUser(String login, String pass) {
        view.printRegistrationMenuOptions();
        if (!validate(login, pass)) {
            view.printInvalidData();
            return Command.R;
        }
        if (inMemoryUserDao.getAllUsers().containsKey(login)) {
            view.printUserAlreadyExist();
            return Command.R;
        }
        User user = new User();
        user.setLogin(login);
        user.setPass(pass);
        inMemoryUserDao.createNewUser(user);
        view.printRegistrationSuccessful();
        return Command.M;
    }

    private boolean validate(String login, String pass) {
        return login != null && !login.isEmpty() && pass != null && !pass.isEmpty();
    }
}
