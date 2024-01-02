package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Day6 {

    public void resolverDia() throws IOException{
        this.cargarDatos();
    }

    public void cargarDatos() throws IOException {
        //List distancia = new LinkedList<Integer>();
        //List tiempo = new LinkedList<Integer>();
        List<String> distancia = null;
        List<String> tiempos = null;

        BufferedReader in = null;
        try {


            in = new BufferedReader(new FileReader("src\\InputDay6.txt"));
            String line;
            while ((line = in.readLine()) != null) {
                String[] datosLine;
                datosLine = line.trim().split(":");
                //System.out.println(datosLine[0]);
                if (datosLine[0].equals("Time")) {
                    String[] valueTime;
                    valueTime = datosLine[1].trim().split("\\s+");
                    tiempos = Arrays.asList(valueTime);

                } else if (datosLine[0].equals("Distance")) {
                    String[] valueDistance;
                    valueDistance = datosLine[1].trim().split("\\s+");
                    distancia = Arrays.asList(valueDistance);
                }
            }

        } finally {
            if (in != null) {
                in.close();
            }
        }

        int numeroCarreras = tiempos.size();
        int resultado = 1;
        for (int nCarrera = 0; nCarrera < numeroCarreras; nCarrera++) {
            int exito;
            int b = Integer.parseInt(tiempos.get(nCarrera)) * (-1);
            int c = Integer.parseInt(distancia.get(nCarrera));

            int norma = (b * b) - (4 * c);
            if (norma > 0) {
                int max;
                int min;
                double x1 = ((b * (-1)) + (Math.pow(norma, 0.5))) / 2;
                double x2 = ((b * (-1)) - (Math.pow(norma, 0.5))) / 2;
                double xMax = x1 > x2 ? x1 : x2;

                max = (x1 > x2) ? (int) x1 : (int) x2;
                min = (x1 < x2) ? (int) x1 + 1 : (int) x2 + 1;

                if (Math.abs(xMax - (double) max) <= 1e-16) {
                    max = max - 1;
                }

                exito = max - min + 1;
                resultado = resultado * exito;
            }
        }
        System.out.println(resultado);
    }
}
