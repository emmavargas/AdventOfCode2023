package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import ObjectsDays.*;

public class Day4  {

    LinkedList<String> lines = new LinkedList<String>();
    LinkedList<Tarjeta> tarjetas = new LinkedList<Tarjeta>();

    LinkedList<Integer> puntajes = new LinkedList<Integer>();

    LinkedList<Integer> tarjetasTotales = new LinkedList<Integer>();
    public void cargarLineas() throws IOException
    {
        BufferedReader in =null;
        try
        {
            in = new BufferedReader(new FileReader("src\\InputDay4.txt"));
            String line;
            while((line=in.readLine())!=null)
            {
                lines.add(line);
            }

        }
        finally
        {
            if(in!=null)
            {
                in.close();
            }
        }
    }

    public void cargaListaTarjetas()
    {
        for(String line: lines)
        {
            LinkedList<Integer> numerosObtenidos = new LinkedList<Integer>();
            String[] tarjetaNumeros = line.trim().split(":");
            String[] numeros = tarjetaNumeros[1].split("\\|");
            /*Siguiente metodo ArraysStream
            int[] numeroGanadores = Arrays.stream(numeros[0].trim().split("\s+")).mapToInt(Integer::parseInt).toArray();
            ArrayList<String> numerosGanadores = new ArrayList<>(List.of(numeros[0].trim().split("\s+")));*/
            String[] numeroGanadores = numeros[0].trim().split("\s+");
            String[] numeroObtenidos = numeros[1].trim().split("\s+");
            LinkedList<String> numGanadores = new LinkedList<>();
            LinkedList<String> numObtenidos = new LinkedList<>();
            for(int i=0; i<numeroGanadores.length;i++)
            {
                numGanadores.add(numeroGanadores[i]);
            }
            for(int i=0; i<numeroObtenidos.length;i++)
            {
                numObtenidos.add(numeroObtenidos[i]);
            }
            tarjetas.add(new Tarjeta((tarjetaNumeros[0]), numGanadores,numObtenidos));
        }
    }

    public void cargarPuntajes()
    {
        int puntajeTotal=0;
        for(Tarjeta tarjeta: tarjetas)
        {
            puntajeTotal= puntajeTotal +tarjeta.getPuntaje();
        }
        System.out.println(puntajeTotal);

    }

    public void cargarCoincidencias()
    {
        int total=0;
        for(Tarjeta tarjeta: tarjetas)
        {
            for(int i=1; i<=tarjeta.getCoincidencias();i++)
            {
               tarjetas.get(tarjetas.indexOf(tarjeta)+i).aumentarCantidadTarjeta(tarjeta.getCantidadTarjeta());
            }
        }
        for(Tarjeta tarjeta: tarjetas)
        {
            total= total +tarjeta.getCantidadTarjeta();
        }
        System.out.println(total);
    }










}
