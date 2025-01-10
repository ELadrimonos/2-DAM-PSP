import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPObjetoServidor1 {

    static int PUERTO = 2000;

    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(PUERTO);

            System.out.println("Esperando conexión...");
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado");

            Persona objetoPersona = new Persona("Adrián", 20);
            System.out.println("Creado objeto: " + objetoPersona);

            OutputStream out = cliente.getOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(out);

            outputStream.writeObject(objetoPersona);

            InputStream in  = cliente.getInputStream();
            ObjectInputStream inputStream = new ObjectInputStream(in);

            Persona objetoModificado = (Persona) inputStream.readObject();
            System.out.println("Objeto modificado: " + objetoModificado);

            outputStream.close();
            out.close();
            inputStream.close();
            in.close();
            cliente.close();
            servidor.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
