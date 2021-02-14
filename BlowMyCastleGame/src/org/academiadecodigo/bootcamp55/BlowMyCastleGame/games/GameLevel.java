package org.academiadecodigo.bootcamp55.BlowMyCastleGame.games;

public enum GameLevel {
    LEVEL1(10,5),
    LEVEL2(15, 5),
    LEVEL3(20, 5);

    private final int bomb;
    private final int wall;

    GameLevel(int bomb, int wall) {
        this.bomb = bomb;
        this.wall = wall;
    }

    public int getBomb() {
        return bomb;
    }

    public int getWall() {
        return wall;
    }
}
