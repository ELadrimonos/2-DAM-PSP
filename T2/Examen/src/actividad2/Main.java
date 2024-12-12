package actividad2;

public class Main {
    public static void main(String[] args) {
        System.out.println("BIENVENIDO AL TITANIC");

        HiloTitanic hiloClase1 = new HiloTitanic(1);
        HiloTitanic hiloClase2 = new HiloTitanic(2);
        HiloTitanic hiloClase3 = new HiloTitanic(3);
        hiloClase1.run();
        hiloClase2.run();
        hiloClase3.run();

        System.out.println("FIN DE LA TRAVESIA");
    }
}
