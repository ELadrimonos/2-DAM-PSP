import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Servidor {

    public static int PUERTO = 32323;

    public static void main(String[] args) {
        String[] burgers = {"Cheeseburger", "Whooper", "Long chicken"};
        String[] company = {"Patatas clasicas", "Patatas supereme", "Aros de cebolla"};
        String[] refrescos = {"Cocacola", "Nestea", "Monster"};

        String burger_def = "";
        String company_def = "";
        String refresco_def = "";

        byte[] buffer = new byte[1024];

        System.out.println("Iniciado el servidor UDP");
        DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);

        Pedido pedidoAValidar;
        Pedido pedidoConfirmado;

        try {
            DatagramSocket socketUDP = new DatagramSocket(Cliente.PUERTO);
            socketUDP.receive(recibo);

            InputStream is = new ByteArrayInputStream(recibo.getData());
            ObjectInputStream ois = new ObjectInputStream(is);

            pedidoAValidar = (Pedido) ois.readObject();
            ois.close();
            is.close();

            burger_def = pedidoAValidar.getNombreBurger();
            company_def = pedidoAValidar.getNombreAcompa();
            refresco_def = pedidoAValidar.getBebida();

            System.out.println("Pedido recibido: " + pedidoAValidar);


            if (!Arrays.asList(burgers).contains(burger_def)) {
                pedidoAValidar.setNombreBurger("_");
            }

            if (company_def != null && !Arrays.asList(company).contains(company_def)) {
                pedidoAValidar.setNombreAcompa("_");
            }

            if (refresco_def != null && !Arrays.asList(refrescos).contains(refresco_def)) {
                pedidoAValidar.setBebida("_");
            }




            System.out.println("Pedido confirmado: " + pedidoAValidar);

            pedidoConfirmado = new Pedido(pedidoAValidar.getNombreBurger(),
                    pedidoAValidar.getNombreAcompa(), pedidoAValidar.getBebida());


            ByteArrayOutputStream boas = new ByteArrayOutputStream();
            ObjectOutputStream ous = new ObjectOutputStream(boas);
            ous.writeObject(pedidoConfirmado);
            byte[] bufferObjeto = boas.toByteArray();
            ous.close();
            boas.close();

            InetAddress destino = InetAddress.getLocalHost();

            DatagramPacket paquete = new DatagramPacket(bufferObjeto, bufferObjeto.length, destino, PUERTO);

            socketUDP.send(paquete);

            socketUDP.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("Cerrando conexión...");
    }
}