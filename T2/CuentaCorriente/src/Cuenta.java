public class Cuenta {
    public static int saldo;

    public Cuenta(int fsaldo) {
        saldo = fsaldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void restar(int fsaldo) {
        saldo -= fsaldo;
    }

    synchronized public void RetirarDinero(int cant, String nombre) {
        if (saldo >= cant) {
            System.out.println("SE VA A RETIRAR SALDO: (ACTUAL ES: " + getSaldo() + ")");
            restar(cant);
            System.out.println(nombre + " retira =>" + cant + " ACTUAL(" + getSaldo() + ")");
        } else System.out.println("No se puede retirar dinero, NO HAY SALDO(" + getSaldo() + ") (intentaste retirar " + cant + " )");
    }
}
