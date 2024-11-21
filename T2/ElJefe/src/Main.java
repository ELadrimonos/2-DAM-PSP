public class Main {
    public static void main(String[] args) {
        Empleado jefe = new Empleado("Pepe", true);
        for (int i = 0; i < 5; i++) {
            new Empleado("Empleado " + i, false);
        }
    }
}