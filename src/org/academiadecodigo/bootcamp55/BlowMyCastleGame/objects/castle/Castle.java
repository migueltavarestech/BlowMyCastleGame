package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.castle;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.Destroyable;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.GameObjects;

public class Castle extends GameObjects implements Destroyable {

    private int castleDamage;
    private boolean destroyed;

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
