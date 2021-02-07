package org.academiadecodigo.bootcamp55.BlowMyCastleGame;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Grid {

    //Player should only be created after the field;
//    public Rectangle field;
    private Picture canvas;
    private int PADDING = 10;

    public void init() {
//      field = new Rectangle(0, 0, 800, 500);
//      field.draw();

      canvas = new Picture(PADDING, PADDING, "background.png");
      canvas.draw();
    }
}