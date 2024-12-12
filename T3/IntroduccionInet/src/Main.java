import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        try {
            String[] urls = {"localhost", "www.marca.es", "www.google.es", "www.github.com", ""};
            for (String url : urls) {
                printIPData(url);
            }

        } catch (UnknownHostException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void printIPData(String url) throws UnknownHostException {
        // El getByName si pasas una string vacia coge el localhost
        boolean esLocalHost = Objects.equals(url.toLowerCase(), "localhost") || url.isEmpty();

        InetAddress host = esLocalHost ? InetAddress.getLocalHost() : InetAddress.getByName(url);

        System.out.println("\nSALIDA PARA " + (esLocalHost ? "LOCALHOST" : "UNA URL") + ": " + host.getHostName());

        System.out.println("getByName: " + host);
        System.out.println("getLocalHost: " + InetAddress.getLocalHost());
        System.out.println("getHostName: " + host.getHostName());
        System.out.println("getHostAddress: " + host.getHostAddress());
        System.out.println("toString: " + host.toString());
        System.out.println("getCanonicalHostName: " + host.getCanonicalHostName());
        if (! esLocalHost) {
            System.out.println("DIRECCIONES IP PARA: " + host.getHostAddress());
            for (InetAddress direccion : InetAddress.getAllByName(url)) {
                System.out.println("\t\t" + direccion);

            }
        }
        System.out.println("\n===============================================================");
    }
}