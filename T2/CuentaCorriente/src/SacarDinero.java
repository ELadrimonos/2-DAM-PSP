public class SacarDinero extends Thread{
    Cuenta c;
    public SacarDinero(Cuenta cuenta, String name) {
        super(name);
        this.c = cuenta;
    }

    public void run() {
        for (int i = 0; i < 4; i++) {
            c.RetirarDinero(30, this.getName());
        }
    }
}
