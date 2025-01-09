import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class Servidor {

    static final int PUERTO = 2000;

    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(PUERTO);
            System.out.println("Arrancado Servidor. Esperando conexión...");
            Socket cliente = servidor.accept();
            System.out.println("Conexión establecida.");

            InputStream in = cliente.getInputStream();
            DataInputStream dataIn = new DataInputStream(in);

            String producto = dataIn.readUTF();

            guardarEnElFichero(producto);
            System.out.println("Se ha recibido el producto: " + producto);

            in.close();
            dataIn.close();
            cliente.close();
            servidor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void guardarEnElFichero(String producto) {
        File directorio = new File(System.getProperty("user.dir") + "/archivos/");
        if (!directorio.exists()) {
            directorio.mkdir();
        }
        File archivo = new File(directorio + "/" + obtenerFechaActual() + ".txt");
        try {
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(producto);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static String obtenerFechaActual() {
        ZoneId z = ZoneId.of("Europe/Paris");
        ZonedDateTime zdt = ZonedDateTime.now(z);
        Date fecha = Date.from(zdt.toInstant());
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(fecha);
    }
}
