public class Main {
    public static void main(String[] args) {
        Saludo objSaludo = new Saludo();
        Empleado jefe = new Empleado("Pepe", true, objSaludo);
        for (int i = 0; i < 5; i++) {
            new Empleado("Empleado " + i, false, objSaludo).start();
        }
        jefe.start();
    }
}