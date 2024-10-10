public class SacarDinero extends Thread{
    Cuenta c;
    public SacarDinero(Cuenta cuenta, String name) {
        super(name);
        this.c = cuenta;
    }

    public void run() {
        c.RetirarDinero(30, this.getName());
    }
}
