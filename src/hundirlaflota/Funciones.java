package hundirlaflota;

import java.util.Scanner;

/**
 *
 * @author Augusto Carlos Blanco Prendes
 */
public class Funciones {

    // FUNCIÓN PARA CREAR EL TABLERO INICIAL VACÍO
    public static String[][] tableroInicial() {
        // Creamos el tablero de juego (array bidimensional)
        String[][] tablero = new String[11][11];
        // Rellenamos la primera fila con sus números
        tablero[0][0] = " ";
        for (int i = 1; i < 11; i++) {
            tablero[0][i] = "" + (i - 1);
        }
        // Rellenamos la primera columna con sus letras
        tablero[1][0] = "A";
        tablero[2][0] = "B";
        tablero[3][0] = "C";
        tablero[4][0] = "D";
        tablero[5][0] = "E";
        tablero[6][0] = "F";
        tablero[7][0] = "G";
        tablero[8][0] = "H";
        tablero[9][0] = "I";
        tablero[10][0] = "J";
        // Rellenamos con guiones el resto del tablero
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                tablero[i][j] = "-";
            }
        }
        // Devolvemos el resultado (tablero)
        return tablero;
    }

    // FUNCIÓN PARA RELLENAR CON BARCOS EL TABLERO
    public static String[][] tableroConBarcos(int numPortaaviones, int numAcorazados, int numBuques, int numLanchas) {
        // Copiamos el tablero inicial vacío para rellenarlo con barcos
        String[][] tableroConBarcos = tableroInicial();
        // Rellenamos el tablero con barcos mediante bucles WHILE
        int contadorPortaaviones = 0;
        int contadorAcorazados = 0;
        int contadorBuques = 0;
        int contadorLanchas = 0;
        // Creamos el bucle WHILE del portaaviones
        while (contadorPortaaviones < numPortaaviones) {
            int numAleatorio1 = (int) (Math.random() * 10);
            int numAleatorio2 = (int) (Math.random() * 10);
            // Comprobamos si hay espacio para el barco y lo creamos
            if (numAleatorio1 + 4 < 10
                    && tableroConBarcos[numAleatorio1][numAleatorio2].equals("-")
                    && tableroConBarcos[numAleatorio1 + 1][numAleatorio2].equals("-")
                    && tableroConBarcos[numAleatorio1 + 2][numAleatorio2].equals("-")
                    && tableroConBarcos[numAleatorio1 + 3][numAleatorio2].equals("-")
                    && tableroConBarcos[numAleatorio1 + 4][numAleatorio2].equals("-")) {
                tableroConBarcos[numAleatorio1][numAleatorio2] = "P";
                tableroConBarcos[numAleatorio1 + 1][numAleatorio2] = "P";
                tableroConBarcos[numAleatorio1 + 2][numAleatorio2] = "P";
                tableroConBarcos[numAleatorio1 + 3][numAleatorio2] = "P";
                tableroConBarcos[numAleatorio1 + 4][numAleatorio2] = "P";
                contadorPortaaviones++;
            }
        }
        // Creamos el bucle WHILE del acorazado
        while (contadorAcorazados < numAcorazados) {
            int numAleatorio1 = (int) (Math.random() * 10);
            int numAleatorio2 = (int) (Math.random() * 10);
            // Comprobamos si hay espacio para el barco y lo creamos
            if (numAleatorio2 + 3 < 10
                    && tableroConBarcos[numAleatorio1][numAleatorio2].equals("-")
                    && tableroConBarcos[numAleatorio1][numAleatorio2 + 1].equals("-")
                    && tableroConBarcos[numAleatorio1][numAleatorio2 + 2].equals("-")
                    && tableroConBarcos[numAleatorio1][numAleatorio2 + 3].equals("-")) {
                tableroConBarcos[numAleatorio1][numAleatorio2] = "Z";
                tableroConBarcos[numAleatorio1][numAleatorio2 + 1] = "Z";
                tableroConBarcos[numAleatorio1][numAleatorio2 + 2] = "Z";
                tableroConBarcos[numAleatorio1][numAleatorio2 + 3] = "Z";
                contadorAcorazados++;
            }
        }
        // Creamos el bucle WHILE de los buques
        while (contadorBuques < numBuques) {
            int numAleatorio1 = (int) (Math.random() * 10);
            int numAleatorio2 = (int) (Math.random() * 10);
            // Comprobamos si hay espacio para el barco y lo creamos
            if (numAleatorio2 + 2 < 10
                    && tableroConBarcos[numAleatorio1][numAleatorio2].equals("-")
                    && tableroConBarcos[numAleatorio1][numAleatorio2 + 1].equals("-")
                    && tableroConBarcos[numAleatorio1][numAleatorio2 + 2].equals("-")) {
                tableroConBarcos[numAleatorio1][numAleatorio2] = "B";
                tableroConBarcos[numAleatorio1][numAleatorio2 + 1] = "B";
                tableroConBarcos[numAleatorio1][numAleatorio2 + 2] = "B";
                contadorBuques++;
            }
        }
        // Creamos el bucle WHILE de las lanchas
        while (contadorLanchas < numLanchas) {
            int numAleatorio1 = (int) (Math.random() * 10);
            int numAleatorio2 = (int) (Math.random() * 10);
            // Creamos el barco
            if (tableroConBarcos[numAleatorio1][numAleatorio2].equals("-")) {
                tableroConBarcos[numAleatorio1][numAleatorio2] = "L";
                contadorLanchas++;
            }
        }
        // Devolvemos el resultado (tablero rellenado con barcos)
        return tableroConBarcos;
    }

    // FUNCIÓN PARA MOSTRAR EL TABLERO DE BARCOS
    public static void mostrarTableroConBarcos(String[][] tableroConBarcos) {
        System.out.println("Tablero del ordenador");
        System.out.println("=====================");
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                // System.out.print(tableroConBarcos()[i][j] + " ");  // ESTO FALLA. CUIDADO: AL PONER LOS PARÉNTESIS ESTÁS INVOCANDO LA FUNCIÓN!!!
                System.out.print(tableroConBarcos[i][j] + " ");
            }
            System.out.println();
        }
    }

    // FUNCIÓN PARA CREAR EL TABLERO DE JUEGO
    public static String[][] tableroDeJuego() {
        // Copiamos el tablero inicial vacío para usarlo como tablero de juego
        String[][] tableroDeJuego = tableroInicial();
        // Devolvemos el resultado (tablero de juego)
        return tableroDeJuego;
    }

    // FUNCIÓN PARA MOSTRAR EL TABLERO DE JUEGO
    public static void mostrarTablero(String[][] tableroDeJuego) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(tableroDeJuego[i][j] + " ");
                // System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    // FUNCIÓN PARA PREGUNTAR EL DISPARO
    public static int[] preguntarDisparo() {
        Scanner sc = new Scanner(System.in);
        boolean coordenadaValida = false;
        int filaDisparo, columnaDisparo;
        // Pedimos al jugador la fila del disparo, comprobando que es válida
        do {
            System.out.print("Introduce la fila de disparo (1 = A, 2 = B, etc.): ");
            filaDisparo = sc.nextInt();
            if (filaDisparo > 0 && filaDisparo < 11) {
                coordenadaValida = true;
            }
        } while (!coordenadaValida);
        coordenadaValida = false;
        // Pedimos al jugador la columna del disparo, comprobando que es válida
        do {
            System.out.print("Introduce la columna de disparo: ");
            columnaDisparo = sc.nextInt();
            if (columnaDisparo >= 0 && columnaDisparo < 10) {
                coordenadaValida = true;
                columnaDisparo = columnaDisparo + 1;
            }
        } while (!coordenadaValida);
        // Devolvemos el resultado (coordenadas del disparo)
        return new int[]{filaDisparo, columnaDisparo};
    }

    // FUNCIÓN PARA ACTUALIZAR EL TABLERO CON EL DISPARO REALIZADO
    public static boolean modificarTablero(String[][] tableroConBarcos, String[][] tableroDeJuego, int[] coordenadasDisparo) {
        if (!tableroConBarcos[coordenadasDisparo[0]][coordenadasDisparo[1]].equals("-")) {
            tableroDeJuego[coordenadasDisparo[0]][coordenadasDisparo[1]] = "X";
            System.out.println("***** TOCADO *****");
            return true;
        } else {
            tableroDeJuego[coordenadasDisparo[0]][coordenadasDisparo[1]] = "A";
            System.out.println("***** AGUA *****");
            return false;
        }
    }
}
