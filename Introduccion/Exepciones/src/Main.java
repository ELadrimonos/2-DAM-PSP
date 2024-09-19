import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Valor muy bajo por si a alguien se le ocurre solamente poner numeros negativos
        int mayor = -1000;

        for (int i = 0; i < 6; i++) {
            boolean correcto = false;
            int valor;
            do {
                try {
                    valor = scanner.nextInt();

                    if (valor > mayor) {
                        mayor = valor;
                    }

                    correcto = true;
                } catch (InputMismatchException e) {
                    System.out.println("El dato introducido no es correcto, debe ser un número entero.");
                    System.out.println("Por favor, inténtelo de nuevo.");
                    scanner.nextLine();
                }
            } while (!correcto);
        }

        System.out.println("El mayor número es: " + mayor);
    }
}