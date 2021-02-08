package org.academiadecodigo.bootcamp55.BlowMyCastleGame;

import java.security.Key;
import java.util.*;
import java.util.Map.Entry;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.EVENT;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.Input;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.KEY;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Engine  implements KeyboardHandler {
    private int nrPlayers;
    private Keyboard keyboard;
    private KEY[] keys;
    private Player player1;
    private Player player2;
    private Map<Integer, Input> inputs;
    private boolean stopGame = false;

    public Engine(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        inputs = new LinkedHashMap();
        keyboard = new Keyboard(this);


    }

    public void init() {
        this.keyboard = new Keyboard(this);

        for (KEY key : KEY.values()) {
            this.addListener(keyboard, key.getKeyCode(), KeyboardEventType.KEY_PRESSED);
            this.addListener(keyboard, key.getKeyCode(), KeyboardEventType.KEY_RELEASED);
        }

    }

    public void start() {
        while (!this.stopGame) {
            this.showAllMovements();
            this.sleep(100L);
        }

    }

    private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException var4) {
            System.err.println(var4.getMessage());
        }

    }

    public void playerKeys(int nrPlayers) {
        this.keys = new KEY[8];
        this.keys[0] = KEY.A;
        this.keys[1] = KEY.S;
        this.keys[2] = KEY.D;
        this.keys[3] = KEY.W;
        this.keys[4] = KEY.DOWN;
        this.keys[5] = KEY.UP;
        this.keys[6] = KEY.LEFT;
        this.keys[7] = KEY.RIGHT;
    }

    public void keyPressed(KeyboardEvent keyboardEvent) {
        KEY key = KEY.withCode(keyboardEvent.getKey());
        synchronized (this.inputs) {
            this.inputs.put(keyboardEvent.getKey(), new Input(key, EVENT.KEY_PRESS));
        }
    }

    public void keyReleased(KeyboardEvent keyboardEvent) {
        KEY key = KEY.withCode(keyboardEvent.getKey());
        synchronized (this.inputs) {
            this.inputs.remove(keyboardEvent.getKey());
        }
    }

    private void addListener(Keyboard keyboard, int key, KeyboardEventType type) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(type);
        keyboard.addEventListener(event);
    }

    public void showAllMovements() {
        synchronized (this.inputs) {
            Iterator var2 = this.inputs.entrySet().iterator();

            while (var2.hasNext()) {
                Entry<Integer, Input> entry = (Entry) var2.next();
                this.movePlayer(entry.getValue());
            }
        }
    }

    private void movePlayer(Input input) {
        System.out.println("movePlayers");
        KEY key = input.getKey();
        switch (key) {
            case DOWN:
                player2.p2MoveDown();
                break;
            case UP:
                player2.p2MoveUp();
                break;
            case LEFT:
                player2.p2MoveLeft();
                break;
            case RIGHT:
                player2.p2MoveRight();
                break;
            case A:
                player1.p1MoveLeft();
                break;
            case S:
                player1.p1MoveDown();
                break;
            case W:
                player1.p1MoveUp();
                break;
            case D:
                player1.p1MoveRight();
        }

    }
}