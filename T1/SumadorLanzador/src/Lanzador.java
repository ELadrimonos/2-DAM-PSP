import java.io.File;
import java.io.InputStream;

public class Lanzador {
    public static void main(String[] args) {
        File directorio = new File("src");
        ProcessBuilder pb =  new ProcessBuilder("java", "Sumador.java", "1", "10");
        pb.directory(directorio);
        try {
            Process p1 = pb.start();

            InputStream is = p1.getInputStream();
            int c;
            while((c = is.read())!=-1)
                System.out.print((char)c);
            is.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
