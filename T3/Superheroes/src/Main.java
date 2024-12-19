import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static ArrayList<Heroe> heroes = new ArrayList<>();

    public static void main(String[] args) {
        leerFicheroTXT();
        crearHTML("marvel", true);
        crearHTML("dcweb", false);
    }

    public static void leerFicheroTXT() {
        File archivo = new File("superheroes.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                Heroe heroe = new Heroe(datos[0], datos[1], datos[2], datos[3]);
                heroes.add(heroe);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el archivo: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + archivo.getAbsolutePath());
        }
    }

    public static void crearHTML(String nombreFichero, boolean esMarvel) {
        File archivo = new File(nombreFichero + (nombreFichero.endsWith(".html") ? "" : ".html"));

        final String cabecera = "<html><head><title>" + nombreFichero + "</title></head><body>";
        final String finArchivo = "</body></html>";
        final String tablaHTML = "<table style=\"margin: auto;\"><thead><tr><th colspan=\"4\">Superheroes</th></tr>" +
                "<tr><th>Imagen</th><th>Nombre</th><th>Identidad secreta</th><th>Descripcion</th></tr><thead><tbody>";
        final String finTablaHTML = "</tbody></table>";
        String contenidoTablaHTML = "";

        for (Heroe heroe : heroes) {
            if (heroe.esMarvel() == esMarvel) {
                String imagen = obtenerImagenHeroe(heroe.id);
                String filaHTML = String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",
                        imagen, heroe.nombre, heroe.identidadSecreta, heroe.descripcion);

                contenidoTablaHTML += filaHTML;
            }
        }

        final String documentoHTML = cabecera + tablaHTML + contenidoTablaHTML + finTablaHTML + finArchivo;

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(documentoHTML);
            bw.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + archivo.getAbsolutePath());
        }
    }
    @SuppressWarnings({"deprecation"})
    private static String obtenerImagenHeroe(String idHeroe){
        URL url;
        try {
            url = new URL("http://mural.uv.es/franpevi/index.html");
        } catch (MalformedURLException e) {
            System.err.println("La url no es correcta");
            return "";
        }

        InputStream is;
        try {
            is = url.openStream();
            StringBuilder datos = new StringBuilder();
            int byteCaracter;

            while ((byteCaracter = is.read()) != - 1) {
                if ((char) byteCaracter != '\n') {
                    datos.append((char) byteCaracter);
                }
            }
            is.close();

            Pattern patternIMG = Pattern.compile("<img\\b[^>]*>", Pattern.CASE_INSENSITIVE);
            Pattern patternCLASS = Pattern.compile("class=\"([^\"]*)\"", Pattern.CASE_INSENSITIVE);
            Matcher matcherIMG = patternIMG.matcher(datos.toString());


            while (matcherIMG.find()) {
                String contenido = matcherIMG.group(0);
                Matcher matcherCLASS = patternCLASS.matcher(contenido);
                if (matcherCLASS.find()) {
                    if (Objects.equals(matcherCLASS.group(1), idHeroe)) {
                        return contenido;
                    }
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }
}