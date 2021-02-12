package org.academiadecodigo.bootcamp55.BlowMyCastleGame.games;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen.GameState;

public interface GameContracts {

    void init(GameState gameState);

    boolean isRunning();

    void end();

    void setEnd();
}
