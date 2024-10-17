public class Main {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            new HiloCliente(i).start();
        }
        Thread.sleep(1000);

        System.out.printf("Total entradas vendidas: %d (%d disponibles)\n", HiloCliente.EntradasVendidas, HiloCliente.EntradasDisponibles);
    }
}