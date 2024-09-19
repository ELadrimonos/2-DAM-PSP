import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la ruta absoluta del directorio para listar la imágenes: ");
        String ruta = scanner.nextLine();
        scanner.close();
        if (formatoRutaCorrecta(ruta)) {
//            ProcessBuilder pb = new ProcessBuilder("java", "ProcessListPNG.java", ruta);
            ProcessBuilder pb = new ProcessBuilder("cat", ruta);
            Process process = pb.start();
        }


    }

    public static boolean formatoRutaCorrecta(String ruta) {
        Pattern pattern = Pattern.compile("^(\\/[\\w-]+)+\\/?$");
        Matcher matcher = pattern.matcher(ruta);
        return matcher.find();
    }
}

