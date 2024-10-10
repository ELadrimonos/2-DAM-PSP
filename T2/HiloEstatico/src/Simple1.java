import java.util.ArrayList;

public class Simple1 {
    public static void main(String[] args) {

        ArrayList<Hilo> hilos = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            hilos.add(new Hilo());
        }

        for (Hilo hilo : hilos) {
            hilo.start();
        }

        // Si no espero que finalicen todos los hilos (con join), el valor parece aleatorio
        System.out.println(Hilo.contador);
    }
}