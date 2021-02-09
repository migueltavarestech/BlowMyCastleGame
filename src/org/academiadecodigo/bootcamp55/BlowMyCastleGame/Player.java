package org.academiadecodigo.bootcamp55.BlowMyCastleGame;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.castle.Castle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private int health;
    private Picture playerAvatar;
    private int speed = 5;
    private int avatarSize = 40;
    private static int count = 0;
    private Position player1Pos;
    private Position player2Pos;

    //gun inventory
    private static int playerBombs = 0;

    public Player() {

        count++;

        if (count == 1) {
            // First player (Left)
            player1Pos = new Position(4, 8);
            if (player1Pos == null){
                System.out.println("I'm null");
            }
            playerAvatar = new Picture(Grid.columnToX(player1Pos.getCol()),Grid.rowToY(player1Pos.getRow()),"player1.png");
            playerAvatar.draw();
        } else {
            // Second player (Right)
            player2Pos = new Position(20, 8);
            playerAvatar = new Picture(Grid.columnToX(player2Pos.getCol()),Grid.rowToY(player2Pos.getRow()),"player2.png");
            playerAvatar.draw();
        }
    }

    public void p1MoveRight() {
        // Can't go Right if player is in the last column
        if ((player1Pos.getCol() != Grid.getTotalCols()-1) &&
                (player1Pos.getCol() != Castle.getCastle2Pos().getCol()-2) &&
                (player1Pos.getCol() != Castle.getCastle1Pos().getCol() - 1 || (
                        player1Pos.getRow() < Castle.getCastle1Pos().getRow() ||
                                player1Pos.getRow() > Castle.getCastle1Pos().getRow() + 2))) {
            playerAvatar.translate(avatarSize, 0);
            player1Pos.moveInDirection(GridDirection.RIGHT, speed);
            System.out.println(player1Pos.toString());
        }
        }




    public void p1MoveLeft() {
        if (player1Pos.getCol() != 0 ) {
            if (player1Pos.getCol() != Castle.getCastle1Pos().getCol() + 3 || (
                    player1Pos.getRow() < Castle.getCastle1Pos().getRow() ||
                            player1Pos.getRow() > Castle.getCastle1Pos().getRow() + 2)) {
                playerAvatar.translate(-avatarSize, 0);
                player1Pos.moveInDirection(GridDirection.LEFT, speed);
                System.out.println(player1Pos.toString());
            }
        }
    }

    public void p1MoveUp() {
        if (player1Pos.getRow() != 0) {
            if (player1Pos.getRow() != Castle.getCastle1Pos().getRow() + 3 || (
                    player1Pos.getCol() < Castle.getCastle1Pos().getCol() ||
                            player1Pos.getCol() > Castle.getCastle1Pos().getCol() + 2)) {
                playerAvatar.translate(0, -avatarSize);
                player1Pos.moveInDirection(GridDirection.UP, speed);
                System.out.println(player1Pos.toString());
            }
        }
    }

    public void p1MoveDown() {
        if (player1Pos.getRow() != Grid.getTotalRows()-3) {
            if (player1Pos.getRow() != Castle.getCastle1Pos().getRow()-1 || (
                    player1Pos.getCol() < Castle.getCastle1Pos().getCol() ||
                            player1Pos.getCol() > Castle.getCastle1Pos().getCol() + 2)) {
                playerAvatar.translate(0,avatarSize);
                player1Pos.moveInDirection(GridDirection.DOWN, speed);
                System.out.println(player1Pos.toString());
            }
        }
    }

    public void p2MoveRight() {
        if (player2Pos.getCol() != Grid.getTotalCols()-1) {
            if (player2Pos.getCol() != Castle.getCastle2Pos().getCol() - 1 || (
                    player2Pos.getRow() < Castle.getCastle2Pos().getRow() ||
                            player2Pos.getRow() > Castle.getCastle2Pos().getRow() + 2)) {
                playerAvatar.translate(avatarSize,0);
                player2Pos.moveInDirection(GridDirection.RIGHT, speed);
                System.out.println(player2Pos.toString());
            }
        }
    }

    public void p2MoveLeft() {
        if (player2Pos.getCol() != 0) {
            if (player2Pos.getCol() != Castle.getCastle1Pos().getCol()+4 ) {
                if (player2Pos.getCol() != Castle.getCastle2Pos().getCol() + 3 || (
                        player2Pos.getRow() < Castle.getCastle2Pos().getRow() ||
                                player2Pos.getRow() > Castle.getCastle2Pos().getRow() + 2)) {
                    playerAvatar.translate(-avatarSize, 0);
                    player2Pos.moveInDirection(GridDirection.LEFT, speed);
                    System.out.println(player2Pos.toString());
                }
            }
        }
    }

    public void p2MoveUp() {
        if (player2Pos.getRow() != 0) {
            if (player2Pos.getRow() != Castle.getCastle2Pos().getRow() + 3 || (
                    player2Pos.getCol() < Castle.getCastle2Pos().getCol() ||
                            player2Pos.getCol() > Castle.getCastle2Pos().getCol() + 2)) {
                playerAvatar.translate(0, -avatarSize);
                player2Pos.moveInDirection(GridDirection.UP, speed);
                System.out.println(player2Pos.toString());
            }
        }
    }

    public void p2MoveDown() {
        if (player2Pos.getRow() != Grid.getTotalRows()-3) {
            if (player2Pos.getRow() != Castle.getCastle2Pos().getRow()-1 || (
                    player2Pos.getCol() < Castle.getCastle2Pos().getCol() ||
                            player2Pos.getCol() > Castle.getCastle2Pos().getCol() + 2)) {
                playerAvatar.translate(0,avatarSize);
                player2Pos.moveInDirection(GridDirection.DOWN, speed);
                System.out.println(player2Pos.toString());
            }
        }
    }


    //methods to control the fire power
    public void setPlayerBombs(int bomb){
        this.playerBombs = bomb;
    }

    public int getPlayerBombs (){
        return playerBombs;
    }

}