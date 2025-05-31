import java.util.Random;

public class HiloCoche extends Thread{
    int recorridoTotal = 0;

    public HiloCoche( int id, String marca) {
        this.setName(marca + "(" + id + ")");
    }

    @Override
    public void run() {
        try {
            do {
                Random random = new Random();
                int distanciaRandom = random.nextInt(100);
                recorridoTotal += distanciaRandom;
                System.out.println(getName() + " lleva recorrido " + recorridoTotal + "km!!!!");
                sleep(1000);
            } while (this.recorridoTotal < 500);
            System.out.println("----------------------------\n" + getName()
                    + " ha finalizado al recorrer " + recorridoTotal + "km");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
