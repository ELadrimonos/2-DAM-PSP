import java.io.*;
import java.util.Scanner;

public class PrincipalOutput {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Introduce un email: ");
            String email = entrada.nextLine();

            ProcessBuilder pb = new ProcessBuilder("java", "ValidaMailOutput.java");
            pb.directory(new File("src"));

            try {
                Process p = pb.start();

                // Enviar el email al proceso ValidaMail
                OutputStream os = p.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
                writer.write(email);
                writer.newLine(); // Indicar fin de la entrada
                writer.flush();
                writer.close();

                // Leer la salida del proceso
                InputStream is = p.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line;

                // Leer la salida de error
                InputStream es = p.getErrorStream();
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(es));
                String errorLine;
                while ((errorLine = errorReader.readLine()) != null) {
                    System.err.println("Error del proceso: " + errorLine);
                }
                errorReader.close();


                while ((line = reader.readLine()) != null) {
                    System.out.println(line); // Mostrar la salida en tiempo real
                    if (line.contains("es correcto")) {
                        i = 3; // Salir del bucle

                    }
                }
                reader.close();
                p.waitFor();

            } catch (IOException e) {
                System.err.println("Error de E/S: " + e.getMessage());
            } catch (InterruptedException e) {
                System.err.println("Proceso interrumpido: " + e.getMessage());
            }
        }

        System.out.println("Fin del programa");
        entrada.close();
    }
}
