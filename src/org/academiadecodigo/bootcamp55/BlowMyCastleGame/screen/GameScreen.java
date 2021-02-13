package org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Engine;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.GridObjects;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Position;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Player;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.games.GameContracts;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.games.GameLevel;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.Input;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.KEY;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.Inventory;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.walls.Wall;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.walls.WallType;
import org.academiadecodigo.simplegraphics.graphics.Text;


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

    private List<Wall> listofKeys;
    private List<Inventory> inventory;
    private List<Player> players;

    private int nrPlayers = 2;

    public GameScreen(Engine engine) {
        super(engine);
        gameElements = new HashMap<>();
        listofKeys = new ArrayList<>();
        inventory = new LinkedList<>();
        players = new LinkedList<>();
    }

    @Override
    public void show() {

        /**
         * creates set of players
         */
        player1 = new Player(1);         // will receive Player number
        player2 = new Player(2);         // with player number
        players.add(player1);
        players.add(player2);

        /**
         * create inventory dependent on GameLeval and display
         */
        inventory.add(new Inventory(GameLevel.LEVEL3.getBomb(),GameLevel.LEVEL3.getWall(), 1));
        inventory.add(new Inventory(GameLevel.LEVEL3.getBomb(),GameLevel.LEVEL3.getWall(), 2));

        for (Inventory entry : inventory){
            entry.initialDraw();
        }
    }

    @Override
    public void hide() {
        /** previous players and other objects have to be removed from screen
         * it corresponds to delete the current pictures and clear all occupied cells
         * or re-use same players with clear inventory
         */

        for (Player entry : players){
            entry.hide();
        }
        players.clear();

        for (Inventory entry : inventory){
            entry.hide();
        }
        inventory.clear();

        for (Wall w : gameElements.keySet()){
            w.hideWall();
        }
    }

    private void placeWalls(Player player) {

        if (player.equals(player1)){

            if (inventory.get(0).getWallsNumber() != 0) {

                Wall newWall =new Wall(player.getPos(), WallType.WOOD);
                gameElements.put(newWall, player);
                inventory.get(0).useWall();

                Position temp = new Position(player.getPos().getCol(), player.getPos().getRow());
                setOcuppiedPos(temp);

                return;
            }
        }
        if (player.equals(player2)){

            if (inventory.get(1).getWallsNumber() != 0)
            {
                Wall newWall =new Wall(player.getPos(), WallType.WOOD);
                gameElements.put(newWall, player);
                inventory.get(1).useWall();

                Position temp = new Position(player.getPos().getCol(), player.getPos().getRow());

                setOcuppiedPos(temp);

                return;
            }

        }
    }

    private void setOcuppiedPos(Position pos) {
        pos.setCellOccupied(true);
        Grid.addOccupiedCell(pos);
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