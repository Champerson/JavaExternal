package com.gmail.violentoleg.droid.battles.game.model;

import static java.lang.Math.random;

public class DodgerDroid extends Droid{

    public DodgerDroid(int health, int damage) {
        super(health, damage);
    }

    @Override
    protected int calculateDamage() {
        return this.getDamage();
    }

    protected int reduceIncomingDamage(int damage) {
        int dodgeChance = (int) (random() * 5);

        if (dodgeChance == 4) {
            return 0;
        } else {
            return damage;
        }
    }
}
