package com.gmail.violentoleg.droid.battles.game.controller;


import com.gmail.violentoleg.droid.battles.game.dao.UserDao;
import com.gmail.violentoleg.droid.battles.game.model.user.User;
import com.gmail.violentoleg.droid.battles.game.viewer.ConsoleView;


import static com.gmail.violentoleg.droid.battles.game.controller.validator.Validator.validateCredentials;
import static com.gmail.violentoleg.droid.battles.game.model.user.UserRole.USER;
import static java.lang.String.format;

public class UserController {

    private UserDao userDao;
    DroidController droidController;
    private ConsoleView consoleView;
    private MessagesController messagesController;

    public UserController(MessagesController messagesController, ConsoleView consoleView, UserDao userDao, DroidController droidController) {
        this.userDao = userDao;
        this.consoleView = consoleView;
        this.droidController = droidController;
        this.messagesController = messagesController;
    }

    public User getCurrentUser() {
        return userDao.getCurrentUser();
    }

    public void registerUser(String login, String pass) {
        if (!validateCredentials(login, pass)) {
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
        if (!validateCredentials(login, pass)) {
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

    public void logOut() {
        userDao.saveCurrentUser(new User());
        consoleView.showMessage(messagesController.getProperty("logout.successful.message"));
    }

    public void betOnDroid(int droidToBet) {

    }
}
