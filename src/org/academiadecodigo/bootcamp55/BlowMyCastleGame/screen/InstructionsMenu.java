package org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Engine;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.Input;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.KEY;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class InstructionsMenu extends AbstractScreen implements Screens {

    private Picture menu;

    public InstructionsMenu(Engine engine) {
        super(engine);
    }

    @Override
    public void handleInputs(Input input) {

        KEY key = input.getKey();

        switch (key) {
            case ESC:
                hide();
                engine.setGameState(GameState.MENU);
                break;
            case Q:
                System.exit(0);
                break;
        }

    }

    @Override
    public void show() {
        menu = new Picture(400, 200, "resources/Pictures/instructions.png");
        menu.draw();
    }

    @Override
    public void hide() {
        menu.delete();


    }
}
