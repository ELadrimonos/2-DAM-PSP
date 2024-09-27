
public class Sumador {
    public static void main(String[] args) {
        try {
            int suma = sumaIntervalo(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            System.out.println("La suma es: " + suma);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int sumaIntervalo(int val1, int val2) {
        int suma = 0;
        for (int i = val1; i <= val2; i++) {
            suma += i;
        }
        return suma;
    }
}