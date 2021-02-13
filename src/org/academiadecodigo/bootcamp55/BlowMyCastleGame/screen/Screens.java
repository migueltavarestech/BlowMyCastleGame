package org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.Input;

public interface Screens {
    void show();

    void hide();

    void handleInputs(Input value) throws InterruptedException;

    /**
         * Put in place to hadle the several screens
        It is overridden by menu and instructions screen, that can have its setup invoked when added to the engine.
        */






}
