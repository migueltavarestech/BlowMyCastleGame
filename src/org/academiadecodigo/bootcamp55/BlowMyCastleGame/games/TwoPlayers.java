package org.academiadecodigo.bootcamp55.BlowMyCastleGame.games;


import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Player;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen.GameState;

public class TwoPlayers extends AbstractGames{

    private Player player1;
    private Player player2;

    public TwoPlayers(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public void init(GameState gameState) {



    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public void end() {

    }

    @Override
    public void setEnd() {

    }
}
