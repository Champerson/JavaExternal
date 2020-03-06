package com.gmail.violentoleg.droid.battle.game.model.factory;


import com.gmail.violentoleg.droid.battle.game.model.droids.*;

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
        Droid createdDroid = new SlayerDroid(20, 20);

        if (typeOfDroid.equalsIgnoreCase("juggernaut")) {
            createdDroid = createJuggernautDroid();
        } else if (typeOfDroid.equalsIgnoreCase("dodge")) {
            createdDroid = createDodgerDroid();
        } else if (typeOfDroid.equalsIgnoreCase("simple")) {
            createdDroid = createSimpleDroid();
        } else if (typeOfDroid.equalsIgnoreCase("slayer")) {
            createdDroid = createSlayerDroid();
        } else if (typeOfDroid.equalsIgnoreCase("healer")) {
            createdDroid = createSelfHealDroid();
        }

        return createdDroid;
    }
}

