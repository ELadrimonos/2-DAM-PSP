public class Empleado {
    String nombre;
    Saludo saludo;
    boolean esJefe;

    public Empleado(String nombre, boolean esJefe) {
        this.nombre = nombre;
        this.esJefe = esJefe;
        this.saludo = new Saludo(nombre, esJefe);
        saludo.start();
    }
}
