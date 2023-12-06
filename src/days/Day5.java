package days;

import ObjectsDays.NumeroTransformado;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Day5 {
    HashMap<Integer,LinkedList<String>> txt = new HashMap();
    HashMap<Integer, LinkedList<NumeroTransformado>> validacion = new HashMap<>();

    LinkedList<Long> valoresEntrada = new LinkedList<Long>();
    LinkedList<Long> valoresMinimos = new LinkedList<Long>();

    public void cargaDatos() throws IOException
    {
        BufferedReader in= null;

        try
        {
            in = new BufferedReader(new FileReader("src\\InputDay5.txt"));
            String line;
            int i = 0;
            while((line=in.readLine())!=null)
            {
                if(line.equals("")==false)
                {
                    if(!txt.containsKey(i))
                    {
                        txt.put(i,new LinkedList<String>());
                    }
                    txt.get(i).add(line);

                }
                else{
                    i++;
                }

            }


        }
        finally {
            if(in!=null)
            {
                in.close();
            }
        }
        //txt.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));

    }

    public void cargarCondiciones()
    {
        for(int indice= 1;indice<8;indice++)
        {
            txt.get(indice).remove();
        }
       // txt.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
        int aux=0;
        for(int indice= 1;indice<8;indice++) {
            for (String numeros : txt.get(indice)) {
                if (!validacion.containsKey(aux)) {
                    validacion.put(aux, new LinkedList<>());
                }
                long[] num = Arrays.stream(numeros.trim().split(" ")).mapToLong(Long::parseLong).toArray();
                validacion.get(aux).add(new NumeroTransformado(num[1], num[0], num[2]));
            }
            aux++;
        }
    }



    public void valorMenor()
    {
        long resultado=0;
        String[] texto=  txt.get(0).get(0).split(":");
        long[] num = Arrays.stream(texto[1].trim().split(" ")).mapToLong(Long::parseLong).toArray();
        for(int indiceValor=0;indiceValor<num.length;indiceValor++)
        {
            valoresEntrada.add(num[indiceValor]);
        }
    }
    public void valorFinalMinimos()
    {
        long resultado =0;
        for(long e: valoresEntrada)
        {
            resultado=e;
            for(int indice= 0;indice<7;indice++) {

                for(NumeroTransformado f: validacion.get(indice))
                {
                    if(f.obtenerValorSalida(resultado)!=0)
                    {
                        resultado= f.obtenerValorSalida(resultado);
                        break;
                    }
                }
            }
            valoresMinimos.add(resultado);
        }
        for (long x: valoresMinimos)
        {
            //System.out.println(x);
        }
    }

    public long valorMinimoParte2(long num)
    {
        long resultado =num;
        for(int indice= 0;indice<7;indice++) {

            for(NumeroTransformado f: validacion.get(indice))
            {
                if(f.obtenerValorSalida(resultado)!=0)
                {
                    resultado= f.obtenerValorSalida(resultado);
                    break;
                }
            }
        }
        return resultado;

    }







    public void valorMinmo()
    {
        long vMinimo=0;
        for (long valor : valoresMinimos)
        {
            if(vMinimo==0)
            {
                vMinimo=valor;
            }
            if(valor<vMinimo)
            {
                vMinimo=valor;
            }
        }
       // System.out.println(vMinimo);
    }




    public void parte2Numeros()
    {
        long resultado =0;
        for(int indice =0; indice<valoresEntrada.size();indice=indice+2)
        {
            long aux = valoresEntrada.get(indice) + valoresEntrada.get(indice + 1);

            for (long indice2=valoresEntrada.get(indice); indice2<aux;indice2++)
            {
                long aux2=this.valorMinimoParte2(indice2);
                if((aux2<resultado)||resultado==0)
                {
                    //System.out.println(indice2);
                    resultado = aux2;
                }

            }
        }

        System.out.println(resultado);


    }


}




