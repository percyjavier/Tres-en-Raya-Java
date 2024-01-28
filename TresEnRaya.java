import java.util.Scanner;


//Creado por Javier Barquilla (@percyjavier en github). Por favor no copie el contenido de este programa solo uselo para basarse en el suyo en el caso de que lo necesite.
public class TresEnRaya {

    //Con esto mostramos el tablero de tres en raya de manera visual
    char[][] tablerodetresenraya;
    char jugadorqueletocajugarahora;

    public TresEnRaya() {
        tablerodetresenraya = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}

        };
        jugadorqueletocajugarahora = 'X';
    }

    //Con lo siguiente hacemos que se vayan modificando y añadiendo los signos en el trablero
    public void vamosajugaraltresenraya() {
        mostrartablerodeltresenraya();

        for (int i = 0; i < 9; i++) {
            vamosarealizarlajugada();
            mostrartablerodeltresenraya();

            //Con lo siguiente creamos las diferentes situaciones finales de la partida
            if (yahaganadounjugador()) {
                System.out.println("¡El jugador " + jugadorqueletocajugarahora + " ha ganado la partida de tres en raya!");
                return;
            }

            if (hasurgidounempateenlapartida()) {
                System.out.println("¡Ha habido un empate!");
                return;
            }

            cambiodeturno();
        }
    }

    //Con lo siguiente hacemos que se vayan modificando y añadiendo los signos en el trablero, además de mostrar el tablero
    public void mostrartablerodeltresenraya() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablerodetresenraya[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  ---------");
        }
        System.out.println();
    }

    //Esto es para que dependiendo de las situaciones que vayan eligiendo los jugadores el programa recorra las filas y las columnas hasta llegar al punto concreto que quiere el jugador para poner su jugada
    public void vamosarealizarlajugada() {
        Scanner scanner = new Scanner(System.in);
        int recorrerlafila, recorrerlacolumna;

        do {
            System.out.print("El jugador " + jugadorqueletocajugarahora + ", debe introducir un numero de fila entre (0-2): ");
            recorrerlafila = scanner.nextInt();
            System.out.print("El jugador " + jugadorqueletocajugarahora + ", debe introducir un numero de columna entre (0-2): ");
            recorrerlacolumna = scanner.nextInt();
        } while (!lajugadaescorrecta(recorrerlafila, recorrerlacolumna) || !lacasillaestavacia(recorrerlafila, recorrerlacolumna));

        tablerodetresenraya[recorrerlafila][recorrerlacolumna] = jugadorqueletocajugarahora;
    }

    public boolean lajugadaescorrecta(int recorrerlafila, int recorrerlacolumna) {
        return recorrerlafila >= 0 && recorrerlafila < 3 && recorrerlacolumna >= 0 && recorrerlacolumna < 3;
    }

    public boolean lacasillaestavacia(int recorrerlafila, int recorrerlacolumna) {
        return tablerodetresenraya[recorrerlafila][recorrerlacolumna] == ' ';
    }

    //Esto es para hacer el cambio de turno entre los 2 jugadores del tres en raya, uno que sera el X y el otro que sera el O
    public void cambiodeturno() {
        jugadorqueletocajugarahora = (jugadorqueletocajugarahora == 'X') ? 'O' : 'X';
    }

    //Esto es para que dependiendo de las situaciones que vayan eligiendo los jugadores el programa recorra las filas y las columnas hasta llegar al punto concreto que quiere el jugador para poner su jugada
    public boolean yahaganadounjugador() {
        for (int i = 0; i < 3; i++) {
            if (tablerodetresenraya[i][0] == jugadorqueletocajugarahora && tablerodetresenraya[i][1] == jugadorqueletocajugarahora && tablerodetresenraya[i][2] == jugadorqueletocajugarahora) {
                return true;
            }
            if (tablerodetresenraya[0][i] == jugadorqueletocajugarahora && tablerodetresenraya[1][i] == jugadorqueletocajugarahora && tablerodetresenraya[2][i] == jugadorqueletocajugarahora) {
                return true;
            }
        }


        if (tablerodetresenraya[0][0] == jugadorqueletocajugarahora && tablerodetresenraya[1][1] == jugadorqueletocajugarahora && tablerodetresenraya[2][2] == jugadorqueletocajugarahora) {
            return true;
        }
        if (tablerodetresenraya[0][2] == jugadorqueletocajugarahora && tablerodetresenraya[1][1] == jugadorqueletocajugarahora && tablerodetresenraya[2][0] == jugadorqueletocajugarahora) {
            return true;
        }

        return false;
    }

    //Esto es para que indique en el caso de que surja un empate.
    public boolean hasurgidounempateenlapartida() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablerodetresenraya[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        TresEnRaya juego = new TresEnRaya();
        juego.vamosajugaraltresenraya();
    }

}