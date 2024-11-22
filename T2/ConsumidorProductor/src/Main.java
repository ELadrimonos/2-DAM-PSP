public class Main {
    public static void main(String[] args) {
        int limite = 5;
        DatoCompartido compartido = new DatoCompartido(limite);

        Thread consumidor = new Thread(() -> {
            for (int i = 1; i <= limite; i++) {
                System.out.println("Consumidor: " + compartido.obtener());
                compartido.mostrarDatos();
            }
        });

        Thread productor = new Thread(() -> {
            for (int i = 1; i <= limite; i++) {
                compartido.poner(i);
                System.out.println("Productor: " + compartido.dato);
                compartido.mostrarDatos();
            }
        });
        productor.start();
        consumidor.start();
    }
}