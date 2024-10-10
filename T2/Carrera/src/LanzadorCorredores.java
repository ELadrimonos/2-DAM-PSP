public class LanzadorCorredores {
    public static void main(String[] args) {
        String[] corredores =
                {"Hicham El Guerrouj", "Noah Ngeny", "Mohamed Farah", "Bernard Lagat", "Rashid Ramzi",
                        "Ryan Gregson", "Fermín Cacho", "Teddy Flack" };



        for (String corredor : corredores) {
            new Corredor(corredor).start();
        }
    }
}