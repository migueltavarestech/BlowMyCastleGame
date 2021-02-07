package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.weapons;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.GameObjects;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.concurrent.TimeUnit;

public class Bomb extends GameObjects {

    private Picture bombIcon;
    private int bombCol;
    private int bombRow;

    public Bomb() {

        bombCol = (int)(Math.random()*(750-250)+250);
        bombRow = (int)(Math.random()*((700-Grid.getPadding()-Grid.getWaterPadding())-(0+Grid.getPadding())));

        bombIcon = new Picture(bombCol,bombRow,"bombIcon.png");
        bombIcon.draw();
    }

    public int getBombCol(){
        return bombCol;
    }

    public int getBomRow(){
        return bombRow;
    }

}
