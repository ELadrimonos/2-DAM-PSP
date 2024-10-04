public class Hilo extends Thread{
    public static int contador = 0;

    public void run(){
        for (int i = 1; i < 1001; i++) {
            contador++;
        }
    }
}
