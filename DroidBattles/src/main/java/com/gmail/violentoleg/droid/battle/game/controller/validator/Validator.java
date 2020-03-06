package com.gmail.violentoleg.droid.battle.game.controller.validator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static Pattern credentialsRegex = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\.]{2,20}$");

    public static boolean validateCredentials(String login, String password) {
        if (login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
            return match(login) && match(password);
        } else {
            return false;
        }
    }

    private static boolean match(String compareString) {
        Matcher matcher = credentialsRegex.matcher(compareString);
        return matcher.matches();
    }
}
