package actividad1;

public class Hilo extends Thread {
    String caracter;
    Dato dato;
    public Hilo(String car, Dato dato) {
        this.caracter = car;
        this.dato = dato;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            dato.imprimirCadena(caracter);
        }
    }
}
