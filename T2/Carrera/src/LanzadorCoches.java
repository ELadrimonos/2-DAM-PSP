import java.util.ArrayList;
import java.util.Scanner;

public class LanzadorCoches {

    public static void main(String[] args) throws InterruptedException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca numero de coches a competir:");
        int veces = entrada.nextInt();
        entrada.nextLine();

        ArrayList<Coche> cochesList = new ArrayList<>();

        for (int i = 1; i <= veces; i++) {
            System.out.println("Introduzca marca del coche " + i + ":");
            String marca = entrada.nextLine();
            cochesList.add(new Coche(marca, i));
        }

        System.out.println("Que empiece la carrera!\n");

        for (Coche coche : cochesList) {
            coche.start();
        }

        for (Coche coche : cochesList) {
            coche.join();
        }

        System.out.printf("El ganador es!!!: %s(%d) - %ds", Coche.ganador.getName(), Coche.ganador.obtenerID(), Coche.ganador.obtenerTiempoRecorrido());

    }
}
