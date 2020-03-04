package com.gmail.violentoleg.droid.battles.game.model.droids.strategy;

import com.gmail.violentoleg.droid.battles.game.model.droids.Attacking;

public class SimpleDroidAttackStrategy implements Attacking {

    @Override
    public int calculateDamage(int damage) {
        return damage;
    }

    @Override
    public int reduceIncomingDamage(int damage) {
        return damage;
    }
}
