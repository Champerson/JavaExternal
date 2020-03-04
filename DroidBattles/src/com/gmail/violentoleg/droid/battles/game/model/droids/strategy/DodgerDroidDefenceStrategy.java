package com.gmail.violentoleg.droid.battles.game.model.droids.strategy;

import com.gmail.violentoleg.droid.battles.game.model.droids.Defending;

import static java.lang.Math.random;

public class DodgerDroidDefenceStrategy implements Defending {

    private static final int DODGE_CHANCE_PERCENTS = 20;

    @Override
    public int calculateDamage(int damage) {
        return damage;
    }

    @Override
    public int reduceIncomingDamage(int damage) {
        return isDodgeApply() ? 0 : damage;
    }

    private boolean isDodgeApply() {
        int dodgeChance = (int) (random() * (100 / DODGE_CHANCE_PERCENTS));
        return dodgeChance == 0;
    }
}
