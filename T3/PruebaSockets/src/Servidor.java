import java.net.*;
public class Servidor {
    static final int Puerto = 2000;
    public static void main( String[] arg ) {
        try {
            // Inicio la escucha del servidor en un determinado puerto
            ServerSocket skServidor = new ServerSocket(Puerto);
            System.out.println("Escuchando en el puerto "+Puerto);
            System.out.println("Esperando al cliente... ");
            // Aquí atiendo la petición del cliente1 ...
            Socket sCliente1 = skServidor.accept();
            System.out.println("Conectado Cliente 1!!: " + sCliente1.getInetAddress().getHostAddress());
            System.out.println("Escuchando al Cliente 2 ");
            // Aquí atiendo la petición del cliente2 ...
            Socket sCliente2 = skServidor.accept();
            // Cierro el socket
            skServidor.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
        System.out.println("Servidor cerrado. ");
    }
}