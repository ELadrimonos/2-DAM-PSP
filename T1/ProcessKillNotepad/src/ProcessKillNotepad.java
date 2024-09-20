import java.io.IOException;

public class ProcessKillNotepad {
    public static void main(String[] args) throws IOException, InterruptedException {
        // kwrite es el editor de texto que utiliza LLiurex
        ProcessBuilder pb = new ProcessBuilder("kwrite");
        Process p = pb.start();
        System.out.println("Proceso iniciado!!");
        Thread.sleep(10000);
        p.destroy();
        System.out.println("Proceso destruido!!");
    }
}