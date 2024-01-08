package days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day8 {

    public void resolverParte1() throws IOException {
        cargarDatos();
    }

    public void cargarDatos() throws IOException
    {
        List<String> lines = new LinkedList<>();
        List<Character> eleccionCamino=new ArrayList<>();
        Map<String, LinkedList<String>> caminos = new HashMap<>();

        try(BufferedReader in = new BufferedReader(new FileReader("src/InputDay8.txt")))
        {
            String line;
            while((line= in.readLine())!=null)
            {
                lines.add(line);
            }
            char[] elecciones = lines.get(0).toCharArray();
            for(int eleccion=0; eleccion< elecciones.length; eleccion++)
            {
                eleccionCamino.add(elecciones[eleccion]);
            }
            lines.remove(0);
            lines.remove(1);

            eleccionCamino.forEach(lineas -> System.out.println(lineas));
            for(String lineCamino: lines)
            {
                String[] origenYDireccion;
                origenYDireccion= lineCamino.trim().replace("\\s+","").split("=");
                String origen = origenYDireccion[0];
                String[] direccion;
                direccion = origenYDireccion[1].replace("")
                LinkedList<String> direcciones = new LinkedList<>();
                caminos.put(origen[0].)

            }
        }
    }



}
