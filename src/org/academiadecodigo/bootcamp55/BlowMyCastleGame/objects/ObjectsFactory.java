package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Position;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.games.GameLevel;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.castle.Castle;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.walls.Wall;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.walls.WallType;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.weapons.Bomb;

import java.util.concurrent.TimeUnit;

public class ObjectsFactory {

    private int bombs = 0;
    private int walls = 0;
    private Bomb[] bomb;
    private Wall[] wall;

    public void init(GameLevel gameLevel)  {
        this.bombs = gameLevel.getBomb();
        this.walls = gameLevel.getWall();
    }

    public void createCastles() {
        Castle castle1 = new Castle();
        Castle castle2 = new Castle();

        // Temporary hit/damage, proof that health bar works;
        castle1.hit(60);
        castle2.hit(40);
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

    public void createWalls(int nrPlayer) {
        wall = new Wall[this.walls * 2];
        Position pos;
        int deltaPos = 1;

        for (int i = 0; i < wall.length / 2; i++) {
            pos = new Position(1 + i * deltaPos, 14);
            wall[i] = new Wall(pos, WallType.WOOD);

        }

        for (int i = wall.length / 2; i < wall.length; i++) {
//            System.out.println(i);
            pos = new Position(24 + (i - wall.length) * deltaPos, 14);
            wall[i] = new Wall(pos, WallType.WOOD);
        }
    }


}
