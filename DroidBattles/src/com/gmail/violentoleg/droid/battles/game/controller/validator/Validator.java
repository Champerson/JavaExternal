package com.gmail.violentoleg.droid.battles.game.controller.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static Pattern passwordRegex = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}");
    private static Pattern loginRegex = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\.]{6,20}$");
    private static Matcher matcher;

    public static boolean validateLogin(String login) {
        matcher = loginRegex.matcher(login);
        return matcher.matches();
    }

    public static boolean validatePassword(String password) {
        matcher = passwordRegex.matcher(password);
        return matcher.matches();
    }
}
