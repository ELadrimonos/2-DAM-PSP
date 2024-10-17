public class Main {
    public static void main(String[] args) {

        HiloMenu hiloPrimeros = new HiloMenu(1);
        HiloMenu hiloSegundos = new HiloMenu(2);
        HiloMenu hiloPostres = new HiloMenu(3);

        hiloPrimeros.start();
        hiloSegundos.start();
        hiloPostres.start();

    }
}