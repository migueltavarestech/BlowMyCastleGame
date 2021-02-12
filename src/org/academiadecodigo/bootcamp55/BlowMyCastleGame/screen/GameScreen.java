package org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Engine;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Player;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.games.GameContracts;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.Input;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.KEY;

public class GameScreen extends AbstractScreen implements Screens{

    private GameContracts game;
    private Player player1;
    private Player player2;

    public GameScreen(Engine engine) {
        super(engine);
    }

    @Override
    public void show() {
        // players
        player1 = new Player();
        player2 = new Player();
        // wall bricks


    }

    @Override
    public void handleInputs(Input input) {

        KEY key = input.getKey();

        switch (key) {
            case ESC:
                game.setEnd();
            case DOWN:
                player2.moveDown();
                break;
            case UP:
                player2.moveUp();
                break;
            case LEFT:
                player2.moveLeft();
                break;
            case RIGHT:
                player2.moveRight();
                break;
            case A:
                player1.moveLeft();
                break;
            case S:
                player1.moveDown();
                break;
            case W:
                player1.moveUp();
                break;
            case D:
                player1.moveRight();
        }
    }



}
