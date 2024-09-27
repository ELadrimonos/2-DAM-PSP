import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class LeerWeb {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entra el nombre de hasta 3 páginas web (separadas por @): ");
        String websString = sc.nextLine();
        ProcessBuilder pbWeb = new ProcessBuilder("java", "VisitarWeb.java", websString);
        pbWeb.directory(new File("src"));
        sc.close();
        Process pWeb = pbWeb.start();

        try {
            InputStream isWeb= pWeb.getInputStream();
            int c;
            while ((c = isWeb.read()) != -1) {
                System.out.print((char) c);
            }
            isWeb.close();

        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}