package com.gmail.violentoleg.droid.battles.game.dao;

import com.gmail.violentoleg.droid.battles.game.model.Duel;
import com.gmail.violentoleg.droid.battles.game.model.droids.Droid;
import com.gmail.violentoleg.droid.battles.game.model.droids.JuggernautDroid;
import com.gmail.violentoleg.droid.battles.game.model.droids.SlayerDroid;
import com.gmail.violentoleg.droid.battles.game.viewer.ConsoleView;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;

public class DuelDao {

    private ConsoleView consoleView;
    private List<Duel> allDuels = new ArrayList<>() {{
        add(new Duel(new JuggernautDroid(430, 40), new SlayerDroid(350, 60)));
    }};

    public DuelDao(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    public void createNewDuel(Droid firstParticipant, Droid secondParticipant) {
        allDuels.add(new Duel(firstParticipant, secondParticipant));
    }

    public void showAllDuels() {
        int duelNumber = 0;

        for (Duel duel : allDuels) {
            consoleView.showMessage(format(duel.toString(), duelNumber));
            duelNumber++;
        }
    }

    public List<Duel> getAllDuels() {
        return allDuels;
    }
}