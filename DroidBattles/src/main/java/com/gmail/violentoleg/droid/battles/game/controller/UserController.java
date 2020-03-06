package main.java.com.gmail.violentoleg.droid.battles.game.controller;


import main.java.com.gmail.violentoleg.droid.battles.game.dao.DuelDao;
import main.java.com.gmail.violentoleg.droid.battles.game.dao.UserDao;
import main.java.com.gmail.violentoleg.droid.battles.game.model.Duel;
import main.java.com.gmail.violentoleg.droid.battles.game.model.User;
import main.java.com.gmail.violentoleg.droid.battles.game.viewer.ConsoleView;

import static java.lang.String.format;
import static main.java.com.gmail.violentoleg.droid.battles.game.controller.validator.Validator.validateCredentials;
import static main.java.com.gmail.violentoleg.droid.battles.game.model.UserRole.USER;

public class UserController {

    private UserDao userDao;
    private DuelDao duelDao;
    private ConsoleView consoleView;
    private MessagesController messagesController;

    public UserController(MessagesController messagesController, ConsoleView consoleView, UserDao userDao, DuelDao duelDao) {
        this.userDao = userDao;
        this.duelDao = duelDao;
        this.consoleView = consoleView;
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

    public void betOnDroid(int duelNumber, int participantToBet) {
        if (duelDao.isExist(duelNumber)) {
            Duel duel = duelDao.getAllDuels().get(duelNumber);
            if (participantToBet == 1) {
                duel.setUserBet(duel.getFirstFighter());
            } else if (participantToBet == 2) {
                duel.setUserBet(duel.getSecondFighter());
            } else {
                consoleView.showError(messagesController.getProperty("error.invalid.input"));
            }
        } else {
            consoleView.showError(messagesController.getProperty("error.invalid.input"));
        }
    }
}
