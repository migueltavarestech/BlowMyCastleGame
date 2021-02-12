package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.walls;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Position;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.Destroyable;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.GameObjects;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Wall extends GameObjects implements Destroyable {

    private WallType wallType;
    private int wallDamage;
    private boolean destroyed = false;
    private Position pos;

    /**
     * Creates a new wall
     * @param pos           the initial wall position
     * @param wallType      the type of wall
     */

    public Wall(Position pos, WallType wallType) {
        this.pos = pos;
        this.wallType = wallType;
        drawbombs();

//        pos.setColor(wallType.getColor())

    }

    private void drawbombs() {
        Picture wall = new Picture(Grid.columnToX(pos.getCol()),Grid.rowToY(pos.getRow()), "resources/Pictures/woodWall.png" );
        wall.draw();
    }


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
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
