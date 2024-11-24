import java.io.*;

public class ValidaMailOutput {

    public static void main(String[] args) {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String email = "";

        try {
            email = br.readLine();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Email introducido: " + email);

        boolean arrobaValido = comprobarArroba(email);
        boolean extensionValida = comprobarExtensionDominio(email);
        boolean primerIdentificadorValido = comprobarPrimerIdentificador(email);
        boolean segundoIdentificadorValido = comprobarSegundoIdentificador(email);

        if (! arrobaValido) System.out.println("ERROR: El email no contiene un @!");
        else if (! segundoIdentificadorValido) System.out.println("ERROR: No existe segundo identificador!");
        else if (! primerIdentificadorValido)
            System.out.println("ERROR: El primer identificador ha de tener una longitud mínima de 3 caracteres!");
        else if (! extensionValida) System.out.println("ERROR: El dominio no es ni com/es/org!");

        else System.out.println("El email introducido es correcto!");

    }

    public static boolean comprobarArroba(String email) {
        return email.contains("@");
    }

    public static boolean comprobarExtensionDominio(String email) {
        String[] posiblesDominios = {".com", ".es", ".org"};
        return email.endsWith(posiblesDominios[0]) || email.endsWith(posiblesDominios[1]) || email.endsWith(posiblesDominios[2]);
    }

    public static int encontrarPosicionArroba(String email) {
        return email.indexOf("@");
    }


    public static boolean comprobarSegundoIdentificador(String email) {
        return (email.length() - (encontrarPosicionArroba(email) + 1)) >= 2;
    }

    public static boolean comprobarPrimerIdentificador(String email) {
        return encontrarPosicionArroba(email) > 2;
    }
}
