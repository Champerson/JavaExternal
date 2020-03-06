package com.gmail.violentoleg.droid.battles.game.model.droids.strategy;


import com.gmail.violentoleg.droid.battles.game.model.droids.Attacking;

import static java.lang.Math.random;

public class SlayerAttack implements Attacking {

    private static final int CRITICAL_HIT_CHANCE_PERCENTS = 20;
    private static final int CRITICAL_HIT_MULTIPLIER = 2;

    @Override
    public int calculateDamage(int damage) {
        int criticalDamageMultiplier = isAttackApply() ? CRITICAL_HIT_MULTIPLIER : 1;
        return damage * criticalDamageMultiplier;
    }

    public boolean isAttackApply() {
        int criticalChance = (int) (random() * (100 / CRITICAL_HIT_CHANCE_PERCENTS));
        return criticalChance == 0;
    }

    @Override
    public int reduceIncomingDamage(int damage) {
        return damage;
    }
}
