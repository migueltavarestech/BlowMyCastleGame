package org.academiadecodigo.bootcamp55.BlowMyCastleGame;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.games.GameLevel;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.ObjectsFactory;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen.Music;

public class Game {

    private Player player1;
    private Player player2;

    public Game() {
    }

    public void init() {
 //       Grid grid = new Grid();
//        grid.init();
        //       MyKeyboard myKeyboard = new MyKeyboard(player1, player2);
        //       myKeyboard.init();
//        createObjects();
        Engine engineSelect = new Engine();
        engineSelect.init();
//        engineSelect.startEngine();


    }

        public void start() {
            player1 = new Player(1);
            player2 = new Player(2);

            Engine engine = new Engine(player1, player2);
            engine.init();
            engine.start();
        }

    public void createObjects() {
        ObjectsFactory factory = new ObjectsFactory();
        factory.init(GameLevel.LEVEL3);
        factory.createCastles();
//        factory.createBombs();
    }

}
