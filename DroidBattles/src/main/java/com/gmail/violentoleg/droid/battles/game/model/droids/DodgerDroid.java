package com.gmail.violentoleg.droid.battles.game.model.droids;

import com.gmail.violentoleg.droid.battles.game.model.droids.strategy.DodgerDroidDefenceStrategy;

public class DodgerDroid extends Droid {

    public DodgerDroid(int health, int damage) {
        super(health, damage, new DodgerDroidDefenceStrategy());
    }
}
