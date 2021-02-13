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

    //gun inventory
    private static int playerBombs = 0;

    public Player() {

        count++;

        if (count == 1) {
            // First player (Left)
            pos = new Position(4,8);
            playerAvatar = new Picture(Grid.columnToX(pos.getCol()),Grid.rowToY(pos.getRow()),"player1.png");
            playerAvatar.draw();

            inventory = new Inventory(15,10);
            inventory.initialDraw(1);
        } else {
            // Second player (Right)
            pos = new Position(20, 8);
            playerAvatar = new Picture(Grid.columnToX(pos.getCol()),Grid.rowToY(pos.getRow()),"player2.png");
            playerAvatar.draw();

            inventory = new Inventory(15,10);
            inventory.initialDraw(2);
        }
    }

    public void moveRight() {
        if (!Position.isNextCellOccupied(GridDirection.RIGHT, pos)) {
            playerAvatar.translate(avatarSize, 0);
            pos.moveInDirection(GridDirection.RIGHT);
        }
    }

    public void moveLeft() {
        if (!Position.isNextCellOccupied(GridDirection.LEFT, pos)) {
            playerAvatar.translate(-avatarSize, 0);
            pos.moveInDirection(GridDirection.LEFT);
        }
    }

    public void moveUp() {
        if (!Position.isNextCellOccupied(GridDirection.UP, pos)) {
            playerAvatar.translate(0, -avatarSize);
            pos.moveInDirection(GridDirection.UP);
        }
    }

    public void moveDown() {
        if (!Position.isNextCellOccupied(GridDirection.DOWN, pos)) {
            playerAvatar.translate(0,avatarSize);
            pos.moveInDirection(GridDirection.DOWN);
        }
    }

    public void shoot() throws InterruptedException {
        inventory.useBomb(pos.getCol(), pos.getRow());
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
}