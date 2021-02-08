package org.academiadecodigo.bootcamp55.BlowMyCastleGame;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.ObjectsFactory;

public class Game {

    private Player player1;
    private Player player2;

    public Game() {
    }

    public void init() {
        Grid grid = new Grid();
        grid.init();

        player1 = new Player();
        player2 = new Player();

 //       MyKeyboard myKeyboard = new MyKeyboard(player1, player2);
        //       myKeyboard.init();
        createObjects();

        Engine engine = new Engine(player1, player2);
        engine.init();
        engine.start();


    }

    public void start() {}

    public void createObjects() {
        ObjectsFactory factory = new ObjectsFactory();
        factory.init(GameLevel.LEVEL3);
        factory.createCastles();
//        factory.createBombs();
    }

}
