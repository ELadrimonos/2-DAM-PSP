import java.util.ArrayList;

public class PilaPlatos {
    int cantidad = 0;
    ArrayList<Plato> pila = new ArrayList<>();
    boolean lavando = true;

    public synchronized void Lavar(Plato plato) {
        if (cantidad + 1 > 5) return;
        if (!lavando) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        lavando = true;
        cantidad++;
        pila.add(plato);
        System.out.println("Plato lavado #" + plato.id + ". " + cantidad + " en la pila.");
        notify();
    }

    public synchronized void Secar(Plato plato) {
        if (cantidad == 0) return;

        if (lavando) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        cantidad--;
        pila.remove(plato);
        System.out.println("Plato secado #" + plato.id + ". " + cantidad + " en la pila.");
        notify();

    }
}
