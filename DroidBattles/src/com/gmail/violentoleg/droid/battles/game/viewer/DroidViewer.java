package com.gmail.violentoleg.droid.battles.game.viewer;


import com.gmail.violentoleg.droid.battles.game.model.droids.Droid;

public class DroidViewer {

    private static final String BATTLE_PARTICIPANTS_HEADER_MESSAGE = "Participants of the battle: ";
    private static final String BATTLE_HEADER_BEGIN_MESSAGE = System.lineSeparator() + " THE BATTLE BEGIN!";
    private static final String RESULT_OF_THE_ROUND_MESSAGE = "\nResult of the round ";
    private static final String FIRST_FIGHTER_HEALTH_TRACK_MESSAGE = "First fighter HP: ";
    private static final String SECOND_FIGHTER_HEALTH_TRACK_MESSAGE = "Second fighter HP: ";

    public void printDroidSpecification(Droid droid) {
        System.out.println(droid);
    }

    public void printDroidBattleHeader(Droid firstFighter, Droid secondFighter) {
        System.out.println(BATTLE_PARTICIPANTS_HEADER_MESSAGE);
        printDroidSpecification(firstFighter);
        printDroidSpecification(secondFighter);
        System.out.println(BATTLE_HEADER_BEGIN_MESSAGE);
    }

    public void printTitleOfRound(int round) {
        System.out.println(RESULT_OF_THE_ROUND_MESSAGE + round);
    }

    public void printResultOfRound(Droid firstFighter, Droid secondFighter) {
        System.out.println(FIRST_FIGHTER_HEALTH_TRACK_MESSAGE + firstFighter.getHealth() + System.lineSeparator() +
                SECOND_FIGHTER_HEALTH_TRACK_MESSAGE + secondFighter.getHealth());
    }
}
