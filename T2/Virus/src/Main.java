import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Número de virus a ejecutar");
        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();
        entrada.close();
        Thread[] hilos = new Thread[n];

        for (int i = 0; i < n; i++) {
            int num = i;
            hilos[i] = new Thread(() -> {
                System.out.print("Virus " + (num+1) + ":");
                int progreso = 0;
                Random random = new Random();
                do {
                    int valor = random.nextInt(1, 3) * 5;
                    progreso += valor;
                    if (valor == 5) System.out.print("X");
                    else if (valor == 10) System.out.print("XX");
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } while (progreso < 100);
                System.out.print(" 100%\n");
            });
            hilos[i].start();
            hilos[i].join();
        }
        System.out.println("\nHAS SIDO INFECTADO!");
    }
}