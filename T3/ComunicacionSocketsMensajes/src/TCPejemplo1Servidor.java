import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPejemplo1Servidor {

    static final int PUERTO = 2000;

    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(PUERTO);
            System.out.println("Esperando conexión...");

            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado!!!");

            InputStream in = cliente.getInputStream();
            DataInputStream dataIn = new DataInputStream(in);
            OutputStream out = cliente.getOutputStream();
            DataOutputStream dataOut = new DataOutputStream(out);

            dataOut.writeUTF("Hola Don Pepito!");
            System.out.println("Recibiendo del cliente: " + dataIn.readUTF());

            dataIn.close();
            dataOut.close();
            servidor.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
