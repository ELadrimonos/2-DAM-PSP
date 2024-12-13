import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    @SuppressWarnings({"deprecation"})
    public static void main(String[] args) {
        final String dominio = "www.marca.com";
        final String protocolo = "https";

        try {
            String sUrlDirecta = protocolo + "://" + dominio + "/";
            URL urlDirecta = new URL(sUrlDirecta);

            URL urlDividida = new URL(protocolo, dominio, "/23");

            URL urlDivididaPuerto = new URL(protocolo, dominio, 123, "/23");

            URL[] urls = {urlDirecta, urlDividida, urlDivididaPuerto};

            for (URL url : urls) {
                printURLData(url);
                System.out.println("\n==================================\n");
            }

        } catch (MalformedURLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void printURLData(URL url) {
        System.out.println("URL Completa: " + url);
        System.out.println("Protocolo: " + url.getProtocol());
        System.out.println("Host: " + url.getHost());
        System.out.println("Puerto: " + url.getPort());
        System.out.println("Ruta: " + url.getPath());
        System.out.println("Archivo: " + url.getFile());
        System.out.println("UserInfo: " + url.getUserInfo());
        System.out.println("Autoridad: " + url.getAuthority());
        System.out.println("Query: " + url.getQuery());
        System.out.println("Puerto Default: " + url.getDefaultPort());

        BufferedReader in;
        //FIXME: No finaliza en datos vacios
        try {
            InputStream is = url.openStream();
            in = new BufferedReader(new InputStreamReader(is));


            File archivoOutput = new File( "output_" + url.getHost() + ".html");
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoOutput));

            String inputLine = in.readLine();
            if (inputLine != null) {
                do {
                    System.out.println(inputLine);
                    bw.write(inputLine);
                    bw.newLine();
                } while ((inputLine = in.readLine()) != null);
            }



            in.close();
            bw.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}