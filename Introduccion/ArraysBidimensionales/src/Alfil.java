import java.util.ArrayList;
import java.util.Scanner;

public class Alfil {
    // Carácter unicode del alfil para dejarlo más chulo
    static String caracterAlfil = "\u265D";

    static boolean usarCuadros = false;

    public static void main(String[] args) {
        String[][] tableroJuego = generarTablero();
        dibujarTablero(tableroJuego);
        System.out.println("Introducir cualquier cadena ajena para finalizar el juego");
        Scanner entrada = new Scanner(System.in);
        String valorEntrada;
        boolean continuarJuego;

        System.out.println("Usar cuadrados de colores?: (s/n)");


        String opcionCuadros = entrada.nextLine();
        if (opcionCuadros.equalsIgnoreCase("s")) usarCuadros = true;


        do {
            System.out.print("Introduce la posición del alfil (Ej: D5): ");
            valorEntrada = entrada.nextLine();
            valorEntrada = valorEntrada.toUpperCase();
            continuarJuego = comprobarEntradaJuego(valorEntrada);
            if (continuarJuego) {
                ArrayList<String> movimientos = opcionesPosibles(valorEntrada, tableroJuego);
                System.out.println(movimientos);
                dibujarTableroPosiciones(tableroJuego, movimientos, valorEntrada);
            }
        } while (continuarJuego);

        entrada.close();
        System.out.println("Juego finalizado!!");
    }

    public static String[][] generarTablero() {
        String[] letras = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        String[][] tablero = new String[8][8];
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                tablero[y][x] = letras[x] + (y + 1);
            }
        }
        return tablero;
    }

    public static ArrayList<String> opcionesPosibles(String posicionAlfil, String[][] tablero) {
        ArrayList<String> movimientosPosibles = new ArrayList<>();
        int[] indicesAlfil = encontrarIndiceAlfil(posicionAlfil, tablero);

        // Asi no me lio a la hora de llamarlos en los bucles
        int fila = indicesAlfil[0];
        int columna = indicesAlfil[1];

        /*
        Cojo los índices de fila y columna del alfil y voy incrementando y/o disminuyendo
        el valor para que siga una dirección diagonal
        */

        // Diagonal derecha abajo
        for (int i = 1; fila + i < 8 && columna + i < 8; i++) {
            movimientosPosibles.add(tablero[fila + i][columna + i]);
        }

        // Diagonal izquierda abajo
        for (int i = 1; fila + i < 8 && columna - i >= 0; i++) {
            movimientosPosibles.add(tablero[fila + i][columna - i]);
        }

        // Diagonal derecha arriba
        for (int i = 1; fila - i >= 0 && columna + i < 8; i++) {
            movimientosPosibles.add(tablero[fila - i][columna + i]);
        }

        // Diagonal izquierda arriba
        for (int i = 1; fila - i >= 0 && columna - i >= 0; i++) {
            movimientosPosibles.add(tablero[fila - i][columna - i]);
        }

        return movimientosPosibles;
    }


    // Saco los índices de fila y columna del alfil usando la coordenada del tablero
    public static int[] encontrarIndiceAlfil(String posicionAlfil, String[][] tablero) {
        for (int y = 0; y < tablero.length; y++) {
            for (int x = 0; x < tablero[y].length; x++) {
                if (tablero[y][x].equals(posicionAlfil)) {
                    return new int[]{y, x};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static void dibujarTableroPosiciones(String[][] tablero, ArrayList<String> movimientosPosibles, String posicionAlfil) {
        boolean toogleCuadrado = false;

        for (String[] filas : tablero) {
            for (String columnas : filas) {
                if (movimientosPosibles.contains(columnas)) {
                    System.out.print(columnas + "\t");  // Muestro las coordenadas en sus posiciones respectivas
                } else if (columnas.equals(posicionAlfil)) {
                    System.out.print(caracterAlfil + "\t");
                } else {
                    System.out.print(( usarCuadros ? (toogleCuadrado ? "\u25A1" : "\u25A0") : "_") +  "\t");
                }
                toogleCuadrado = !toogleCuadrado;

            }
            toogleCuadrado = !toogleCuadrado;
            System.out.println();
        }
    }

    public static void dibujarTablero(String[][] tablero) {
        for (String[] filas : tablero) {
            for (String columnas : filas) {
                System.out.print(columnas + "\t");
            }
            System.out.println();
        }
    }

    public static boolean comprobarEntradaJuego(String valor) {
        // Hago un arraylist porque asi puedo usar contains
        ArrayList<String> listaValoresLetras = new ArrayList<>() {{
            add("A");
            add("B");
            add("C");
            add("D");
            add("E");
            add("F");
            add("G");
            add("H");
        }};

        boolean letraValida = listaValoresLetras.contains(valor.substring(0, 1));
        boolean numeroValido;

        // Si no es un número tirará una excepción
        try {
            numeroValido = Integer.parseInt(valor.substring(1, 2)) > 0 && Integer.parseInt(valor.substring(1, 2)) < 9;
        } catch (NumberFormatException e) {
            numeroValido = false;
        }

        return letraValida && numeroValido;
    }
}
