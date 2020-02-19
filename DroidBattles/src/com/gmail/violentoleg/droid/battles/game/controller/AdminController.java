package com.gmail.violentoleg.droid.battles.game.controller;
import static com.gmail.violentoleg.droid.battles.game.controller.ConsoleMenuController.Command;

public class AdminController {

    public Command showDroidDetails(String droidNumber) {
        System.out.println(droidNumber + " Droid: { some details}");
        return Command.M;
    }
}
