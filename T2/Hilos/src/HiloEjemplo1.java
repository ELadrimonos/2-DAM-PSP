import java.util.ArrayList;
import java.util.Scanner;

public class HiloEjemplo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cuantos hilos crearemos?");
        int n = scanner.nextInt();
        scanner.close();
        ArrayList<Hilo> hilos = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            Hilo hilo = new Hilo("Hilo " + i);
            hilos.add(hilo);
        }

        for (Hilo hilo : hilos) {
            hilo.start();
            try {
                hilo.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        System.out.println(n +" HILOS INICIADOS...y finalizados");

    }
}