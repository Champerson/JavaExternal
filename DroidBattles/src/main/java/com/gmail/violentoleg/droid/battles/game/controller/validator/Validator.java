package main.java.com.gmail.violentoleg.droid.battles.game.controller.validator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static Matcher loginMatcher;
    private static Matcher passwordMatcher;
    private static Pattern credentialsRegex = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\.]{2,20}$");

    public static boolean validateCredentials(String login, String password) {
        if (login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
            loginMatcher = credentialsRegex.matcher(login);
            passwordMatcher = credentialsRegex.matcher(password);
            return loginMatcher.matches() && passwordMatcher.matches();
        } else {
            return false;
        }
    }
}
