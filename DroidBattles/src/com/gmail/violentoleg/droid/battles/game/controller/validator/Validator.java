package com.gmail.violentoleg.droid.battles.game.controller.validator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static Matcher loginMatcher;
    private static Matcher passwordMatcher;
    private static Pattern loginRegex = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\.]{2,20}$");
    private static Pattern passwordRegex = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\.]{2,20}$");

    public static boolean validateCredentials(String login, String password) {
        if (login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
            loginMatcher = loginRegex.matcher(login);
            passwordMatcher = passwordRegex.matcher(password);
            return loginMatcher.matches() && passwordMatcher.matches();
        } else {
            return false;
        }
    }
}
