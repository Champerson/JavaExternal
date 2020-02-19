package com.gmail.violentoleg.droid.battles.game.controller;


import com.gmail.violentoleg.droid.battles.game.dao.UserDao;
import com.gmail.violentoleg.droid.battles.game.model.user.User;
import com.gmail.violentoleg.droid.battles.game.viewer.ConsoleView;

import static com.gmail.violentoleg.droid.battles.game.model.user.UserRole.USER;
import static java.lang.String.format;

public class UserController {

    private MessagesController messagesController;
    private ConsoleView consoleView;
    private UserDao userDao;

    public UserController(MessagesController messagesController, ConsoleView consoleView, UserDao userDao) {
        this.messagesController = messagesController;
        this.consoleView = consoleView;
        this.userDao = userDao;
    }

    public User getCurrentUser() {
        return userDao.getCurrentUser();
    }

    public void registerUser(String login, String pass) {
        if (!validate(login, pass)) {
            consoleView.showError(messagesController.getProperty("error.invalid.input"));
        } else if (userDao.getAllUsers().containsKey(login)) {
            consoleView.showError(format(messagesController.getProperty("error.registration.user.exist"), login));
        } else {
            User user = new User();
            user.setLogin(login);
            user.setPass(pass);
            user.setRole(USER);
            userDao.createNewUser(user);
            consoleView.showMessage(messagesController.getProperty("registration.successful.message"));
        }
    }

    public void authorize(String login, String pass) {
        if (!validate(login, pass)) {
            consoleView.showError(messagesController.getProperty("error.invalid.input"));
        } else {
            User user = userDao.getAllUsers().get(login);
            if (user == null || !user.getPass().equals(pass)) {
                consoleView.showError(messagesController.getProperty("error.wrong.credentials"));
            } else {
                userDao.saveCurrentUser(user);
                consoleView.showMessage(messagesController.getProperty("authorization.successful.message") + user.getLogin());
            }
        }
    }

    private boolean validate(String login, String pass) {
        return login != null && !login.isEmpty() && pass != null && !pass.isEmpty();
    }

    public void logOut() {
        userDao.saveCurrentUser(new User());
        consoleView.showMessage(messagesController.getProperty("logout.successful.message"));
    }
}
