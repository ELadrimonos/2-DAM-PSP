import java.io.IOException;

public class VisitarWeb {
    public static void main(String[] args) throws IOException {
        switch (args.length){
            case 1 -> new ProcessBuilder("firefox", args[0]).start();
            case 2 -> new ProcessBuilder("firefox", args[0], args[1]).start();
            case 3 -> new ProcessBuilder("firefox", args[0], args[1], args[2]).start();
            case 0 -> throw new IllegalArgumentException("Ningún argumento");
            default -> throw new IllegalArgumentException("Demasiados argumentos");
        }

    }
}
