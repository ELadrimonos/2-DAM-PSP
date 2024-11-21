public class Saludo {

    public synchronized void SaludoEmpleado(String nombre) throws InterruptedException {
        wait();
        System.out.println(nombre + ": Hola Jefe!!!!!");
    }

    public synchronized void SaludoJefe(String nombre){
        System.out.println(nombre + ": Hola Subditos");
        notifyAll();
    }
}
