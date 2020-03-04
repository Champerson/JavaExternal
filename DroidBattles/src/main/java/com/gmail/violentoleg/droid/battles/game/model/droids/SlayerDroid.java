package com.gmail.violentoleg.droid.battles.game.model.droids;

import com.gmail.violentoleg.droid.battles.game.model.droids.strategy.SlayerDroidAttackStrategy;

public class SlayerDroid extends Droid {


    public SlayerDroid(int health, int damage) {
        super(health, damage, new SlayerDroidAttackStrategy());
    }
}
