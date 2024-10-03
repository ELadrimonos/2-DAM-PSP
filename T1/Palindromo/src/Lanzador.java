import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class Lanzador {
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Dame una cadena para pasar a mayusculas: ");
        String mayusculas = entrada.nextLine();
        ProcessBuilder pbMayusculas = new ProcessBuilder("java", "Mayusculas.java", mayusculas);
        pbMayusculas.directory(new File("src"));
        Process pMayusculas = pbMayusculas.start();

        try {
            InputStream isMayusculas = pMayusculas.getInputStream();
            int c;

            while ((c = isMayusculas.read()) != -1) {
                System.out.print((char) c);
            }
            isMayusculas.close();
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }


        String palindromo;
        do{
            System.out.print("Dame una cadena para comprobar si es palindromo (cadena vacía para finalizar): ");
            palindromo = entrada.nextLine();

            ProcessBuilder pbPalindromo = new ProcessBuilder("java", "Palindromo.java", palindromo);
            pbPalindromo.directory(new File("src"));

            Process pPalindromo = pbPalindromo.start();

            try {
                InputStream isPalindromo = pPalindromo.getInputStream();
                int c;

                while ((c = isPalindromo.read()) != -1) {
                    System.out.print((char) c);
                }
                isPalindromo.close();
                pPalindromo.waitFor(); // Espero a que llegue a guardar en el fichero supongo
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (!Objects.equals(palindromo, ""));



    }
}
