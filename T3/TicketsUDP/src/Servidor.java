import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;

public class Servidor {

    public static final int PUERTO = 2000;
    public static DatagramSocket socket = null;

    private static final ArrayList<String> butacas = new ArrayList<>(4);

    public static void main(String[] args) throws IOException {
        socket = new DatagramSocket(PUERTO);
        boolean fin = false;
        while (! fin) {
            byte[] buffer = new byte[64];
            DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
            socket.receive(recibo);
            String opcionTexto = new String(recibo.getData(), 0, recibo.getLength());
            String nombreTexto;
            switch (opcionTexto) {
                case "1":
                    listarButacas();
                    break;
                case "2":
                case "3":
                    buffer = new byte[64];
                    recibo = new DatagramPacket(buffer, buffer.length);
                    socket.receive(recibo);
                    nombreTexto = new String(recibo.getData(), 0, recibo.getLength());
                    if (opcionTexto.equals("2")) reservarButaca(nombreTexto);
                    else anularButaca(nombreTexto);
                    break;
                case "123":
                    cerrarServidor();
                    fin = true;
                    break;
            }
        }
    }

    public static void listarButacas() {
        for (int i = 0; i < 4; i++) {
            try {
                String cliente = butacas.get(i);
                System.out.println((i + 1) + ": " + cliente);
            } catch (Exception e) {
                System.out.println((i + 1) + ": LIBRE!!!!");
            }
        }
    }

    public static void reservarButaca(String cliente) {
        if (butacas.contains(cliente)) return;
        butacas.add(cliente);
        System.out.println("Reservar: " + cliente);
    }

    public static void anularButaca(String cliente) {
        if (! butacas.contains(cliente)) return;
        butacas.remove(cliente);
        System.out.println("Anular: " + cliente);
    }

    public static void cerrarServidor() {
        System.out.println("Cerrando servidor...");
        socket.close();
    }
}
