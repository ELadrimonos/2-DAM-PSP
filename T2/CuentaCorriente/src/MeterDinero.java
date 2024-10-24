public class MeterDinero extends Thread{
    Cuenta c;
    public MeterDinero(Cuenta cuenta, String name) {
        super(name);
        this.c = cuenta;
    }

    public void run() {
        for (int i = 0; i < 4; i++) {
            c.IngresarDinero(60, this.getName());
        }
    }
}
