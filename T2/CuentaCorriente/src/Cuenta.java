public class Cuenta {
    private int saldo = 0;

    public Cuenta(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void restar(int saldo) {
        this.saldo -= saldo;
    }

    public void RetirarDinero(int cant, String nombre) {
        if (this.saldo >= cant) {
            System.out.println("SE VA A RETIRAR SALDO: (ACTUAL ES: " + this.getSaldo() + ")");
            this.restar(cant);
        } else System.out.println("No se puede retirar dineto, NO HAY SALDO(" + this.getSaldo() + ")");
    }
}
