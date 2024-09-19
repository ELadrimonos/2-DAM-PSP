import java.io.File;
import java.util.Objects;

public class ProcessListPNG {
    public static void main(String[] args) {
        File directorio = new File(args[0]);
        for (File f : Objects.requireNonNull(directorio.listFiles())
        ) {
            if (f.getName().endsWith(".png")) {
                System.out.println(f.getName());
            }
        }
        System.out.println("Terminado de listar");
    }
}