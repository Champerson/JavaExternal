package main.java.com.gmail.violentoleg.droid.battles.game.model.droids;


import main.java.com.gmail.violentoleg.droid.battles.game.model.droids.strategy.DamageCalculation;

import java.io.Serializable;

import static java.lang.Math.max;

public abstract class Droid implements Serializable {

    private int health;
    private int damage;
    private Engine engine;
    private DamageCalculation damageCalculation;
    private static final long serialVersionUID = 1L;

    public Droid(int health, int damage, DamageCalculation damageCalculation) {
        this.health = health;
        this.damage = damage;
        this.engine = new Engine();
        this.damageCalculation = damageCalculation;
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
        droidRecipient.takeDamage(damageCalculation.calculateDamage(this.getDamage()));
    }

    public void takeDamage(int damage) {
        this.health = max(0, this.health - damageCalculation.reduceIncomingDamage(damage));
    }

    @Override
    public String toString() {
        return " Droid: " + getClass().getSimpleName() +
                "\n health: " + health +
                "\n damage: " + damage;
    }
}
