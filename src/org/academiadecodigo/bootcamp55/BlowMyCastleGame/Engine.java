package org.academiadecodigo.bootcamp55.BlowMyCastleGame;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Position;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.games.GameContracts;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.games.GameLevel;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen.GameState;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.EVENT;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.Input;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.KEY;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.ObjectsFactory;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Engine  implements KeyboardHandler {

    private Keyboard keyboard;
    private KEY[] keys;
    private Player player1;
    private Player player2;
    private Map<Integer, Input> inputs;
    private GameState gameState = GameState.MENU;
    private static boolean stopGame;
    private MenuScreen menuScreen;
    private Screens activeScreen;
    private Map<GameState, Screens> screens;
    private InstructionsMenu instructionsMenu;
    private Music music;
    private GameContracts game;


    public Engine(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        inputs = new LinkedHashMap();
    }

    public Engine() {
        inputs = new LinkedHashMap();
        keyboard = new Keyboard(this);
        screens = new HashMap<>();
    }

    public void init() {
        /**
         * Initiates the keyboard and the listener for the keys used in the game
         * see @KEY for details on the overall used keys in the game
         */
        this.keyboard = new Keyboard(this);

        for (KEY key : KEY.values()) {
            this.addListener(keyboard, key.getKeyCode(), KeyboardEventType.KEY_PRESSED);
            this.addListener(keyboard, key.getKeyCode(), KeyboardEventType.KEY_RELEASED);
        }

        /**
         * Initiates the background grid with the two castles already in place
         */


//        factory.createWalls();

        /**
         * create the screens associeted with the several stages of the game
         */
        screens.put(GameState.MENU, new MenuScreen(this));
        screens.put(GameState.INSTRUCTIONS, new InstructionsMenu(this));
        screens.put(GameState.TWO_PLAYER, new GameScreen(this));
        screens.put(GameState.PRATICE, new GameScreen(this));

        activeScreen = screens.get(gameState);

        /**
         * create field bombs after some seconds
         */
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException ex) {
//            System.out.println("Interrupted Exception happened.");
//            Thread.currentThread().interrupt();
//        }


        stopGame = false;
    }

    public void startEngine() throws InterruptedException {

        music = new Music();
        music.playMusic();

        activeScreen.show();

        while (gameState == GameState.MENU || gameState == GameState.INSTRUCTIONS
        || gameState == GameState.TWO_PLAYER || gameState == GameState.PRATICE) {
            if(stopGame){
                System.out.println(stopGame);
                setGameState(GameState.MENU);
                activeScreen.hide();
                activeScreen = screens.get(gameState);
                activeScreen.show();
                stopGame = false;
            } else {
                showAllMovements();
                checkActiveScreen();
                sleep(80L);
            }
        }
    }

    private void checkActiveScreen() {

        Screens current = screens.get(gameState);

        if (current != activeScreen) {
            activeScreen.hide();
            activeScreen = current;
            activeScreen.show();
        }
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void play() throws InterruptedException {

        game.init(gameState);

        while (game.isRunning()){
            showAllMovements();
            sleep(10L);
        }

        game.end();
        // funny sound stuff
        gameState = GameState.MENU;
    }


    /**
     * runs the 2 players game
     */
    public void start() throws InterruptedException {

        while (!this.stopGame) {
            Iterator var2 = this.inputs.entrySet().iterator();
//            System.out.println("in loop" + var2.hasNext());

            while(!var2.hasNext()){
                //this.sleep(62L);
                var2 = this.inputs.entrySet().iterator();
//                System.out.println("teste" + var2.hasNext());
            }
            this.showAllMovements();
            this.sleep(100L);
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

    public void keyPressed(KeyboardEvent keyboardEvent) {
        KEY key = KEY.withCode(keyboardEvent.getKey());
 //       System.out.println("key pressed");
        synchronized (this.inputs) {
            this.inputs.put(keyboardEvent.getKey(), new Input(key, EVENT.KEY_PRESS));
//            System.out.println(key);
        }
    }

    public void keyReleased(KeyboardEvent keyboardEvent) {
        KEY key = KEY.withCode(keyboardEvent.getKey());
        synchronized (this.inputs) {
            this.inputs.remove(keyboardEvent.getKey());
        }
//        activeScreen.process(new Input(key, Input.Type.KEY_RELEASE));
    }

    private void addListener(Keyboard keyboard, int key, KeyboardEventType type) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(type);
        keyboard.addEventListener(event);
    }

    public void showAllMovements() throws InterruptedException {

        synchronized (this.inputs) {
            Iterator var2 = this.inputs.entrySet().iterator();
//            System.out.println("in loop" + var2.hasNext() + "teste" + inputs.values());

            while (var2.hasNext()) {
//                System.out.println("in loop");
                Entry<Integer, Input> entry = (Entry) var2.next();
//                System.out.println("Menu");
                activeScreen.handleInputs(entry.getValue());

            }
        }
    }

    public static void setGameOver(boolean value) {
        stopGame = value;
    }

    public Screens getActiveScreen() {
        return activeScreen;
    }
}