package org.academiadecodigo.bootcamp55.BlowMyCastleGame;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.castle.Castle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private int health;
    private Picture playerAvatar;
    private Position position;
    private int speed = 5;
    private int avatarSize = 20;
    private static int count = 0;

    //gun inventory
    private static int playerBombs = 0;


    public Player() {

        count++;
        if (count == 1) {
            // First player (Left)
            int Xpos = 15 + Castle.getCastleSize()/2;
            int Ypos = 700/2 + Castle.getCastleSize() - 35;

            playerAvatar = new Picture(Xpos,Ypos,"player1.png");
            playerAvatar.draw();

            position = new Position(0, 0);
        } else {
            // Second player (Right)
            int Xpos = 975 - Grid.getPadding() - Castle.getCastleSize()/2;
            int Ypos = 700/2 + Castle.getCastleSize() - 35;

            playerAvatar = new Picture(Xpos,Ypos,"player2.png");
            playerAvatar.draw();

            position = new Position(0, 0);
        }


    }

    public void moveRight() {
        playerAvatar.translate(speed,0);
        position.moveInDirection(GridDirection.RIGHT, speed);
        System.out.println(position.toString());
    }

    public void moveLeft() {
        playerAvatar.translate(-speed, 0);
        position.moveInDirection(GridDirection.LEFT, speed);
        System.out.println(position.toString());
    }

    public void moveUp() {
        playerAvatar.translate(0, -speed);
        position.moveInDirection(GridDirection.UP, speed);
        System.out.println(position.toString());
    }

    public void moveDown() {
        playerAvatar.translate(0,speed);
        position.moveInDirection(GridDirection.DOWN, speed);
        System.out.println(position.toString());
    }

    public int getCol() {
        return position.getCol();
    }

    public int getRow() {
        return position.getRow();
    }


    //methods to control the fire power
    public void setPlayerBombs(int bomb){
        this.playerBombs = bomb;
    }

    public int getPlayerBombs (){
        return playerBombs;
    }

}