import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {
    public static final int PUERTO = 3000;

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(PUERTO);
             Scanner entrada = new Scanner(System.in)) {

            while (true) {
                System.out.print("Palabra en inglés: ");
                String palabraIngles = entrada.nextLine();

                byte[] buffer = palabraIngles.getBytes();
                DatagramPacket envio = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), Servidor.PUERTO);
                socket.send(envio);

                socket.setSoTimeout(5000);

                buffer = new byte[64];
                DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);

                try {
                    socket.receive(recibo);
                    String palabraTraducida = new String(recibo.getData(), 0, recibo.getLength()).trim();
                    System.out.println("Traducción: " + palabraTraducida);
                } catch (InterruptedIOException e) {
                    System.out.println("No se encontró traducción.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
