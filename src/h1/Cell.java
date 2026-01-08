package h1;

public class Cell {

    private int indexRow;
    private int indexCol;
    private boolean alive;
    private int numLivingNeighbors;
    private boolean isAliveNextGen;

    // Konstruktor 1
    public Cell(int indexRow, int indexCol, boolean alive) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        this.alive = alive;
    }

    // Konstruktor 2
    public Cell(int indexRow, int indexCol) {
        this(indexRow, indexCol, false);
    }

    // Getter & Setter
    public int getIndexRow() {
        return indexRow;
    }

    public int getIndexCol() {
        return indexCol;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getNumLivingNeighbors() {
        return numLivingNeighbors;
    }

    public boolean isAliveNextGen() {
        return isAliveNextGen;
    }

    public void countLivingNeighbors(Cell[][] gridArray) {
        int count = 0;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {

                if (dr == 0 && dc == 0) {
                    continue;
                }

                int r = indexRow + dr;
                int c = indexCol + dc;

                if (r >= 0 && r < gridArray.length &&
                        c >= 0 && c < gridArray[0].length &&
                        gridArray[r][c].isAlive()) {

                    count++;
                }
            }
        }

        this.numLivingNeighbors = count;
        decideNextStatus();
    }

    private void decideNextStatus() {
        if (alive) {
            isAliveNextGen = (numLivingNeighbors == 2 || numLivingNeighbors == 3);
        } else {
            isAliveNextGen = (numLivingNeighbors == 3);
        }
    }
}
