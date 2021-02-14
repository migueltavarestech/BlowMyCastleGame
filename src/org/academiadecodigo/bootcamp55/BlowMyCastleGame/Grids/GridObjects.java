package org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.Inventory;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GridObjects extends Grid{

    Picture picture;

    public GridObjects() {
        super();
    }

    public void showPicture(Position pos, String path){
        picture = new Picture(pos.getCol()*cellSize,pos.getRow()*cellSize, path);
    }

    public void showPicture(int col, int row, String path) {
        picture = new Picture(col*cellSize, row*cellSize, path);
    }

    public void hidePicture(Picture pic){
        pic.delete();
    }

    public void showInventory(int nrPlayer){

        if (nrPlayer == 1){
            Position pos = new Position(4,8);
            Picture playerAvatar = new Picture(Grid.columnToX(pos.getCol()),Grid.rowToY(pos.getRow()),"player1.png");
            playerAvatar.draw();

           // inventory = new Inventory(15,10);
            // inventory.initialDraw(1);

        }
    }
}

