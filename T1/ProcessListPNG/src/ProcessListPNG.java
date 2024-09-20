import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessListPNG {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la ruta absoluta del directorio para listar la imágenes: ");
        String ruta = scanner.nextLine();
        scanner.close();
        if (formatoRutaCorrecta(ruta)) {
            System.out.println("RUTA CORRECTA");
            ProcessBuilder pb = new ProcessBuilder("bash", "-c", "ls " + ruta + " | grep .png");
//            + " | grep *.png"
            Process p = pb.start();
            try {
                InputStream is = p.getInputStream();
                int c;
                while ((c = is.read()) != - 1) System.out.print((char) c);
                is.close();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }


    }

    public static boolean formatoRutaCorrecta(String ruta) {
        Pattern pattern = Pattern.compile("^(\\/[\\w-]+)+\\/?$");
        Matcher matcher = pattern.matcher(ruta);
        return matcher.find();
    }
}

