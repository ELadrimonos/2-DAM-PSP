import java.util.ArrayList;
import java.util.Random;

public class ArrayListRandom {
    public static void main(String[] args) {
        ArrayList<Integer> listaRandom = generarListaRandom();
        int min = 21, max = 0, suma = 0;

        float media;


        for (Integer valor: listaRandom) {
            System.out.print(valor + "\t");
            suma += valor;
            if (valor < min) min = valor;
            if (valor > max) max = valor;
        }

        media = (float) suma / listaRandom.size();

        System.out.println("\nMinimo: " + min + " Maximo: " + max + " Media: " + media);

    }

    public static ArrayList<Integer> generarListaRandom(){
        ArrayList<Integer> lista = new ArrayList<>();
        Random random = new Random();
        int longitud = random.nextInt(0,100);
        for (int i = 0; i < longitud; i++) {
            // Va del 0 al 10 y se agrega 10 para hacer 10-20
            lista.add(random.nextInt(11) + 10);
        }
        return lista;
    }
}
