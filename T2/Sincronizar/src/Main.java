public class Main {
    public static void main(String[] args) {

        Contador contador = new Contador(100);

        Thread hiloIncrementador = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                contador.incrementar();
            }
        });
        Thread hiloDecrementador = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                contador.decrementar();
            }
        });

        hiloIncrementador.start();
        hiloDecrementador.start();

    }
}