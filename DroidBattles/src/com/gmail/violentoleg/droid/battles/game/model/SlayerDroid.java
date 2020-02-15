package com.gmail.violentoleg.droid.battles.game.model;

import static java.lang.Math.random;

public class SlayerDroid extends Droid {

    public SlayerDroid(int health, int damage) {
        super(health, damage);
    }

    @Override
    protected int calculateDamage() {
        int criticalChance = (int) (random() * 5);

        if (criticalChance == 4) {
            return this.getDamage() * 2;
        } else {
            return this.getDamage();
        }
    }

    @Override
    protected int reduceIncomingDamage(int damage) {
        return damage;
    }
}
