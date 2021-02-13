package org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Engine;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.Input;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.KEY;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class MenuScreen extends AbstractScreen implements Screens{

    private Picture menu;
//    private Engine engine;

    public MenuScreen(Engine engine) {
        super(engine);
    }

    @Override
    public void handleInputs(Input input) {

        KEY key = input.getKey();

        switch (key) {
            case S:
                engine.setGameState(GameState.TWO_PLAYER);
                break;
            case P:
                engine.setGameState(GameState.PRATICE);
                break;
            case I:
                engine.setGameState(GameState.INSTRUCTIONS);
                break;
            case Q:
                System.exit(0);
                break;
        }

    }

    @Override
    public void show() {
        menu = new Picture(400, 200, "Pictures/oldTeste.png");
        menu.draw();
    }

    @Override
    public void hide() {
        menu.delete();
    }
}

