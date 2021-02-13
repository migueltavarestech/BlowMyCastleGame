package org.academiadecodigo.bootcamp55.BlowMyCastleGame;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.castle.Castle;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen.Inventory;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private int health;
    private Picture playerAvatar;
    private int speed = 5;
    private int avatarSize = 40;
    private static int count = 0;
    private Position pos;
    private Inventory inventory;
    private GridDirection lastDirection;
    private int playerNum;

    //gun inventory
    private static int playerBombs = 0;

    public Player(int playerNum) {
        this.playerNum = playerNum;
        if (playerNum == 1) {
            // First player (Left)
            pos = new Position(4,8);
            playerAvatar = new Picture(Grid.columnToX(pos.getCol()),Grid.rowToY(pos.getRow()),"/players/player1down.png");
            playerAvatar.draw();

            inventory = new Inventory(15,10);
            inventory.initialDraw(1);
        } else {
            // Second player (Right)
            pos = new Position(20, 8);
            playerAvatar = new Picture(Grid.columnToX(pos.getCol()),Grid.rowToY(pos.getRow()),"/players/player2down.png");
            playerAvatar.draw();

            inventory = new Inventory(15,10);
            inventory.initialDraw(2);
        }
    }

    public void moveRight() {
        if (!Position.isNextCellOccupied(GridDirection.RIGHT, pos)) {
            lastDirection = GridDirection.RIGHT;
            if (playerNum == 1) {
                playerAvatar.load("players/player1right.png");
            } else {
                playerAvatar.load("players/player2right.png");
            }
            playerAvatar.translate(avatarSize, 0);
            pos.moveInDirection(GridDirection.RIGHT);
        }
    }

    public void moveLeft() {
        if (!Position.isNextCellOccupied(GridDirection.LEFT, pos)) {
            lastDirection = GridDirection.LEFT;
            if (playerNum == 1) {
                playerAvatar.load("players/player1left.png");
            } else {
                playerAvatar.load("players/player2left.png");
            }
            playerAvatar.translate(-avatarSize, 0);
            pos.moveInDirection(GridDirection.LEFT);
        }
    }

    public void moveUp() {
        if (!Position.isNextCellOccupied(GridDirection.UP, pos)) {
            lastDirection = GridDirection.UP;
            if (playerNum == 1) {
                playerAvatar.load("players/player1up.png");
            } else {
                playerAvatar.load("players/player2up.png");
            }
            playerAvatar.translate(0, -avatarSize);
            pos.moveInDirection(GridDirection.UP);
        }
    }

    public void moveDown() {
        if (!Position.isNextCellOccupied(GridDirection.DOWN, pos)) {
            lastDirection = GridDirection.DOWN;
            if (playerNum == 1) {
                playerAvatar.load("players/player1down.png");
            } else {
                playerAvatar.load("players/player2down.png");
            }
            playerAvatar.translate(0,avatarSize);
            pos.moveInDirection(GridDirection.DOWN);
        }
    }

    //methods to control the fire power
    public void setPlayerBombs(int bomb){
        this.playerBombs = bomb;
    }

    public int getPlayerBombs (){
        return playerBombs;
    }

    public Position getPos() {
        return pos;
    }

    public GridDirection getLastDirection() {return lastDirection;}
}