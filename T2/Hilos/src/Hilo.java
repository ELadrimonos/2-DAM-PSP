public class Hilo extends Thread{

    public Hilo(String name) {
        super(name);
        System.out.println("CREANDO HILO: " + name);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getClass().getName() + ":\"" +  getName() + "\" = " + i);
        }
    }
}
