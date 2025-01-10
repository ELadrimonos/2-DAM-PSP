import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    static int PUERTO = 2000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("Esperando conexión del cliente...");

            Socket cliente = serverSocket.accept();
            System.out.println("Cliente conectado");

            InputStream in = cliente.getInputStream();
            ObjectInputStream inputStream = new ObjectInputStream(in);

            OutputStream out = cliente.getOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(out);

            Object arrayList = inputStream.readObject();
            System.out.println("Objeto recibido del cliente: " + arrayList.toString());

            outputStream.writeObject("Mensaje recibido correctamente en el servidor");

            inputStream.close();
            in.close();
            outputStream.close();
            out.close();
            cliente.close();
            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Conexión cerrada");
        }
    }
}
