package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.weapons;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.GameObjects;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.concurrent.TimeUnit;

public class Bomb extends GameObjects {

    private Picture bombIcon;

    public Bomb() {

        int randomX = (int)(Math.random()*(750-250)+250);
        int randomY = (int)(Math.random()*((700-Grid.getPadding()-Grid.getWaterPadding())-(0+Grid.getPadding())));

        bombIcon = new Picture(randomX,randomY,"bombIcon.png");
        bombIcon.draw();
    }

}
