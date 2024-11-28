import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        boolean emailValido = false;

        for (int i = 0; i < 3 && !emailValido; i++) {
            System.out.println("Introduce un email: ");
            String email = entrada.nextLine();
            ProcessBuilder pb = new ProcessBuilder("java", "ValidaMail.java", email);
            pb.directory(new File("src"));
            try {
                Process p = pb.start();
                InputStream is = p.getErrorStream();
                int c;
                while ((c = is.read()) != - 1) {
                    System.err.print((char) c);
                }
                is.close();
                p.waitFor();
                if (p.exitValue() == 0) {
                    emailValido = true;
                    System.out.println("Enhorabuena!!! El email introducido es correcto!!!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Fin del programa");


        entrada.close();
    }
}