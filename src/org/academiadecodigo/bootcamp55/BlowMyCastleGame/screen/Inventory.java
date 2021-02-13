package org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.weapons.Bomb;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Inventory {

    private Picture bombIcon;
    private Picture wallsIcon;
    private int bombsNumber = 5; // martelei bombas para teste
    private int wallsNumber;
    private Text bombsNumText;
    private Text wallsNumText;
    private Rectangle bombsTextBackground;
    private Rectangle wallsTextBackground;

    public Inventory(int bombsNumber, int wallsNumber) {
       this.bombsNumber = bombsNumber;
       this.wallsNumber = wallsNumber;
    }

    public void initialDraw(int playerNum){
        if (playerNum == 1) {
            bombIcon = new Picture(Grid.columnToX(6)+Grid.getPadding(),Grid.rowToY(16)+Grid.getPadding()+20,"bombInventory.png");
            bombIcon.draw();
            drawBombText();

            wallsIcon = new Picture(bombIcon.getX()+40, bombIcon.getY(), "resources/woodWallInventory.png");
            wallsIcon.draw();
            drawWallsInfo();
        } else {
            bombIcon = new Picture(Grid.columnToX(18)-10,Grid.rowToY(16)+Grid.getPadding()+20,"bombInventory.png");
            bombIcon.draw();
            drawBombText();

            wallsIcon = new Picture(bombIcon.getX()-40, bombIcon.getY(), "resources/woodWallInventory.png");
            wallsIcon.draw();
            drawWallsInfo();
        }
    }

    private void drawBombText(){
        bombsNumText = new Text(bombIcon.getX()+15, bombIcon.getY()-10, "" + bombsNumber);
        bombsNumText.grow(2,2);

        bombsTextBackground = new Rectangle(bombsNumText.getX()-2.5, bombsNumText.getY()-2.5, bombsNumText.getWidth(), bombsNumText.getHeight());
        bombsTextBackground.setColor(Color.WHITE);
        bombsTextBackground.fill();
        bombsNumText.draw();
    }

    private void drawWallsInfo(){
        wallsNumText = new Text(wallsIcon.getX()+14, wallsIcon.getY()-10, "" + wallsNumber);
        wallsNumText.grow(2,2);
        wallsTextBackground = new Rectangle(wallsNumText.getX()-2.5, wallsNumText.getY()-2.5, wallsNumText.getWidth(), wallsNumText.getHeight());
        wallsTextBackground.setColor(Color.WHITE);
        wallsTextBackground.fill();
        wallsNumText.draw();
    }

    public void useBomb(int col, int row) throws InterruptedException {
        if (bombsNumber > 0){
            bombsNumber -= 1;
            Bomb bomb = new Bomb(col, row); //a criar uma nova, mas é suposto utilizar das que capturarmos
            bomb.launchBomb();
        }
        else {
            System.out.println("There are no more bombs available");
        }
    }

    public void useWall(){
        wallsNumber += 1;
    }

    public void incrementBomb(){
        bombsNumber += 1;
    }

    public void incrementWall(){
        wallsNumber += 1;
    }
}
