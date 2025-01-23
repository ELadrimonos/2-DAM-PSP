import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {

    public static final int PUERTO = 34567;

    public static void main(String[] args) throws IOException {
        System.out.println("Introduce el mensaje");
        Scanner entrada = new Scanner(System.in);

        byte[] buffer;
        String mensaje = entrada.nextLine();

        buffer = mensaje.getBytes();

        DatagramPacket envio = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), Servidor.PUERTO);
        DatagramSocket socketUDP = new DatagramSocket(PUERTO);

        socketUDP.send(envio);
        buffer = new byte[1024];

        System.out.println("Esperando datagrama...");

        DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
        socketUDP.receive(recibo);
        String numLetras = new String(recibo.getData(), 0, recibo.getLength());
        System.out.println("Numero letras 'a': " + numLetras);

        socketUDP.close();
    }
}
