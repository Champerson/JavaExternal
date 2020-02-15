package com.gmail.violentoleg.droid.battles.game.model;

import static java.lang.Math.random;

public class JuggernautDroid extends Droid {

    public JuggernautDroid(int health, int damage) {
        super(health, damage);
    }

    @Override
    protected int calculateDamage() {
        return this.getDamage();
    }

    @Override
    protected int reduceIncomingDamage(int damage) {
        int blockDamageChance = (int) (random() * 5);

        if (blockDamageChance == 4) {
            return damage / 2;
        } else {
            return damage;
        }
    }

}
