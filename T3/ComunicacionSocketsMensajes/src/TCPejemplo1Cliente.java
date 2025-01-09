import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPejemplo1Cliente {
    public static void main(String[] args) {
        try{
            System.out.println("Iniciando cliente...");
            Socket socket = new Socket( InetAddress.getLocalHost(), TCPejemplo1Servidor.PUERTO );
            System.out.println("Conectado!!");

            InputStream in = socket.getInputStream();
            DataInputStream dataIn = new DataInputStream(in);
            OutputStream out = socket.getOutputStream();
            DataOutputStream dataOut = new DataOutputStream(out);

            dataOut.writeUTF("Hola Don José!");
            System.out.println("Recibiendo del servidor: " + dataIn.readUTF());

            dataIn.close();
            dataOut.close();
            socket.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }
}
