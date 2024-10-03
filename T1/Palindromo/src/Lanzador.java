import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Lanzador {
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Dame una cadena para pasar a mayusculas: ");
        String mayusculas = entrada.nextLine();

        System.out.print("Dame una cadena para comprobar si es palindromo: ");
        String palindromo = entrada.nextLine();

        ProcessBuilder pbMayusculas = new ProcessBuilder("java", "Mayusculas.java", mayusculas);
        ProcessBuilder pbPalindromo = new ProcessBuilder("java", "Palindromo.java", palindromo);
        pbMayusculas.directory(new File("src"));
        pbPalindromo.directory(new File("src"));

        Process pMayusculas = pbMayusculas.start();
        Process pPalindromo = pbPalindromo.start();

        try {
            InputStream isMayusculas = pMayusculas.getInputStream();
            InputStream isPalindromo = pPalindromo.getInputStream();
            int c;
            while ((c = isMayusculas.read()) != -1) {
                System.out.print((char) c);
            }
            isMayusculas.close();
            System.out.println();
            while ((c = isPalindromo.read()) != -1) {
                System.out.print((char) c);
            }
            isPalindromo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
