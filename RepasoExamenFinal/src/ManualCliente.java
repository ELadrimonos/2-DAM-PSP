import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ManualCliente {
    public static void main(String[] args) {
        try {
            System.out.println("Iniciando cliente...");
            Socket socket = new Socket( InetAddress.getLocalHost(), ManualServidor.PUERTO );
            System.out.println("Conectado!!");

            Scanner entrada = new Scanner(System.in);

            InputStream in = socket.getInputStream();
            DataInputStream dataIn = new DataInputStream(in);
            OutputStream out = socket.getOutputStream();
            DataOutputStream dataOut = new DataOutputStream(out);

            String comando;
            do {
                System.out.print("Introduzca el comando: ");
                comando = entrada.nextLine();
                dataOut.writeUTF(comando);
                System.out.println("Se ha enviado el comando: " + comando);
                System.out.println(dataIn.readUTF());
            } while (!comando.isBlank());

            dataIn.close();
            dataOut.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
