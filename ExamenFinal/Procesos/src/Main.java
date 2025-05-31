import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String opcion = "";

        do {
            mostrarMenu();
            opcion = entrada.nextLine();
            switch (opcion) {
                case "1":
                    obtenerCompleto();
                    break;
                case "2":
                    obtenerPrimeros();
                    break;
                case "3":
                    obtenerUltimos();
                    break;
                case "4":
                    obtenerPares();
                    break;
                case "5":
                    obtenerImpares();
                    break;
                case "6":
                    System.out.println("Saliendo.... Gracias por utilizar el histórico...");
                    break;
                default:
                    System.out.println("Opción desconocida");
            }

        } while (!opcion.equals("6"));
    }

    public static void mostrarMenu() {
        System.out.println("--------------");
        System.out.println("1 Obtener histórico completo");
        System.out.println("2 Obtener solo las primeras 10 líneas");
        System.out.println("3 Obtener solo las 10 últimas líneas");
        System.out.println("4 Obtener líneas pares");
        System.out.println("5 Obtener líneas impares");
        System.out.println("Salir");
        System.out.println("--------------");
    }

    public static void obtenerCompleto(){
        ProcessBuilder pb = new ProcessBuilder("cat", "historico.txt");
        pb.directory(new File(System.getProperty("user.dir") + "/src"));
        try {
            Process proceso = pb.start();

            mostrarDatosPorPantalla(proceso);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void obtenerPrimeros(){
        ProcessBuilder pb = new ProcessBuilder("head", "historico.txt");
        pb.directory(new File(System.getProperty("user.dir") + "/src"));
        try {
            Process proceso = pb.start();

            mostrarDatosPorPantalla(proceso);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void obtenerUltimos(){
        ProcessBuilder pb = new ProcessBuilder("tail", "historico.txt");
        pb.directory(new File(System.getProperty("user.dir") + "/src"));
        try {
            Process proceso = pb.start();

            mostrarDatosPorPantalla(proceso);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void obtenerPares(){
        ProcessBuilder pb = new ProcessBuilder("sed", "-n", "2~2p", "historico.txt");
        pb.directory(new File(System.getProperty("user.dir") + "/src"));
        try {
            Process proceso = pb.start();

            mostrarDatosPorPantalla(proceso);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void obtenerImpares(){
        ProcessBuilder pb = new ProcessBuilder("sed", "-n", "1~2p", "historico.txt");
        pb.directory(new File(System.getProperty("user.dir") + "/src"));
        try {
            Process proceso = pb.start();

            mostrarDatosPorPantalla(proceso);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static void mostrarDatosPorPantalla(Process proceso) throws IOException {
        InputStream is = proceso.getInputStream();
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char)c);
        }

        InputStream ies = proceso.getErrorStream();
        int e;
        while ((e = ies.read()) != -1) {
            System.err.print((char)e);
        }
    }
}