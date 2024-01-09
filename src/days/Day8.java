package days;

import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day8 {

    public void resolverParte1() throws IOException {
        Datos<Queue<Character>,Map<String,LinkedList<String>>> datosDelEjericio = this.cargarDatos();
        this.pasosParte1(datosDelEjericio);
    }

    public void resolverParte2() throws  IOException
    {
        Datos<Queue<Character>,Map<String,LinkedList<String>>> datosDelEjericio = this.cargarDatos();
        this.pasosParte2(datosDelEjericio);
    }

    private Datos cargarDatos() throws IOException {
        int pasos = 0;
        String llegada;
        List<String> lines = new LinkedList<>();
        Queue<Character> eleccionCaminos = new LinkedList<>();
        Map<String, LinkedList<String>> caminos = new HashMap<>();
        Datos<Queue,Map> datosDelEjercicio = new Datos<>();

        try (BufferedReader in = new BufferedReader(new FileReader("src/InputDay8.txt"))) {
            String line;

            while ((line = in.readLine()) != null) {
                lines.add(line);
            }

            char[] elecciones = lines.get(0).toCharArray();

            for (int eleccion = 0; eleccion < elecciones.length; eleccion++) {
                eleccionCaminos.add(elecciones[eleccion]);
            }

            lines.remove(0);
            lines.remove(0);

            LinkedList<String> direcciones;

            for (String lineCamino : lines) {
                String[] origenYDireccion;
                origenYDireccion = lineCamino.split("=");
                String origen = origenYDireccion[0].trim();
                String[] direccion;
                direccion = origenYDireccion[1].trim().replaceAll(" +", "").replace("(", "").replace(")", "").split(",");
                direcciones = new LinkedList<>(Arrays.asList(direccion));
                caminos.put(origen, direcciones);
            }

            datosDelEjercicio.set(eleccionCaminos, caminos);

            return datosDelEjercicio;


        }
    }

    private void pasosParte1(Datos<Queue<Character>,Map<String,LinkedList<String>>> datosEjer) {
        int pasos = 0;
        String llegada = "AAA";

        do {
            if (datosEjer.getEleccionCaminos().peek() == 'L') {
                llegada = datosEjer.getCaminos().get(llegada).get(0);
                datosEjer.getEleccionCaminos().offer(datosEjer.getEleccionCaminos().poll());
            } else if (datosEjer.getEleccionCaminos().peek() == 'R') {
                llegada = datosEjer.getCaminos().get(llegada).get(1);
                datosEjer.getEleccionCaminos().offer(datosEjer.getEleccionCaminos().poll());
            }
            pasos++;
        } while (!(llegada.equals("ZZZ")));
        System.out.println(pasos);
    }

    private void pasosParte2(Datos<Queue<Character>,Map<String,LinkedList<String>>> datosEjer)
    {
        List<String> keys = new LinkedList<>(datosEjer.getCaminos().keySet());
        List<Long> pasoDiferentesCaminosA = new LinkedList<>();
        LinkedList<String> keysA = new LinkedList<>();
        for (String key: keys)
        {
            char[] letrasKey = key.toCharArray();
            if(letrasKey[2]=='A')
            {
                keysA.add(key);
            }
        }
        for(int key=0;key<keysA.size(); key++)
        {
            Queue<Character> eleccionCamino = datosEjer.getEleccionCaminos();
            int keysZ=0;
            long pasos=0;

            do {
                if (eleccionCamino.peek() == 'L') {
                    keysA.set(key,datosEjer.getCaminos().get(keysA.get(key)).get(0));
                    eleccionCamino.offer(eleccionCamino.poll());

                } else if (eleccionCamino.peek() == 'R') {
                    keysA.set(key,datosEjer.getCaminos().get(keysA.get(key)).get(1));
                    eleccionCamino.offer(eleccionCamino.poll());
                }

                char[] letraKeya = keysA.get(key).toCharArray();
                pasos++;

                if(letraKeya[2]=='Z')
                {
                    keysZ++;
                }
            }while (!(keysZ==1));
            pasoDiferentesCaminosA.add(pasos);
        }

        long mcmTotal = pasoDiferentesCaminosA.get(0);

        for(int pasoscaminos=1; pasoscaminos<pasoDiferentesCaminosA.size();pasoscaminos++)
        {
            mcmTotal = this.mcm(mcmTotal,pasoDiferentesCaminosA.get(pasoscaminos));
        }

        System.out.println(mcmTotal);
    }



    class Datos<EleccionCaminos,Caminos>
    {
        private EleccionCaminos eleccionCaminos;
        Caminos caminos;
        public void set(EleccionCaminos eC, Caminos c)
        {
            this.eleccionCaminos = eC;
            this.caminos = c;
        }
        public EleccionCaminos getEleccionCaminos()
        {
            return this.eleccionCaminos;
        }

        public Caminos getCaminos()
        {
            return this.caminos;
        }
    }

    private long mcd(long n1, long n2)
    {
        long resultado =0;
        long max= Math.max(n1,n2);
        long min= Math.min(n1,n2);
        long resto;
        boolean condicion =true;
        do {
            resto = max % min;
            resultado=min;
            if(resto!=0)
            {
                max = min;
                min = resto;
            }
            else {
                condicion=false;
            }

        }while(condicion);

        return resultado;
    }

    private long mcm(long n1, long n2)
    {
        long resultado= (n1*n2)/this.mcd(n1,n2);
        return resultado;
    }
}
