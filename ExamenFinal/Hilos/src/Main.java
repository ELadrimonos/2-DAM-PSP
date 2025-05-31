import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<HiloCoche> coches = new ArrayList<>();

        System.out.println("Introduzca el número de coches:");
        int numCoches = entrada.nextInt();
        entrada.nextLine();

        for (int i = 1; i <= numCoches; i++) {
            System.out.println("Introduzca la marca del coche " + i + ":");
            String nombre = entrada.nextLine();
            coches.add(new HiloCoche(i, nombre));
        }

        System.out.println("Que empiece la carrera!!!");
        for (int i = 0; i < numCoches; i++) {
            coches.get(i).start();
        }
    }
}