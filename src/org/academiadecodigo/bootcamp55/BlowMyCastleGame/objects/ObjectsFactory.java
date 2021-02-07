package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.walls.Wall;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.weapons.Bomb;

import java.util.concurrent.TimeUnit;

public class ObjectsFactory {

    public void init(int bombs, int wallBlocks)  {

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException ex) {
            System.out.println("Interrupted Exception happened.");
            Thread.currentThread().interrupt();
        }

        for (int i=0; i<=bombs; i++) {
            Bomb bomb = new Bomb();
        }
    }

    /** create initial set-up of wall bricks
     *
     */
}
