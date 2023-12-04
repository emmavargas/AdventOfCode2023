package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class Day2 {
    LinkedList<String> list = new LinkedList<String>();

    public void loadData() throws IOException
    {
        BufferedReader in= null;
        try {
            in = new BufferedReader(new FileReader("src\\InputDay2.txt"));
            String line;
            while((line=in.readLine())!=null)
            {
                line = line.replace(" ,","");
                String[] asd = new String[2];
                asd = line.split(":");
                list.add(asd[1]);
            }

        }
        finally {
            if(in!=null)
            {
                in.close();
            }
        }
    }

    public void cantidadJuegos()
    {

        int cantJuegos=0;
        int potencia = 0;

        for(String line : list)
        {
            HashMap<Integer,HashMap<String,Integer>> mapaRondas = new HashMap<Integer,HashMap<String,Integer>>();
            boolean invalidBlue = false;
            boolean invalidRed = false;
            boolean invalidGreen = false;
            int cantBlueValida = 0;
            int cantRedValida = 0;
            int cantGreenValida = 0;
            LinkedList<String> rondas = new LinkedList<String>();
            String[] a = new String[list.size()];
            a = line.split(";");
            for(int i=0 ; i<a.length;i++)
            {
                rondas.add(a[i]);
            }
            for(String ronda: rondas)
            {
                HashMap<String, Integer> mapaRonda = new HashMap<String,Integer>();
                String color;
                if(ronda.indexOf("green")!=-1)
                {
                 mapaRonda.put("green", ronda.indexOf(ronda.indexOf("green")-1));
                }
                if(ronda.indexOf("red")!=-1)
                {
                    mapaRonda.put("red", ronda.indexOf(ronda.indexOf("red")-1));
                }
                if(ronda.indexOf("blue")!=-1)
                {
                    mapaRonda.put("blue", ronda.indexOf(ronda.indexOf("blue")-1));
                }

            }
            if(invalidBlue==false && invalidGreen==false && invalidRed==false)
            {
                cantJuegos=cantJuegos + list.indexOf(line)+1;
            }
            potencia = potencia + (cantBlueValida*cantRedValida*cantGreenValida);

        }

        System.out.println(cantJuegos);
        System.out.println(potencia);

    }

}
