package com.gmail.violentoleg.droid.battles.game.model;

import static com.gmail.violentoleg.droid.battles.game.model.DroidType.ASSASSIN;
import static java.lang.Math.random;

public class DodgerDroid extends Droid{

    private static final int DODGE_CHANCE_PERCENTS = 20;

    public DodgerDroid(int health, int damage) {
        super(health, damage, ASSASSIN);
    }

    @Override
    protected int calculateDamage() {
        return this.getDamage();
    }

    @Override
    protected int reduceIncomingDamage(int damage) {
        return isDodgeApply() ? 0 : damage;
    }

    private boolean isDodgeApply() {
        int dodgeChance = (int) (random() * (100 / DODGE_CHANCE_PERCENTS));
        return dodgeChance == 0;
    }
}
