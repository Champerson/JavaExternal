package com.gmail.violentoleg.droid.battles.game.controller;

import com.gmail.violentoleg.droid.battles.game.dao.DroidDao;
import com.gmail.violentoleg.droid.battles.game.dao.DuelDao;
import com.gmail.violentoleg.droid.battles.game.model.Duel;
import com.gmail.violentoleg.droid.battles.game.viewer.ConsoleView;

import static java.lang.String.format;

public class DuelController {

    private DuelDao duelDao;
    private DroidDao droidDao;
    private ConsoleView consoleView;
    private MessagesController messagesController;

    public DuelController(MessagesController messagesController, ConsoleView consoleView, DuelDao duelDao, DroidDao droidDao) {
        this.messagesController = messagesController;
        this.consoleView = consoleView;
        this.droidDao = droidDao;
        this.duelDao = duelDao;
    }

    public void registerDuel(int firstParticipant, int secondParticipant) {
        if (droidDao.getAllDroids().size() <= firstParticipant || droidDao.getAllDroids().size() <= secondParticipant) {
            consoleView.showError(messagesController.getProperty("error.invalid.input"));
        } else {
            duelDao.createNewDuel(droidDao.getAllDroids().get(firstParticipant), droidDao.getAllDroids().get(secondParticipant));
        }
    }

    public void removeDuel(Duel duel) {
        if (duelDao.getAllDuels().contains(duel)) {
            duelDao.getAllDuels().remove(duelDao.getAllDuels().indexOf(duel));
        } else {
            consoleView.showError(messagesController.getProperty("error.invalid.data"));
        }
    }

    public void startDuel(Duel duel) {
        int round = 1;

        while (duel.getFirstFighter().isAlive() && duel.getSecondFighter().isAlive()) {
            consoleView.showMessage(format(messagesController.getProperty("duel.round.title"), round++));
            duel.getFirstFighter().giveDamage(duel.getSecondFighter());
            if (duel.getSecondFighter().isAlive()) {
                duel.getSecondFighter().giveDamage(duel.getFirstFighter());
            }
            consoleView.showMessage(format(messagesController.getProperty("duel.round.result.message"), duel.getFirstFighter().getHealth(), duel.getSecondFighter().getHealth()));
        }
    }
}
