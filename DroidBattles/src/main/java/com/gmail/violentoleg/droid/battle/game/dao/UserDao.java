package com.gmail.violentoleg.droid.battle.game.dao;


import com.gmail.violentoleg.droid.battle.game.model.User;

import java.util.HashMap;
import java.util.Map;

import static com.gmail.violentoleg.droid.battle.game.model.UserRole.ADMIN;


public class UserDao {

    private Map<String, User> allUsers = new HashMap<String, User>() {{
        put("admin", new User("admin", "admin", ADMIN));
    }};
    private User currentUser = new User();

    public void createNewUser(User newUser) {
        allUsers.put(newUser.getLogin(), newUser);
    }

    public Map<String, User> getAllUsers() {
        return allUsers;
    }

    public void saveCurrentUser(User user) {
        currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
