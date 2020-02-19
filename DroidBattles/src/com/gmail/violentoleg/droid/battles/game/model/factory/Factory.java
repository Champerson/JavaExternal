package com.gmail.violentoleg.droid.battles.game.model.factory;

import com.gmail.violentoleg.droid.battles.game.model.droids.*;

public class Factory {

    public Droid droidFactory(DroidType type) {
        switch (type) {
            case TANK:
                return new JuggernautDroid(500, 35);
            case STANDARD:
                return new SimpleDroid(450, 50);
            case HEALER:
                return new SelfHealDroid(350, 40);
            case ASSASSIN:
                return new DodgerDroid(350, 40);
            case DAMAGE_DIALER:
                return new SlayerDroid(300, 60);
            default:
                throw new IllegalArgumentException("Wrong droid type: " + type);
        }
    }
}
