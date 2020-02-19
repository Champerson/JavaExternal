package com.gmail.violentoleg.droid.battles.game.controller;


import com.gmail.violentoleg.droid.battles.game.dao.InMemoryUserDao;
import com.gmail.violentoleg.droid.battles.game.model.user.UserRole;

import java.util.List;

public class AuthenticationManager {

    private InMemoryUserDao userDao;

    public AuthenticationManager(InMemoryUserDao userDao) {
        this.userDao = userDao;
    }

    public boolean authenticate(List<UserRole> restrictions) {
        return !restrictions.contains(userDao.getCurrentUser().getRole());
    }
}
