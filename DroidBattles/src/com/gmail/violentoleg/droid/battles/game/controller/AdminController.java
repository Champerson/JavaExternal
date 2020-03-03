package com.gmail.violentoleg.droid.battles.game.controller;


import com.gmail.violentoleg.droid.battles.game.dao.DroidDao;
import com.gmail.violentoleg.droid.battles.game.dao.DuelDao;
import com.gmail.violentoleg.droid.battles.game.model.Duel;
import com.gmail.violentoleg.droid.battles.game.viewer.ConsoleView;

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
            if (participantNumber == 1 && duelDao.getAllDuels().get(duelNumber).getFirstFighter() == null) {
                duel.setFirstFighter(droidDao.getDroid(droidNumber));
            } else if (participantNumber == 2 && duelDao.getAllDuels().get(duelNumber).getSecondFighter() == null) {
                duel.setSecondFighter(droidDao.getDroid(droidNumber));
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

    public void replaceParticipantOfTheDuel(int participantToReplace, int duelNumber, int droid) {
        if (duelDao.isExist(duelNumber)) {
            Duel duel = duelDao.getAllDuels().get(duelNumber);
            if (participantToReplace == 1) {
                duel.setFirstFighter(droidDao.getDroid(droid));
            } else if (participantToReplace == 2) {
                duel.setSecondFighter(droidDao.getDroid(droid));
            } else {
                consoleView.showError(messagesController.getProperty("error.invalid.input"));
            }
        }
    }
}
