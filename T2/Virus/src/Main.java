import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
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
                    if (valor == 5) System.out.print("#");
                    else if (valor == 10) System.out.print("##");
                    try {
                        // Cuantos más virus tengamos la ejecución se realizará más rápido
                        sleep(500 / n);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } while (progreso < 100);
                System.out.println(" 100%");
            });
            //NOTE: Con run es lo mismo que hacer un start() y un join(), ejecuta en el mismo hilo que el programa
            hilos[i].run();
        }
        System.out.println("\nHAS SIDO INFECTADO!");
    }
}