package com.gmail.violentoleg.droid.battles.game.dao;

import com.gmail.violentoleg.droid.battles.game.model.Duel;

import java.util.ArrayList;
import java.util.List;

public class DuelDao {

    private List<Duel> allDuels = new ArrayList<>() {{
        add(new Duel());
    }};

    public void createNewDuel() {
            allDuels.add(new Duel());
    }

    public void showAllDuels() {
        int duelNumber = 0;

        for (Duel duel : allDuels) {
            System.out.print(duel);
        }
    }

    public List<Duel> getAllDuels() {
        return allDuels;
    }
}
