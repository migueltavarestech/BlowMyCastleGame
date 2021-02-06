package org.academiadecodigo.bootcamp55.BlowMyCastleGame;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class Grid {

    //Player should only be created after the field;
    public Rectangle field;

    public void init() {
      field = new Rectangle(0, 0, 800, 500);
      field.draw();
    }
}