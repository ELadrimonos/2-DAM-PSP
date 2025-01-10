import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPObjetoCliente1 {

    public static void main(String[] args) {

        try {
            Socket cliente = new Socket(InetAddress.getLocalHost(), TCPObjetoServidor1.PUERTO);

            InputStream in = cliente.getInputStream();
            OutputStream out = cliente.getOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            ObjectInputStream inputStream = new ObjectInputStream(in);

            Persona personaServidor = (Persona) inputStream.readObject();
            System.out.println("Recibido objeto: " + personaServidor);

            personaServidor.setNombre("David");
            personaServidor.setEdad(200);

            outputStream.writeObject(personaServidor);
            System.out.println("Enviado objeto: " + personaServidor);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
