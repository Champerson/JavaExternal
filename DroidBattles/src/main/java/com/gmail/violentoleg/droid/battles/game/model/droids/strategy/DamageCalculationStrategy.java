package com.gmail.violentoleg.droid.battles.game.model.droids.strategy;

public interface DamageCalculationStrategy {

    int calculateDamage(int damage);

    int reduceIncomingDamage(int damage);
}
