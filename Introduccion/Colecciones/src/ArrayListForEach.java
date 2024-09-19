import java.util.ArrayList;

public class ArrayListForEach {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>() {{
            add("Adrián");
            add("Ricardo");
            add("David");
            add("Pablo");
            add("Nacho");
            add("Javi");
        }};

        // For each para recorrer un arrayList sin indices
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }
}