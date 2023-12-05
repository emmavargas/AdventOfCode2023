package ObjectsDays;

import java.util.LinkedList;

public class Tarjeta {
    private String numeroTarjeta;
    private LinkedList<String> numerosGanadores;
    private LinkedList<String> numerosObtenidos;
    private int puntaje;

    private int coincidencias;
    private int cantidadTarjeta=1;
    public Tarjeta(String numeroTarjeta, LinkedList<String> nGanadores, LinkedList<String> nObtenidos) {
        this.numeroTarjeta = numeroTarjeta;
        this.numerosGanadores = nGanadores;
        this.numerosObtenidos = nObtenidos;
        boolean flag = false;
        int punt=0;
        int valorCoincidencia = 0;
        for(String nGanador: numerosGanadores)
        {
            for(String nObtenido: numerosObtenidos)
            {
                if(nGanador.equals(nObtenido))
                {
                    valorCoincidencia++;
                    if(!flag)
                    {
                        punt= 1;
                        flag =true;
                    }
                    else
                    {
                        punt = punt*2;
                    }
                }
            }
        }
        this.puntaje = punt;
        this.coincidencias = valorCoincidencia;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public LinkedList<String> getNumerosGanadores() {
        return numerosGanadores;
    }

    public LinkedList<String> getNumerosTengo() {
        return numerosObtenidos;
    }
    public int getPuntaje()
    {
        return this.puntaje;
    }
    public int getCoincidencias()
    {
        return this.coincidencias;
    }

    public int getCantidadTarjeta()
    {
        return this.cantidadTarjeta;
    }
    public void aumentarCantidadTarjeta(int cantidadPermitida)
    {
        this.cantidadTarjeta = this.cantidadTarjeta+cantidadPermitida;
    }
}