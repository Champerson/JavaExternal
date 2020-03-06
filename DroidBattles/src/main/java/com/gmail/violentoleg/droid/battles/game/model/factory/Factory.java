package main.java.com.gmail.violentoleg.droid.battles.game.model.factory;


import main.java.com.gmail.violentoleg.droid.battles.game.model.droids.*;


public class Factory {

    public Droid createDodgerDroid() {
        return new DodgerDroid(500, 40);
    }

    public Droid createSimpleDroid() {
        return new SimpleDroid(700, 40);
    }

    public Droid createSlayerDroid() {
        return new SlayerDroid(400, 60);
    }

    public Droid createJuggernautDroid() {
        return new JuggernautDroid(800, 30);
    }

    public Droid createSelfHealDroid() {
        return new SelfHealDroid(500, 40);
    }

    public Droid droidFactory(String typeOfDroid) {
        Droid factoryDroid = null;

        if (typeOfDroid.isEmpty()) {
            return null;
        } else if (typeOfDroid.equalsIgnoreCase("juggernaut")) {
            factoryDroid = createJuggernautDroid();
        } else if (typeOfDroid.equalsIgnoreCase("simple")) {
            factoryDroid = createSimpleDroid();
        } else if (typeOfDroid.equalsIgnoreCase("slayer")) {
            factoryDroid = createSlayerDroid();
        } else if (typeOfDroid.equalsIgnoreCase("healer")) {
            factoryDroid = createSelfHealDroid();
        } else if (typeOfDroid.equalsIgnoreCase("dodger")) {
            factoryDroid = createDodgerDroid();
        }

        return factoryDroid;
    }
}


