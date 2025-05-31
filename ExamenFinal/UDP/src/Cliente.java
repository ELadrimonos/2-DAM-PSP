import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {

    public static int PUERTO = 32313;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenido a BurriKing! Haga su pedido en 3 pasos: ");
        System.out.print("1- Introduzca el nombre de su Burger: ");
        String burger = entrada.nextLine();

        if (burger.isBlank()) {
            System.err.println("La hamburguesa es obligatoria");
            return;
        }

        System.out.print("2- Introduzca el nombre del acompañamiento: ");
        String acomp = entrada.nextLine();
        System.out.print("3- Introduzca el nombre de su refresco: ");
        String bebida = entrada.nextLine();


        Pedido pedidoAConfirmar;

        if (!acomp.isBlank() && !bebida.isBlank()) pedidoAConfirmar = new Pedido(burger, acomp, bebida);
        else if (acomp.isBlank() && bebida.isBlank()) pedidoAConfirmar = new Pedido(burger);
        else {
            pedidoAConfirmar = new Pedido(burger, (bebida.isBlank() ? acomp : bebida), (!bebida.isBlank()));
        }


        try {
            ByteArrayOutputStream boas = new ByteArrayOutputStream();
            ObjectOutputStream ous = new ObjectOutputStream(boas);
            ous.writeObject(pedidoAConfirmar);

            byte[] bufferObjeto = boas.toByteArray();
            ous.close();
            boas.close();

            InetAddress destino = InetAddress.getLocalHost();

            DatagramPacket paquete = new DatagramPacket(bufferObjeto, bufferObjeto.length, destino, PUERTO);

            DatagramSocket socketServidor = new DatagramSocket(Servidor.PUERTO);

            socketServidor.send(paquete);




            byte[] buffer = new byte[1024];

            DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
            socketServidor.receive(recibo);

            byte[] datos = recibo.getData();
            socketServidor.close();

            Pedido pedidoConfirmado;


            InputStream is = new ByteArrayInputStream(datos);
            ObjectInputStream ois = new ObjectInputStream(is);

            // FIXME ESTO LANZA ERROR DE STREAM
            pedidoConfirmado = (Pedido) ois.readObject();
            ois.close();
            is.close();

            System.out.println("Recibido el pedido validado!!");
            System.out.println("Tu pedido es: " + pedidoConfirmado);

        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}