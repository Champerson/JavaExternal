package com.gmail.violentoleg.droid.battles.game.model.droids;

import com.gmail.violentoleg.droid.battles.game.model.droids.strategy.DamageCalculationStrategy;

import static java.lang.Math.max;

public abstract class Droid {

    private int health;
    private int damage;
    private DamageCalculationStrategy damageCalculationStrategy;

    public Droid(int health, int damage, DamageCalculationStrategy damageCalculationStrategy) {
        this.health = health;
        this.damage = damage;
        this.damageCalculationStrategy = damageCalculationStrategy;
    }

    private class Engine {

    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void giveDamage(Droid droidRecipient) {
        droidRecipient.takeDamage(damageCalculationStrategy.calculateDamage(this.getDamage()));
    }

    public void takeDamage(int damage) {
        this.health = max(0, this.health - damageCalculationStrategy.reduceIncomingDamage(damage));
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public String toString() {
        return " Droid: " + getClass().getSimpleName() +
                "\n health: " + health +
                "\n damage: " + damage;
    }
}
