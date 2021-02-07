package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.weapons;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.GameObjects;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bomb extends GameObjects {

    private Picture bombIcon;
    private int bombCol;
    private int bombRow;

    public Bomb() {

        bombCol = (int)(Math.random()*(750-250)+250);
        bombRow = (int)(Math.random()*((700-Grid.getPadding()-Grid.getWaterPadding())-(0+Grid.getPadding())));

        bombIcon = new Picture(bombCol,bombRow,"bombIcon.png");
        int randomCol = (int)(Math.random()*(19-6)+6);
        int randomRow = (int)(Math.random()*(16-1)+1);

        bombIcon = new Picture(Grid.columnToX(randomCol),Grid.rowToY(randomRow),"bombIcon.png");
        bombIcon.draw();
    }

    public int getBombCol(){
        return bombCol;
    }

    public int getBomRow(){
        return bombRow;
    }

}
