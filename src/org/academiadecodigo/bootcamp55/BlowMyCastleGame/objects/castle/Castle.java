package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.castle;


import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.GridDirection;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Position;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.Destroyable;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.GameObjects;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;
import java.util.List;

public class Castle extends GameObjects implements Destroyable {

    private int castleHealth = 100;
    private boolean destroyed;
    private Picture castleIcon;
    private static int count = 0;
    private HealthBar healthBar;
    private int castleNumber;
    private Position pos;
    private Position[] posArr = new Position[0];
    private static LinkedList<Castle> castleList = new LinkedList();

    public Castle() {
        count++;
        drawCastles();
        healthBar = new HealthBar();
        castleList.add(this);

    }

    @Override
    public void hit(int damage) {
        if (!destroyed) {
            castleHealth = castleHealth - damage;
            healthBar.showDamage(this, damage);
            if (castleHealth <= 0) {
                destroyed = true;
                // set Engine game over
            } else if (castleHealth <= 25) {
                castleIcon.load("castle25.png");
            } else if (castleHealth <= 50) {
                castleIcon.load("castle50.png");
            } else if (castleHealth <= 75) {
                castleIcon.load("castle75.png");
            } else if (castleHealth <= 99) {
                castleIcon.load("castle0.png");
            }
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
        if (count == 1) {
            // First Castle (Left)
            pos = new Position(1,6);
            castleIcon = new Picture(Grid.columnToX(pos.getCol()),Grid.rowToY(pos.getRow()),"castle.png");
            castleIcon.draw();
            castleNumber = 1;

            for (int x=1; x<4; x++) {
                for (int y=6; y<9; y++) {
                    Position pos = new Position(x, y);
                    pos.setCellOccupied(true);
                    Grid.addOccupiedCell(pos);
                    addCastlePos(pos);
                }
            }
        } else {
            // Second Castle (Right)
            pos = new Position(21,6);
            castleIcon = new Picture(Grid.columnToX(pos.getCol()),Grid.rowToY(pos.getRow()),"castle.png");
            castleIcon.draw();
            castleNumber = 2;

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
            // Implementar LEFT (Col + 1) / UP (Row -1) / DOWN (Row + 1)
        }
        return false;
    }

}
