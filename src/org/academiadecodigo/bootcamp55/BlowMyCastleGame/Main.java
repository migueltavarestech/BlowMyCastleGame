package org.academiadecodigo.bootcamp55.BlowMyCastleGame;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Grid;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Grid grid = new Grid();
        grid.init();

        Engine engineSelect = new Engine();
        engineSelect.init();
        engineSelect.startEngine();
    }
}