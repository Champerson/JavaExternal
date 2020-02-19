package com.gmail.violentoleg.droid.battles.game.model.droids;

import static com.gmail.violentoleg.droid.battles.game.model.droids.DroidType.STANDARD;

public class SimpleDroid extends Droid{

    public SimpleDroid(int health, int damage) {
        super(health, damage, STANDARD);
    }

    @Override
    protected int calculateDamage() {
        return this.getDamage();
    }

    @Override
    protected int reduceIncomingDamage(int damage) {
        return damage;
    }
}
