package com.gmail.violentoleg.droid.battles.game.model.factory;


import com.gmail.violentoleg.droid.battles.game.model.droids.*;

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
        switch (typeOfDroid) {
            case "juggernaut":
                return createJuggernautDroid();
            case "simple":
                return createSimpleDroid();
            case "slayer":
                return createSlayerDroid();
            case "healer":
                return createSelfHealDroid();
            case "dodger":
                return createDodgerDroid();
        }

        return null;
    }
}

