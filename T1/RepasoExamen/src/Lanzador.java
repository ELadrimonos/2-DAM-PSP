import java.io.*;
import java.util.Scanner;

public class Lanzador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una cadena para buscar en el fichero: ");
        String cadena = sc.nextLine();
        sc.close();

        ProcessBuilder pb = new ProcessBuilder("java", "LectorFichero.java");
        pb.directory(new File(System.getProperty("user.dir") + "/src"));

        try {
            Process p = pb.start();

            OutputStream os = p.getOutputStream();

            os.write((cadena + "\n").getBytes());
            os.flush();
            os.close();

            InputStream es = p.getErrorStream();
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(es));
            String errorLine;
            while ((errorLine = errorReader.readLine()) != null) {
                System.err.println("Error del proceso: " + errorLine);
            }
            errorReader.close();

            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String salidaPantalla;
            while ((salidaPantalla = br.readLine()) != null) {
                System.out.println(salidaPantalla);
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}