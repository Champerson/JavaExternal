package com.gmail.violentoleg.guess.game.patterns.mvc.controller;

import com.gmail.violentoleg.guess.game.patterns.mvc.viewer.GameViewer;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class GameMessagesController {

    private static final String DEFAULT_LANGUAGE_EN = "en";
    private static final String DEFAULT_COUNTRY_US = "US";

    private ResourceBundle resourceBundle;
    private GameViewer gameView;

    public GameMessagesController(GameViewer gameView) {
        this.resourceBundle = ResourceBundle.getBundle("game", new Locale(DEFAULT_LANGUAGE_EN, DEFAULT_COUNTRY_US));
        this.gameView = gameView;
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
                gameView.showError(getProperty("error.invalid.input"));
                break;
            }
        }
    }

    private void reloadResourceBundle(String languageCode, String countryCode) {
        resourceBundle = ResourceBundle.getBundle("game", new Locale(languageCode, countryCode));
    }
}
