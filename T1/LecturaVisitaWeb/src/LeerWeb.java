import java.io.IOException;
import java.util.Scanner;

public class LeerWeb {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entra el nombre de hasta 3 páginas web (separadas por @): ");
        String websString = sc.nextLine();
        sc.close();
        String[] webs = websString.split("@");
        Process procesoWeb = new ProcessBuilder("java", "VisitarWeb").start();
    }
}