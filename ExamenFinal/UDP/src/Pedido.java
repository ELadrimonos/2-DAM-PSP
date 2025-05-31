import java.io.Serializable;

public class Pedido implements Serializable {
    String nombreBurger;
    String nombreAcompa;
    String bebida;

    public Pedido(String hamburguesa) {
        this.nombreBurger = hamburguesa;
    }

    public Pedido(String hamburguesa, String loOtro, boolean esBebida) {
        this.nombreBurger = hamburguesa;
        if (esBebida) this.bebida = loOtro;
        else this.nombreAcompa = loOtro;
    }

    public Pedido(String hamburguesa, String acompany, String bebida) {
        this.nombreBurger = hamburguesa;
        this.nombreAcompa = acompany;
        this.bebida = bebida;
    }

    @Override
    public String toString() {
        return nombreBurger +
                (
                (nombreAcompa != null ? " acompañado con " + nombreAcompa : "") +
                        (nombreAcompa != null && bebida != null ? " y" : "") +
                        (bebida != null ? " regado con " + bebida : "")

                );
    }

    public String getNombreBurger() {
        return nombreBurger;
    }

    public void setNombreBurger(String nombreBurger) {
        this.nombreBurger = nombreBurger;
    }

    public String getNombreAcompa() {
        return nombreAcompa;
    }

    public void setNombreAcompa(String nombreAcompa) {
        this.nombreAcompa = nombreAcompa;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }
}
