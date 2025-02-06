import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Profesional> profesionales = new ArrayList<>();
        profesionales.add(new Profesional("Adrián Primo", 20, 'm', 2));
        profesionales.add(new Profesional("Marta Gomez", 23, 'f', 1));
        profesionales.add(new Profesional("Laura Pascual", 16, 'f', 3));
        profesionales.add(new Profesional("Ricardo Rausell", 21, 'm', 1));
        int opcionMenu;

        do {
            mostrarMenuPrincipal();
            try {
                opcionMenu = scanner.nextInt();
                scanner.nextLine();

                switch (opcionMenu) {
                    case 1:
                        System.out.println("Ingrese el nombre del profesional");
                        String nombre = scanner.nextLine();
                        System.out.println("Ingrese la edad del profesional");
                        int edad = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Ingrese el genero del profesional (m/f)");
                        String genero = scanner.nextLine().toLowerCase();
                        System.out.println("Ingrese el tipo de profesional { 1 (Jugador), 2 (Directivo), 3 (Fisio)}");
                        int tipo = scanner.nextInt();
                        scanner.nextLine();

                        try {
                            Profesional profesional = new Profesional(nombre, edad, genero.charAt(0), tipo);
                            profesionales.add(profesional);
                        } catch (IllegalArgumentException e) {
                            System.err.print(e.getMessage());
                            System.err.println(" Ignorando cambios.");
                        }

                        break;
                    case 2:
                        mostrarMenuConsultas();
                        int opcionSubMenu = scanner.nextInt();
                        scanner.nextLine();
                        switch (opcionSubMenu) {
                            case 1:
                                profesionales.stream().sorted(Comparator.comparing(Profesional::getGenero).reversed())
                                        .forEach(profesional -> System.out.println(profesional.getNombre()
                                                + ": " + profesional.getGenero()));
                                break;
                            case 2:
                                profesionales.stream().sorted(Comparator.comparing(Profesional::getTipoProfesional))
                                        .forEach(profesional -> System.out.println(profesional.getNombre()
                                                + ": " + profesional.getTipoProfesional()));
                                break;
                            case 3:
                                System.out.println("Edad mínima");
                                int edadMinima = scanner.nextInt();
                                scanner.nextLine();

                                System.out.println("Edad máxima");
                                int edadMaxima = scanner.nextInt();
                                scanner.nextLine();

                                profesionales.stream().filter(profesional -> profesional.getEdad() >= edadMinima
                                        && profesional.getEdad() <= edadMaxima).forEach(profesional ->
                                        System.out.println(profesional.getNombre() + ": " + profesional.getEdad()));
                                break;
                            case 4:
                                break;
                        }
                        break;

                    case 3:
                        String nombresPros = profesionales.stream().map(Profesional::getNombre)
                                .collect(Collectors.joining(", ", "Profesionales: ", "."));
                        System.out.println(nombresPros);
                        break;
                }
            } catch (InputMismatchException e) {
                opcionMenu = 0;
                scanner.nextLine();
                System.err.println("Has introducido un valor no válido (se esperaba un número entero).");
            }
        } while (opcionMenu != 4);
        System.out.println("Fin del programa");
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("SOFTWARE DE GESTIÓN DEL IBIS SPORT CLUB");
        System.out.println("=======================================");
        System.out.println("1. Introducir datos de un profesional");
        System.out.println("2. Consulta con filtro");
        System.out.println("3. Listado de nombres");
        System.out.println("4. Salir");
    }

    private static void mostrarMenuConsultas() {
        System.out.println("Submenú de Consultas");
        System.out.println("--------------------");
        System.out.println("1. Profesionales por género");
        System.out.println("2. Profesionales por tipo");
        System.out.println("3. Profesionales por edad");
        System.out.println("4. Volver");
    }
}