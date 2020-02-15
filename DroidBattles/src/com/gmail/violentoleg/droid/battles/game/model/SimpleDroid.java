package com.gmail.violentoleg.droid.battles.game.model;

public class SimpleDroid extends Droid{

    public SimpleDroid(int health, int damage) {
        super(health, damage);
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
