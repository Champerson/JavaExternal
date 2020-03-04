package com.gmail.violentoleg.droid.battles.game.controller;

import com.gmail.violentoleg.droid.battles.game.dao.DroidDao;
import com.gmail.violentoleg.droid.battles.game.model.droids.Droid;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class DroidController {

    private DroidDao droidDao;

    public DroidController(DroidDao droidDao) {
        this.droidDao = droidDao;
    }

    public List<Droid> sortAllDroidsByHealth() {
        List<Droid> sortedList = new ArrayList<>();
        for (Droid droid : droidDao.getAllDroids()) {
            sortedList.add(droid);
        }
        sortedList.sort(Comparator.comparingInt(Droid::getHealth));
        return sortedList;
    }

    public void showAllSortedDroids() {
        for (Droid droid : sortAllDroidsByHealth()) {
            droid.toString();
        }
    }

    public Droid findDroidWithByHealth() {
        Droid maxHealthDroid = null;

        for (Droid droid : droidDao.getAllDroids()) {
            if (maxHealthDroid.getHealth() <= droid.getHealth()) {
                maxHealthDroid = droid;
            }
        }

        return maxHealthDroid;
    }

    public Droid findDroidByMaxDamage() {
        Droid maxDamageDroid = null;

        for (Droid droid : droidDao.getAllDroids()) {
            if (maxDamageDroid.getDamage() <= droid.getDamage()) {
                maxDamageDroid = droid;
            }
        }

        return maxDamageDroid;
    }
}
