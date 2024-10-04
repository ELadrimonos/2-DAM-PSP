public class Simple1 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Hilo hilo = new Hilo();
            hilo.start();
        }
        // Si no espero que finalicen todos los hilos, el valor parece aleatorio
        System.out.println(Hilo.contador);
    }
}