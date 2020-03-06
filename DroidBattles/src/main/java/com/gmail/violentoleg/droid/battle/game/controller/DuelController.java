package com.gmail.violentoleg.droid.battle.game.controller;


import com.gmail.violentoleg.droid.battle.game.dao.DroidDao;
import com.gmail.violentoleg.droid.battle.game.dao.DuelDao;
import com.gmail.violentoleg.droid.battle.game.model.Duel;
import com.gmail.violentoleg.droid.battle.game.viewer.ConsoleView;

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
            duelDao.getAllDuels().remove(duel);
        } else {
            consoleView.showError(messagesController.getProperty("error.invalid.input"));
        }
    }

    public void startDuel(Duel duel) {
        int round = 1;

        while (duel.getFirstFighter().getEngine().isAlive() && duel.getSecondFighter().getEngine().isAlive()) {
            consoleView.showMessage(format(messagesController.getProperty("duel.round.title"), round++));
            duel.getFirstFighter().giveDamage(duel.getSecondFighter());
            if (duel.getSecondFighter().getEngine().isAlive()) {
                duel.getSecondFighter().giveDamage(duel.getFirstFighter());
            }
            consoleView.showMessage(format(messagesController.getProperty("duel.round.result.message"), duel.getFirstFighter().getHealth(), duel.getSecondFighter().getHealth()));
        }
        determineTheWinnerOfTheDuel(duel);
        showUserBetResult(duel);
    }

    private void determineTheWinnerOfTheDuel(Duel duel) {
        if (!duel.getFirstFighter().getEngine().isAlive()) {
            duel.setWinner(duel.getSecondFighter());
        } else {
            duel.setWinner(duel.getFirstFighter());
        }
    }

    private void showUserBetResult(Duel duel) {
        if (duel.getUserBet() != null && duel.getWinner() != null && duel.getUserBet() == duel.getWinner()) {
            consoleView.showMessage(format(messagesController.getProperty("duel.user.bet.won.message"), duel.getUserBet().getClass().getSimpleName()));
        } else if (duel.getUserBet() == null) {
            consoleView.showMessage(format(messagesController.getProperty("duel.winner.message"), duel.getWinner().getClass().getSimpleName()));
        } else {
            consoleView.showMessage(format(messagesController.getProperty("duel.user.bet.lost"), duel.getUserBet().getClass().getSimpleName()));
        }
    }

    public void showAllDuels() {
        int duelNumber = 0;

        for (Duel duel : duelDao.getAllDuels()) {
            consoleView.showMessage(format(duel.toString(), duelNumber));
            duelNumber++;
        }
    }
}
