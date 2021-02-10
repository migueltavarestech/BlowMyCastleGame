package org.academiadecodigo.bootcamp55.BlowMyCastleGame;

public class Position {

    private int col;
    private int row;
    private boolean cellOccupied;

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

    public void moveInDirection(GridDirection direction) {
        switch (direction) {
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
        }
    }

    public void moveUp() {
        row -= 1;
    }

    public void moveDown() {
        row += 1;
    }

    public void moveLeft() {
        col -= 1;
    }

    public void moveRight() {
        col += 1;
    }

    public void setCellOccupied(boolean value) { this.cellOccupied = value; }

    public boolean isOccupied() { return cellOccupied; }

    public String toString() {
        return "GridPosition{" +
                "col=" + col +
                ", row=" + row +
                "}";
    }

    public static boolean isNextCellOccupied(GridDirection direction, Position pos) {
        Position[] occupiedCells = Grid.getOccupiedCells();

        boolean isNextCellOccupied = false;
        int currentCol = pos.getCol();
        int currentRow = pos.getRow();

        if (direction == GridDirection.RIGHT) {
            for (int i = 0; i < occupiedCells.length; i++) {
                if (currentCol + 1 == occupiedCells[i].getCol() &&
                        currentRow == occupiedCells[i].getRow()) {
                    isNextCellOccupied = true;
                }
            }
        } else if (direction == GridDirection.LEFT) {
            for (int i = 0; i < occupiedCells.length; i++) {
                if (currentCol - 1 == occupiedCells[i].getCol() &&
                        currentRow == occupiedCells[i].getRow()) {
                    isNextCellOccupied = true;
                }
            }
        } else if (direction == GridDirection.UP) {
            for (int i = 0; i < occupiedCells.length; i++) {
                if (currentCol == occupiedCells[i].getCol() &&
                        currentRow - 1 == occupiedCells[i].getRow()) {
                    isNextCellOccupied = true;
                }
            }
        } else if (direction == GridDirection.DOWN) {
            for (int i = 0; i < occupiedCells.length; i++) {
                if (currentCol == occupiedCells[i].getCol() &&
                        currentRow + 1 == occupiedCells[i].getRow()) {
                    isNextCellOccupied = true;
                }
            }
        }

        return isNextCellOccupied;
    }

    //code to catch bombs


}