package com.gmail.violentoleg.droid.battles.game.model.droids;

import static java.lang.Math.max;

public abstract class Droid {

    private int health;
    private int damage;

    public Droid(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void giveDamage(Droid droidRecipient) {
        droidRecipient.takeDamage(calculateDamage());
    }

    public void takeDamage(int damage) {
        this.health = max(0, this.health - reduceIncomingDamage(damage));
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    protected abstract int calculateDamage();

    protected abstract int reduceIncomingDamage(int damage);

    @Override
    public String toString() {
        return " Droid: " + getClass().getSimpleName() +
                "\n health: " + health +
                "\n damage: " + damage;
    }
}
