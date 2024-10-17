import java.io.*;

public class HiloMenu extends Thread {
    int numero;
    String nombreArchivo;

    public HiloMenu(int num) {
        super("hilo" + num);
        this.numero = num;

        switch (num) {
            case 1:
                this.nombreArchivo = "primeros.txt";
                break;
            case 2:
                this.nombreArchivo = "segundos.txt";
                break;
            case 3:
                this.nombreArchivo = "postres.txt";
                break;
            default:
                System.err.println("Plato desconocido");
                this.nombreArchivo = "desconocidos.txt";
        }
    }

    private void escribirEnFichero(String linea) {
        try {
            FileWriter fichero = new FileWriter(this.nombreArchivo, true);
            fichero.write(linea);
            fichero.close();
        } catch (java.io.IOException e) {
            System.err.println("Error al escribir en el fichero");
        }
    }

    @Override
    public void run() {
        try {
            FileReader fileReader = new FileReader("menu.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea = bufferedReader.readLine();
            while (linea != null) {
                if (linea.startsWith(this.numero + "-")) {
                    if (!linea.toUpperCase().contains(this.nombreArchivo.substring(0, this.nombreArchivo.length() - 4).toUpperCase())) {
                        String plato = linea.substring(2);
                        this.escribirEnFichero( plato + "\n");
                        System.out.printf("El %s escribe... %s\n", this.getName() , plato);
                    }
                }
                linea = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            System.err.println("Fichero menu.txt no encontrado");
        } catch (IOException e) {
            System.err.println("Error al leer en el fichero");
        }

    }
}
