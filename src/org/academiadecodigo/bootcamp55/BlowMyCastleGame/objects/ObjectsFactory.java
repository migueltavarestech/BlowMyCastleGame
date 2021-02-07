package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.castle.Castle;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.walls.Wall;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.weapons.Bomb;

import java.util.concurrent.TimeUnit;

public class ObjectsFactory {

    public void init(int bombs, int wallBlocks)  {

    }

    public void createCastles() {
        Castle castle1 = new Castle();
        Castle castle2 = new Castle();
    }

    public void createBombs(int bombs) {
        // Wait 10 seconds before creating first bombs
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException ex) {
            System.out.println("Interrupted Exception happened.");
            Thread.currentThread().interrupt();
        }

        // Create x number of bombs
        for (int i=0; i<=bombs; i++) {
            Bomb bomb = new Bomb();
        }
    }

    /** create initial set-up of wall bricks
     *
     */
}
