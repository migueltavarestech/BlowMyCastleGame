package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects;


import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.GridDirection;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.weapons.Bomb;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ConcurrentModificationException;


public class Inventory {

    private Picture bombIcon;
    private Picture wallsIcon;
    private int bombsNumber;
    private int wallsNumber;
    private Text bombsNumText;
    private Text wallsNumText;
    private Rectangle bombsTextBackground;
    private Rectangle wallsTextBackground;
    private int nrPlayer;
    private static final String bombIconPath = "/Users/MiguelTavares/BlowMyCastleGame/resources/bombInventory.png";
    private static final String iconPath = "/Users/MiguelTavares/BlowMyCastleGame/resources/woodWallInventory.png";

    public Inventory(int bombsNumber, int wallsNumber, int nrPlayer) {
        this.bombsNumber = bombsNumber;
        this.wallsNumber = wallsNumber;
        this.nrPlayer = nrPlayer;
    }

    public void initialDraw() {

        if (nrPlayer == 1){

            bombIcon = new Picture(Grid.columnToX(6) + Grid.getPadding(), Grid.rowToY(16) + Grid.getPadding() + 20, bombIconPath);
            bombIcon.draw();
            drawBombText();

            wallsIcon = new Picture(bombIcon.getX() + 40, bombIcon.getY(), iconPath);
            wallsIcon.draw();
            drawWallsInfo();

            return;
            }
        if (nrPlayer == 2) {

            bombIcon = new Picture(Grid.columnToX(18) - 10, Grid.rowToY(16) + Grid.getPadding() + 20, bombIconPath);
            bombIcon.draw();
            drawBombText();

            wallsIcon = new Picture(bombIcon.getX() - 40, bombIcon.getY(), iconPath);
            wallsIcon.draw();
            drawWallsInfo();
        }

    }

    public void drawBombText(){
        try {
            bombsNumText = new Text(bombIcon.getX() + 15, bombIcon.getY() - 10, "" + bombsNumber);
            bombsNumText.grow(2, 2);

            bombsTextBackground = new Rectangle(bombsNumText.getX() - 2.5, bombsNumText.getY() - 2.5, bombsNumText.getWidth(), bombsNumText.getHeight());
            bombsTextBackground.setColor(Color.WHITE);
            bombsTextBackground.fill();
            bombsNumText.draw();
        } catch (ConcurrentModificationException ex) {
            System.out.println("ConcurrentModificationException");
        }
    }

    private void drawWallsInfo(){
        try {
            wallsNumText = new Text(wallsIcon.getX() + 14, wallsIcon.getY() - 10, "" + wallsNumber);
            wallsNumText.grow(2, 2);
            wallsTextBackground = new Rectangle(wallsNumText.getX() - 2.5, wallsNumText.getY() - 2.5, wallsNumText.getWidth(), wallsNumText.getHeight());
            wallsTextBackground.setColor(Color.WHITE);
            wallsTextBackground.fill();
            wallsNumText.draw();
        } catch (ConcurrentModificationException ex) {
        System.out.println("ConcurrentModificationException");
        }
    }

    public void useBomb(int col, int row, GridDirection lastDirection) throws InterruptedException {
        if (bombsNumber > 0){
            bombsNumber -= 1;
            Bomb bomb = new Bomb(col, row); //a criar uma nova, mas é suposto utilizar das que capturarmos
            bomb.launchBomb(lastDirection);
            bombsNumText.delete();
            drawBombText();
        } else {
            System.out.println("There are no more bombs available");
        }
    }

    public void useWall(){
        if (wallsNumber >0){
            wallsNumber--;
            wallsNumText.delete();
            wallsTextBackground.delete();
            drawWallsInfo();
        }
    }

    public void incrementBomb(){
        bombsNumber += 1;
        bombsNumText.delete();
        bombsTextBackground.delete();
        drawBombText();
    }

    public void incrementWall(){
        wallsNumber += 1;
        wallsNumText.delete();
        wallsTextBackground.delete();
        drawWallsInfo();
    }

    public void hide() {
        wallsIcon.delete();
        wallsNumText.delete();
        wallsTextBackground.delete();

        bombIcon.delete();
        bombsNumText.delete();
        bombsTextBackground.delete();
    }


    public int getWallsNumber() {
        return wallsNumber;
    }
}
