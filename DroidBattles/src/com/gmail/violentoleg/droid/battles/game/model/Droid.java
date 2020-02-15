package com.gmail.violentoleg.droid.battles.game.model;

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

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    protected abstract int calculateDamage();

    protected abstract int reduceIncomingDamage(int damage);

    public void giveDamage(Droid droidRecipient) {
        droidRecipient.takeDamage(calculateDamage());
    }

    public void takeDamage(int damage) {
        this.health = this.health - reduceIncomingDamage(damage);
    }

    public boolean isAlive() {
        return this.health >= 1;
    }
}
