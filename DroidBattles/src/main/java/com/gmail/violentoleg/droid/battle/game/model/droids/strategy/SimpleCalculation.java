package com.gmail.violentoleg.droid.battle.game.model.droids.strategy;


public class SimpleCalculation implements DamageCalculation {

    @Override
    public int calculateDamage(int damage) {
        return damage;
    }

    @Override
    public int reduceIncomingDamage(int damage) {
        return damage;
    }
}
