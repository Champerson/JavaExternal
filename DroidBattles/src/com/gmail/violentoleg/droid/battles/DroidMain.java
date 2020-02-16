package com.gmail.violentoleg.droid.battles;


import com.gmail.violentoleg.droid.battles.game.controller.DroidController;
import com.gmail.violentoleg.droid.battles.game.model.factory.Factory;

import static com.gmail.violentoleg.droid.battles.game.model.DroidType.DAMAGE_DIALER;
import static com.gmail.violentoleg.droid.battles.game.model.DroidType.TANK;

public class DroidMain {

    public static void main(String[] args) {
        Factory factory = new Factory();

        DroidController droidController = new DroidController();
        droidController.startBattleOfTwoDroids(factory.droidFactory(TANK), factory.droidFactory(DAMAGE_DIALER));
    }
}
