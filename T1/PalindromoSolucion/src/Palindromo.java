import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Palindromo {
	 public static boolean esPalindromo(String cadena) {
	        String cadenaLimpia = cadena.replaceAll("\\s+", "").toLowerCase();
	        StringBuilder reverso = new StringBuilder(cadenaLimpia).reverse();
	        return cadenaLimpia.contentEquals(reverso);
	    }
		public static void main(String[] args) {

			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader br= new BufferedReader(in);
			String texto;
			try {
				texto=br.readLine();
				if (esPalindromo(texto)) {
	                System.out.println(texto+" es un palíndromo.");
	            } else {
	                System.err.println(texto+" NO es un palíndromo.");
	            }
				//System.out.println("Introduce Cadena:");
			//	texto=br.readLine();
			//	System.err.println("Su Cadena: "+texto);
				in.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}

		}
}
