import java.util.ArrayList;
import java.util.Objects;

public class DatoCompartido {
    Integer dato;
    boolean disponible = false;
    ArrayList<Integer> datos;

    DatoCompartido(int limite) {
        datos = new ArrayList<>(limite);
    }

    public synchronized int obtener() {
        if (!disponible)
            try {
                System.out.println("ESPERA OBTENER");
                wait();
                System.out.println("RESUMIDO OBTENER");
            } catch (Exception ignored) {}
        disponible = false;
        datos.remove(dato);
        notify();
        return dato;
    }

    public synchronized void poner(int nuevoDato) {
        if (disponible)
            try {
                System.out.println("ESPERA PONER");
                wait();
                System.out.println("RESUMIDO PONER");
            } catch (Exception ignored) {}

        dato = nuevoDato;
        datos.add(dato);
        disponible = true;
        notify();
    }

    public synchronized void mostrarDatos() {
        System.out.print("Array de datos:\t");
        if (datos.isEmpty()) {
            System.out.print("[]");
        } else {
            for (Integer dato : datos) {
                System.out.print(dato);
                if (!Objects.equals(dato, datos.getLast())) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
    }
}
