import java.io.IOException;
import java.net.*;

public class Minmap {
    public static void main(String[] args) {
        try {
            InetAddress host = InetAddress.getLocalHost();
            System.out.println("Iniciando escaneo de puertos");

            for (int i = 0; i < 1023; i++) {
                Socket sCliente = null;
                try {
                    sCliente = new Socket( host, i );
                    System.out.println("El puerto " + i + " está abierto");
                    sCliente.close();
                } catch (ConnectException e) {
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}