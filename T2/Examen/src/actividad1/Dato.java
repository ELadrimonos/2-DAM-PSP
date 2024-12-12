package actividad1;

class Dato{
    public boolean esB = false;

    public synchronized void imprimirCadena(String s) {
        esB = s.equalsIgnoreCase("B");
        if (esB && s.equalsIgnoreCase("A")) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else notify();
        System.out.print(s + " ");
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}