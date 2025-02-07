import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Profesional> profesionales = new ArrayList<>();
        int opcionMenu;
        do {
            mostrarMenuPrincipal();opcionMenu = pedirNumero(scanner);
            switch (opcionMenu) {
                case 1:
                    System.out.println("Ingrese el nombre del profesional");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese la edad del profesional");
                    int edad = pedirNumero(scanner);
                    System.out.println("Ingrese el genero del profesional (m/f)");
                    String genero = scanner.nextLine().toLowerCase();
                    System.out.println("Ingrese el tipo de profesional { 1 (Jugador), 2 (Directivo), 3 (Fisio)}");
                    int tipo = pedirNumero(scanner);
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
                    int opcionSubMenu = pedirNumero(scanner);
                    switch (opcionSubMenu) {
                        case 1:
                            profesionales.stream().sorted(Comparator.comparing(Profesional::getGenero)
                                    .reversed()).forEach(System.out::println);
                            break;
                        case 2:
                            profesionales.stream().sorted(Comparator.comparing(Profesional::getTipoProfesional))
                                    .forEach(System.out::println);
                            break;
                        case 3:
                            System.out.println("Edad mínima");
                            int edadMinima = pedirNumero(scanner);
                            System.out.println("Edad máxima");
                            int edadMaxima = pedirNumero(scanner);

                            profesionales.stream()
                                    .filter(profesional -> profesional.getEdad() >= edadMinima
                                            && profesional.getEdad() <= edadMaxima)
                                    .sorted(Comparator.comparing(Profesional::getEdad)).forEach(System.out::println);
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

    private static int pedirNumero(Scanner scanner) {
        try {
            int valor = scanner.nextInt();
            scanner.nextLine();
            return valor;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.err.println("Has introducido un valor no válido (se esperaba un número entero).");
            return -1;
        }
    }
}