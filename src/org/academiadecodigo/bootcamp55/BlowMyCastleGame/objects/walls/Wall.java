package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.walls;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Position;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.Destroyable;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.GameObjects;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen.Music;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen.Music.soundBombExplosion;

public class Wall extends GameObjects implements Destroyable {

    private WallType wallType;
    private int wallHealth;
    private boolean destroyed = false;
    private Position pos;
    private Picture wallIcon;

    /**
     * Creates a new wall
     * @param pos           the initial wall position
     * @param wallType      the type of wall
     */

    public Wall(Position pos, WallType wallType) {
        this.pos = pos;
        this.wallType = wallType;
        drawWalls();

//        pos.setColor(wallType.getColor())

    }

    /**
     * draw the wall in the grid for the wall pos
     */
    private void drawWalls() {
        wallIcon = new Picture(Grid.columnToX(pos.getCol()),Grid.rowToY(pos.getRow()), "resources/Pictures/woodWall.png" );
        wallIcon.draw();
    }

    /**
     * deletes the wall from screen, for instance when damaged by the enemy
     */
    public void hideWall() {
        wallIcon.delete();
    }

    public Picture getWall() {
        return wallIcon;
    }

    public Position getPos() {
        return pos;
    }

    /**
     * Checks damage level of Wall upon hit, if destroyed deletes the wall and setCellOccupied to false
     * @param hit
     */
    @Override
    public void hit(int hit) {

        if (!destroyed) {
            wallHealth--;

            if (wallHealth == 0) {
                destroyed = true;
                hideWall();
                Position temp = new Position(pos.getCol(), pos.getRow());
                temp.setCellOccupied(false);
            } else if (wallHealth <= 35) {
                wallIcon.load("/Pictures/woodWall35.png");
            } else if (wallHealth <= 75) {
                wallIcon.load("/Pictures/woodWall75.png");
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
