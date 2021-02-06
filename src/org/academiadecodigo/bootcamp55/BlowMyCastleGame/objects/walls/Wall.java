package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.walls;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.Destroyable;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.GameObjects;

public class Wall extends GameObjects implements Destroyable {

    private WallType wallType;
    private int wallDamage;
    private boolean destroyed = false;
    private Grid pos;

    /**
     * Creates a new wall
     * @param pos           the initial wall position
     * @param wallType      the type of wall
     */

    public Wall(Grid pos, WallType wallType) {
        this.pos = pos;
        this.wallType = wallType;

//        pos.setColor(wallType.getColor())

    }

    /**
     * constructors a new wall  (wallType and initial position on the grid)
     */


    @Override
    public void hit(int hit) {

        if (!destroyed) {
            wallDamage--;

            if (wallDamage == 0) {
                destroyed = true;
            }
        }


    }

    @Override
    public boolean isDestrotyed() {
        return destroyed;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
