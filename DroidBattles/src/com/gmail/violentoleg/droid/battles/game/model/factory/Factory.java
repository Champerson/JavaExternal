package com.gmail.violentoleg.droid.battles.game.model.factory;

import com.gmail.violentoleg.droid.battles.game.model.Duel;
import com.gmail.violentoleg.droid.battles.game.model.droids.*;

public class Factory {

    public Droid droidFactory(int droidNumber) {
        Droid droid = new SlayerDroid(400, 30);

        switch (droidNumber) {
            case 0:
                droid = new SimpleDroid(700, 40);
            case 1:
                droid = new JuggernautDroid(500, 30);
            case 2:
                droid = new SelfHealDroid(600, 40);
            case 3:
                droid = new SlayerDroid(300, 50);
            case 4:
                droid = new DodgerDroid(400, 40);
        }
        return droid;
    }

    public Duel duelFactory() {
        return new Duel();
    }
}
