public class Corredor extends Thread{

    public Corredor(String nom){
        super(nom);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1500; i++) {
            try {
                sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("El corredor " + getName() + " ha terminado");
    }
}
