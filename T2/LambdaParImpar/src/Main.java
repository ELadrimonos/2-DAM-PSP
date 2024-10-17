public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread hiloPares = new Thread(() -> {
            for (int i = 2; i < 1000; i += 2) {
                System.out.println(i);
            }
        });

        hiloPares.start();

        // Así puedo comprobar que vayan bien los impares
        hiloPares.join();

        Thread hiloImpares = new Thread(() -> {
            for (int i = 1; i < 1000; i += 2) {
                System.out.println(i);
            }
        });
        hiloImpares.start();


    }
}