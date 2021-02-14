package org.academiadecodigo.bootcamp55.BlowMyCastleGame.screen;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Engine;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Grid;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.GridDirection;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.GridObjects;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Position;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Player;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.games.GameContracts;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.games.GameLevel;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.Input;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard.KEY;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.Inventory;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.ObjectsFactory;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.castle.Castle;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.walls.Wall;
import org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.walls.WallType;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;


import java.util.*;

public class GameScreen extends AbstractScreen implements Screens {

    private Player player1;
    private Player player2;
    private GameLevel gameLevel = GameLevel.LEVEL3;
    private Map<Wall, Player> gameElements;

    private List<Wall> listofKeys;
    private List<Inventory> inventories;
    private List<Player> players;

    private int nrPlayers = 2;

    public GameScreen(Engine engine) {
        super(engine);
        gameElements = new HashMap<>();
        listofKeys = new ArrayList<>();
        inventories = new LinkedList<>();
        players = new LinkedList<>();

        /** checks number GameMode - Practice or Play
         *
         */
        switch (engine.getGameState()){

            case TWO_PLAYER:
                nrPlayers = 1;
                break;
            case PRATICE:
                nrPlayers = 2;
                break;
        }
    }

    @Override
    public void show() {

        /**
         * create inventory dependent on GameLevel and display
         * set of players and assign initial inventory to each player
         */
        // System.out.println(engine.getGameState());

        Picture canvas = new Picture(Grid.getPadding(), Grid.getPadding(), "background2.png");
        canvas.draw();

        switch (engine.getGameState()){

            case TWO_PLAYER:
                inventories.add(new Inventory(0,GameLevel.LEVEL3.getWall(), 1));
                inventories.add(new Inventory(0,GameLevel.LEVEL3.getWall(), 2));
                player1 = new Player(1);
                player2 = new Player(2);
                players.add(player1);
                players.add(player2);
                players.get(0).setInventory(inventories.get(0));
                players.get(1).setInventory(inventories.get(1));
                break;

            case PRATICE:
                inventories.add(new Inventory(0,GameLevel.LEVEL3.getWall(), 1));
                player1 = new Player(1);
                players.add(player1);
                players.get(0).setInventory(inventories.get(0));
                break;
        }

        for (Inventory entry : inventories){
            entry.initialDraw();
        }

        ObjectsFactory factory = new ObjectsFactory();
        factory.init(GameLevel.LEVEL3);
        factory.createCastles();
        factory.createBombs();

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

        for (Inventory entry : inventories){
            entry.hide();
        }
        inventories.clear();

        for (Wall w : gameElements.keySet()){
            w.hideWall();
        }

        gameElements.clear();
        Position.clearPosArr();
        Grid.clearBombList();
        Castle.clearCastleList();
    }

    private void placeWalls(Player player) {

        int index = 0;
        Position postemp = new Position(player.getPos().getCol(), player.getPos().getRow());

        if (player.equals(players.get(0))){
            index = 0;
       }
        if (player.equals(players.get(1))) {
            index = 1;
        }

        if (inventories.get(index).getWallsNumber() != 0) {

            if (player.getLastDirection() == null){
                    return;
                }

            switch (player.getLastDirection()){

                case UP:
                    if (!Position.isNextCellOccupied(GridDirection.UP, player.getPos())) {
                        postemp.moveInDirection(GridDirection.UP);
                        placeWall(postemp, index);
                        break;
                    }
                case DOWN:
                     if (!Position.isNextCellOccupied(GridDirection.DOWN, player.getPos())) {
                         postemp.moveInDirection(GridDirection.DOWN);
                         placeWall(postemp, index);
                         break;
                        }
                     break;
                case LEFT:
                     if (!Position.isNextCellOccupied(GridDirection.LEFT, player.getPos())) {
                         postemp.moveInDirection(GridDirection.LEFT);
                         placeWall(postemp, index);
                         break;
                        }
                     break;
                case RIGHT:
                    if (!Position.isNextCellOccupied(GridDirection.RIGHT, player.getPos())) {
                        postemp.moveInDirection(GridDirection.RIGHT);
                        placeWall(postemp, index);
                        break;
                        }
                }
               return;
            }
    }

    private void placeWall(Position pos, int nrPlayer){
        Wall newWall = new Wall(pos, WallType.WOOD);
        gameElements.put(newWall,players.get(nrPlayer));
        inventories.get(nrPlayer).useWall();
        setOcuppiedPos(pos);

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
                        if (nrPlayers == 2) {
                            player2.moveDown();
                        }
                        break;
                    case UP:
                        if (nrPlayers == 2) {
                            player2.moveUp();
                        }
                        break;
                    case LEFT:
                        if (nrPlayers == 2) {
                            player2.moveLeft();
                        }
                        break;
                    case RIGHT:
                        if (nrPlayers == 2) {
                            player2.moveRight();
                        }
                        break;
                    case ENTER:
                        if (nrPlayers == 2) {
                            player2.shoot();
                        }
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