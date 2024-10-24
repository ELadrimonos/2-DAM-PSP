import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<HiloCliente> clientes = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            clientes.add(new HiloCliente(i));
        }

        for (HiloCliente cliente : clientes) {
            cliente.start();
        }

        Thread.sleep(1000);

        System.out.printf("Total entradas vendidas: %d (%d disponibles)\n", HiloCliente.EntradasVendidas, HiloCliente.EntradasDisponibles);
    }
}