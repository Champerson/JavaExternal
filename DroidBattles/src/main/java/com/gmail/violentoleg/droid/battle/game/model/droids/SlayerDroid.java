package com.gmail.violentoleg.droid.battle.game.model.droids;


import com.gmail.violentoleg.droid.battle.game.model.droids.strategy.SlayerAttack;

public class SlayerDroid extends Droid {

    public SlayerDroid(int health, int damage) {
        super(health, damage, new SlayerAttack());
    }
}
