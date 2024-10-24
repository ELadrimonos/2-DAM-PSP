import java.util.Random;

public class HiloCliente extends Thread {

    static int EntradasDisponibles = 100;
    static int EntradasVendidas = 0;

    public HiloCliente(int numCliente) {
        super(Integer.toString(numCliente));
    }

    @Override
    public void run() {
        Random random = new Random();
        int valor = random.nextInt(1, 11);
        reservaEntrada(getName(), valor);

    }

    //NOTE: Uso static para que funcione synchronized bien ya que modifico variables estáticas
    private static synchronized void reservaEntrada(String nombre, int cantidad) {

        if (EntradasDisponibles - cantidad >= 0) {
            System.out.printf("%d reservadas para Cliente %s\n", cantidad, nombre);
            EntradasDisponibles -= cantidad;
            EntradasVendidas += cantidad;
        } else
            System.out.printf("No hay entradas disponibles para Cliente %s (Intento de comprar %d entradas)\n", nombre, cantidad);
    }
}
