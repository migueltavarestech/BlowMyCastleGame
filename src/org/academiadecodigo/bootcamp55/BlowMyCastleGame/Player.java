package org.academiadecodigo.bootcamp55.BlowMyCastleGame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private int health;
    private Picture playerAvatar;
    private Position position;
    private int speed = 5;
    private int avatarSize = 20;

    public Player() {
         playerAvatar = new Picture(0,0,"playerAvatar.png");
         playerAvatar.draw();

         position = new Position(0, 0);
    }

    public void moveRight() {
        playerAvatar.translate(speed,0);
        position.moveInDirection(GridDirection.RIGHT, speed*avatarSize);
        System.out.println(position.toString());
    }

    public void moveLeft() {
        playerAvatar.translate(-speed, 0);
        position.moveInDirection(GridDirection.LEFT, speed*avatarSize);
        System.out.println(position.toString());
    }

    public void moveUp() {
        playerAvatar.translate(0, -speed);
        position.moveInDirection(GridDirection.UP, speed*avatarSize);
        System.out.println(position.toString());
    }

    public void moveDown() {
        playerAvatar.translate(0,speed);
        position.moveInDirection(GridDirection.DOWN, speed*avatarSize);
        System.out.println(position.toString());
    }

    public int getCol() {
        return position.getCol();
    }

    public int getRow() {
        return position.getRow();
    }

}