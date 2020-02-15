package com.gmail.violentoleg.droid.battles;


import com.gmail.violentoleg.droid.battles.game.controller.DroidController;
import com.gmail.violentoleg.droid.battles.game.model.*;

public class DroidMain {

    public static void main(String[] args) {
        JuggernautDroid juggernautDroid = new JuggernautDroid(400, 30);
        SelfHealDroid selfHealDroid = new SelfHealDroid(300, 30);
        SimpleDroid simpleDroid = new SimpleDroid(400, 50);
        SlayerDroid slayerDroid = new SlayerDroid(250, 50);
        DodgerDroid dodgerDroid  = new DodgerDroid(300, 40);

        DroidController droidController = new DroidController();
        droidController.startBattleOfTwoDroids(juggernautDroid, selfHealDroid);
    }
}
