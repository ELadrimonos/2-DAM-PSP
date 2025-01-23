import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {

    static final int PUERTO = 12345;

    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[1024];
        System.out.println("Servidor esperando datagrama...");

        DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);

        DatagramSocket socketUDP = new DatagramSocket(PUERTO);

        socketUDP.receive(recibo);
        String recibo_texto = new String(recibo.getData(), 0, recibo.getLength());

        int numApariciones = numeroAs(recibo_texto);
        System.out.println("Enviando número apariciones letra 'a': " + numApariciones);
        buffer = Integer.toString(numApariciones).getBytes();

        DatagramPacket envio = new DatagramPacket(buffer, buffer.length, recibo.getAddress(), recibo.getPort());
        socketUDP.send(envio);

        System.out.println("Cerrando servidor...");
        socketUDP.close();
    }

    public static int numeroAs(String cadena) {
        int cont = 0;
        for (String caracter : cadena.split("")) {
            if (caracter.equals("a")) {
                cont++;
            }
        }
        return cont;
    }
}