package h1;

public class H1_main {
    public static void main(String[] args) {

        Cell[] startCells = {
                new Cell(0, 4),
                new Cell(1, 1),
                new Cell(2, 2),
                new Cell(2, 3),
                new Cell(3, 1),
                new Cell(3, 2)
        };
        Grid grid = new Grid(startCells, 4, 5);
        grid.computeGeneration(2);

//        System.out.println("Start:");
//        printGrid(grid);
//
//        grid.computeGeneration(1);
//        System.out.println("\nNach 1 Generation:");
//        printGrid(grid);
//
//        grid.computeGeneration(1);
//        System.out.println("\nNach 2 Generationen:");
//        printGrid(grid);
//    }

//        private static void printGrid(Grid grid) {
//            Cell[][] g = grid.getGridArray();
//            for (int r = 0; r < g.length; r++) {
//                for (int c = 0; c < g[0].length; c++) {
//                    System.out.print(g[r][c].isAlive() ? "1 " : "0 ");
//                }
//                System.out.println();
//            }
      }
  }