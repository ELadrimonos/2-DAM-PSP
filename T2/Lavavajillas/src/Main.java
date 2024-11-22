import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PilaPlatos pila = new PilaPlatos();
        ArrayList<Plato> platosSucios = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            platosSucios.add(new Plato(i));
        }

        Friega hiloFriega = new Friega(5,pila, platosSucios);
        Seca hiloSecar = new Seca(5,pila, platosSucios);

        hiloFriega.start();
        hiloSecar.start();

    }
}