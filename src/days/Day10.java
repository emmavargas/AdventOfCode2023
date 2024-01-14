package days;

import javax.swing.plaf.basic.BasicDesktopIconUI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day10 {

    public void resolverParte1() throws IOException
    {
        Datos datosPrueba = this.cargarDatosd();
        this.recorridoTuberia(datosPrueba);
    }


    public Datos cargarDatosd() throws IOException
    {
        Map<Integer,List<Character>> tuberias = new HashMap<>();
        ArrayList<Integer> ubicacionS = new ArrayList<>();


        try(BufferedReader in = new BufferedReader(new FileReader("src/InputDay10.txt")))
        {
            String line;
            int key=0;
            while((line=in.readLine())!=null)
            {
                char[] lineTub = line.toCharArray();
                List<Character> lineTuberias = new ArrayList<>();

                for(int tubo=0; tubo<lineTub.length;tubo++)
                {
                    if(lineTub[tubo]=='S')
                    {
                        ubicacionS.add(key);
                        ubicacionS.add(tubo);
                    }
                    lineTuberias.add(lineTub[tubo]);
                }

                tuberias.put(key,lineTuberias);
                key++;
            }
        }
        Datos datos = new Datos(tuberias,ubicacionS);
        return datos;

    }

    public class Datos
    {
        private Map<Integer,List<Character>> tuberias;
        private ArrayList<Integer> ubicacionS;

        public Datos(Map<Integer,List<Character>> t, ArrayList<Integer> uS)
        {
            this.tuberias = t;
            this.ubicacionS = uS;
        }

        public Map<Integer,List<Character>> getTuberias()
        {
            return this.tuberias;
        }

        public ArrayList<Integer> getUbicacionS()
        {
            return this.ubicacionS;
        }
    }

    public LinkedList<Integer> direccion(char tubo, int x, int y)
    {
        LinkedList<Integer> coordenadas = new LinkedList<>();
        int direccionX=0;
        int direccionY=0;

        if(x==1 && y==0)
        {
            switch (tubo)
            {
                case '7':
                    direccionX=0;
                    direccionY=1;
                    break;
                case 'J':
                    direccionX=0;
                    direccionY=-1;
                    break;
                case '-':
                    direccionX=1;
                    direccionY=0;
                    break;
            }
        }
        else if(x==-1 && y==0)
        {
            switch (tubo)
            {
                case 'F':
                    direccionX=0;
                    direccionY=1;
                    break;
                case 'L':
                    direccionX=0;
                    direccionY=-1;
                    break;
                case '-':
                    direccionX=-1;
                    direccionY=0;
                    break;
            }
        }
        else if(x==0 && y==1)
        {
            switch (tubo)
            {
                case 'L':
                    direccionX=1;
                    direccionY=0;
                    break;
                case 'J':
                    direccionX=-1;
                    direccionY=0;
                    break;
                case '|':
                    direccionX=0;
                    direccionY=1;
                    break;
            }
        }
        else if(x==0 && y==-1)
        {
            switch (tubo)
            {
                case 'F':
                    direccionX=1;
                    direccionY=0;
                    break;
                case '7':
                    direccionX=-1;
                    direccionY=0;
                    break;
                case '|':
                    direccionX=0;
                    direccionY=-1;
                    break;
            }
        }
        coordenadas.add(direccionX);
        coordenadas.add(direccionY);

        return coordenadas;
    }

    public void recorridoTuberia(Datos ubicacionSTuberias)
    {
        LinkedList<LinkedList<Integer>> direccionesIniciales = new LinkedList<>();
        LinkedList<Integer> direcion1 = new LinkedList<>();
        LinkedList<Integer> direcion2 = new LinkedList<>();
        LinkedList<Integer> direcion3 = new LinkedList<>();
        LinkedList<Integer> direcion4 = new LinkedList<>();
        direcion1.add(0);
        direcion1.add(1);
        direcion2.add(0);
        direcion2.add(-1);
        direcion3.add(1);
        direcion3.add(0);
        direcion4.add(-1);
        direcion4.add(0);
        direccionesIniciales.add(direcion1);
        direccionesIniciales.add(direcion2);
        direccionesIniciales.add(direcion3);
        direccionesIniciales.add(direcion4);

        int keyUbicacionActual= ubicacionSTuberias.getUbicacionS().get(0);
        int indiceTubo = ubicacionSTuberias.getUbicacionS().get(1);
        int pasos =0;
        boolean condicion =true;
        int x=0;
        int y=0;

        do {
            if(condicion==true)
            {
                for(LinkedList<Integer> direccionInicial: direccionesIniciales)
                {
                    LinkedList<Integer> proximaDireccion= this.direccion(ubicacionSTuberias.getTuberias().get(keyUbicacionActual+direccionInicial.get(1)).get(indiceTubo+direccionInicial.get(0)), direccionInicial.get(0), direccionInicial.get(1));
                    x = proximaDireccion.get(0);
                    y = proximaDireccion.get(1);
                    if(x!=0 || y!=0)
                    {
                        keyUbicacionActual=keyUbicacionActual+y;
                        indiceTubo=indiceTubo+x;
                        break;
                    }
                }

                condicion=false;
                pasos++;
            }
            else {
                LinkedList<Integer> proximaDireccion = this.direccion(ubicacionSTuberias.getTuberias().get(keyUbicacionActual).get(indiceTubo),x,y);
                x= proximaDireccion.get(0);
                y =proximaDireccion.get(1);
                keyUbicacionActual =keyUbicacionActual+y;
                indiceTubo=indiceTubo+x;
                pasos++;
            }
        }while(ubicacionSTuberias.getTuberias().get(keyUbicacionActual).get(indiceTubo)!='S');

        System.out.println(pasos/2);
    }
}