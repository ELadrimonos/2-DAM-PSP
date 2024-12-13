import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    @SuppressWarnings({"deprecation"})
    public static void main(String[] args) {
        final String dominio = "www.marca.com";
        final String protocolo = "https";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Dime una etiqueta HTML para buscar en " + dominio + " (sin <> y vacío para h2): ");
        String etiqueta = scanner.nextLine();
        try {
            String sUrl = protocolo + "://" + dominio + "/";
            URL url = new URL(sUrl);

            etiqueta = (etiqueta.isEmpty()) ? "h2" : etiqueta;

            printHTMLTag(url, etiqueta);
        } catch (MalformedURLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void printHTMLTag(URL url, String etiqueta) {
        try {
            InputStream is = url.openStream();
            StringBuilder datos = new StringBuilder();
            int byteCaracter;

            while ((byteCaracter = is.read()) != - 1) {
                if ((char) byteCaracter != '\n') {
                    datos.append((char) byteCaracter);
                }
            }
            is.close();

            Pattern pattern = Pattern.compile("<"+ etiqueta + "\\b[^>]*>(.*?)</" + etiqueta +">", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(datos.toString());

            File archivoOutput = new File("Resultados_<" + etiqueta + ">_en_" + url.getHost() + ".html");
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoOutput));

            while (matcher.find()) {
                String contenido = matcher.group(0);
                bw.write(contenido);
                bw.newLine();
            }
            bw.close();
            System.out.println("Resultados guardados en: " + archivoOutput.getAbsolutePath());

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}