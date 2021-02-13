package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.castle;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Position;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.Destroyable;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.GameObjects;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Castle extends GameObjects implements Destroyable {

    private int castleHealth = 100;
    private boolean destroyed;
    private Picture castleIcon;
    private static int count = 0;
    private HealthBar healthBar;
    private int castleNumber;
    private Position pos;

    public Castle() {
        count++;
        drawCastles();
        healthBar = new HealthBar();
    }

    @Override
    public void hit(int damage) {
        if (!destroyed) {
            castleHealth = castleHealth - damage;
            healthBar.showDamage(this, damage);
            if (castleHealth <= 0) {
                destroyed = true;
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
                }
            }
        }
    }


}
