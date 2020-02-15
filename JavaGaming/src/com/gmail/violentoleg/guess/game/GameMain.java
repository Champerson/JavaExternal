package com.gmail.violentoleg.guess.game;

import com.gmail.violentoleg.guess.game.patterns.mvc.controller.GameController;

public class GameMain {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.play();
    }
}
