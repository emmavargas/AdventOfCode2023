package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Day6 {

    public void resolverDia() throws IOException {
        this.cargarDatos();
    }
    public void cargarDatos() throws IOException
    {
        //List distancia = new LinkedList<Integer>();
        //List tiempo = new LinkedList<Integer>();
        List<String> distancia=null;
        List <String> tiempos = null;

        BufferedReader in = null;
        try
        {


            in = new BufferedReader(new FileReader("src\\InputDay6.txt"));
            String line;
            while((line=in.readLine())!=null)
            {
                String[] datosLine;
                datosLine = line.trim().split(":");
                //System.out.println(datosLine[0]);
                if(datosLine[0].equals("Time"))
                {
                    String valueTime[];
                    valueTime = datosLine[1].trim().split("\\s+");
                    tiempos = Arrays.asList(valueTime);

                }
                else if (datosLine[0].equals("Distance"))
                {
                    String valueDistance[];
                    valueDistance = datosLine[1].trim().split("\\s+");
                    distancia = Arrays.asList(valueDistance);
                }
            }
        }
        finally {
            if(in!=null)
            {
                in.close();
            }
        }

        int numeroCarreras = tiempos.size();
        int resultado=1;
        for(int nCarrera=0; nCarrera<numeroCarreras; nCarrera++)
        {
            int victoria=0;
            int tiempoCarrera= Integer.parseInt(tiempos.get(nCarrera));
            int distanciaCarrera = Integer.parseInt(distancia.get(nCarrera));
            for(int botonCarga=0; botonCarga<tiempoCarrera; botonCarga++)
            {

                int distanciaPropia = botonCarga*(tiempoCarrera-botonCarga);
                if(distanciaPropia>distanciaCarrera)
                {
                    victoria++;
                }
            }
            resultado = resultado*victoria;
        }
        System.out.println(resultado);
    }

}