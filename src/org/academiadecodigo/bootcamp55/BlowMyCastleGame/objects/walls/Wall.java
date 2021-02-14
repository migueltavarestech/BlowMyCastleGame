package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.walls;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.GridDirection;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Position;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.Destroyable;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.GameObjects;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.castle.Castle;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.weapons.Bomb;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen.Music;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

import static org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen.Music.soundBombExplosion;

public class Wall extends GameObjects implements Destroyable {

    private WallType wallType;
    private int wallHealth = 50;
    private boolean destroyed = false;
    private Position pos;
    private Picture wallIcon;
    private static Position[] posArr = new Position[0];
    private static LinkedList<Wall> wallList = new LinkedList();

    /**
     * Creates a new wall
     * @param pos           the initial wall position
     * @param wallType      the type of wall
     */

    public Wall(Position pos, WallType wallType) {
        this.pos = pos;
        this.wallType = wallType;
        drawWalls();
        wallList.add(this);
        addWallPos(pos);
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
            wallHealth -= hit;

            if (wallHealth == 0) {
                destroyed = true;
                hideWall();
                Position temp = new Position(pos.getCol(), pos.getRow());
                temp.setCellOccupied(false);
                wallIcon.delete();
            } else if (wallHealth <= 15) {
                wallIcon.load("/Pictures/woodWall35.png");
            } else if (wallHealth <= 35) {
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

    public void addWallPos(Position element) {
        Position[] tempArr = new Position[posArr.length + 1];
        for(int i = 0; i < posArr.length; ++i) {
            tempArr[i] = posArr[i];
        }
        tempArr[posArr.length] = element;
        posArr = tempArr;
    }

    public boolean isWall(Position bombPos, GridDirection direction){
        for (Position position : posArr) {
            if(direction == GridDirection.LEFT) {
                if (position.getCol() == bombPos.getCol() - 1 &&
                        position.getRow() == bombPos.getRow()) {
                    return true;
                }
            } else if (direction == GridDirection.RIGHT) {
                if (position.getCol() == bombPos.getCol() + 1 &&
                        position.getRow() == bombPos.getRow()) {
                    return true;
                }
            } else if (direction == GridDirection.UP) {
                if (position.getCol() == bombPos.getCol() &&
                        position.getRow() == bombPos.getRow() - 1) {
                    return true;
                }
            } else if (direction == GridDirection.DOWN) {
                if (position.getCol() == bombPos.getCol() &&
                        position.getRow() == bombPos.getRow() + 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static LinkedList<Wall> getWallList() {
        return wallList;
    }
}
