package com.gmail.violentoleg.droid.battles.game.controller;


import com.gmail.violentoleg.droid.battles.game.dao.UserDao;
import com.gmail.violentoleg.droid.battles.game.model.UserRole;

import java.util.List;

public class AuthenticationManager {

    private UserDao userDao;

    public AuthenticationManager(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean authenticate(List<UserRole> restrictions) {
        return !restrictions.contains(userDao.getCurrentUser().getRole());
    }
}
