package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Day6 {

    public void resolverDiaParte1() throws IOException {
        List<LinkedList<String>> carreras = this.cargarDatosParte1();
        this.mostrarResultado(carreras);
        System.out.println("hola"); 
    }

    public void resolverDiaParte2() throws IOException {
        List<LinkedList<String>> carreras = this.cargaDatosParte2();
        this.mostrarResultado(carreras);

    }

    public List<LinkedList<String>> cargarDatosParte1() throws IOException {
        //List distancia = new LinkedList<Integer>();
        //List tiempo = new LinkedList<Integer>();
        List<String> distancia = null;
        List<String> tiempos = null;
        List<LinkedList<String>> carreras = new LinkedList<>();
        BufferedReader in = null;
        try {

            in = new BufferedReader(new FileReader("src/InputDay6.txt"));
            String line;
            while ((line = in.readLine()) != null) {
                String[] datosLine;
                datosLine = line.trim().split(":");
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
            int numeroCarreras = tiempos.size();
            for (int numeroCarrera = 0; numeroCarrera < numeroCarreras; numeroCarrera++) {
                LinkedList<String> carrera = new LinkedList<>();
                carrera.add(tiempos.get(numeroCarrera));
                carrera.add(distancia.get(numeroCarrera));
                carreras.add(carrera);
            }

        } finally {
            if (in != null) {
                in.close();
            }
        }
        return carreras;
    }

    public void mostrarResultado(List<LinkedList<String>> carreras) {
        long resultado = 1;
        for (int nCarrera = 0; nCarrera < carreras.size(); nCarrera++) {
            long exito;
            long b = Long.parseLong(carreras.get(nCarrera).get(0)) * (-1);
            long c = Long.parseLong(carreras.get(nCarrera).get(1));

            long norma = (b * b) - (4 * c);
            if (norma > 0) {
                long max;
                long min;
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


    public List<LinkedList<String>> cargaDatosParte2() throws IOException {
        List<LinkedList<String>> carreras = new LinkedList<>();


        BufferedReader in = null;
        try {
            List<String> carrera = new LinkedList<>();
            in = new BufferedReader(new FileReader("src/InputDay6.txt"));
            String line;
            while ((line = in.readLine()) != null) {
                String[] datosLine;
                datosLine = line.trim().split(":");
                if (datosLine[0].equals("Time")) {
                    String valueTime;
                    valueTime = datosLine[1].trim().replace(" ", "");
                    carrera.add(valueTime);
                } else if (datosLine[0].equals("Distance")) {
                    String valueDistance;
                    valueDistance = datosLine[1].trim().replace(" ", "");
                    carrera.add(valueDistance);
                }
            }
            carreras.add((LinkedList<String>) carrera);

        } finally {
            if (in != null) {
                in.close();
            }
        }

        return carreras;
    }
}
