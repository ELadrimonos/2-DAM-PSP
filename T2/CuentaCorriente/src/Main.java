public class Main {
    public static void main(String[] args) {
        Cuenta cont = new Cuenta(200);
        SacarDinero sacarDinero = new SacarDinero(cont, "Adri");

        sacarDinero.start();

    }
}