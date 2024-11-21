public class Empleado extends Thread {
    //NOTE: Para que notify funcione las funciones deben de ejecutarse en el mismo objeto
    Saludo saludo;
    boolean esJefe;

    public Empleado(String nombre, boolean esJefe, Saludo saludo) {
        super(nombre);
        this.esJefe = esJefe;
        this.saludo = saludo;
    }

    public void run() {
        if (esJefe) {
            try {
                sleep(2000);
                saludo.SaludoJefe(getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                saludo.SaludoEmpleado(getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
