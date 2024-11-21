public class Saludo extends Thread {
    boolean esJefe;


    public Saludo(String nombre, boolean esJefe) {
        super(nombre);
        this.esJefe = esJefe;
    }

    public void run() {
        if (esJefe) {
            try {
                sleep(2000);
                SaludoJefe(getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                SaludoEmpleado(getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void SaludoEmpleado(String nombre) throws InterruptedException {
        System.out.println("ESPERA!!!");
        wait();
        System.out.println(nombre + ": Hola Jefe!!!!!");
    }

    public synchronized void SaludoJefe(String nombre){
        System.out.println(nombre + ": Hola Subditos");
        notifyAll();
    }
}
