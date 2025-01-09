import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), ServidorPro.PUERTO);

            OutputStream out = socket.getOutputStream();
            DataOutputStream dataOut = new DataOutputStream(out);

            String producto;
            do {
                System.out.print("Introduce un producto: ");
                producto = in.nextLine();
                dataOut.writeUTF(producto);
            }
            while (!producto.equals("salir"));

            System.out.println("Se ha volcado el producto: " + producto + " a la lista de la compra");

            in.close();
            out.close();
            dataOut.close();
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
