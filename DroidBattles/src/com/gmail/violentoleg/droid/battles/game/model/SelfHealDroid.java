package com.gmail.violentoleg.droid.battles.game.model;

import static java.lang.Math.random;

public class SelfHealDroid extends Droid{

    public SelfHealDroid(int health, int damage) {
        super(health, damage);
    }

    @Override
    protected int calculateDamage() {
        return this.getDamage();
    }

    @Override
    protected int reduceIncomingDamage(int damage) {
        int healChance = (int) (random() * 10);

        if (healChance == 6) {
            return -damage;
        } else {
            return damage;
        }
    }
}
