package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.walls.Wall;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.weapons.Bomb;

public class ObjectsFactory {

    public void init(int bombs, int wallBlocks) {
        for (int i=0; i<=bombs; i++){
            Bomb bomb = new Bomb();
        }

 //       for (int a=0; a<=wallBlocks; a++) {
 //           Wall wallBlock = new Wall();
 //       }
    }
    /** create initial set-up of wall bricks
     *
     */
}
