package com.gmail.violentoleg.droid.battles.game.model.droids;

import com.gmail.violentoleg.droid.battles.game.model.droids.strategy.SelfHealDroidDefenceStrategy;

public class SelfHealDroid extends Droid {


    public SelfHealDroid(int health, int damage) {
        super(health, damage, new SelfHealDroidDefenceStrategy());
    }
}
