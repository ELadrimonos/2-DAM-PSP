import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Usuario {

    public static final int PUERTO = 3200;
    public static DatagramSocket socket = null;

    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        socket = new DatagramSocket(PUERTO);
        String opcion;
        boolean fin = false;

        do {
            mostrarMenu();
            opcion = entrada.nextLine();
            byte[] buffer = opcion.getBytes();
            DatagramPacket envio = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), Servidor.PUERTO);
            socket.send(envio);
            switch (opcion) {
                case "1":
                    System.out.println("Listado en el servidor.");
                    break;
                case "2":
                case "3":
                    System.out.println("Introduce el nombre del cliente:");
                    String nombre = entrada.nextLine();
                    buffer = nombre.getBytes();
                    envio = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), Servidor.PUERTO);
                    socket.send(envio);
                    break;
                case "123":
                    System.out.println("MODO ROOT: Apagando el Servidor desde el Cliente...");
                case "4":
                    fin = true;
                    socket.close();
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (! fin);
        entrada.close();
    }

    public static void mostrarMenu() {
        System.out.println("==TICKETSERVER==");
        System.out.println("Introduzca una opción:");
        System.out.println("1-Listar butacas");
        System.out.println("2-Reservar butacas");
        System.out.println("3-Anular butacas");
        System.out.println("4-Salir");
    }
}