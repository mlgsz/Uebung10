package h2;

public class Spielstein {
    private int currentRow;
    private int currentCol;
    private Spielbrett brett;

    // Konstruktor
    public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
        this.brett = brett;
        this.currentRow = indexRow;
        this.currentCol = indexCol;
    }

    // Getter und Setter
    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }

    public Spielbrett getBrett() {
        return brett;
    }

    public void setBrett(Spielbrett brett) {
        this.brett = brett;
    }

    private boolean movesOut() {
        char dir = brett.getBrett()[currentRow][currentCol].getDirection();
        int dim = brett.getDim();

        switch (dir) {
            case 'U':
                return currentRow == 0;
            case 'D':
                return currentRow == dim - 1;
            case 'L':
                return currentCol == 0;
            case 'R':
                return currentCol == dim - 1;
            default:
                return false;
        }
    }


    public void go(int n) {
        for (int i = 0; i < n; i++) {
            Feld aktuellesFeld = brett.getBrett()[currentRow][currentCol];

            if (aktuellesFeld.isBoese() || movesOut()) {
                break;
            }

            switch (aktuellesFeld.getDirection()) {
                case 'U' -> currentRow--;
                case 'D' -> currentRow++;
                case 'L' -> currentCol--;
                case 'R' -> currentCol++;
            }
        }
    }
}
