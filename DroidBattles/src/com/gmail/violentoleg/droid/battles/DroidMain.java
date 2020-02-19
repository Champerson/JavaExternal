package com.gmail.violentoleg.droid.battles;


import com.gmail.violentoleg.droid.battles.game.controller.ConsoleMenuController;
import com.gmail.violentoleg.droid.battles.game.controller.DroidController;
import com.gmail.violentoleg.droid.battles.game.model.factory.Factory;

import static com.gmail.violentoleg.droid.battles.game.model.droids.DroidType.DAMAGE_DIALER;
import static com.gmail.violentoleg.droid.battles.game.model.droids.DroidType.TANK;

public class DroidMain {

    private static final String DEFAULT_LANGUAGE_EN = "en";
    private static final String DEFAULT_COUNTRY_US = "US";


    public static void main(String[] args) {
        Factory factory = new Factory();
        new ConsoleMenuController().openMainMenu();

        DroidController droidController = new DroidController();
        droidController.startBattleOfTwoDroids(factory.droidFactory(TANK), factory.droidFactory(DAMAGE_DIALER));
    }
}
