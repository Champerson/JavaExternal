package com.gmail.violentoleg.droid.battle.game.controller;


import com.gmail.violentoleg.droid.battle.game.dao.DroidDao;
import com.gmail.violentoleg.droid.battle.game.dao.DuelDao;
import com.gmail.violentoleg.droid.battle.game.model.Duel;
import com.gmail.violentoleg.droid.battle.game.model.droids.Droid;
import com.gmail.violentoleg.droid.battle.game.viewer.ConsoleView;

public class AdminController {

    private DuelDao duelDao;
    private DroidDao droidDao;
    private ConsoleView consoleView;
    private MessagesController messagesController;

    public AdminController(MessagesController messagesController, ConsoleView consoleView, DroidDao droidDao, DuelDao duelDao) {
        this.messagesController = messagesController;
        this.consoleView = consoleView;
        this.droidDao = droidDao;
        this.duelDao = duelDao;
    }

    public void addDroidToTheDuel(int participantNumber, int duelNumber, int droidNumber) {
        if (duelDao.isExist(duelNumber) && participantNumber == 1 || participantNumber == 2) {
            Duel duel = duelDao.getAllDuels().get(duelNumber);
            Droid droid = droidDao.getDroid(droidNumber);
            if (participantNumber == 1 && duel.getFirstFighter() == null) {
                duel.setFirstFighter(droid);
            } else if (participantNumber == 2 && duel.getSecondFighter() == null) {
                duel.setSecondFighter(droid);
            } else if (participantNumber == 1 && duel.getFirstFighter() != null || participantNumber == 2 && duel.getSecondFighter() != null) {
                consoleView.showError(messagesController.getProperty("error.participant.place.taken"));
            }
        } else {
            consoleView.showError(messagesController.getProperty("error.invalid.input"));
        }
    }

    public void removeParticipantFromDuel(int participantToRemove, int duelNumber) {
        if (duelDao.isExist(duelNumber) && participantToRemove == 1 || participantToRemove == 2) {
            Duel duel = duelDao.getAllDuels().get(duelNumber);
            if (participantToRemove == 1 && duel.getFirstFighter() != null) {
                duel.setFirstFighter(null);
            } else if (participantToRemove == 2 && duel.getSecondFighter() != null) {
                duel.setSecondFighter(null);
            } else {
                consoleView.showError(messagesController.getProperty("error.empty.participant.place"));
            }
        } else {
            consoleView.showError(messagesController.getProperty("error.invalid.input"));
        }
    }

    public void replaceParticipantOfTheDuel(int participantToReplace, int duelNumber, int droidNumber) {
        if (duelDao.isExist(duelNumber)) {
            Droid droid = droidDao.getDroid(droidNumber);
            Duel duel = duelDao.getAllDuels().get(duelNumber);
            if (participantToReplace == 1) {
                duel.setFirstFighter(droid);
            } else if (participantToReplace == 2) {
                duel.setSecondFighter(droid);
            } else {
                consoleView.showError(messagesController.getProperty("error.invalid.input"));
            }
        }
    }
}
