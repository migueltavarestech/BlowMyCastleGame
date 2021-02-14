package org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.weapons.Bomb;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;
import java.util.List;

public class Grid {

    //Player should only be created after the field;
//    public Rectangle field;
    private Picture canvas;
    private static final int PADDING = 10;
    private static final int waterPadding = 50;
    protected static final int cellSize = 40;
    private static int width = 0;
    private static int height = 0;
    private static final int totalCols = 25;
    private static final int totalRows = 18;
    private static Position[] occupiedCells = new Position[0];
    private static List<Bomb> occupiedBombs = new LinkedList<>();

    public Grid() {
        this.width = totalCols * cellSize;
        this.height = totalRows * cellSize;
    }

    int randomInt = 0;

    public void init() {
      canvas = new Picture(PADDING, PADDING, "menuBackground.png");
      canvas.draw();
      setCanvasLimits();
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

    public static void addOccupiedCell(Position element) {
        Position[] tempArr = new Position[occupiedCells.length + 1];
        for(int i = 0; i < occupiedCells.length; ++i) {
            tempArr[i] = occupiedCells[i];
        }
        tempArr[occupiedCells.length] = element;
        occupiedCells = tempArr;
    }

    public static void removeOccupiedCell(Position element) {
        Position[] tempArr = new Position[occupiedCells.length-1];
        int j=0;
        for(int i=0; i<occupiedCells.length; i++){
            if(occupiedCells[i] != element) {
                tempArr[j] = occupiedCells[i];
                j++;
            }
        }
        occupiedCells = tempArr;
    }

    public static Position[] getOccupiedCells() {
        return occupiedCells;
    }

    public static void addOccupiedBombs(Bomb element){
        occupiedBombs.add(element);
    }

    public static List<Bomb> getOccupiedBombs() {
        return occupiedBombs;
    }



    public void setCanvasLimits() {
        // UP Limit
        int y = -1;
        for(int x=0; x<totalCols; x++){
            Position pos = new Position(x,y);
            pos.setCellOccupied(true);
            addOccupiedCell(pos);
        }

        // DOWN Limit
        y = totalRows - 2;
        for(int x=0; x<totalCols; x++){
            Position pos = new Position(x,y);
            pos.setCellOccupied(true);
            addOccupiedCell(pos);
        }

        // LEFT Limit
        int x = -1;
        for(y=0; y<totalRows; y++){
            Position pos = new Position(x,y);
            pos.setCellOccupied(true);
            addOccupiedCell(pos);
        }

        // RIGHT Limit
        x = totalCols;
        for(y=0; y<totalRows; y++){
            Position pos = new Position(x,y);
            pos.setCellOccupied(true);
            addOccupiedCell(pos);
        }
    }
}