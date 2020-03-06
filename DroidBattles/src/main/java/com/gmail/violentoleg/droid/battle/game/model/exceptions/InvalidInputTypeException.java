package com.gmail.violentoleg.droid.battle.game.model.exceptions;

public class InvalidInputTypeException extends Exception {

    public InvalidInputTypeException() {
    }

    public InvalidInputTypeException(String message) {
        super(message);
    }

    public InvalidInputTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInputTypeException(Throwable cause) {
        super(cause);
    }

    public InvalidInputTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
