import java.util.ArrayList;

public class Seca extends Thread {
    PilaPlatos pilaPlatos;
    int numASecar;
    ArrayList<Plato> platosSucios;

    public Seca(int numPlatos, PilaPlatos pilaPlatos, ArrayList<Plato> listaPlatos) {
        super("Seca");
        this.pilaPlatos = pilaPlatos;
        this.numASecar = numPlatos;
        this.platosSucios = listaPlatos;
    }

    public void run() {
        while (numASecar > 0) {
            synchronized (pilaPlatos) { // Bloque sincronizado para evitar conflictos
                if (!pilaPlatos.pila.isEmpty()) {
                    Plato plato = pilaPlatos.pila.removeFirst(); // Seca el primer plato de la pila
                    pilaPlatos.Secar(plato);
                    numASecar--;
                }
            }
            try {
                sleep(100); // Simula el tiempo de secado
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
