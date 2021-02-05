package org.academiadecodigo.bootcamp55.BlowMyCastleGame;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MyKeyboard implements KeyboardHandler {

    private Keyboard keyboard;
    private Player player1;
    private Player player2;
    private Player player3;

    public MyKeyboard(Player player1, Player player2) {
        keyboard = new Keyboard(this);
        this.player1 = player1;
        this.player2 = player2;
    }

    public void init() {
        KeyboardEvent rightEvent = new KeyboardEvent();
        rightEvent.setKey(KeyboardEvent.KEY_RIGHT);
        rightEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(rightEvent);

        KeyboardEvent leftEvent = new KeyboardEvent();
        leftEvent.setKey(KeyboardEvent.KEY_LEFT);
        leftEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(leftEvent);

        KeyboardEvent upEvent = new KeyboardEvent();
        upEvent.setKey(KeyboardEvent.KEY_UP);
        upEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(upEvent);

        KeyboardEvent downEvent = new KeyboardEvent();
        downEvent.setKey(KeyboardEvent.KEY_DOWN);
        downEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(downEvent);

        KeyboardEvent rightEventD = new KeyboardEvent();
        rightEventD.setKey(KeyboardEvent.KEY_D);
        rightEventD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(rightEventD);

        KeyboardEvent leftEventA = new KeyboardEvent();
        leftEventA.setKey(KeyboardEvent.KEY_A);
        leftEventA.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(leftEventA);

        KeyboardEvent upEventW = new KeyboardEvent();
        upEventW.setKey(KeyboardEvent.KEY_W);
        upEventW.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(upEventW);

        KeyboardEvent downEventS = new KeyboardEvent();
        downEventS.setKey(KeyboardEvent.KEY_S);
        downEventS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(downEventS);
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        if (e.getKey() == KeyboardEvent.KEY_RIGHT) {
            player2.moveRight();
        } else if (e.getKey() == KeyboardEvent.KEY_LEFT) {
            player2.moveLeft();
        } else if (e.getKey() == KeyboardEvent.KEY_UP) {
            player2.moveUp();
        } else if (e.getKey() == KeyboardEvent.KEY_DOWN) {
            player2.moveDown();
        } else if (e.getKey() == KeyboardEvent.KEY_D) {
            player1.moveRight();
        } else if (e.getKey() == KeyboardEvent.KEY_A) {
            player1.moveLeft();
        } else if (e.getKey() == KeyboardEvent.KEY_W) {
            player1.moveUp();
        } else if (e.getKey() == KeyboardEvent.KEY_S) {
            player1.moveDown();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {}


}
