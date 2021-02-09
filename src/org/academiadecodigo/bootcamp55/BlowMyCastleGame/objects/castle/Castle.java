package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.castle;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Position;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.Destroyable;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.GameObjects;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Castle extends GameObjects implements Destroyable {

    private int castleHealth = 100;
    private boolean destroyed;
    private Picture castleIcon;
    private static int count = 0;
    private static Position castle1Pos;
    private static Position castle2Pos;
    private HealthBar healthBar;
    private int castleNumber;

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

    public static Position getCastle1Pos() {
        return castle1Pos;
    }

    public static Position getCastle2Pos() {
        return castle2Pos;
    }

    public int getCastleNumber() { return castleNumber; }

    public void drawCastles() {
        if (count == 1) {
            // First Castle (Left)
            castle1Pos = new Position(1,6);
            castleIcon = new Picture(Grid.columnToX(castle1Pos.getCol()),Grid.rowToY(castle1Pos.getRow()),"castle.png");
            castleIcon.draw();
            castleNumber = 1;
        } else {
            // Second Castle (Right)
            castle2Pos = new Position(21,6);
            castleIcon = new Picture(Grid.columnToX(castle2Pos.getCol()),Grid.rowToY(castle2Pos.getRow()),"castle.png");
            castleIcon.draw();
            castleNumber = 2;
        }
    }


}
