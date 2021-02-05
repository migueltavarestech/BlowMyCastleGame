package org.academiadecodigo.bootcamp55.BlowMyCastleGame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private int health;
    private Picture playerAvatar;

    public Player() {
        playerAvatar = new Picture(0,0,"playerAvatar.png");
        playerAvatar.draw();
    }

    public void moveRight() { playerAvatar.translate(10,0); }
    public void moveLeft() {
        playerAvatar.translate(-10, 0);
    }
    public void moveUp() {
        playerAvatar.translate(0, -10);
    }
    public void moveDown() {
        playerAvatar.translate(0,10);
    }

}
