import java.io.*;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {

        //		NOTE: Eclipse utiliza el directorio bin y IDEA emplea el directorio src
        File directorio = new File("src");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce una cadena de texto (o 'salir' para terminar):");

        String texto = scanner.nextLine();
        while (! texto.equalsIgnoreCase("salir")) {
            // NOTE: En IntelliJ hay que agregar la extensión .java para ejecutar programas Java (no sé el caso en Eclipse)
            ProcessBuilder pb = new ProcessBuilder("java", "Palindromo.java");
            pb.directory(directorio);


            pb.redirectError(ProcessBuilder.Redirect.appendTo(new File("errores.txt")));
            pb.redirectOutput(ProcessBuilder.Redirect.appendTo(new File("Lectura.txt")));

            Process p = pb.start();

            // escritura -- envia entrada a DATE
            OutputStream os = p.getOutputStream();
            os.write(texto.getBytes());
            os.flush(); // vacía el buffer de salida

            // lectura -- obtiene la salida de DATE
            try {
                InputStream is = p.getInputStream();
                int c;
                while ((c = is.read()) != - 1) System.out.print((char) c);
                is.close();
            } catch (Exception e) {
                e.getMessage();
            }
            System.out.println("\nIntroduce otra cadena de texto (o 'salir' para terminar):");
            texto = scanner.nextLine();
        }

    }

}
