public class Main {
    public static void main(String[] args) {
        DatoCompartido compartido = new DatoCompartido();

        Thread consumidor = new Thread(() -> {
            for (int i = 1; i < 5; i++) {
                System.out.println("Consumidor: " + compartido.obtener());
            }
        });

        Thread productor = new Thread(() -> {
            for (int i = 1; i < 5; i++) {
                compartido.poner(i);
                System.out.println("Productor: " + compartido.dato);
            }
        });
        consumidor.start();
        productor.start();
    }
}