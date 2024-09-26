import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Lanzador {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pbMayusculas = new ProcessBuilder("java", "Mayusculas.java", "hola muy buenas a todos guapos");
        ProcessBuilder pbPalindromo = new ProcessBuilder("java", "Palindromo.java", "Anita lava la tina");
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
