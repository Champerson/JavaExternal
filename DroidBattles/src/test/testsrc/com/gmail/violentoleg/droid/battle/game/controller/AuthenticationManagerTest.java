package com.gmail.violentoleg.droid.battle.game.controller;


import com.gmail.violentoleg.droid.battle.game.dao.UserDao;
import com.gmail.violentoleg.droid.battle.game.model.UserRole;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.gmail.violentoleg.droid.battle.game.model.UserRole.ADMIN;

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