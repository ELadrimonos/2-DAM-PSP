public class Palindromo {
    public static void main(String[] args) {
        boolean palindromo = esPalindromo(args[0]);
        System.out.println(args[0]);
        System.out.println("Es palindromo: " + palindromo);
    }

    public static boolean esPalindromo(String palabra) {
        palabra = palabra.toLowerCase();
        palabra = palabra.replace(" ", "");
        for (int i = 0; i < palabra.length() / 2; i++) {
            if (palabra.charAt(i) != palabra.charAt(palabra.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
