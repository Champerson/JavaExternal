package com.gmail.violentoleg.droid.battles.game.model.droids.strategy;

public interface DamageCalculation {

    int calculateDamage(int damage);

    int reduceIncomingDamage(int damage);
}
