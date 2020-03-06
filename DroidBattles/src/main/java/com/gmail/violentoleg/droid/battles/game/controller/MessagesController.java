package main.java.com.gmail.violentoleg.droid.battles.game.controller;


import main.java.com.gmail.violentoleg.droid.battles.game.viewer.ConsoleView;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessagesController {

    private static final String DEFAULT_LANGUAGE_EN = "en";
    private static final String DEFAULT_COUNTRY_US = "US";

    private ResourceBundle resourceBundle;
    private ConsoleView consoleView;

    public MessagesController(ConsoleView consoleView) {
        this.resourceBundle = ResourceBundle.getBundle("messages", new Locale(DEFAULT_LANGUAGE_EN, DEFAULT_COUNTRY_US));
        this.consoleView = consoleView;
    }

    public String getProperty(String key) {
        try {
            return new String(resourceBundle.getString(key).getBytes("cp1251"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public void changeLanguage(String newLanguage) {
        switch (newLanguage) {
            case "uk":
                reloadResourceBundle("uk", "UA");
                break;
            case "en":
                reloadResourceBundle("en", "US");
                break;
            default: {
                consoleView.showError(getProperty("error.invalid.input"));
                break;
            }
        }
    }

    private void reloadResourceBundle(String languageCode, String countryCode) {
        resourceBundle = ResourceBundle.getBundle("messages", new Locale(languageCode, countryCode));
    }
}
