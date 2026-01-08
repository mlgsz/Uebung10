package h2;

public class H2_main {
    public static void main(String[] args) {

        Spielbrett brett = new Spielbrett(5);

        char[][] richtungen = {
                {'U', 'R', 'L', 'L', 'D'},
                {'L', 'R', 'L', 'L', 'D'},
                {'U', 'L', 'L', 'L', 'R'},
                {'D', 'R', 'U', 'L', 'L'},
                {'U', 'R', 'L', 'D', 'D'}
        };

        for (int i = 0; i < brett.getDim(); i++) {
            for (int j = 0; j < brett.getDim(); j++) {
                brett.getBrett()[i][j] = new Feld(false, richtungen[i][j]);
            }
        }

        //Testausgabe für die Abgabe entfernt

//        Spielstein stein = new Spielstein(brett, 3, 2);
//
//        stein.go(6);
//
//        System.out.println("Spielstein ist auf Position: (" +
//                stein.getCurrentRow() + "," + stein.getCurrentCol() + ")");
    }
}
