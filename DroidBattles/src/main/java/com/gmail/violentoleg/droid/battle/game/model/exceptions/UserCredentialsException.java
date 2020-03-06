package com.gmail.violentoleg.droid.battle.game.model.exceptions;

public class UserCredentialsException extends Exception {

    public UserCredentialsException() {
    }

    public UserCredentialsException(String message) {
        super(message);
    }

    public UserCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserCredentialsException(Throwable cause) {
        super(cause);
    }

    public UserCredentialsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
