package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.castle;


import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Engine;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.GridDirection;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Position;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.Destroyable;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.GameObjects;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.weapons.Bomb;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class Castle extends GameObjects implements Destroyable {

    private int castleHealth;
    private boolean destroyed;
    private Picture castleIcon;
    private Picture gameOver = new Picture(Grid.columnToX(8), Grid.rowToY(0), "gameOver2.png");
    private static int count = 0;
    private HealthBar healthBar;
    private int castleNumber;
    private Position pos;
    private Position[] posArr = new Position[0];
    private static LinkedList<Castle> castleList = new LinkedList();
    private final ScheduledExecutorService scheduler3 = Executors.newScheduledThreadPool(1);

    public Castle(int castleNumber) {
        this.castleNumber = castleNumber;
        castleHealth = 100;
        destroyed = false;
        drawCastles();
        healthBar = new HealthBar(castleNumber);
        castleList.add(this);
    }

    @Override
    public void hit(int damage) {
        if (!destroyed) {
            castleHealth = castleHealth - damage;
            healthBar.showDamage(this, damage);
            if (castleHealth <= 0) {
                castleIcon.load("castle0.png");
                destroyed = true;
                gameOver.draw();
//                for (Castle castle : castleList) {
//                    castle.clearPosArr();
//                }
                Engine.setGameOver(true);
                // endGame();
                // set Engine game over
            } else if (castleHealth <= 25) {
                castleIcon.load("castle25.png");
            } else if (castleHealth <= 50) {
                castleIcon.load("castle50.png");
            } else if (castleHealth <= 75) {
                castleIcon.load("castle75.png");
            }
        }
    }

    public void endGame() {
        try {
            final Runnable beeper3 = new Runnable() {
                public void run() {
                    System.exit(0);
                }
            };
            final ScheduledFuture<?> beeperHandle = scheduler3.scheduleAtFixedRate(beeper3, 2, 1, TimeUnit.SECONDS);
        } catch (RejectedExecutionException ex) {
            System.out.println("RejectedExecutionException");
        }
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    public Position getPos() {
        return pos;
    }

    public int getCastleNumber() { return castleNumber; }

    public void drawCastles() {
        if (castleNumber == 1) {
            // First Castle (Left)
            pos = new Position(1,6);
            castleIcon = new Picture(Grid.columnToX(pos.getCol()),Grid.rowToY(pos.getRow()),"castle.png");
            castleIcon.draw();

            for (int x=1; x<4; x++) {
                for (int y=6; y<9; y++) {
                    Position pos = new Position(x, y);
                    pos.setCellOccupied(true);
                    Grid.addOccupiedCell(pos);
                    addCastlePos(pos);
                }
            }
        } else if (castleNumber == 2) {
            // Second Castle (Right)
            pos = new Position(21,6);
            castleIcon = new Picture(Grid.columnToX(pos.getCol()),Grid.rowToY(pos.getRow()),"castle.png");
            castleIcon.draw();

            for (int x=21; x<24; x++) {
                for (int y=6; y<9; y++) {
                    Position pos = new Position(x, y);
                    pos.setCellOccupied(true);
                    Grid.addOccupiedCell(pos);
                    addCastlePos(pos);
                }
            }
        }
    }

    public void addCastlePos(Position element) {
        Position[] tempArr = new Position[posArr.length + 1];
        for(int i = 0; i < posArr.length; ++i) {
            tempArr[i] = posArr[i];
        }
        tempArr[posArr.length] = element;
        posArr = tempArr;
    }

    public Position[] getPosArr(){
        return posArr;
    }

    public static LinkedList<Castle> getList(){return castleList;}

    public boolean isCastle(Position bombPos, GridDirection direction){
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

    public void clearPosArr() {
        Position[] tempArr = new Position[0];
        posArr = tempArr;
    }

    public static void clearCastleList() {
        castleList.clear();
    }

}
