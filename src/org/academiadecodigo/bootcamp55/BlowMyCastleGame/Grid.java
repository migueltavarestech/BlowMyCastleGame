package org.academiadecodigo.bootcamp55.BlowMyCastleGame;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Grid {

    //Player should only be created after the field;
//    public Rectangle field;
    private Picture canvas;
    private static final int PADDING = 10;
    private static final int waterPadding = 50;
    private static final int cellSize = 40;
    private static int width = 0;
    private static int height = 0;
    private static final int totalCols = 25;
    private static final int totalRows = 18;

    public Grid() {
        this.width = totalCols * cellSize;
        this.height = totalRows * cellSize;
    }

    public void init() {
      canvas = new Picture(PADDING, PADDING, "background2.png");
      canvas.draw();
    }

    public static int getPadding() {
        return PADDING;
    }

    public static int getWaterPadding() {
        return waterPadding;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static int getCellSize() {
        return cellSize;
    }

    public static int rowToY(int row) {
        return row * cellSize + PADDING;
    }

    public static int columnToX(int col) {
        return col * cellSize + PADDING;
    }

    public static int getTotalCols(){
        return totalCols;
    }

    public static int getTotalRows() {
        return totalRows;
    }

}