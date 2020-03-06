package com.gmail.violentoleg.droid.battle.game.controller;


import com.gmail.violentoleg.droid.battle.game.dao.DroidDao;
import com.gmail.violentoleg.droid.battle.game.model.droids.Droid;
import com.gmail.violentoleg.droid.battle.game.viewer.ConsoleView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class DroidController {

    private DroidDao droidDao;
    private ConsoleView consoleView;

    public DroidController(DroidDao droidDao, ConsoleView consoleView) {
        this.droidDao = droidDao;
        this.consoleView = consoleView;
    }

    public List<Droid> sortAllDroidsByHealth() {
        List<Droid> sortedDroids = new ArrayList<>(droidDao.getAllDroids());
        sortedDroids.sort(Comparator.comparingInt(Droid::getHealth));
        droidDao.setAllDroids(sortedDroids);
        return sortedDroids;
    }

    public void showAllDroids() {
        int droidNumber = 0;

        for (Droid droid : droidDao.getAllDroids()) {
            consoleView.showMessage(droidNumber + " - " + droid.toString());
            droidNumber++;
        }
    }

    public Droid findDroidWithMaxHealth() {
        int health = 0;
        Droid maxHealthDroid = null;

        for (Droid droid : droidDao.getAllDroids()) {
            if (health <= droid.getHealth()) {
                health = droid.getHealth();
                maxHealthDroid = droid;
            }
        }

        return maxHealthDroid;
    }

    public Droid findDroidWithMaxDamage() {
        int damage = 0;
        Droid maxDamageDroid = null;

        for (Droid droid : droidDao.getAllDroids()) {
            if (damage <= droid.getDamage()) {
                damage = droid.getHealth();
                maxDamageDroid = droid;
            }
        }

        return maxDamageDroid;
    }
}
