import java.util.Random;

public class Coche extends Thread {

    private final int id;
    private int distanciaRecorrida = 0;

    private int tiempoRecorrido = 0;
    static public Coche ganador;

    public Coche( String marca, int id) {
        super(marca);
        this.id = id;
        System.out.printf("Coche creado: %s(%d)\n", marca, id);
    }

    public int obtenerID() {
        return this.id;
    }

    public int obtenerTiempoRecorrido() {
        return tiempoRecorrido;
    }

    @Override
    public void run() {
        Random rn = new Random();
        do {
            try {
                int km = rn.nextInt(100) + 1;
                distanciaRecorrida += km;
                sleep(1000);
                tiempoRecorrido++;
                System.out.printf("%s(%d) lleva recorrido %dkm\n", getName(), id, distanciaRecorrida);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (distanciaRecorrida < 500);
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%s(%d) ha finalizado al recorrer %dkm - %ds\n\n", getName(), id, distanciaRecorrida, tiempoRecorrido);
        if (ganador == null) ganador = this;
    }
}
