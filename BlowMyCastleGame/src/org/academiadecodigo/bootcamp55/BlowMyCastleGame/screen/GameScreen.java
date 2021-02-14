package org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Engine;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Player;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Position;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.games.GameContracts;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.games.GameLevel;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.Input;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.KEY;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.walls.Wall;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.walls.WallType;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;


import java.util.*;

public class GameScreen extends AbstractScreen implements Screens {

    private GameContracts game;
    private Player player1;
    private Player player2;
    private GameLevel gameLevel = GameLevel.LEVEL3;
    private Wall wall;
    private Map<Wall, Player> gameElements;
    private int nrWalls1;
    private int nrWalls2;
    private Text text;
    private Text text1;
    private List<Wall> listofKeys;

    public GameScreen(Engine engine) {
        super(engine);
        gameElements = new HashMap<>();
        listofKeys = new ArrayList<>();
    }

    @Override
    public void show() {
        // players
        player1 = new Player(1);
        player2 = new Player(2);
        // wall bricks
        setUpWalls();
    }

    @Override
    public void hide() {
        hideWalls();

    }

    private void hideWalls() {
        gameElements.clear();
    }

    private void setUpWalls() {
        //add GameLevel logic (no need for switch cases)

        nrWalls1 = gameLevel.getWall();
        nrWalls2 = gameLevel.getWall();

//        Picture pictureWall = new Picture(40, 40, "resources/Pictures/walls.png");
//        pictureWall.draw();
//        text = new Text(80, 40, "   Available Walls: " + nrWalls1);
//        text.draw();
//
//        Picture pictureWall2 = new Picture(800, 40, "resources/Pictures/walls.png");
//        pictureWall2.draw();
//        text1 = new Text(800, 40, "   Available Walls: " + nrWalls2);
//        text1.draw();
    }

    private void placeWalls(Player player) {

        if (player.equals(player1)){

            if (nrWalls1 !=0 )
            {
                gameElements.put(new Wall(player.getPos(), WallType.WOOD), player);
                nrWalls1--;
                updateWalls(player, nrWalls1);

                Position temp = new Position(player.getPos().getCol(), player.getPos().getRow());
                setOcuppiedPos(temp);

                return;
            }
        }
        if (player.equals(player2)){
            if (nrWalls2 !=0 )
            {
                gameElements.put(new Wall(player.getPos(), WallType.WOOD), player);
                Position temp = new Position(player.getPos().getCol(), player.getPos().getRow());

                setOcuppiedPos(temp);
                nrWalls2--;
                updateWalls(player, nrWalls2);
            }

        }
    }

    private void setOcuppiedPos(Position pos) {
        pos.setCellOccupied(true);
        Grid.addOccupiedCell(pos);
    }

    private void updateWalls (Player player,int nrWall){

                if (player.equals(player1)) {
                    text.delete();
                    text = new Text(80, 40, "   Available Walls: " + nrWalls1);
                    text.draw();
                }
                if (player.equals(player2)) {
                    text1.delete();
                    text1 = new Text(800, 40, "   Available Walls: " + nrWalls2);
                    text1.draw();
                }

            }

            @Override
            public void handleInputs (Input input) throws InterruptedException {

                KEY key = input.getKey();

                switch (key) {
                    case ESC:
                        engine.setGameState(GameState.MENU);
                        break;
                    case DOWN:
                        player2.moveDown();
                        break;
                    case UP:
                        player2.moveUp();
                        break;
                    case LEFT:
                        player2.moveLeft();
                        break;
                    case RIGHT:
                        player2.moveRight();
                        break;
                    case ENTER:
                        player2.shoot();
                        break;
                    case A:
                        player1.moveLeft();
                        break;
                    case S:
                        player1.moveDown();
                        break;
                    case W:
                        player1.moveUp();
                        break;
                    case D:
                        player1.moveRight();
                        break;
                    case Q:
                        placeWalls(player1);
                        break;
                    case ZERO:
                        placeWalls(player2);
                        break;
                    case SPACE:
                        player1.shoot();
                        break;
                }
            }


}