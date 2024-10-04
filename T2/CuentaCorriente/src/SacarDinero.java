public class SacarDinero extends Thread{
    Cuenta c;
    public SacarDinero(Cuenta cuenta, String name) {
        super(name);
        this.c = cuenta;
    }

    public void run() {
        super.run();
        c.RetirarDinero(100, this.getName());
    }
}
