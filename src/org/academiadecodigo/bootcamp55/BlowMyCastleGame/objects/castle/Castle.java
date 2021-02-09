package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.castle;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Position;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.Destroyable;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.GameObjects;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Castle extends GameObjects implements Destroyable {

    private int castleDamage;
    private boolean destroyed;
    private Picture castleIcon;
    private static int count = 0;
    private static final int castleSize = 100;
    private static Position castle1Pos;
    private static Position castle2Pos;

    public Castle() {

        count++;
        if (count == 1) {
            // First Castle (Left)
            castle1Pos = new Position(1,6);
            castleIcon = new Picture(Grid.columnToX(castle1Pos.getCol()),Grid.rowToY(castle1Pos.getRow()),"castle.png");
            castleIcon.draw();
        } else {
            // Second Castle (Right)
            castle2Pos = new Position(21,6);
            castleIcon = new Picture(Grid.columnToX(castle2Pos.getCol()),Grid.rowToY(castle2Pos.getRow()),"castle.png");
            castleIcon.draw();
        }
    }

    @Override
    public void hit(int hit) {

        if (!destroyed) {
            castleDamage--;

            if (castleDamage == 0) {
                destroyed = true;
            }
        }

    }

    @Override
    public boolean isDestrotyed() {
        return destroyed;
    }

    public int getCastleSize() {
        return castleSize;
    }

    public static Position getCastle1Pos() {
        return castle1Pos;
    }

    public int getCastle1Col(){
        return castle1Pos.getCol();
    }

    public static Position getCastle2Pos() {
        return castle2Pos;
    }
}
