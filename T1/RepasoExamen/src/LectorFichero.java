import java.io.*;

public class LectorFichero {
    public static void main(String[] args) {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader brStream = new BufferedReader(inputStreamReader);
        String cadena;
        boolean encontrada = false;

        try {
            cadena = brStream.readLine();
            brStream.close();

            File directorioActual = new File(System.getProperty("user.dir"));
            FileReader fr = new FileReader( directorioActual + "/archivo.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains(cadena)) {
                    System.out.println("La cadena " + cadena + " esta en el fichero");
                    encontrada = true;
                }
            }
            br.close();

            if (!encontrada) {
                System.out.println("La cadena " + cadena + " no esta en el fichero");

                FileWriter fw = new FileWriter( directorioActual + "/archivo.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.newLine();
                bw.write(cadena);
                bw.close();
            }

        } catch (IOException ioException) {
            System.err.println("Error!!: " + ioException.getMessage());
        }

    }
}
