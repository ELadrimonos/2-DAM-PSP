public class Main {
    public static void main(String[] args) {
        Cuenta cont = new Cuenta(200);
        MeterDinero ricardoMeter = new MeterDinero(cont, "Ricardo");
        SacarDinero adriSacar = new SacarDinero(cont, "Adri");
        SacarDinero ricardoSacar = new SacarDinero(cont, "Ricardo");

        ricardoMeter.start();
        adriSacar.start();
        ricardoSacar.start();

    }
}