package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.walls;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Position;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.Destroyable;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.GameObjects;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Wall extends GameObjects implements Destroyable {

    private WallType wallType;
    private int wallDamage;
    private boolean destroyed = false;
    private Position pos;
    private Picture wall;

    /**
     * Creates a new wall
     * @param pos           the initial wall position
     * @param wallType      the type of wall
     */
    public Wall(Position pos, WallType wallType) {
        this.pos = pos;
        this.wallType = wallType;
        drawWall(pos);
    }

    /**
     * draw the wall in the grid for the wall pos
     */
    private void drawWall(Position position) {
        wall = new Picture(Grid.columnToX(position.getCol()),Grid.rowToY(position.getRow()), "resources/Pictures/woodWall.png" );
        wall.draw();
    }

    /**
     * deletes the wall from screen, for instance when damaged by the enemy
     */
    public void hideWall() {
        wall.delete();
    }

    public Picture getWall() {
        return wall;
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
            wallDamage--;

            if (wallDamage == 0) {
                destroyed = true;
                hideWall();
                Position temp = new Position(pos.getCol(), pos.getRow());
                temp.setCellOccupied(false);
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
