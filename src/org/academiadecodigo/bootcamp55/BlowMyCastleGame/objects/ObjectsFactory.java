package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.GameLevel;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.castle.Castle;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.walls.Wall;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.weapons.Bomb;

import java.util.concurrent.TimeUnit;

public class ObjectsFactory {

    private int bombs = 0;
    private int walls = 0;
    private Bomb[] bomb;
    private Wall[] wall;

    public void init(GameLevel gameLevel)  {
        switch (gameLevel) {
            case LEVEL1:
                bombs = 10;
                walls = 10;
                break;
            case LEVEL2:
                bombs = 15;
                walls = 15;
                break;
            case LEVEL3:
                bombs = 20;
                walls = 20;
                break;
        }
        this.bombs = bombs;
        this.walls = walls;
    }

    public void createCastles() {
        Castle castle1 = new Castle();
        Castle castle2 = new Castle();
    }

    public void createBombs() {
        // Wait 10 seconds before creating first bombs
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException ex) {
            System.out.println("Interrupted Exception happened.");
            Thread.currentThread().interrupt();
        }

        // Create bombs according with chosen GameLevel
        bomb = new Bomb[bombs];
        for (int i=0; i < bomb.length; i++) {
            bomb[i] = new Bomb();
        }
    }

    /** create initial set-up of wall bricks
     *
     */
}
