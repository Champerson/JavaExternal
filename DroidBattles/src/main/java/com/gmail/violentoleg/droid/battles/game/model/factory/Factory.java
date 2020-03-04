package com.gmail.violentoleg.droid.battles.game.model.factory;

import com.gmail.violentoleg.droid.battles.game.model.droids.*;

import java.util.Scanner;

public class Factory {

    DroidFactory droidFactory;

    public Factory() {
        this.droidFactory = new DroidFactory();
    }

    public DroidFactory getDroidFactory() {
        return droidFactory;
    }

    public Droid droidFactory(int droidNumber) {
        Droid droid = new SlayerDroid(400, 30);

        switch (droidNumber) {
            case 0:
                droid = new SimpleDroid(700, 40);
            case 1:
                droid = new JuggernautDroid(500, 30);
            case 2:
                droid = new SelfHealDroid(500, 40);
            case 3:
                droid = new SlayerDroid(300, 50);
            case 4:
                droid = new DodgerDroid(400, 40);
        }
        return droid;
    }

    public class DroidFactory {

        public Droid createDodgerDroid() {
            return new DodgerDroid(400, 40);
        }

        public Droid createSimpleDroid() {
            return new SimpleDroid(700, 40);
        }

        public Droid createSlayerDroid() {
            return new SlayerDroid(300, 50);
        }

        public Droid createJuggernautDroid() {
            return new JuggernautDroid(800, 20);
        }

        public Droid createSelfHealDroid() {
            return new SelfHealDroid(500, 40);
        }

        public Droid createDroid(Scanner userInput) {
            Droid factoryDroid = null;

            if (userInput.nextLine().isEmpty() || userInput.nextLine() == null) {
                return null;
            } else if (userInput.nextLine().equalsIgnoreCase("juggernaut")) {
                factoryDroid = createJuggernautDroid();
            } else if (userInput.nextLine().equalsIgnoreCase("simple")) {
                factoryDroid = createSimpleDroid();
            } else if (userInput.nextLine().equalsIgnoreCase("slayer")) {
                factoryDroid = createSlayerDroid();
            } else if (userInput.nextLine().equalsIgnoreCase("SelfHeal")) {
                factoryDroid = createSelfHealDroid();
            } else if (userInput.nextLine().equalsIgnoreCase("dodger")) {
                factoryDroid = createDodgerDroid();
            }

            return factoryDroid;
        }
    }
}
