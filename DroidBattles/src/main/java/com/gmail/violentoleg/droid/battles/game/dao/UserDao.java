package main.java.com.gmail.violentoleg.droid.battles.game.dao;


import main.java.com.gmail.violentoleg.droid.battles.game.model.User;

import java.util.HashMap;
import java.util.Map;

import static main.java.com.gmail.violentoleg.droid.battles.game.model.UserRole.ADMIN;

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
