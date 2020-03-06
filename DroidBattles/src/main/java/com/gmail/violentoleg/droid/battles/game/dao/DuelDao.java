package main.java.com.gmail.violentoleg.droid.battles.game.dao;


import main.java.com.gmail.violentoleg.droid.battles.game.model.Duel;
import main.java.com.gmail.violentoleg.droid.battles.game.model.droids.Droid;
import main.java.com.gmail.violentoleg.droid.battles.game.model.droids.JuggernautDroid;
import main.java.com.gmail.violentoleg.droid.battles.game.model.droids.SlayerDroid;

import java.util.ArrayList;
import java.util.List;

public class DuelDao {

    private List<Duel> allDuels = new ArrayList<>() {{
        add(new Duel(new JuggernautDroid(800, 30), new SlayerDroid(350, 60)));
    }};

    public void createNewDuel(Droid firstParticipant, Droid secondParticipant) {
        allDuels.add(new Duel(firstParticipant, secondParticipant));
    }

    public boolean isExist(int duelNumber) {
        return duelNumber < allDuels.size() && duelNumber >= 0;
    }

    public List<Duel> getAllDuels() {
        return allDuels;
    }

    public Duel getDuel(int duelNumber) {
        return isExist(duelNumber) ? getAllDuels().get(duelNumber) : null;
    }
}
