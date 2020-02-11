package com.java.external;

import com.java.external.patterns.mvc.controller.GameController;

public class Main {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.play();
    }
}
