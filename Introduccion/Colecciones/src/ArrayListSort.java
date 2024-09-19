import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListSort {
    public static void main(String[] args) {
        ArrayList<String> palabras = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce 10 palabras para ser ordenadas");
        for (int i = 0; i < 10; i++) {
            palabras.add(entrada.nextLine());
        }
        entrada.close();
        ordenarArrayList(palabras);

        System.out.println("Palabras ordenadas");
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
    }

    public static void ordenarArrayList(ArrayList<String> listaOriginal) {
        // Como se pasa el valor por referencia se modifica el valor original

        // Con null se ordena alfabeticamente y las mayusculas antes que las minusculas
        listaOriginal.sort(null);
    }
}
