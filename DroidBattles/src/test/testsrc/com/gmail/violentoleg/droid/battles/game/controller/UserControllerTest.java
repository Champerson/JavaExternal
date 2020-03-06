package com.gmail.violentoleg.droid.battles.game.controller;

import com.gmail.violentoleg.droid.battles.game.dao.DuelDao;
import com.gmail.violentoleg.droid.battles.game.dao.UserDao;
import com.gmail.violentoleg.droid.battles.game.viewer.ConsoleView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserControllerTest {

    private UserDao userDao = new UserDao();
    private DuelDao duelDao = new DuelDao();
    private ConsoleView consoleView = new ConsoleView();
    private MessagesController messagesController = new MessagesController(consoleView);
    private UserController userController = new UserController(messagesController, consoleView, userDao, duelDao);

    @Before
    public void setUp() throws Exception {
        userController.registerUser("oleh", "oleh");
        userDao.saveCurrentUser(userDao.getAllUsers().get("oleh"));
        userController.betOnDroid(0, 1);
    }

    @Test
    public void registerUser() {
        Assert.assertTrue(userDao.getAllUsers().containsKey("oleh"));
    }

    @Test
    public void authorize() {
        Assert.assertSame(userController.getCurrentUser(), userDao.getAllUsers().get("oleh"));
    }

    @Test
    public void logOut() {
        userController.logOut();
        Assert.assertNotSame(userController.getCurrentUser(), userDao.getAllUsers().get("oleh"));
    }

    @Test
    public void betOnDroid() {
        Assert.assertSame(duelDao.getDuel(0).getUserBet(), duelDao.getDuel(0).getFirstFighter());
    }
}