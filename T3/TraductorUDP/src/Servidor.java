import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Objects;

public class Servidor {
    public static final int PUERTO = 6000;

    public static DatagramSocket socket = null;

    static final HashMap<String, String> diccionario = new HashMap<>();

    public static void main(String[] args) {
        llenarDatos();
        try {
            socket = new DatagramSocket(PUERTO);
            System.out.println("Servidor iniciado");
            while (true) {
                byte[] buffer = new byte[64];

                DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
                socket.receive(recibo);
                String palabra = new String(recibo.getData(), 0, recibo.getLength());
                System.out.println("Recibiendo: " + palabra);
                String traduccion = encontrarTraduccion(palabra);
                System.out.println("Traduccion: " + traduccion);
                if (! traduccion.equals("?")) {
                    buffer = traduccion.getBytes();
                    DatagramPacket envio = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), Cliente.PUERTO);
                    socket.send(envio);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static String encontrarTraduccion(String englishWord) {
        return diccionario.getOrDefault(englishWord, "?");
    }

    private static void llenarDatos() {
        diccionario.put("hello", "hola");
        diccionario.put("world", "mundo");
        diccionario.put("dog", "perro");
        diccionario.put("cat", "gato");
        diccionario.put("food", "comida");
    }
}
