import java.util.ArrayList;

public class Friega extends Thread {
    PilaPlatos pilaPlatos;
    int numALimpiar;
    ArrayList<Plato> platosSucios;

    public Friega(int numPlatos, PilaPlatos pilaPlatos, ArrayList<Plato> listaPlatos) {
        super("Friega");
        this.pilaPlatos = pilaPlatos;
        this.numALimpiar = numPlatos;
        this.platosSucios = listaPlatos;
    }

    public void run() {
        while (numALimpiar > 0) {
            synchronized (pilaPlatos) { // Bloque sincronizado para evitar conflictos
                if (!platosSucios.isEmpty()) {
                    Plato plato = platosSucios.removeFirst(); // Lava el primer plato disponible
                    pilaPlatos.Lavar(plato); // Añadir el plato lavado a la pila
                    numALimpiar--;
                }
            }
            try {
                sleep(50); // Simula el tiempo de lavado
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
