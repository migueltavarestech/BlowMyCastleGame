package org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Engine;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.HandleInputs;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.Input;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractScreen {

    protected Engine engine;
    private Map<Input, HandleInputs> validInputs;

    public AbstractScreen(Engine engine) {
        this.engine = engine;
        validInputs = new HashMap<>();
    }

    public AbstractScreen() {

    }


    // validate inouts and process the events in the objects created by Inputs
    public void handleInputs(Input input){

    }

    public void show(){}

    public void hide(){}




}
