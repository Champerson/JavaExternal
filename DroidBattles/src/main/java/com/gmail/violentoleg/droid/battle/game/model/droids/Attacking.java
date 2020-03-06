package com.gmail.violentoleg.droid.battle.game.model.droids;


import com.gmail.violentoleg.droid.battle.game.model.droids.strategy.DamageCalculation;

public interface Attacking extends DamageCalculation {

    int calculateDamage(int damage);

    int reduceIncomingDamage(int damage);

    boolean isAttackApply();
}
