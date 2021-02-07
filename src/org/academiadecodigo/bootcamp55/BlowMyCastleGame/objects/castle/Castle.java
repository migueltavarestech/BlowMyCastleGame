package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.castle;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.Destroyable;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.GameObjects;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Castle extends GameObjects implements Destroyable {

    private int castleDamage;
    private boolean destroyed;
    private Picture castleIcon;
    private static int count = 0;
    private static final int castleSize = 100;

    public Castle() {

        count++;
        if (count == 1) {
            // First Castle (Left)
            int Xpos = 100 ;
            int Ypos = 700/2 - castleSize/2;
            castleIcon = new Picture(Xpos,Ypos,"castle.png");
            castleIcon.draw();
        } else {
            // Second Castle (Right)
            int Xpos = 900 - castleSize;
            int Ypos = 700/2 - castleSize/2;
            castleIcon = new Picture(Xpos,Ypos,"castle.png");
            castleIcon.draw();
        }
    }

    @Override
    public void hit(int hit) {

        if (!destroyed) {
            castleDamage--;

            if (castleDamage == 0) {
                destroyed = true;
            }
        }

    }

    @Override
    public boolean isDestrotyed() {
        return destroyed;
    }


}
