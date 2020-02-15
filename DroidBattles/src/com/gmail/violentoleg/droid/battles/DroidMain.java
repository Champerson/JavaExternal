package com.gmail.violentoleg.droid.battles;

import com.gmail.violentoleg.droid.battles.game.model.Droid;
import com.gmail.violentoleg.droid.battles.game.model.DodgerDroid;
import com.gmail.violentoleg.droid.battles.game.model.JuggernautDroid;
import com.gmail.violentoleg.droid.battles.game.model.SlayerDroid;

public class DroidMain {

    public static void main(String[] args) {
        DodgerDroid dodgerDroid = new DodgerDroid(175, 25);
        SlayerDroid slayerDroid = new SlayerDroid(200, 40);
        JuggernautDroid juggernautDroid = new JuggernautDroid(400, 20);

        fight(slayerDroid, juggernautDroid);
    }

    private static void fight(Droid firstFighter, Droid secondFighter) {
        System.out.println("First damage: " + firstFighter.getDamage());
        System.out.println("Second Damage: " + secondFighter.getDamage());

        while (firstFighter.isAlive() && secondFighter.isAlive()) {

            System.out.println();
            System.out.println("STEP");
            System.out.println("Before");
            System.out.println("First HP: " + firstFighter.getHealth());
            System.out.println("Second HP: " + secondFighter.getHealth());
            System.out.println();
            firstFighter.giveDamage(secondFighter);
            secondFighter.giveDamage(firstFighter);
            System.out.println();
            System.out.println("After");
            System.out.println("First HP: " + firstFighter.getHealth());
            System.out.println("Second HP: " + secondFighter.getHealth());
        }
    }
}
