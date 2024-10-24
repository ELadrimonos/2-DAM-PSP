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

    private void reservaEntrada(String nombre, int cantidad){
        EntradasDisponibles -= cantidad;
        EntradasVendidas += cantidad;
        if (EntradasDisponibles > 0) System.out.printf("%d reservadas para Cliente %s\n", cantidad, nombre);
        else System.out.println("No hay entradas disponibles para Cliente " + nombre);
    }
}
