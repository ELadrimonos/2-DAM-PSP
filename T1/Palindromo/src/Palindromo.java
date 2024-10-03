import java.io.File;
import java.io.FileWriter;

public class Palindromo {
    public static void main(String[] args) {
        boolean palindromo = esPalindromo(args[0]);
        System.out.println("Es palindromo: " + palindromo);
        guardarEnFichero(args[0], "todas.txt");
        guardarEnFichero(args[0],  (!palindromo ? "No" : "") + "palindromo.txt");

    }

    public static boolean esPalindromo(String palabra) {
        palabra = palabra.toLowerCase();
        palabra = palabra.replace(" ", "");
        for (int i = 0; i < palabra.length() / 2; i++) {
            if (palabra.charAt(i) != palabra.charAt(palabra.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void guardarEnFichero(String palabra, String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            FileWriter fw = new FileWriter(archivo, true);
            fw.write(palabra + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Error al escribir el fichero " + nombreArchivo);
        }
    }

}
