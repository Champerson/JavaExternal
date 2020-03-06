package main.java.com.gmail.violentoleg.droid.battles.game.model.droids;


import main.java.com.gmail.violentoleg.droid.battles.game.model.droids.strategy.SimpleCalculation;

public class SimpleDroid extends Droid {

    public SimpleDroid(int health, int damage) {
        super(health, damage, new SimpleCalculation());
    }
}
