public class Main {
    public static void main(String[] args) {
        Cuenta cont = new Cuenta(200);
        SacarDinero adriSacar = new SacarDinero(cont, "Adri");
        SacarDinero ricardoSacar = new SacarDinero(cont, "Ricardo");

        adriSacar.start();
        ricardoSacar.start();

    }
}