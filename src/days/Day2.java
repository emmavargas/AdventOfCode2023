package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Day2 {
    LinkedList<String> list = new LinkedList<String>();

    public void loadData() throws IOException
    {
        BufferedReader in= null;
        try {
            in = new BufferedReader(new FileReader("src/InputDay2.txt"));
            String line;
            while((line=in.readLine())!=null)
            {
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

        for(String e : list)
        {
            boolean invalidBlue = false;
            boolean invalidRed = false;
            boolean invalidGreen = false;
            int cantBlueValida = 0;
            int cantRedValida = 0;
            int cantGreenValida = 0;
            LinkedList<String> ronda = new LinkedList<String>();
            String[] a = new String[list.size()];
            a = e.split(";");
            for(int i=0 ; i<a.length;i++)
            {
                ronda.add(a[i]);
            }
            for(String g: ronda)
            {
                LinkedList<String> datos = new LinkedList<String>();
                LinkedList<String> valores = new LinkedList<String>();
                String[] b = new String[ronda.size()];
                b = g.split(",");
                for(int i=0; i<b.length;i++)
                {
                    datos.add(b[i]);
                }
                for(String h: datos)
                {
                    String[] c = new String[ronda.size()];
                    c = h.split(" ");
                    int d = Integer.parseInt(c[1]);
                    //System.out.println(d);
                    if(c[2].equals("blue"))
                    {
                        if(d<=14 && d>cantBlueValida)
                        {
                            cantBlueValida=d;
                        }
                        if(d>14 && d>cantBlueValida)
                        {
                            invalidBlue=true;
                            cantBlueValida =d;
                        }
                    } else if (c[2].equals("red"))
                    {
                        if(d<=14 && d>cantRedValida)
                        {
                            cantRedValida=d;
                        }
                        if(d>14 && d>cantRedValida)
                        {
                            invalidRed=true;
                            cantRedValida =d;
                        }
                    }
                    else if (c[2].equals("green"))
                    {
                        if(d<=14 && d>cantGreenValida)
                        {
                            cantGreenValida=d;
                        }
                        if(d>14 && d>cantGreenValida)
                        {
                            invalidGreen=true;
                            cantGreenValida =d;
                        }
                    }

                }

            }
            if(invalidBlue==false && invalidGreen==false && invalidRed==false)
            {
                cantJuegos=cantJuegos + list.indexOf(e)+1;
            }
            potencia = potencia + (cantBlueValida*cantRedValida*cantGreenValida);

        }

        System.out.println(cantJuegos);
        System.out.println(potencia);

    }

}
