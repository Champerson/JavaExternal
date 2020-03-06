package com.gmail.violentoleg.droid.battle.game.model.droids;


import com.gmail.violentoleg.droid.battle.game.model.droids.strategy.HealDefence;

public class SelfHealDroid extends Droid {

    public SelfHealDroid(int health, int damage) {
        super(health, damage, new HealDefence());
    }
}
