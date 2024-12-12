package actividad2;

import java.io.*;
import java.util.ArrayList;

public class HiloTitanic extends Thread {
    int clasePasajeros;
    ArrayList<String[]> datosPasajeros = new ArrayList<>();

    public HiloTitanic(int clase) {
        this.clasePasajeros = clase;
    }

    @Override
    public void run() {
        leerFichero();
    }

    public void leerFichero() {
        //TODO Cambiar directorio
        File directorio = new File(System.getProperty("user.dir") + "/src/actividad2/");
        File archivo = new File(directorio + "/Titanic.csv");
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[0].equals(String.valueOf(this.clasePasajeros))) {
                    datosPasajeros.add(datos);
                }
            }
            br.close();
            printearEstadisticasPasajeros();
        } catch (FileNotFoundException e) {
            System.err.println("No se puede leer el fichero");
            System.err.println("Archivo existe: " + archivo.exists());
            System.err.println("Ruta archivo: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error leyendo el fichero (br.readLine)");
        }
    }

    void printearEstadisticasPasajeros() {
        String clase;
        switch (this.clasePasajeros) {
            case 1:
                clase = "Primera";
                break;
            case 2:
                clase = "Segunda";
                break;
            default:
                clase = "Tercera";
        }


        int numVivos = calcularSupervivientes();
        double mediaVivos = calcularMedia(numVivos);
        int numMuertos = calcularMuertos();
        double mediaMuertos = calcularMedia(numMuertos);


        System.out.println("En " + clase + " clase viajaban " + this.datosPasajeros.size() +
                " pasajeros. Sobrevivieron " + numVivos + "(" + mediaVivos + "%)" + " pasajeros y fallecieron "
                + numMuertos + "(" + mediaMuertos + "%)" + " pasajeros.");
    }

    boolean haSobrevivido(String siNo) {
        return siNo.equalsIgnoreCase("S");
    }

    int calcularSupervivientes() {
        int contSupervivientes = 0;

        for (String[] datosPasajero : datosPasajeros) {
            if (haSobrevivido(datosPasajero[5])) {
                contSupervivientes++;
            }
        }

        return contSupervivientes;
    }

    int calcularMuertos() {
        int contMuertos = 0;

        for (String[] datosPasajero : datosPasajeros) {
            if (! haSobrevivido(datosPasajero[5])) {
                contMuertos++;
            }
        }

        return contMuertos;
    }

    double calcularMedia(int numeroPasajeros) {
        return (double) numeroPasajeros / this.datosPasajeros.size() * 100;
    }


}
