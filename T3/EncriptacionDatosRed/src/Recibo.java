import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Recibo {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchAlgorithmException {
        FileInputStream filein = new FileInputStream("Datos.dat");
        ObjectInputStream dataOS = new ObjectInputStream(filein);
        Object o = dataOS.readObject();

        // Primera lectura, se obtiene el String original
        String datos = (String) o;
        System.out.println("Datos: " + datos);

        // Segunda lectura, se obtiene el resumen (string codificado)
        o = dataOS.readObject();
        byte[] resumenOriginal = (byte[]) o; // Lo pasamos de Object a bytes

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(datos.getBytes());
        byte[] resumenActual = md.digest(); // Encriptamos los datos originales para comprobar si los dos hashes son iguales

        if (MessageDigest.isEqual(resumenActual, resumenOriginal))
            System.out.println("DATOS VÁLIDOS");

        else
            System.out.println("DATOS NO VÁLIDOS");
        dataOS.close();
        filein.close();
    }
}
