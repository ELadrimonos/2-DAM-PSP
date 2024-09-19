import java.util.ArrayList;

public class Columnas {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<ArrayList<Integer>> num = new ArrayList<>();
        num.add(new ArrayList<>() {{
            add(0);
            add(30);
            add(2);
            add(0);
            add(0);
            add(5);
        }});
        num.add(new ArrayList<>() {{
            add(75);
            add(0);
            add(0);
            add(0);
            add(0);
            add(0);
        }});
        num.add(new ArrayList<>() {{
            add(0);
            add(0);
            add(- 2);
            add(9);
            add(0);
            add(11);
        }});

        dibujarColumnas(num);
    }

    public static void dibujarColumnas(ArrayList<ArrayList<Integer>> valores) throws InterruptedException {

        for (int y = 0; y < valores.size() + 1; y++) {
            for (int x = 0; x < valores.getFirst().size() + 1; x++) {

                // Con printf puedo formatear para poner un tamaño de columna fijo
 
                if (y == 0) {
                    if (x == 0) {
                        System.out.printf("%-10s", "");
                    } else System.out.printf("%-15s", "Columna " + (x - 1));
                } else {
                    if (x == 0) {
                        System.out.printf("%-10s", "Fila " + (y - 1));
                        Thread.sleep(500);
                    } else {
                        System.out.printf("%-15d", valores.get(y - 1).get(x - 1));
                        Thread.sleep(500);
                    }

                }
            }
            System.out.println();
        }
    }
}
