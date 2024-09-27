import java.io.IOException;

public class VisitarWeb {
    public static void main(String[] args) throws IOException, IllegalArgumentException {
        try {
            // Como se pasa un valor vacío string si el usuario no introduce nada en el lanzador
            // Tengo que comprobar esto aquí en vez de ver la longitud de array webs

            if (args.length == 0 || args[0].isEmpty()) {
                throw new IllegalArgumentException("No hay argumentos");
            }
            String[] webs = formatearWebs(args[0]);
            visitarWebs(webs);
        } catch (IllegalArgumentException e) {
            // Muestro en pantalla el error de argumentos para que se muestre en el proceso origen
            System.out.println(e);
        }

    }

    public static void visitarWebs(String[] webs) throws IOException {
        switch (webs.length) {
            case 1: new ProcessBuilder("firefox", webs[0]).start(); break;
            case 2: new ProcessBuilder("firefox", webs[0], webs[1]).start(); break;
            case 3: new ProcessBuilder("firefox", webs[0], webs[1], webs[2]).start(); break;
            default: throw new IllegalArgumentException("Demasiados argumentos");
        }
    }

    public static String[] formatearWebs(String webs) {
        return webs.split("@");
    }
}
