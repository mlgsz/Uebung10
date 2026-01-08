package h1;

public class Grid {

    private Cell[][] gridArray;

    // Getter & Setter
    public Cell[][] getGridArray() {
        return gridArray;
    }

    public void setGridArray(Cell[][] gridArray) {
        this.gridArray = gridArray;
    }

    // Konstruktor
    public Grid(Cell[] cells, int gridRows, int gridCols) {

        gridArray = new Cell[gridRows][gridCols];


        for (int r = 0; r < gridRows; r++) {
            for (int c = 0; c < gridCols; c++) {
                gridArray[r][c] = new Cell(r, c);
            }
        }

        for (Cell cell : cells) {
            int row = cell.getIndexRow();
            int col = cell.getIndexCol();

            if (row >= 0 && row < gridRows && col >= 0 && col < gridCols) {
                gridArray[row][col].setAlive(true);
            }
        }

        for (int r = 0; r < gridRows; r++) {
            for (int c = 0; c < gridCols; c++) {
                gridArray[r][c].countLivingNeighbors(gridArray);
            }
        }
    }

    public void computeNextGen() {

        for (int r = 0; r < gridArray.length; r++) {
            for (int c = 0; c < gridArray[0].length; c++) {
                gridArray[r][c].countLivingNeighbors(gridArray);
            }
        }

        for (int r = 0; r < gridArray.length; r++) {
            for (int c = 0; c < gridArray[0].length; c++) {
                gridArray[r][c].setAlive(
                        gridArray[r][c].isAliveNextGen()
                );
            }
        }
    }

    public void computeGeneration(int n) {
        for (int i = 0; i < n; i++) {
            computeNextGen();
        }
    }
}
