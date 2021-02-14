package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects;



import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Position;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.games.GameLevel;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.castle.Castle;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.walls.Wall;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.walls.WallType;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.weapons.Bomb;

import java.util.concurrent.*;

public class ObjectsFactory {

    private int bombs = 0;
    private int walls = 0;
    private Bomb[] bomb;
    private Wall[] wall;
    private final ScheduledExecutorService scheduler3 = Executors.newScheduledThreadPool(1);

    public void init(GameLevel gameLevel)  {
        this.bombs = gameLevel.getBomb();
        this.walls = gameLevel.getWall();
    }

    public void createCastles() {
        Castle castle1 = new Castle();
        Castle castle2 = new Castle();

        // Temporary hit/damage, proof that health bar works;
//        castle1.hit(60);
//        castle2.hit(40);
    }

    public void createBombs() {
        bomb = new Bomb[bombs];
        try {
            final Runnable beeper3 = new Runnable() {
                public void run() {
                    for (int i=0; i < bomb.length; i++) {
                        bomb[i] = new Bomb();
                    }
                    scheduler3.shutdownNow();
                }
            };
            final ScheduledFuture<?> beeperHandle = scheduler3.scheduleAtFixedRate(beeper3, 20, 1, TimeUnit.SECONDS);
        } catch (RejectedExecutionException ex) {
            System.out.println("test");
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
