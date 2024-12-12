package actividad1;

public class Main {
    public static void main(String[] args) {
        Dato dato = new Dato();

        Hilo hiloA = new Hilo("A", dato);
        Hilo hiloB = new Hilo("B", dato);

        hiloA.start();
        hiloB.start();

    }
}
