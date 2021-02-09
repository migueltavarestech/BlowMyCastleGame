package org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen;

import org.academiadecodigo.simplegraphics.graphics.Text;

public class GameScreens {

    public GameScreens() {
    }

    public void startScreen() {

        Text text = new Text(500,200,"Press S to Start");
        text.draw();
        Text text1 = new Text(500,220,"Press P to Pratice");
        text1.draw();
        Text text2 = new Text(500,240,"Press I to Pratice");
        text2.draw();
        Text text3 = new Text(500,260,"Press Q to Quit");
        text3.draw();
    }

    public void hideStartScreen() {


    }
}


