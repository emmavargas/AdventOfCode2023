package days;

import ObjectsDays.ManoCartas;

import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day7 {


    public void resolverParte1() throws IOException
    {
        this.cargarDatosParte1();
    }
    public void resolverParte2() throws IOException
    {
        this.cargarDatosParte2();
    }
    public void cargarDatosParte1() throws IOException
    {
        List<ManoCartas> cincoIgualesLista = new LinkedList<>();
        List<ManoCartas> poquerLista = new LinkedList<>();
        List<ManoCartas> fullHouseLista = new LinkedList<>();
        List<ManoCartas> trioLista = new LinkedList<>();
        List<ManoCartas> dosParesLista = new LinkedList<>();
        List<ManoCartas> unParLista = new LinkedList<>();
        List<ManoCartas> cartaAltaLista = new LinkedList<>();
        Map<Integer,List<ManoCartas>> listaTipos = new HashMap<>();
        int cintoIguales=5;
        int poquer=41;
        int fullHouse=32;
        int trio=311;
        int dosPares=221;
        int unPar=2111;
        int cartaAlta=11111;
        long resultado=0;

        try (BufferedReader in = new BufferedReader(new FileReader("src/InputDay7.txt")))
        {
            String line;
            int prueba=1;

            while((line=in.readLine())!=null)
            {
                int tipo;
                String[] manoYPuntaje;
                manoYPuntaje = line.trim().split(" ");
                String mano =manoYPuntaje[0];
                String puntaje =manoYPuntaje[1];
                tipo= this.tipoManoParte1(mano);
                switch (tipo)
                {
                    case 11111:
                        cartaAltaLista.add(new ManoCartas(mano,puntaje));
                        break;
                    case 2111:
                        unParLista.add(new ManoCartas(mano,puntaje));
                        break;
                    case 221:
                        dosParesLista.add(new ManoCartas(mano,puntaje));
                        break;
                    case 311:
                        trioLista.add(new ManoCartas(mano,puntaje));
                        break;
                    case 32:
                        fullHouseLista.add(new ManoCartas(mano,puntaje));
                        break;
                    case 41:
                        poquerLista.add(new ManoCartas(mano,puntaje));
                        break;
                    case 5:
                        cincoIgualesLista.add(new ManoCartas(mano,puntaje));
                        break;
                }


            }

            listaTipos.put(6, cincoIgualesLista);
            listaTipos.put(5, poquerLista);
            listaTipos.put(4, fullHouseLista);
            listaTipos.put(3, trioLista);
            listaTipos.put(2, dosParesLista);
            listaTipos.put(1, unParLista);
            listaTipos.put(0, cartaAltaLista);

            List<Integer> claveListaTipos = new ArrayList<>(listaTipos.keySet());
            int rango =1;
            for(int clave: claveListaTipos)
            {
                Collections.sort(listaTipos.get(clave), (mano1,mano2)-> {
                    return mano2.getCartaModificadaParte1().compareTo(mano1.getCartaModificadaParte1());
                });

                for(ManoCartas mano: listaTipos.get(clave))
                {
                    mano.setRango(rango);
                    rango++;
                    resultado = resultado + mano.puntajeReal();
                }
            }

            System.out.println(resultado);
        }

    }
    public int tipoManoParte1(String mano)
    {
        String m = mano;
        Map<Character,Integer> cantidadTipoCartas = new HashMap<>();
        for(int carta=0; carta<mano.length();carta++)
        {
            if(cantidadTipoCartas.containsKey(mano.charAt(carta)))
            {
                cantidadTipoCartas.put(mano.charAt(carta), cantidadTipoCartas.get(mano.charAt(carta))+1);
            }
            else {
                cantidadTipoCartas.put(mano.charAt(carta),1);
            }
        }
        List<Character> keys = new LinkedList<>(cantidadTipoCartas.keySet());
        Collections.sort(keys,(k1,k2) -> {
            return  cantidadTipoCartas.get(k2)- cantidadTipoCartas.get(k1);
        });

        int potencia=1;
        double tipo=0;
        for(char key: keys)
        {
            tipo = tipo+ (cantidadTipoCartas.get(key)*Math.pow(10,keys.size()-potencia));
            potencia++;
        }
        return (int)tipo;
    }
        public void cargarDatosParte2() throws IOException
    {
        List<ManoCartas> cincoIgualesLista = new LinkedList<>();
        List<ManoCartas> poquerLista = new LinkedList<>();
        List<ManoCartas> fullHouseLista = new LinkedList<>();
        List<ManoCartas> trioLista = new LinkedList<>();
        List<ManoCartas> dosParesLista = new LinkedList<>();
        List<ManoCartas> unParLista = new LinkedList<>();
        List<ManoCartas> cartaAltaLista = new LinkedList<>();
        Map<Integer,List<ManoCartas>> listaTipos = new HashMap<>();
        int cintoIguales=5;
        int poquer=41;
        int fullHouse=32;
        int trio=311;
        int dosPares=221;
        int unPar=2111;
        int cartaAlta=11111;
        long resultado=0;

        try (BufferedReader in = new BufferedReader(new FileReader("src/InputDay7.txt")))
        {
            String line;
            int prueba=1;

            while((line=in.readLine())!=null)
            {
                int tipo;
                String[] manoYPuntaje;
                manoYPuntaje = line.trim().split(" ");
                String mano =manoYPuntaje[0];
                String puntaje =manoYPuntaje[1];
                tipo= this.tipoManoParte2(mano);
                switch (tipo)
                {
                    case 11111:
                        cartaAltaLista.add(new ManoCartas(mano,puntaje));
                        break;
                    case 2111:
                        unParLista.add(new ManoCartas(mano,puntaje));
                        break;
                    case 221:
                        dosParesLista.add(new ManoCartas(mano,puntaje));
                        break;
                    case 311:
                        trioLista.add(new ManoCartas(mano,puntaje));
                        break;
                    case 32:
                        fullHouseLista.add(new ManoCartas(mano,puntaje));
                        break;
                    case 41:
                        poquerLista.add(new ManoCartas(mano,puntaje));
                        break;
                    case 5:
                        cincoIgualesLista.add(new ManoCartas(mano,puntaje));
                        break;
                }
            }

            listaTipos.put(6, cincoIgualesLista);
            listaTipos.put(5, poquerLista);
            listaTipos.put(4, fullHouseLista);
            listaTipos.put(3, trioLista);
            listaTipos.put(2, dosParesLista);
            listaTipos.put(1, unParLista);
            listaTipos.put(0, cartaAltaLista);

            List<Integer> claveListaTipos = new ArrayList<>(listaTipos.keySet());
            int rango =1;
            for(int clave: claveListaTipos)
            {
                Collections.sort(listaTipos.get(clave), (mano1,mano2)-> {
                    return mano2.getCartaModificadaParte2().compareTo(mano1.getCartaModificadaParte2());
                });

                for(ManoCartas mano: listaTipos.get(clave))
                {
                    mano.setRango(rango);
                    rango++;
                    resultado = resultado + mano.puntajeReal();
                }
            }
            System.out.println(resultado);
        }
    }
    public int tipoManoParte2(String mano)
    {
        String m = mano;
        Map<Character,Integer> cantidadTipoCartas = new HashMap<>();
        for(int carta=0; carta<mano.length();carta++)
        {
            if(cantidadTipoCartas.containsKey(mano.charAt(carta)))
            {
                cantidadTipoCartas.put(mano.charAt(carta), cantidadTipoCartas.get(mano.charAt(carta))+1);
            }
            else {
                cantidadTipoCartas.put(mano.charAt(carta),1);
            }
        }
        List<Character> keys = new LinkedList<>(cantidadTipoCartas.keySet());
        Collections.sort(keys,(k1,k2) -> {
            return  cantidadTipoCartas.get(k2)- cantidadTipoCartas.get(k1);
        });
        if (cantidadTipoCartas.containsKey('J') && keys.get(0)!='J')
        {
            cantidadTipoCartas.put(keys.get(0),cantidadTipoCartas.get(keys.get(0))+cantidadTipoCartas.get('J'));
            cantidadTipoCartas.remove('J');
            keys.remove(keys.indexOf('J'));

        }
        else if (cantidadTipoCartas.containsKey('J') && keys.get(0)=='J' && keys.size()!=1)
        {
            cantidadTipoCartas.put(keys.get(1),cantidadTipoCartas.get(keys.get(1))+cantidadTipoCartas.get('J'));
            cantidadTipoCartas.remove('J');
            keys.remove(keys.indexOf('J'));
        }

        int potencia=1;
        double tipo=0;
        for(char key: keys)
        {
            tipo = tipo+ (cantidadTipoCartas.get(key)*Math.pow(10,keys.size()-potencia));
            potencia++;
        }
        return (int)tipo;
    }
}
