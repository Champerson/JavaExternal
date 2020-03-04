package com.gmail.violentoleg.droid.battles.game.controller;

import com.gmail.violentoleg.droid.battles.game.dao.UserDao;
import com.gmail.violentoleg.droid.battles.game.model.User;
import com.gmail.violentoleg.droid.battles.game.model.UserRole;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static com.gmail.violentoleg.droid.battles.game.model.UserRole.ADMIN;
import static org.junit.Assert.*;

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