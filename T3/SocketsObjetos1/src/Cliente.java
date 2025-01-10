import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), Servidor.PUERTO);
            System.out.println("Iniciando conexión con el servidor...");

            OutputStream out = socket.getOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(out);

            InputStream in  = socket.getInputStream();
            ObjectInputStream inputStream = new ObjectInputStream(in);

            ArrayList<String> clientes = new ArrayList<>();
            // Agregar nombres de clientes al ArrayList
            clientes.add("Juan Pérez");
            clientes.add("María López");
            clientes.add("Carlos García");
            clientes.add("Ana Martínez");

            outputStream.writeObject(clientes);
            System.out.println("Objeto enviado al servidor: " + clientes);

            Object respuestaServidor = inputStream.readObject();
            System.out.println("Objeto recibido del servidor: " + respuestaServidor.toString());

            outputStream.close();
            out.close();
            inputStream.close();
            in.close();
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Conexión cerrada");
        }
    }
}
