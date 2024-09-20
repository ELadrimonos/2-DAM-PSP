import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VisitarWeb {
    public static void main(String[] args) {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br= new BufferedReader(in);
        String texto;
        try {
            System.out.println("Introduce Cadena:");
            texto=br.readLine();
            System.out.println("Su Cadena: "+texto);
            in.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
