package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.weapons;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.GridDirection;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Player;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Position;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.GameObjects;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.castle.Castle;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen.Music;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class Bomb extends GameObjects {

    private Picture bombIcon;
    private int bombAvatar = 40;
    private int bombCol;
    private int bombRow;
    private Position pos;
    private boolean usedBomb = false;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private boolean hitHappened;
    private LinkedList<Castle> castleList;
    private int castleNum;

    public Bomb() {

        bombCol = (int)(Math.random()*(750-250)+250);
        bombRow = (int)(Math.random()*((700-Grid.getPadding()-Grid.getWaterPadding())-(0+Grid.getPadding())));

        bombIcon = new Picture(bombCol,bombRow,"bombIcon.png");
        int randomCol = (int)(Math.random()*(19-6)+6);
        int randomRow = (int)(Math.random()*(16-1)+1);

        bombIcon = new Picture(Grid.columnToX(randomCol),Grid.rowToY(randomRow),"bombIcon.png");
        bombIcon.draw();
        pos = new Position(bombCol, bombRow); // add
    }

    public Bomb(int col, int row) {
        pos = new Position(col, row);
        bombIcon = new Picture(Grid.columnToX(col),Grid.rowToY(row),"bombIcon.png");
        bombIcon.draw();
    }

    public void launchBomb() {
        try {
            final Runnable beeper = new Runnable() {
                public void run() {
                    bombThrowLogic();
                }
            };
            final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 150, 200, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException ex) {
            System.out.println("test");
        }
    }

    public void bombThrowLogic() {
        if(!Position.isNextCellOccupied(GridDirection.LEFT,pos)) {
            bombIcon.translate(-bombAvatar, 0);
            pos.moveInDirection(GridDirection.LEFT);
        } else {
            bombHit();
        }
    }

    public void bombHit(){
        scheduler.shutdownNow();
        if(isItAWall()){
           // wall.hit(damage);
        } else if (isItACastle()){
            castleList.get(castleNum).hit(15);
            System.out.println("it's a hit!");
        }
        bombIcon.delete();
        Music.soundBombExplosion();
    }

    public boolean isItAWall(){
        // Ask wall class
        return false;
    }

    public boolean isItACastle(){
        castleList = Castle.getList();
        for (int i=0; i<2; i++) {
            if (castleList.get(i).isCastle(pos)) {
                castleNum = i;
                return true;
            }
        }
        return false;
    }
}