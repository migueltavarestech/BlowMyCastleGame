package org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Inventory {

    private Picture bombIcon;
    private Picture wallsIcon;
    private int bombsNumber;
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
        } else {
            bombIcon = new Picture(Grid.columnToX(18)-10,Grid.rowToY(16)+Grid.getPadding()+20,"bombInventory.png");
            bombIcon.draw();
            drawBombText();
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
}
