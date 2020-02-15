package com.gmail.violentoleg.droid.battles.game.model;

import static java.lang.Math.max;

public abstract class Droid {

    private int health;
    private int damage;
    private DroidType type;

    public Droid(int health, int damage, DroidType type) {
        this.health = health;
        this.damage = damage;
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public DroidType getType() {
        return type;
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
        return "\n Droid: " + getClass().getSimpleName() + " [" + type + "]" +
                "\n health: " + health +
                "\n damage: " + damage;
    }
}
