import java.net.InetAddress;
import java.net.Socket;

public class Cliente {
    static final String Host = "localhost";
    static final int Puerto=2000;

    public static void main( String[] arg ) {
        try{
            // Me conecto al servidor en un determinado puerto
            Socket sCliente = new Socket( Host, Puerto );
            // TAREAS QUE REALIZA EL CLIENTE
            InetAddress i = sCliente.getInetAddress();
            System.out.println("Host Remoto: "+i.getHostName());
            System.out.println("IP Host Remoto: "+i.getHostAddress());
            // Cierro el socket
            sCliente.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }
}