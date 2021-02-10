package org.academiadecodigo.bootcamp55.BlowMyCastleGame;

import java.security.Key;
import java.util.*;
import java.util.Map.Entry;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.EVENT;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.Input;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.KEY;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen.GameScreens;
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
    private Map<Integer, Input> inputs2;
    private boolean stopGame = false;
    private GameScreens screens;

    public Engine(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        inputs = new LinkedHashMap();
//        keyboard = new Keyboard(this);
//        screens = new GameScreens();

    }

    public Engine() {
        inputs = new LinkedHashMap();
        keyboard = new Keyboard(this);
        screens = new GameScreens();
    }

    public void init() {
        this.keyboard = new Keyboard(this);

        for (KEY key : KEY.values()) {
            this.addListener(keyboard, key.getKeyCode(), KeyboardEventType.KEY_PRESSED);
            this.addListener(keyboard, key.getKeyCode(), KeyboardEventType.KEY_RELEASED);
        }

    }

    public void setUP() {
        screens.startScreen();

        Iterator<Input> iterator = inputs.values().iterator();

        /**
         *  wait till key is pressed
         */
        while (!iterator.hasNext()){
            sleep(10);
            iterator = inputs.values().iterator();
        }

        /**
         * acts on pressed key
         */
        Input input = null;
        if (iterator.hasNext()) {
            input = iterator.next();
            setUPActions(input);   // if not valid key re-runs this method
        }
    }

    /**
     * decision maker based on player inputs
     * if not valid key re-runs setUP method
     * @param input
     */
    public void setUPActions(Input input){
        KEY key = input.getKey();

            switch (key){
                case S:
                    Game newGame = new Game();
                    newGame.start();
                    break;
                case P:
                    pratice();
                    break;
                case I:
                    instructions();
                    break;
                case Q:
                    System.exit(0);
                default:
                    inputs.clear();
                    sleep(100);
                    setUP();
                    break;

            }

        }

    private void instructions() {
    }

    private void pratice() {
    }

    /**
     * runs the 2 players game
     */
    public void start() {

        while (!this.stopGame) {
            Iterator var2 = this.inputs.entrySet().iterator();
//            System.out.println("in loop" + var2.hasNext());

            while(!var2.hasNext()){
                this.sleep(65L);
                var2 = this.inputs.entrySet().iterator();
//                System.out.println("teste" + var2.hasNext());
            }
            this.showAllMovements();
            this.sleep(65L);
        }
    }

    /**
     * delay time to allow some time for player to press or release key before checking keyboard
     * @param time
     */
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
        System.out.println("key pressed");
        synchronized (this.inputs) {
            this.inputs.put(keyboardEvent.getKey(), new Input(key, EVENT.KEY_PRESS));
            System.out.println(key);
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
        System.out.println("in show");
        synchronized (this.inputs) {
            Iterator var2 = this.inputs.entrySet().iterator();
            System.out.println("in loop" + var2.hasNext() + "teste" + inputs.values());

            while (var2.hasNext()) {
                System.out.println("in loop");
                Entry<Integer, Input> entry = (Entry) var2.next();
                this.movePlayer(entry.getValue());
            }
        }
    }

    private void movePlayer(Input input) {
        System.out.println("in move player");
        KEY key = input.getKey();
        switch (key) {
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