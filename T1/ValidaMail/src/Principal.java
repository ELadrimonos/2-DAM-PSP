import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        boolean emailValido = false;



        for (int i = 0; i < 3; i++) {
            System.out.println("Introduce un email: ");
            String email = entrada.nextLine();
            ProcessBuilder pb = new ProcessBuilder("java", "ValidaMail.java", email);
            pb.directory(new File("src"));
            try {
                Process p =pb.start();
                InputStream is = p.getInputStream();
                int c;
                while ((c = is.read()) != -1) {
                    System.out.print((char) c);
                }
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        entrada.close();
    }
}