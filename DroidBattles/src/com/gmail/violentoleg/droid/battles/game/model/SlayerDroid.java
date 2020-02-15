package com.gmail.violentoleg.droid.battles.game.model;

import static com.gmail.violentoleg.droid.battles.game.model.DroidType.ATTACKER;
import static java.lang.Math.random;

public class SlayerDroid extends Droid {

    private static final int CRITICAL_HIT_CHANCE_PERCENTS = 20;
    private static final int CRITICAL_HIT_MULTIPLIER = 2;

    public SlayerDroid(int health, int damage) {
        super(health, damage, ATTACKER);
    }

    @Override
    protected int calculateDamage() {
        int criticalDamageMultiplier = isCriticalHitApply() ? CRITICAL_HIT_MULTIPLIER : 1;
        return this.getDamage() * criticalDamageMultiplier;
    }

    private boolean isCriticalHitApply() {
        int criticalChance = (int) (random() * (100 / CRITICAL_HIT_CHANCE_PERCENTS));
        return criticalChance == 0;
    }

    @Override
    protected int reduceIncomingDamage(int damage) {
        return damage;
    }
}
