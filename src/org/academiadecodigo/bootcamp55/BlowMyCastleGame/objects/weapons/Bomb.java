package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.weapons;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.GridDirection;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Position;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Player;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.GameObjects;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.castle.Castle;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.walls.Wall;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen.Music;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class Bomb extends GameObjects {

    private Picture bombIcon;
    private Picture explosionIcon;
    private int bombAvatar = 40;
    private final static int bombDamage = 10;
    private Position pos;
    private boolean usedBomb = false;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final ScheduledExecutorService scheduler2 = Executors.newScheduledThreadPool(1);
    private boolean hitHappened;
    private LinkedList<Castle> castleList;
    private LinkedList<Wall> wallList;
    private int castleNum;
    private int wallNum;

    public Bomb() {

        int randomCol = (int)(Math.random()*(17-8)+8);
        int randomRow = (int)(Math.random()*(16-1)+1);
        pos = new Position(randomCol, randomRow);

        bombIcon = new Picture(Grid.columnToX(randomCol),Grid.rowToY(randomRow),"bombIcon.png");
        Grid.addOccupiedBombs(pos);
        bombIcon.draw();
        // System.out.println("pos bomb//col: " + pos.getCol() + "//row: " + pos.getRow());
    }

    public Bomb(int col, int row) {
        pos = new Position(col, row);
        bombIcon = new Picture(Grid.columnToX(col),Grid.rowToY(row),"bombIcon.png");
        bombIcon.draw();
    }

    public void launchBomb(final GridDirection lastDirection) {
        try {
            final Runnable beeper = new Runnable() {
                public void run() {
                    bombThrowLogic(lastDirection);
                }
            };
            final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 150, 200, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException ex) {
            System.out.println("test");
        }
    }

    public void bombThrowLogic(GridDirection lastDirection) {
        if (lastDirection == GridDirection.LEFT){
            if(!Position.isNextCellOccupied(GridDirection.LEFT,pos)) {
                bombIcon.translate(-bombAvatar, 0);
                pos.moveInDirection(GridDirection.LEFT);
            } else {
                bombHit(lastDirection);
            }
        }
         else if(lastDirection == GridDirection.RIGHT){
            if(!Position.isNextCellOccupied(GridDirection.RIGHT,pos)) {
                bombIcon.translate(bombAvatar, 0);
                pos.moveInDirection(GridDirection.RIGHT);
            } else {
                bombHit(lastDirection);
            }
        }
        else if (lastDirection == GridDirection.DOWN) {
            if (!Position.isNextCellOccupied(GridDirection.DOWN, pos)) {
                bombIcon.translate(0, bombAvatar);
                pos.moveInDirection(GridDirection.DOWN);
            } else {
                bombHit(lastDirection);
            }
        }
        else if (lastDirection == GridDirection.UP) {
            if (!Position.isNextCellOccupied(GridDirection.UP, pos)) {
                bombIcon.translate(0, -bombAvatar);
                pos.moveInDirection(GridDirection.UP);
            } else {
                bombHit(lastDirection);
            }
        }
    }

    public void bombHit (GridDirection lastDirection) {
        scheduler.shutdownNow();
        if(isItAWall(lastDirection)){
            wallList.get(wallNum).hit(bombDamage);
            System.out.println("It's a wall hit!");
            Music.soundBombExplosion();
            explosionIcon = new Picture(Grid.columnToX(pos.getCol()),Grid.rowToY(pos.getRow()),"explosionIcon.png");
            explosionIcon.draw();
            deleteExplosion();
        } else if (isItACastle(lastDirection)){
            castleList.get(castleNum).hit(bombDamage);
            System.out.println("it's a castle hit!");
            Music.soundBombExplosion();
            explosionIcon = new Picture(Grid.columnToX(pos.getCol()),Grid.rowToY(pos.getRow()),"explosionIcon.png");
            explosionIcon.draw();
            deleteExplosion();
        }
        bombIcon.delete();
    }
    public void hide(Position pos){
        bombIcon.delete();
    }

    public boolean isItAWall(GridDirection lastDirection){
        wallList = Wall.getWallList();
        for (Wall wall : wallList) {
            if(wall.isWall(pos, lastDirection)){
                wallNum = wallList.indexOf(wall);
                return true;
            }
        }
        return false;
    }

    public boolean isItACastle(GridDirection lastDirection){
        castleList = Castle.getList();
        for (int i=0; i<2; i++) {
            if (castleList.get(i).isCastle(pos, lastDirection)) {
                castleNum = i;
                return true;

            }
        }
        return false;
    }

    public Position getPos() {
        return this.pos;
    }

    private void deleteExplosion() {
        try {
            final Runnable beeper2 = new Runnable() {
                public void run() {
                    explosionIcon.delete();
                }
            };
            final ScheduledFuture<?> beeperHandle = scheduler2.scheduleAtFixedRate(beeper2, 150, 150, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException ex) {
            System.out.println("test");
        }
    }

    public static int getBombDamage() {
        return bombDamage;
    }
}