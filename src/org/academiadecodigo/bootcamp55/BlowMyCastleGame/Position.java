package org.academiadecodigo.bootcamp55.BlowMyCastleGame;

public class Position {

    private int col;
    private int row;

    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void moveInDirection(GridDirection direction, int distance) {
        switch (direction) {
            case UP:
                moveUp(distance);
                break;
            case DOWN:
                moveDown(distance);
                break;
            case LEFT:
                moveLeft(distance);
                break;
            case RIGHT:
                moveRight(distance);
                break;
        }
    }

    public void moveUp(int distance) {
        setPos(getCol(), getRow() - distance);
    }

    public void moveDown(int distance) {
        setPos(getCol(), getRow() + distance);
    }

    public void moveLeft(int distance) {
        setPos(getCol() - distance, getRow());
    }

    public void moveRight(int distance) {
        setPos(getCol() + distance, getRow());
    }

    public String toString() {
        return "GridPosition{" +
                "col=" + col +
                ", row=" + row +
                "}";
    }

}