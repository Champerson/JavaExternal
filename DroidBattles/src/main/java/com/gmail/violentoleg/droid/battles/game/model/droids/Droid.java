package com.gmail.violentoleg.droid.battles.game.model.droids;

import com.gmail.violentoleg.droid.battles.game.model.droids.strategy.DamageCalculationStrategy;

import static java.lang.Math.max;

public abstract class Droid {

    private int health;
    private int damage;
    private Engine engine;
    private DamageCalculationStrategy damageCalculationStrategy;

    public Droid(int health, int damage, DamageCalculationStrategy damageCalculationStrategy) {
        this.health = health;
        this.damage = damage;
        this.engine = new Engine();
        this.damageCalculationStrategy = damageCalculationStrategy;
    }

    public class Engine {
        public boolean isAlive() {
            return getHealth() > 0;
        }
    }

    public Engine getEngine() {
        return engine;
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

    @Override
    public String toString() {
        return " Droid: " + getClass().getSimpleName() +
                "\n health: " + health +
                "\n damage: " + damage;
    }
}
