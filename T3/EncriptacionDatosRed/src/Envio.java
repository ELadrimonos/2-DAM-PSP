import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Envio {

    public static void main(String[] args) {
        MessageDigest md;

        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        String datos = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme";
        byte[] dataBytes = datos.getBytes();
        md.update(dataBytes);
        byte[] resumen = md.digest();

        try (FileOutputStream fileout = new FileOutputStream("Datos.dat"); ObjectOutputStream out = new ObjectOutputStream(fileout)) {
            out.writeObject(datos);
            out.writeObject(resumen);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}