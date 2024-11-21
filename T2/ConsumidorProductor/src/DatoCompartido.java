public class DatoCompartido {
    int dato;
    boolean disponible = false;

    public synchronized int obtener() {
        if (!disponible)
            try {
                System.out.println("ESPERA OBTENER");
                wait();
            } catch (Exception ignored) {}
        disponible = false;
        notify();
        return dato;
    }
    public synchronized void poner(int nuevoDato) {
        if (disponible)
            try {
                System.out.println("ESPERA PONER");
                wait();
            } catch (Exception ignored) {}
        dato = nuevoDato;
        disponible = true;
        notify();
    }
}