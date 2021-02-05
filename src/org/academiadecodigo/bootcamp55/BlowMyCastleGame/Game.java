package org.academiadecodigo.bootcamp55.BlowMyCastleGame;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.ObjectsFactory;

public class Game {

    private Player player1;
    private Player player2;

    public Game() {
        player1 = new Player();
        player2 = new Player();
    }

    public void init() {
        createObjects();

        Grid grid = new Grid();
        grid.init();
    }

    public void start() {}

    public void createObjects(){
        ObjectsFactory factory = new ObjectsFactory();
        factory.init(10, 15);
    }

}
