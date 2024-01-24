package hundirlaflota;

import java.util.Scanner;
import static hundirlaflota.Funciones.tableroInicial;
import static hundirlaflota.Funciones.tableroConBarcos;
import static hundirlaflota.Funciones.mostrarTableroConBarcos;
import static hundirlaflota.Funciones.mostrarTablero;
import static hundirlaflota.Funciones.preguntarDisparo;
import static hundirlaflota.Funciones.modificarTablero;

/**
 *
 * @author Augusto Carlos Blanco Prendes
 */
public class HundirLaFlota {

    public static void main(String[] args) {

        // Preguntamos al jugador el nivel de dificultad
        Scanner sc = new Scanner(System.in);
        boolean nivelValido = false;
        int nivelDificultad;
        // Pedimos al jugador el nivel de dificultad, comprobando que es válido
        do {
            System.out.print("Introduce el nivel de dificultad (1-Facil, 2-Medio, 3-Dificil): ");
            nivelDificultad = sc.nextInt();
            if (nivelDificultad > 0 && nivelDificultad < 4) {
                nivelValido = true;
            }
        } while (!nivelValido);
        nivelValido = false;

        // Creamos una copia del tablero con barcos (ORDENADOR) para trabajar con ella
        String[][] tableroConBarcos = null;
        int recuentoFinalDisparos = 0;
        int recuentoFinalAciertos = 0;
        switch (nivelDificultad) {
            case 1:
                tableroConBarcos = tableroConBarcos(1, 1, 3, 5);
                recuentoFinalDisparos = 50;
                recuentoFinalAciertos = 23;
                break;
            case 2:
                tableroConBarcos = tableroConBarcos(1, 1, 1, 2);
                recuentoFinalDisparos = 30;
                recuentoFinalAciertos = 14;
                break;
            case 3:
                tableroConBarcos = tableroConBarcos(0, 0, 1, 1);
                recuentoFinalDisparos = 10;
                recuentoFinalAciertos = 4;
                break;
            default:
                System.out.println("Valor no valido");
        }

        // Creamos una copia del tablero de juego (JUGADOR) para trabajar con ella
        String[][] tableroDeJuego = tableroInicial();

        // Pintamos el tablero con barcos (SOLO MODO DESARROLLADOR - Comentar la siguiente línea para que el tablero no se muestre al empezar la partida)
        mostrarTableroConBarcos(tableroConBarcos);

        // Pintamos el tablero de juego actualizado
        mostrarTablero(tableroDeJuego);

        // Preguntamos el disparo al jugador y actualizamos el tablero de juego
        int numDisparos = 0;
        int[] disparo = new int[2];
        int numAciertos = 0;
        // Creamos el bucle que se repetirá hasta que el jugador se quede sin intentos o hunda todos los barcos
        do {
            disparo = preguntarDisparo();
            int filaDisparo = disparo[0];
            int columnaDisparo = disparo[1];
            numDisparos++;
            // Comprobamos el disparo y sumamos acierto si es "Tocado"
            boolean disparoAcertado = modificarTablero(tableroConBarcos, tableroDeJuego, disparo);
            if (disparoAcertado) {
                numAciertos++;
            }
            // Pintamos el tablero de juego actualizado
            mostrarTablero(tableroDeJuego);
            // Ofrecemos información al jugador sobre cómo va la partida
            System.out.println("Disparos realizados hasta ahora: " + numDisparos);
            System.out.println("");
        } while (numDisparos < recuentoFinalDisparos && numAciertos < recuentoFinalAciertos);

        // Al terminar los intentos o hundir todos los barcos, mostramos el FIN DE JUEGO
        if (numAciertos >= recuentoFinalAciertos) {
            System.out.println("FANTASTICO. Has ganado.");
            System.out.println("");
        } else {
            System.out.println("Ya no tienes mas intentos. Has perdido.");
            System.out.println("");
        }

        // Acabado el juego, pintamos el tablero de barcos original (ORDENADOR)
        mostrarTableroConBarcos(tableroConBarcos);
    }
}
