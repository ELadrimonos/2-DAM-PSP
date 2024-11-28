import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ManualComandos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String comando;
        do {
            System.out.print("Introduce un comando para aprender más sobre él: ");
            comando = entrada.nextLine();

            ProcessBuilder pb = new ProcessBuilder("bash", "-c", "man " + comando);

            try {
                Process p = pb.start();

                InputStream in = p.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String lineaPantalla;
                boolean llegadoADescription = false;

                while ((lineaPantalla = br.readLine()) != null && !llegadoADescription) {
                    if (lineaPantalla.toLowerCase().contains("description")) llegadoADescription = true;
                    else System.out.println(lineaPantalla);
                }
                br.close();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        } while (!comando.equalsIgnoreCase("salir"));
        entrada.close();
    }
}