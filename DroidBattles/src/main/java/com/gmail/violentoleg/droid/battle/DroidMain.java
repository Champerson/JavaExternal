package com.gmail.violentoleg.droid.battle;


import com.gmail.violentoleg.droid.battle.game.controller.ConsoleMenuController;
import com.gmail.violentoleg.droid.battle.game.model.exceptions.InvalidInputTypeException;

public class DroidMain {

    public static void main(String[] args) throws InvalidInputTypeException {
        new ConsoleMenuController().openMainMenu();
    }
}
