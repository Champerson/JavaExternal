package main.java.com.gmail.violentoleg.droid.battles.game.controller;

import main.java.com.gmail.violentoleg.droid.battles.game.dao.UserDao;
import main.java.com.gmail.violentoleg.droid.battles.game.model.UserRole;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static main.java.com.gmail.violentoleg.droid.battles.game.model.UserRole.ADMIN;

public class AuthenticationManagerTest {

    UserDao userDao = new UserDao();
    AuthenticationManager authenticationManager = new AuthenticationManager(userDao);
    List<UserRole> restrictions = new ArrayList<>();

    @Test
    public void authenticate() {
        userDao.saveCurrentUser(userDao.getAllUsers().get("admin"));
        restrictions.add(ADMIN);
        boolean test = authenticationManager.authenticate(restrictions);

        Assert.assertFalse(test);
    }
}