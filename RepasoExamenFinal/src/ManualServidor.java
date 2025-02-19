import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ManualServidor {

    public static int PUERTO = 65535;
    private static Socket cliente;

    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(PUERTO);
            System.out.println("Arrancado Servidor. Esperando conexión...");
            cliente = servidor.accept();
            System.out.println("Conexión establecida.");

            InputStream in = cliente.getInputStream();
            DataInputStream dataIn = new DataInputStream(in);

            String comando;
            do {
                comando = dataIn.readUTF();
                System.out.println("Se ha recibido el comando: " + comando);
                ejecutarProceso(comando);
            } while (! comando.isBlank());


            in.close();
            dataIn.close();
            cliente.close();
            servidor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void ejecutarProceso(String comando) {
        ProcessBuilder pb = new ProcessBuilder("bash", "-c", "man " + comando);

        try {
            OutputStream out = cliente.getOutputStream();
            DataOutputStream dataOut = new DataOutputStream(out);

            Process p = pb.start();
            InputStream in = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            StringBuilder resultado = new StringBuilder();
            String lineaPantalla;
            boolean llegadoADescription = false;

            while ((lineaPantalla = br.readLine()) != null && ! llegadoADescription) {
                if (lineaPantalla.toLowerCase().contains("description")) llegadoADescription = true;
                else {
                    resultado.append(lineaPantalla).append("\n");
                }
            }
            br.close();

            dataOut.writeUTF(resultado.toString());
            dataOut.flush();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}